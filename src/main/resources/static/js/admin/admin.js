// 사이드바 클릭 이벤트
document.querySelectorAll('.sidebar-item').forEach(function (item) {
    item.addEventListener('click', function () {
        let target = item.getAttribute('data-target');
        console.log(target + ' 섹션으로 이동합니다.');
        // 페이지 이동 또는 내용 표시 로직 추가
    });
});

// 방 카드 클릭 이벤트
document.querySelectorAll('.room-card').forEach(function (card) {
    card.addEventListener('click', function () {
        let roomNumber = card.getAttribute('data-room');
        console.log(roomNumber + '호 방 정보를 확인합니다.');
        // 방 정보 페이지로 이동하거나 팝업 표시 로직 추가
    });
});

