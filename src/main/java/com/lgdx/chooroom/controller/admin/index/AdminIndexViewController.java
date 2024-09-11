package com.lgdx.chooroom.controller.admin.index;

import com.lgdx.chooroom.dto.RoomsRoomConditionDTO;
import com.lgdx.chooroom.service.admin.RoomDetailServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminIndexViewController {
    @Autowired
    RoomDetailServiceAdmin roomDetailService;

    @GetMapping("/admin")
    public String adminIndex() {
        return "/admin/admin-device";
    }


    @GetMapping("/admin/api/rooms")
    @ResponseBody
    public List<RoomsRoomConditionDTO> rooms() {
        return roomDetailService.getRoomsWithCondition();
    }


}
