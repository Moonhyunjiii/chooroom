function toggleCalendar() {
  const calendar = document.getElementById('calendar');
  if (calendar.style.display === "none") {
    calendar.style.display = "block"; // 달력 표시
  } else {
    calendar.style.display = "none"; // 달력 숨김
  }
}


function toggleRoomDetails(element) {
  const roomDetails = element.querySelector('.room-details');
  const isOpen = roomDetails.classList.contains('open');

  if (isOpen) {
    roomDetails.classList.remove('open');
    element.classList.remove('open');
  } else {
    roomDetails.classList.add('open');
    element.classList.add('open');
  }
}
  

function toggleSelection(element) {
  // 클릭된 요소에 active 클래스를 추가/제거
  element.classList.toggle('active');
}

// 필터 드랍다운
function toggleDropdown(dropdownId) {
  // dropdownId로 드롭다운을 선택
  const dropdown = document.getElementById(dropdownId);

  // 현재 드롭다운이 숨겨져 있는지 확인
  if (dropdown.style.display === 'none' || !dropdown.style.display) {
    dropdown.style.display = 'block';  // 드롭다운 표시
  } else {
    dropdown.style.display = 'none';   // 드롭다운 숨김
  }
}

// 반응형 화면
$(document).ready(function() {
  // 초기 설정: 창 크기에 맞춰 높이 설정
  setContainerHeight();

  // 창 크기가 변경될 때마다 실행
  $(window).resize(function(){
      setContainerHeight();
  });

  function setContainerHeight() {
      var winWidth = $(window).width();
      // 창 너비를 기준으로 비율 유지 (1.618:1)
      $('body').height(winWidth * 1.618);
  }
});


// 모달 열기 함수
function openModal(roomNumber) {
  document.getElementById('myModal').style.display = 'block';
  document.getElementById('modalRoomNumber').innerText = roomNumber + '호';
}

// 모달 닫기 함수
function closeModal() {
  document.getElementById('myModal').style.display = 'none';
}

// 선택 확인 함수
function confirmSelection() {
  alert('객실이 선택되었습니다!');
  closeModal(); // 모달 닫기
}

// 외부 클릭 시 모달 닫기
window.onclick = function(event) {
  var modal = document.getElementById('myModal');
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

        // JavaScript로 동적으로 데이터를 생성하는 방법
        document.addEventListener("DOMContentLoaded", function() {
            const roomTags = [
                { tagName: 'Deluxe Room' },
                { tagName: 'Suite Room' },
                { tagName: 'Standard Room' }
            ];

            // roomTags 데이터를 이용해 동적으로 HTML을 생성
            const container = document.getElementById("tags-container");
            roomTags.forEach((tag, index) => {
                const div = document.createElement("div");
                div.className = "tag";
                div.innerHTML = `
                    <div class="div5">${tag.tagName}</div>
                `;
                div.onclick = function() {
                    toggleSelection(this);
                };
                container.appendChild(div);
            });
        });
