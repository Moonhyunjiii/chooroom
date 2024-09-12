package com.lgdx.chooroom.controller.user.rooms;

import com.lgdx.chooroom.domain.room.Rooms;
import com.lgdx.chooroom.service.rooms.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoomsDataController {

    @Autowired
    RoomsService roomsService;

    @GetMapping("/api/rooms")
    @ResponseBody
    public List<Rooms> getFilteredRooms(@RequestParam(name = "viewType", required = false) String viewType,
                                        @RequestParam(name = "bedType", required = false) String bedType,
                                        @RequestParam(name = "priceOrder", required = false) String priceOrder) {

        // 필터에 따라 방 데이터를 조회하는 서비스 호출
        return roomsService.getFilteredRooms(viewType, bedType, priceOrder);
    }

    @GetMapping("/rooms-noiseAvg")
    @ResponseBody
    public Map<String, Object> getRoomNoiseAndPrice(@RequestParam(name = "roomType") String roomType) {
        Double noiseLevelAvg = roomsService.getNoiseLevelAvg(roomType);
        String minRoomPrice = roomsService.getMinRoomPrice(roomType);
        // JSON 응답으로 소음도 값을 반환
        Map<String, Object> response = new HashMap<>();
        response.put("noiseLevelAvg", noiseLevelAvg);
        response.put("minRoomPrice", minRoomPrice);

        return response;
    }

}
