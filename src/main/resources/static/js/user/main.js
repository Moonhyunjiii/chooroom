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

    // 페이지 로드 시 서버로부터 데이터를 받아오는 함수
    function fetchRoomData() {
        fetch("/api/rooms")
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

    // 페이지 로드 시 데이터 불러오기
    fetchRoomData();

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

    document.querySelector('.notification-btn').addEventListener('click', function() {
        alert('알림이 없습니다.');
    });

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
