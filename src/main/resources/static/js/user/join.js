document.addEventListener("DOMContentLoaded", function () {
    // 중복 확인 버튼 클릭 시
    document.querySelector('.Idcheckbutton').addEventListener('click', function () {
        // 아이디 입력 필드 값 가져오기
        var customerId = document.getElementById('customerId').value;

        // 아이디가 입력되었는지 확인
        if (!customerId) {
            alert("아이디를 입력하세요.");
        } else {
            // 단순한 알림 출력
            alert("사용 가능한 아이디입니다!");
        }
    });
});