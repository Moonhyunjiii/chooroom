package com.lgdx.chooroom.controller.user.index;

import com.lgdx.chooroom.domain.user.CustomerAccount;
import com.lgdx.chooroom.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserIndexViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String userIndex(Model model) {
        return "user/index";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }
    @GetMapping("/userRoomInfo")
    public String userRoomInfo() {
        return "user/userRoomInfo";
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam String customerId, @RequestParam String customerPw, Model model) {
        CustomerAccount customerAccount = userService.login(customerId, customerPw);
        if (customerAccount != null) {
            return "redirect:user/login";
        } else {
            model.addAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "user/login";
        }
    }

    // 회원가입 페이지
    @GetMapping("/join")
    public String joinPage() {
        return "user/join";
    }

    // 회원가입 처리
    @PostMapping("/join")
    public String register(CustomerAccount customerAccount, Model model) {
        if (customerAccount.getCustomerId().length() > 10 || customerAccount.getCustomerPw().length() > 10) {
            model.addAttribute("joinError", "아이디와 비밀번호는 최대 10자까지 허용됩니다.");
            return "user/join";
        }

        if (userService.isUserIdTaken(customerAccount.getCustomerId())) {
            model.addAttribute("joinError", "이미 사용 중인 아이디입니다.");
            return "user/join";
        }

        userService.join(customerAccount);
        return "redirect:user/index";
    }

}