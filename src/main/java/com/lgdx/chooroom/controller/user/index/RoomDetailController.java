package com.lgdx.chooroom.controller.user.index;

import com.lgdx.chooroom.domain.room.Rooms;
import com.lgdx.chooroom.domain.room.RoomCondition;
import com.lgdx.chooroom.service.user.RoomDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoomDetailController {

    @Autowired
    public RoomDetailService roomDetailService;

    @GetMapping("/room-detail")
    public String getRoomDetail(@RequestParam("roomNumber") String roomNumber, Model model) {
        Rooms room = roomDetailService.getRoomByNumber(roomNumber);
        RoomCondition roomCondition = roomDetailService.getRoomConditionByNumber(roomNumber);

        model.addAttribute("room", room);
        model.addAttribute("roomCondition", roomCondition);
        return "user/room-detail";
    }
}
