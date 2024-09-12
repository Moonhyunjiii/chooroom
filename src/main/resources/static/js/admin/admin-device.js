// 서버로부터 데이터를 가져오는 fetch 요청
    async function fetchRoomData() {
        try {
            // 서버에서 데이터를 요청 (URL은 서버 API의 엔드포인트로 대체해야 합니다.)
            const response = await fetch('/admin/api/rooms');  // API 엔드포인트를 실제 서버 주소로 변경
            const rooms = await response.json();  // 서버에서 받은 데이터를 JSON으로 변환
            console.log(rooms);

            renderRooms(rooms);  // 데이터를 렌더링하는 함수 호출
        } catch (error) {
            console.error('데이터를 불러오는데 실패했습니다:', error);
        }
    }

    // 데이터를 받아서 HTML에 반영하는 함수
    function renderRooms(rooms) {
        if (!Array.isArray(rooms)) {
                console.error("rooms 데이터가 배열이 아닙니다.", rooms);
                return;
            }
        const roomContainer = document.getElementById('roomContainer');

        // 데이터를 기반으로 동적으로 HTML 생성
        rooms.forEach(room => {
            const roomCard = document.createElement('div');
            roomCard.className = 'room-card';

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
                        <div class="circle blue">${room.roomAirQuality}</div>
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