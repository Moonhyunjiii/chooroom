package com.lgdx.chooroom.controller.user.rooms;

import com.lgdx.chooroom.domain.room.RoomTags;
import com.lgdx.chooroom.domain.room.Rooms;
import com.lgdx.chooroom.service.rooms.RoomTagsService;
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
import java.util.stream.Collectors;

@RestController
public class RoomsDataController {

    @Autowired
    RoomsService roomsService;

    @Autowired
    RoomTagsService roomTagsService;

    @GetMapping("/api/rooms")
    @ResponseBody
    public List<Rooms> getFilteredRooms(@RequestParam(name = "viewType", required = false) String viewType,
                                        @RequestParam(name = "bedType", required = false) String bedType,
                                        @RequestParam(name = "priceOrder", required = false) String priceOrder,
                                        @RequestParam(name = "hashtags", required = false) List<String> hashtags ) {// 해시태그 필터 추가

        // 필터링 로직: viewType, bedType, priceOrder에 따라 필터
        List<Rooms> rooms = roomsService.getFilteredRooms(viewType, bedType, priceOrder);
/*
        // 해시태그 필터 추가(개수별 조합>??)
        if (hashtags != null && !hashtags.isEmpty()) {
            rooms = rooms.stream()
                    .filter(room -> {
                        List<String> roomTags = room.getTags().stream()
                                .map(RoomTags::getTagName)  // 방의 태그 이름 목록 가져오기
                                .collect(Collectors.toList());

                        // 방의 태그 중 선택된 해시태그가 모두 포함되는지 확인
                        long matchingTagsCount = hashtags.stream()
                                .filter(roomTags::contains)
                                .count();

                        // 선택한 해시태그 중 최소 1개가 포함된 방만 필터링 (제한 없이)
                        return matchingTagsCount > 0 && matchingTagsCount <= hashtags.size();
                    })
                    .collect(Collectors.toList());
        }*/
        // 해시태그 필터 추가(중복필터)
        if (hashtags != null && !hashtags.isEmpty()) {
            rooms = rooms.stream()
                    .filter(room -> hashtags.stream()
                            .allMatch(hashtag -> room.getTags().stream()
                                    .anyMatch(tag -> tag.getTagName().equals(hashtag))))
                    .collect(Collectors.toList());
        }
        /*
        // 해시태그 필터 추가(중복 필터 X)
        if (hashtags != null && !hashtags.isEmpty()) {
            rooms = rooms.stream()
                    .filter(room -> room.getTags().stream()
                            .anyMatch(tag -> hashtags.contains(tag.getTagName())))
                    .collect(Collectors.toList());
        }*/

        return rooms;
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
