document.addEventListener("DOMContentLoaded", function() {
    const checkUserIdButton = document.getElementById("checkUserId");
    const userIdInput = document.getElementById("userId");

    checkUserIdButton.addEventListener("click", function() {
        const userId = userIdInput.value;

        if (!userId) {
            alert("아이디를 입력하세요.");
            return;
        }

        // 서버에 userId를 보내서 중복 여부를 확인
        fetch(`/api/user/check-id?customerId=${encodeURIComponent(userId)}`) // 쿼리 파라미터 수정
            .then(response => response.json())
            .then(data => {
                if (data) {
                    alert("이미 사용 중인 아이디입니다.");
                } else {
                    alert("사용 가능한 아이디입니다.");
                }
            })
            .catch(error => {
                console.error("Error:", error);
                alert("아이디 중복검사 중 오류가 발생했습니다.");
            });
    });
});
