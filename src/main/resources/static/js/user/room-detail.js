// 모달 관련 스크립트
var modal = document.getElementById("myModal");
var btn = document.getElementById("openModalBtn");
var span = document.getElementsByClassName("close")[0];

// 모달을 열기
btn.onclick = function() {
    modal.style.display = "block";
}

// 모달을 닫기
span.onclick = function() {
    modal.style.display = "none";
}

// 모달 바깥을 클릭하면 모달 닫기
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

// 예약하기 버튼 클릭 시 알림창 띄우기
var reserveBtn = document.getElementById("reserveBtn");
reserveBtn.onclick = function() {
    alert("예약이 완료되었습니다.\n완료된 예약은 마이페이지에서 확인하실 수 있습니다.");
}
