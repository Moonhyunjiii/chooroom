package com.lgdx.chooroom.controller.user.index;

import com.lgdx.chooroom.domain.user.CustomerAccount;
import com.lgdx.chooroom.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String customerId, @RequestParam String customerPw) {
        CustomerAccount customerAccount = userService.login(customerId, customerPw);
        if (customerAccount != null) {
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.status(401).body("로그인 실패: 아이디 또는 비밀번호가 올바르지 않습니다.");
        }
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody CustomerAccount customerAccount){
        if(userService.isUserIdTaken(customerAccount.getCustomerId())){
            return ResponseEntity.status(400).body("이미 사용 중인 아이디입니다.");
        }
        userService.join(customerAccount);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }

    @GetMapping("/check-id")
    public ResponseEntity<Boolean> checkUserId(@RequestParam String customerId) {
        boolean isTaken = userService.isUserIdTaken(customerId);
        return ResponseEntity.ok(isTaken);
    }
}
