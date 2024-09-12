
roomNumber = "1115";
customerId = "user12";
reservationId = "RES0040";

// 이미지 URL을 동적으로 설정
function fetchImageUrl(roomNumber) {
    fetch(`/room/Rooms/${roomNumber}`)
        .then(response => response.json())
        .then(data => {
            if (data.imageUrl) {
                document.getElementById("dynamic-image").src = data.imageUrl;
            } else {
                console.error('No image URL found in the response.');
            }
        })
        .catch(error => console.error('Error fetching image URL:', error));
}
// 방 정보 불러오기
function fetchRoomInfo(reservationId) {
    fetch(`/reservation/Reservation/${reservationId}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("roomname1").innerText = `객실명: ${data.roomId}호, 예약번호: ${data.reservId}`;
            document.getElementById("customer-name").innerText = `아이디 : ${data.cusId}`;
        })
        .catch(error => console.error('Error:', error));
}
// 고객의 컨디션 상태 불러오기
function fetchCustomerConditions(customerId) {
    fetch(`/user/CustomerRequestHealth/${customerId}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('noise-sensitive').checked = data.health.includes('소음에 민감해요');
            document.getElementById('dust-sensitive').checked = data.health.includes('먼지에 민감해요');
            document.getElementById('dust-allergy').checked = data.health.includes('먼지 알레르기');
            document.getElementById('mite-allergy').checked = data.health.includes('진드기 알레르기');
        })
        .catch(error => console.error('Error:', error));
}



// 방 상태 업데이트
function fetchRoomDetails(roomNumber) {
    fetch(`/room/RoomCondition/${roomNumber}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("roomID").innerText = `${data.roomId}호는 이런 방이에요.`;
            document.getElementById("roomNoise").innerHTML = `${data.noiseDescription} <br> 소음도: ${data.noiseLevel} dB`;
            document.getElementById("care-info").innerText = data.careDescription;
        })
        .catch(error => console.error('Error:', error));
}


// 종합 청정도 업데이트
function updateRoomStatus(roomNumber) {
    fetch(`/room/RoomCondition/${roomNumber}`)
        .then(response => response.json())
        .then(data => {
            const airQuality = data.AirQuality;
            const humidity = data.Humidity;
            const noiseLevel = data.noiseLevel;
            let poorConditionCount = 0;

            if (airQuality > 70) poorConditionCount++;
            if (humidity > 50) poorConditionCount++;
            if (noiseLevel > 50) poorConditionCount++;

            if (poorConditionCount === 3) {
                document.getElementById("status").innerText = '나쁨';
                document.getElementById("status").style.backgroundColor = 'red';
                document.getElementById("status-infor").innerText = '"방 상태가 좋지 않습니다."';
            } else if (poorConditionCount >= 1) {
                document.getElementById("status").innerText = '보통';
                document.getElementById("status").style.backgroundColor = 'yellowgreen';
                document.getElementById("status-infor").innerText = '"방 상태가 다소 괜찮습니다."';
            } else {
                document.getElementById("status").innerText = '좋음';
                document.getElementById("status").style.backgroundColor = 'green';
                document.getElementById("status-infor").innerText = '"방이 쾌적하게 관리되고 있어요."';
            }
        })
        .catch(error => console.error('Error:', error));
}



// 청소 상태 확인
function fetchCleaningStatus(roomNumber) {
    fetch(`/room/Rooms/${roomNumber}`)
        .then(response => response.json())
        .then(data => {
            const statusText = data.cleaningStatus === '청소완료' ? '청소가 완료되었습니다.' : '현재 청소 중입니다.';
            document.getElementById("clean-status-text").innerText = statusText;
        })
        .catch(error => console.error('Error:', error));
}



// 체크인 버튼 클릭 이벤트 처리


function checkIn(roomNumber) {
    fetch(`/room/Rooms/${roomNumber}`)
        .then(response => response.json())
        .then(data => {
            const cleanStatus = data.cleaningStatus;
            if (cleanStatus === "청소완료") {
                const confirmCheckIn = confirm("체크인 하시겠습니까?");
                if (confirmCheckIn) {
                    document.getElementById("check-in-button").innerText = "체크아웃 하기";
                    fetch(`/room/ROOMS/${roomNumber}`, {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify({ status: 'Y' })
                    })
                    .then(response => response.json())
                    .then(data => {
                        alert("체크인 완료되었습니다.");
                    })
                    .catch(error => console.error('Error:', error));
                }
            } else {
                alert("지금은 체크인이 불가능합니다.");
            }
        })
        .catch(error => console.error('Error:', error));
}

// ** drawProgressCircle 함수 추가 **
function drawProgressCircle(canvasId, roomNumber, dataField, labelId, color) {
    let endProgress = 0;

    fetch(`/room/RoomCondition/${roomNumber}`)
        .then(response => response.json())
        .then(data => {
            endProgress = parseInt(data[dataField]); // 해당 데이터를 받아옴
            const canvas = document.getElementById(canvasId);
            const ctx = canvas.getContext('2d');
            const radius = 30;
            const centerX = canvas.width / 2;
            const centerY = canvas.height / 2;
            let progress = 0;
            const speed = 2;

            function drawCircle() {
                ctx.clearRect(0, 0, canvas.width, canvas.height);
                ctx.beginPath();
                ctx.arc(centerX, centerY, radius, 0, 2 * Math.PI);
                ctx.strokeStyle = '#e0e0e0';
                ctx.lineWidth = 5;
                ctx.stroke();

                ctx.beginPath();
                const startAngle = -0.5 * Math.PI;
                const endAngle = (2 * Math.PI * (progress / 100)) - 0.5 * Math.PI;
                ctx.arc(centerX, centerY, radius, startAngle, endAngle);
                ctx.strokeStyle = color;  // 색상 매개변수 사용
                ctx.lineWidth = 5;
                ctx.stroke();

                ctx.font = "16px Arial";
                ctx.fillStyle = "#000";  // 텍스트 색상
                ctx.textAlign = "center";
                ctx.textBaseline = "middle";
                ctx.fillText(`${Math.floor(progress)}%`, centerX, centerY);

                if (progress < endProgress) {
                    progress += speed;
                    requestAnimationFrame(drawCircle);
                }
            }
            drawCircle();

            // 업데이트된 값에 따른 텍스트 출력
            if (endProgress > 70) {
                document.getElementById(labelId).innerText = "높음";
            } else if (endProgress >= 40) {
                document.getElementById(labelId).innerText = "적당";
            } else {
                document.getElementById(labelId).innerText = "낮음";
            }
        })
        .catch(error => console.error('Error:', error));
}

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
document.getElementById("loginButton").addEventListener("click", function () {
        window.location.href = '/login'
    });

// 각 게이지에 맞춰 호출
document.getElementById("iot-control-button").addEventListener("click", function () {
        window.location.href = '/IOT'
    });

fetchImageUrl(roomNumber);
fetchRoomInfo(reservationId);
drawProgressCircle('dust-circle', roomNumber, 'AirQuality', 'air-lev', '#29ff30');
drawProgressCircle('temp-circle', roomNumber, 'Temperature', 'temp-lev', '#ff7429');
drawProgressCircle('humid-circle', roomNumber, 'Humidity', 'humid-lev', '#298cff');
updateRoomStatus(roomNumber);
fetchCleaningStatus(roomNumber);
setInterval(() => fetchCleaningStatus(roomNumber), 60000);
document.getElementById("check-in-button").addEventListener("click", function () {
    checkIn(roomNumber);
});
fetchRoomDetails(roomNumber);
fetchCustomerConditions(customerId);