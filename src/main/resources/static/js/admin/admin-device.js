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

// 서버로부터 데이터를 가져오는 fetch 요청
async function fetchRoomData() {
    try {
        const response = await fetch('/admin/api/rooms');  // API 엔드포인트를 서버 주소로 변경
        const rooms = await response.json();  // 서버에서 받은 데이터를 JSON으로 변환
        console.log(rooms);

        // 데이터 가져오기가 완료되면 정렬 후 표시
        const sortedRooms = sortRoomsByCondition(rooms);
        renderRooms(sortedRooms);  // 정렬된 데이터 렌더링
    } catch (error) {
        console.error('데이터를 불러오는데 실패했습니다:', error);
    }
}

// 방 상태를 평가하고 테두리 색상을 설정하는 함수
function evaluateRoomStatus(room) {
    let poorConditionCount = 0;

    if (room.roomHumidity > 50) poorConditionCount++;    // 습도 > 50
    if (room.roomTemperature > 26 || room.roomTemperature < 18) poorConditionCount++;  // 온도 > 26도 또는 < 18도
    if (room.roomAirQuality > 50) poorConditionCount++;   // 공기질 > 70

    if (poorConditionCount == 3) {
        return {status: '나쁨', borderColor: 'red', poorConditionCount: poorConditionCount};      // 3가지 조건 모두 나쁨
    } else if (poorConditionCount >= 1) {
        return {status: '보통', borderColor: 'yellow', poorConditionCount: poorConditionCount};  // 1~2가지 조건 나쁨
    } else {
        return {status: '좋음', borderColor: 'green', poorConditionCount: poorConditionCount};    // 모든 조건 좋음
    }
}

// 방 상태에 따른 정렬 함수
function sortRoomsByCondition(rooms) {
    return rooms.sort((a, b) => {
        const statusA = evaluateRoomStatus(a).poorConditionCount;
        const statusB = evaluateRoomStatus(b).poorConditionCount;
        return statusB - statusA; // 나쁨이 위로 정렬되도록 내림차순 정렬
    });
}

// 데이터를 받아서 HTML에 반영하는 함수
function renderRooms(rooms) {
    if (!Array.isArray(rooms)) {
        console.error("rooms 데이터가 배열이 아닙니다.", rooms);
        return;
    }

    const roomContainer = document.getElementById('roomContainer');
    roomContainer.innerHTML = '';  // 기존 내용을 초기화

    rooms.forEach(room => {
        const roomCard = document.createElement('div');
        const roomStatus = evaluateRoomStatus(room);  // 방 상태 평가
        roomCard.className = 'room-card';
        roomCard.style.border = `2px solid ${roomStatus.borderColor}`;  // 방 상태에 따른 테두리 색상 설정

        roomCard.innerHTML = `
            <h4>${room.roomNumber}<span class="room-type">${room.roomType}</span></h4>

            <div class="status-section">
                <div class="status-item">
                    <div class="circle blue">${room.roomHumidity}%</div>
                    <span>습도</span>
                </div>
                <div class="status-item">
                    <div class="circle red">${room.roomTemperature}°C</div>
                    <span>온도</span>
                </div>
                <div class="status-item">
                    <div class="circle green">${room.roomAirQuality}</div>
                    <span>공기질</span>
                </div>
            </div>

            <div class="details-section">
                <div class="detail-item">
                    <span>냉장고</span><span class="status on">ON</span><span>-10°C, 1°C</span>
                </div>
                <div class="detail-item">
                    <span>에어컨</span><span class="status off">OFF</span>
                </div>
                <div class="detail-item">
                    <span>공청기</span><span class="status off">OFF</span>
                </div>
            </div>

            <div class="button-section">
                <button class="manage-button">관리하기</button>
            </div>
        `;

        roomContainer.appendChild(roomCard);
    });
}

// 페이지가 로드될 때 데이터를 가져와서 화면에 표시
fetchRoomData();
