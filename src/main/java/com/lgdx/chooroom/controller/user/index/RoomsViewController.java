package com.lgdx.chooroom.controller.user.index;

import com.lgdx.chooroom.domain.room.Rooms;
import com.lgdx.chooroom.service.user.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RoomsViewController {

    @Autowired
    private RoomsService roomsService;

    @GetMapping("/rooms")
    public String getAllRooms(Model model) {
        // 모든 방 데이터를 DB에서 가져옴
        List<Rooms> rooms = roomsService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "/user/index";
    }
}
