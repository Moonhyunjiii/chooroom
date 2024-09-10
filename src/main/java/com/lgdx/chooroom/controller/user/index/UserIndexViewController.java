package com.lgdx.chooroom.controller.user.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserIndexViewController {

    @GetMapping("/")
    public String userIndex() {
        return "user/index";
    }
    
}
