//function openModalWithRoomDetails(roomNumber) {
//    // 모달을 열고 방 세부정보를 표시하는 코드
//    console.log(`Opening modal for room number: ${roomNumber}`);
//    // 모달 열기 및 세부정보 요청 로직
//    // 모달 관련 스크립트
//    var modal = document.getElementById("myModal");
//    var btn = document.querySelectorAll(".room-select-btn");
//  //  var span = document.getElementsByClassName("close")[0];
//
//    // 모달을 열기
//    btn.onclick = function() {
//        modal.style.display = "block";
//    }
//
//    // 모달을 닫기
//  //  span.onclick = function() {
//  //      modal.style.display = "none";
//  //  }
//
//    // 모달 바깥을 클릭하면 모달 닫기
//    window.onclick = function(event) {
//        if (event.target == modal) {
//            modal.style.display = "none";
//        }
//    }
//
//    // 예약하기 버튼 클릭 시 알림창 띄우기
//    var reserveBtn = document.getElementById("reserveBtn");
//    reserveBtn.onclick = function() {
//        alert("예약이 완료되었습니다.\n완료된 예약은 마이페이지에서 확인하실 수 있습니다.");
//    }
//}

$(document).ready(function() {
            // 예약하기 버튼 클릭 시 동작
            $('#reserveBtn').click(function() {

                // 예약 완료 메시지 표시
                alert('예약이 완료되었습니다. 예약확인하기에서 확인하실 수 있습니다.');


                //fetch 써가지고

                //예약 완료 여부를 던져준다.


                // 창 닫기
                window.close();
            });
        });

