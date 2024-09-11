package com.lgdx.chooroom.controller.user.index;

import com.lgdx.chooroom.domain.user.CustomerAccount;
import com.lgdx.chooroom.domain.user.CustomerFeedback;
import com.lgdx.chooroom.domain.user.CustomerRequestHealth;
import com.lgdx.chooroom.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserIndexViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String userIndex() {
        return "user/index";
    }

    // 회원가입 폼을 보여주는 메소드
    @GetMapping("/join")
    public String showJoinForm(Model model) {
        model.addAttribute("customerAccount", new CustomerAccount());
        model.addAttribute("customerRequestHealth", new CustomerRequestHealth());
        model.addAttribute("customerFeedback", new CustomerFeedback());
        return "user/join";  // join.html 파일을 반환
    }

    @PostMapping("/join")
    public String registerUser(@ModelAttribute CustomerAccount customerAccount,
                               @ModelAttribute CustomerRequestHealth customerRequestHealth,
                               @ModelAttribute CustomerFeedback customerFeedback) {
        // 서비스 계층으로 회원가입 요청
        userService.registerUser(customerAccount, customerRequestHealth, customerFeedback);
        return "redirect:/joinSuccess";  // 회원가입 성공 페이지로 리다이렉트
    }


}
