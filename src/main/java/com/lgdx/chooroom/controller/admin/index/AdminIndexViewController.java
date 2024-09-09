package com.lgdx.chooroom.controller.admin.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminIndexViewController {

    @GetMapping("/admin")
    public String adminIndex() {
        return "admin/index";
    }
}
