package com.lgdx.chooroom.controller.user.rooms;

import com.lgdx.chooroom.domain.room.Rooms;
import com.lgdx.chooroom.service.rooms.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomsDataController {

    @Autowired
    RoomsService roomsService;

    @GetMapping("/api/rooms")
    @ResponseBody
    public List<Rooms> getAllRooms() {
        return roomsService.getAllRooms();
    }


}
