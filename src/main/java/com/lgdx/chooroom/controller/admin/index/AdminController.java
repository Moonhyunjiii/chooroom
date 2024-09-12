package com.lgdx.chooroom.controller.admin.index;

import com.lgdx.chooroom.dto.RoomsRoomAdminDTO;
import com.lgdx.chooroom.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    // 모든 방 정보를 가져오는 메서드
    @GetMapping("/dashboard")
    public String getRoomDetails(Model model) {
        List<RoomsRoomAdminDTO> roomDetails = adminService.getAllRoomDetailsWithCustomer();

        System.out.println(roomDetails);

        model.addAttribute("room", roomDetails);
        return "admin/index"; // Thymeleaf 페이지로 반환
    }
}

