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

    // 객실보기 토글 함수
    function toggleRoomList(button) {
        const roomContainer = button.closest('.room-container'); // 가장 가까운 부모인 room-container 찾기
        const roomDetails = roomContainer.querySelector('.room-details'); // room-details 찾기

        // room-details 요소가 존재하는지 확인
        if (!roomDetails) {
            console.error('room-details 요소를 찾을 수 없습니다.');
            return;
        }

        // 현재 상태에 따라 표시/숨기기 처리
        if (roomDetails.style.display === "none" || roomDetails.style.display === "") {
            roomDetails.style.display = "grid";  // 보이기
            button.textContent = "객실닫기";     // 버튼 텍스트 변경
        } else {
            roomDetails.style.display = "none";  // 숨기기
            button.textContent = "객실보기";     // 버튼 텍스트 변경
        }
    }

    // 객실보기 버튼 클릭 이벤트 처리
    document.querySelectorAll('.toggle-btn').forEach(function(button) {
        button.addEventListener('click', function() {
            toggleRoomList(this);  // 객실보기/숨기기 토글 함수 호출
        });
    });

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
