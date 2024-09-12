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

    // 해시태그 버튼 클릭 이벤트 처리
    document.querySelectorAll('.hashtag').forEach(button => {
        button.addEventListener('click', function () {
            this.classList.toggle('selected');
        });
    });

    // roomTitle 값을 가져옴
    const roomTitle = document.getElementById('roomTitle').textContent.trim();

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
        // 서버로부터 받은 소음도를 페이지에 업데이트
        document.getElementById('noiseLevel').textContent = data.noiseLevelAvg + 'db';
    })
    .catch((error) => {
        console.error('Error:', error);
    });


    // 페이지 로드 시 서버로부터 데이터를 받아오는 함수
    function fetchFilteredRoomData(filters) {
        const queryString = new URLSearchParams(filters).toString();
        fetch(`/api/rooms?${queryString}`)
            .then(response => response.json())
            .then(data => {
                // 모든 room-container를 가져옴
                const roomContainers = document.querySelectorAll('.room-container');

                roomContainers.forEach(container => {
                    const roomTitle = container.querySelector('.room-title').textContent.trim();
                    const roomDetailsContainer = container.querySelector('.room-details');
                    const remainingRooms = container.querySelector('.remaining-rooms');

                    const filteredRooms = data.filter(room => {
                        return (
                            (roomTitle === '스탠다드' && room.roomType === 'STANDARD') ||
                            (roomTitle === '디럭스' && room.roomType === 'DELUXE') ||
                            (roomTitle === '스위트' && room.roomType === 'SUITE')
                        );
                    });

                    roomDetailsContainer.innerHTML = ''; // 기존 내용 초기화

                    if (filteredRooms.length > 0) {
                        remainingRooms.textContent = `남은 객실 ${filteredRooms.length}개`;

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
                                            <button class="room-select-btn">선택</button>
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

        const filters = {
            viewType: selectedView,
            bedType: selectedBed,
            priceOrder: selectedPrice
        };

        console.log(filters);

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

    // 초기화 버튼 클릭 이벤트 처리
    document.getElementById('reset-filters').addEventListener('click', function() {
        // 모든 필터의 'selected' 클래스 제거
        document.querySelectorAll('.filter-category .selected').forEach(item => {
            item.classList.remove('selected');
        });

        // 필터 초기화 후 기본 데이터 다시 불러오기
        fetchFilteredRoomData({}); // 기본 필터 없이 데이터 요청
    });

    // 페이지 로드 시 기본 데이터 불러오기
    fetchFilteredRoomData({}); // 기본 필터 없이 모든 객실 데이터를 불러옴

    // 검색 버튼 클릭 이벤트 처리
    document.querySelector('.search-button').addEventListener('click', function() {
        const checkInDate = document.getElementById('checkin-date').value;
        const checkOutDate = document.getElementById('checkout-date').value;
        const roomCount = document.getElementById('room-count').value;
        const guestCount = document.getElementById('guest-count').value;

        // 입력 값이 모두 있는지 확인 후 알림창으로 표시
        if (checkInDate && checkOutDate && roomCount && guestCount) {
            alert(`Check In: ${checkInDate}, Check Out: ${checkOutDate}, Rooms: ${roomCount}, Guests: ${guestCount}`);
        } else {
            alert('Please fill out all fields.');
        }
    });

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

    // Add event listener to the login button
    document.addEventListener('DOMContentLoaded', function() {
        var loginButton = document.getElementById('loginButton');
        if (loginButton) {
            loginButton.addEventListener('click', redirectToLogin);
        }
});
