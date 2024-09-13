// 드롭다운 토글 함수 - 글로벌 스코프에 선언
function toggleDropdown(id) {
    const dropdown = document.getElementById(id);

    // 드롭다운이 열려 있으면 닫고, 닫혀 있으면 열기
    if (dropdown.style.display === "block") {
        dropdown.style.display = "none";
    } else {
        // 모든 드롭다운 리스트를 닫음
        document.querySelectorAll('.dropdown-list').forEach(list => {
            list.style.display = 'none';
        });

        // 클릭한 드롭다운만 열기
        dropdown.style.display = "block";
    }
}

document.addEventListener("DOMContentLoaded", function() {
    // jQuery UI datepicker 적용
    $(".datepicker").datepicker({
        dateFormat: 'yy-mm-dd',
        showOtherMonths: true,
        selectOtherMonths: true,
        showAnim: 'slideDown',
        changeMonth: true,
        changeYear: true,
        minDate: 0
    });

    // 모든 room-title 요소를 가져옴
    const roomTitles = document.getElementsByClassName('room-title');

    // roomTitles의 각 요소에 대해 처리
    for (let i = 0; i < roomTitles.length; i++) {
        const roomTitle = roomTitles[i].textContent.trim();  // 각 room-title의 텍스트 값을 가져옴

        // 한글 방 제목을 영문 roomType으로 변환하는 함수
        function convertRoomTitleToRoomType(roomTitle) {
            switch (roomTitle) {
                case "스탠다드":
                    return "STANDARD";
                case "디럭스":
                    return "DELUXE";
                case "스위트":
                    return "SUITE";
                default:
                    throw new Error("Unknown room title: " + roomTitle);
            }
        }

        // 변환된 roomType
        const roomType = convertRoomTitleToRoomType(roomTitle);

        // 서버로 변환된 roomType을 GET 요청으로 전송
        fetch(`/rooms-noiseAvg?roomType=${roomType}`, {
            method: 'GET'
        })
        .then(response => response.json())  // JSON으로 응답 처리
        .then(data => {
            // noiseLevelAvg 요소들을 가져옴 (각 room-title에 대응되는 noiseLevelAvg 값을 업데이트)
            const noiseLevelAvgElements = document.getElementsByClassName('noiseLevelAvg');
            const minRoomPriceElements = document.getElementsByClassName('minRoomPrice');

            // 해당하는 noiseLevelAvg 요소의 값을 업데이트
            if (noiseLevelAvgElements[i]) {
                noiseLevelAvgElements[i].textContent = data.noiseLevelAvg + 'db';
            }

            // 해당하는 minRoomPrice 요소의 값을 업데이트
            if (minRoomPriceElements[i]) {
                minRoomPriceElements[i].textContent = data.minRoomPrice + '원~';
            }
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }

    // 해시태그 버튼 클릭 이벤트 처리
    document.querySelectorAll('.hashtag').forEach(button => {
        button.addEventListener('click', function () {
            this.classList.toggle('selected');
            applyFilters();  // 해시태그 클릭 시 필터 적용 함수 호출
        });
    });

    // 해시태그 수집
    function getSelectedHashtags() {
        const selectedHashtags = [];
        document.querySelectorAll('.hashtag.selected').forEach(button => {
            selectedHashtags.push(button.getAttribute('data-tag'));
        });

        console.log("Collected Hashtags:", selectedHashtags); // 수집된 해시태그 출력
        return selectedHashtags;
    }

    // 페이지 로드 시 서버로부터 데이터를 받아오는 함수
    function fetchFilteredRoomData(filters) {
        const queryString = new URLSearchParams(filters).toString();
        return fetch(`/api/rooms?${queryString}`) // 확인하기
            .then(response => response.json())
            .then(data => {
                // 모든 room-container를 가져옴
                const roomContainers = document.querySelectorAll('.room-container');

                // 모든 객실 데이터를 돌면서 각 room-container에 맞는 데이터를 삽입
                roomContainers.forEach(container => {
                    const roomTitle = container.querySelector('.room-title').textContent.trim();
                    const roomDetailsContainer = container.querySelector('.room-details');
                    const remainingRooms = container.querySelector('.remaining-rooms');

                    // 각 roomTitle에 따라 필터링된 room 데이터를 roomDetailsContainer에 넣기
                    const filteredRooms = data.filter(room => {
                        return (
                            (roomTitle === '스탠다드' && room.roomType === 'STANDARD') ||
                            (roomTitle === '디럭스' && room.roomType === 'DELUXE') ||
                            (roomTitle === '스위트' && room.roomType === 'SUITE')
                        );
                    });

                    // roomDetailsContainer 내용을 비우고, 필터링된 데이터를 추가
                    roomDetailsContainer.innerHTML = ''; // 기존 내용 초기화

                    if (filteredRooms.length > 0) {
                        // 남은 객실 수 표시
                        remainingRooms.textContent = `남은 객실 ${filteredRooms.length}개`;

                        // 각 필터링된 방 데이터를 추가
                        filteredRooms.forEach(room => {
                            const roomItem = `
                                <div class="room-item">
                                    <div class="room-item-image">
                                        <img src="/img/user/객실화면예시.png" alt="Room image">
                                    </div>
                                    <div class="room-item-info">
                                        <div class="room-left">
                                            <span class="room-number">${room.roomNumber}호</span>
                                            <span class="room-viewAndNoise">${room.viewType}, 평균소음: <span class="noise-level">${room.roomCondition.roomNoiseLevel}</span>db</span>
                                        </div>
                                        <div class="room-right">
                                            <button class="room-select-btn" data-room-number="${room.roomNumber}">선택</button>
                                        </div>
                                    </div>
                                </div>
                            `;
                            roomDetailsContainer.insertAdjacentHTML('beforeend', roomItem);
                        });
                    } else {
                        remainingRooms.textContent = '남은 객실 0개';
                    }
                });
            })
            .catch(error => console.error('Error fetching room data:', error));
    }

    // 필터 적용 함수
    function applyFilters() {
        const selectedView = document.querySelector('#view-dropdown .selected')?.textContent || '';
        const selectedBed = document.querySelector('#bed-dropdown .selected')?.textContent || '';
        const selectedPrice = document.querySelector('#price-dropdown .selected')?.textContent || '';
        const selectedHashtags = getSelectedHashtags();  // 해시태그 수집 추가

        const filters = {
            viewType: selectedView,
            bedType: selectedBed,
            priceOrder: selectedPrice,
            hashtags: selectedHashtags  // 해시태그 추가
        };

        console.log("Filters:", filters); // 필터 데이터 확인

        fetchFilteredRoomData(filters); // 필터에 맞는 데이터 요청
    }

    // 필터 클릭 이벤트 처리 - 중복 이벤트 리스너 방지
    document.querySelectorAll('.filter-category').forEach(filter => {
        const dropdownItems = filter.querySelectorAll('li');
        dropdownItems.forEach(item => {
            item.addEventListener('click', function () {
                dropdownItems.forEach(i => i.classList.remove('selected'));
                this.classList.add('selected');
                applyFilters(); // 필터 적용
            });
        });
    });

    // 객실보기 토글 함수
    function toggleRoomList(button) {
        const roomContainer = button.closest('.room-container');
        const roomDetails = roomContainer.querySelector('.room-details');

        if (!roomDetails) {
            console.error('room-details 요소를 찾을 수 없습니다.');
            return;
        }

        if (roomDetails.style.display === "none" || roomDetails.style.display === "") {
            roomDetails.style.display = "grid";
            button.textContent = "객실닫기";
        } else {
            roomDetails.style.display = "none";
            button.textContent = "객실보기";
        }
    }

    // 동적으로 생성된 .toggle-btn에 대한 이벤트 위임
    document.addEventListener('click', function(event) {
        if (event.target && event.target.classList.contains('toggle-btn')) {
            toggleRoomList(event.target);  // 객실보기/숨기기 토글 함수 호출
        }
    });

    // 동적으로 생성된 .room-select-btn에 대한 이벤트 위임 (수정된 부분)
    document.addEventListener('click', function(event) {
        if (event.target && event.target.classList.contains('room-select-btn')) {
            const roomNumber = event.target.getAttribute('data-room-number');
            console.log(roomNumber);
            // 모달을 열고, 선택한 방 번호에 해당하는 세부 정보 요청

             const url = "/room-detail?roomNumber=" + roomNumber;
             const width = window.innerWidth;
             const height = window.innerHeight;

             // 새 창의 크기
             const newWidth = width * 0.5;
             const newHeight = height ;

             // 새 창의 위치
             const left = (width - newWidth) / 2;
             const top = (height - newHeight) / 2;

             // 새 창을 여는 옵션 설정
             const features = `width=${newWidth},height=${newHeight},left=${left},top=${top},scrollbars=yes,resizable=yes`;

             // 새 창 열기
             window.open(url, '_blank', features);

        }
    });

    // 초기화 버튼 클릭 이벤트 처리
   document.getElementById('reset-filters').addEventListener('click', function() {
       // 모든 필터의 'selected' 클래스 제거
       document.querySelectorAll('.filter-category .selected').forEach(item => {
           item.classList.remove('selected');
       });

       // 해시태그의 'selected' 클래스 제거
       document.querySelectorAll('.hashtag.selected').forEach(button => {
           button.classList.remove('selected');
       });

       // 필터 초기화 후 기본 데이터 다시 불러오기
       fetchFilteredRoomData({}); // 기본 필터 없이 데이터 요청
   });

    // 페이지 로드 시 기본 데이터 불러오기
    fetchFilteredRoomData({}); // 기본 필터 없이 모든 객실 데이터를 불러옴

//    // 검색 버튼 클릭 이벤트 처리
//    document.querySelector('.search-button').addEventListener('click', function() {
//        const checkInDate = document.getElementById('checkin-date').value;
//        const checkOutDate = document.getElementById('checkout-date').value;
//        const roomCount = document.getElementById('room-count').value;
//        const guestCount = document.getElementById('guest-count').value;
//
//        // 입력 값이 모두 있는지 확인 후 알림창으로 표시
//        if (checkInDate && checkOutDate && roomCount && guestCount) {
//            alert(`Check In: ${checkInDate}, Check Out: ${checkOutDate}, Rooms: ${roomCount}, Guests: ${guestCount}`);
//        } else {
//            alert('Please fill out all fields.');
//        }
//    });

    // 클릭 외부 영역 클릭 시 드롭다운 닫기
    document.addEventListener('click', function(event) {
        const isClickInside = event.target.closest('.filter-category');
        if (!isClickInside) {
            // 드롭다운 리스트를 모두 닫음
            document.querySelectorAll('.dropdown-list').forEach(list => {
                list.style.display = 'none';
            });
        }
    });

/*    document.querySelector('.reservstionCheckButton').addEventListener('click', function() {
        alert('알림이 없습니다.');
    });*/

});

function redirectToLogin() {
        window.location.href = '/login';
}

function redirectToLogout() {
    const form = document.createElement('form');
    form.method = 'POST';
    form.action = '/logout';

    document.body.appendChild(form);
    form.submit();
}

    // Add event listener to the login button
document.addEventListener('DOMContentLoaded', function() {
    var loginButton = document.getElementById('loginButton');
    if (loginButton) {
        loginButton.addEventListener('click', redirectToLogin);
    }
});

// Add event listener to the login button
document.addEventListener('DOMContentLoaded', function() {
    var logoutButton = document.getElementById('logoutButton');
    if (logoutButton) {
        logoutButton.addEventListener('click', redirectToLogout);
    }

});
//
//function openModalWithRoomDetails(roomNumber) {
//    // 모달을 열고 방 세부정보를 표시하는 코드
//    console.log(`Opening modal for room number: ${roomNumber}`);
//    // 모달 열기 및 세부정보 요청 로직
//    // 모달 관련 스크립트
//    var modal = document.getElementById("myModal");
//    var btn = document.querySelectorAll(".room-select-btn");
//    var span = document.getElementsByClassName("close")[0];
//
//    // 모달을 열기
//    btn.onclick = function() {
//        modal.style.display = "block";
//    }
//
//    // 모달을 닫기
//    span.onclick = function() {
//        modal.style.display = "none";
//    }
//
//    // 모달 바깥을 클릭하면 모달 닫기
//    window.onclick = function(event) {
//        if (event.target == modal) {
//            modal.style.display = "none";
//        }
//    }
//
//    // 예약하기 버튼 클릭 시 알림창 띄우기
//    var reserveBtn = document.getElementById("reserveBtn");
//    reserveBtn.onclick = function() {
//        alert("예약이 완료되었습니다.\n완료된 예약은 마이페이지에서 확인하실 수 있습니다.");
//    }
//}


document.querySelectorAll('.room-select-btn').forEach(button => {
    button.addEventListener('click', function() {
        const roomNumber = this.getAttribute('data-room-number');
        console.log(roomNumber);
        // 모달을 열고, 선택한 방 번호에 해당하는 세부 정보 요청
        openModalWithRoomDetails(roomNumber);
    });
});

//

