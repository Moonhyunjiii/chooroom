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

function drawProgressCircle(canvasId, endProgress) {
    const canvas = document.getElementById(canvasId);
    if (!canvas) {
        console.error(`Canvas element with id ${canvasId} not found!`);
        return;
    }

    const ctx = canvas.getContext('2d');
    const radius = canvas.width / 2 - 10; // 패딩을 약간 주기 위해 크기 조정
    const centerX = canvas.width / 2;
    const centerY = canvas.height / 2;

    // 배경 원 그리기
    ctx.clearRect(0, 0, canvas.width, canvas.height); // 캔버스 초기화
    ctx.beginPath();
    ctx.arc(centerX, centerY, radius, 0, 2 * Math.PI);
    ctx.strokeStyle = '#e0e0e0';  // 배경 원색
    ctx.lineWidth = 5;
    ctx.stroke();

    // 게이지 원 그리기
    ctx.beginPath();
    const startAngle = -0.5 * Math.PI; // 12시 방향에서 시작
    const endAngle = (2 * Math.PI * (endProgress / 100)) - 0.5 * Math.PI; // 진행 비율
    ctx.arc(centerX, centerY, radius, startAngle, endAngle);
    ctx.strokeStyle = '#298cff';  // 게이지 색상
    ctx.lineWidth = 5;
    ctx.stroke();
}

// DOM이 로드된 후에 게이지를 그리기
document.addEventListener("DOMContentLoaded", function() {
    drawProgressCircle('dust-circle', 80);  // 미세먼지 80%
    drawProgressCircle('temp-circle', 65);  // 온도 65%
    drawProgressCircle('humid-circle', 45); // 습도 45%
});
