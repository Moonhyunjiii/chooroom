package com.lgdx.chooroom.controller.user.index;


import com.lgdx.chooroom.domain.reservation.Reservation;
import com.lgdx.chooroom.domain.room.RoomCondition;
import com.lgdx.chooroom.domain.room.RoomTags;
import com.lgdx.chooroom.domain.room.Rooms;
import com.lgdx.chooroom.domain.user.CustomerRequestHealth;
import com.lgdx.chooroom.repository.rooms.RoomsRepository;
import com.lgdx.chooroom.repository.user.*;
import com.lgdx.chooroom.service.rooms.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserRoomPageController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomConditionRepository roomConditionRepository;

    @Autowired
    private RoomTagsRepository roomTagsRepository;

    @Autowired
    private RoomsRepository roomsRepository;

    @Autowired
    private CustomerRequestHealthRepository customerRequestHealthRepository;

    @Autowired
    private RoomsService roomService;



    // 방 번호 및 예약 번호 가져오기
    @GetMapping("/reservation/Reservation/{reservationId}")
    public Map<String, String> getRoomInfo(@PathVariable String reservationId) {
        Map<String, String> response = new HashMap<>();
        Reservation reservation = reservationRepository.findByReservationId(reservationId);

        response.put("roomId", reservation.getRoomNumber());
        response.put("reservId", reservation.getReservationId());
        response.put("cusId", reservation.getCustomerId());

        return response;
    }

//    // 방 상태 (청소 상태) 확인
    @GetMapping("/room/Rooms/{roomNumber}")
    @ResponseBody
    public Map<String, String> getRoomStatus(@PathVariable String roomNumber) {
        Map<String, String> response = new HashMap<>();
        Rooms rooms = roomsRepository.findByRoomNumber(roomNumber);


        if(rooms.getCleanStatus().equals("청소완료")){
            response.put("cleaningStatus", "청소완료");
        }
        else{
            response.put("cleaningStatus", "청소중");
        }
        response.put("imageUrl",rooms.getRoomStructure());
        response.put("roomT", rooms.getRoomType());
        return response;
    }

//    @PostMapping("/room/update-checkin/{roomNumber}")
//    public ResponseEntity<String> updateCheckInStatus(@PathVariable String roomNumber, @RequestBody Map<String, String> payload) {
//        String status = payload.get("status");
//        try {
//            roomService.updateCheckInStatus(roomNumber, status);
//            return ResponseEntity.ok("체크인 상태가 성공적으로 업데이트되었습니다.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("체크인 상태 업데이트 실패");
//        }
//    }


    @GetMapping("/user/CustomerRequestHealth/{customerId}")
    @ResponseBody
    public Map<String, String> getHealthStatus(@PathVariable String customerId) {
        Map<String, String> response = new HashMap<>();

        // cus_id로 고객의 건강 요청 정보 리스트 조회
        List<CustomerRequestHealth> customerRequestHealthList = customerRequestHealthRepository.findByCustomerId(customerId);

        // 조회된 건강 요청 정보 리스트에서 h_info 필드를 가져와서 맵에 저장
        StringBuilder healthInfoBuilder = new StringBuilder();
        for (CustomerRequestHealth health : customerRequestHealthList) {
            healthInfoBuilder.append(health.getHealthInfo()).append(", "); // h_info 필드를 가져옴
        }

        // 맨 마지막 ", "를 제거
        if (healthInfoBuilder.length() > 0) {
            healthInfoBuilder.setLength(healthInfoBuilder.length() - 2);
        }

        // health 키에 저장
        response.put("health", healthInfoBuilder.toString());

        return response;
    }



    // 방 소음 상태 및 케어 정보
    @GetMapping("/room/RoomCondition/{roomNumber}")
    @ResponseBody
    public Map<String, Object> getRoomDetails(@PathVariable String roomNumber) {
        Map<String, Object> response = new HashMap<>();

        RoomCondition roomCondition = roomConditionRepository.findByRoomNumber(roomNumber);
        if (roomCondition.getroomNoiseLevel() < 40) {
            response.put("noiseDescription", "편안하게 휴식하기에 알맞은 조용하고 편안한 방입니다.");
            response.put("noiseLevel", roomCondition.getroomNoiseLevel());
        } else {
            response.put("noiseDescription", "주변 소음이 조금 있는 편이나, 창문밖으로 보이는 전망이 매우 아름다운 방이에요.");
            response.put("noiseLevel", roomCondition.getroomNoiseLevel());
        }
        response.put("Temperature", roomCondition.getRoomTemperature());
        response.put("AirQuality", roomCondition.getroomAirQuality());
        response.put("Humidity", roomCondition.getRoomHUMIDITY());
        response.put("roomId", roomCondition.getRoomNumber());

        List<RoomTags> roomTags = roomTagsRepository.findByRoomNumber(roomNumber);
        StringBuilder careDescription = new StringBuilder();
        for (RoomTags tag : roomTags) {
            switch (tag.getTagName()) {
                case "#고온살균얼음위생정수기":
                    careDescription.append("#고온살균얼음위생정수기 : 깨끗한 물을 마시면서 휴식을 취할 수 있어요.\n");
                    break;
                case "#고급의류케어":
                    careDescription.append("#고급의류케어 : 소중한 옷을 말끔하게 관리 할 수 있어요.\n");
                    break;
                case "#프리미엄신발관리":
                    careDescription.append("#프리미엄신발관리 : 소중한 신발을 말끔하게 관리 할 수 있어요.\n");
                    break;
                case "#LG스마트수전":
                    careDescription.append("#LG스마트수전 : 더욱 깨끗한 물로 내가 딱 원하는 온도로 샤워를 즐길 수 있어요.\n");
                    break;
                case "#프리미엄안마의자":
                    careDescription.append("#프리미엄안마의자 : 최고급 안마기기로 하루의 피로를 풀 수 있어요.\n");
                    break;
                case "#LG OLED 오브제컬렉션":
                    careDescription.append("#LG OLED 오브제컬렉션 : 지금까지 본적 없는 선명한 화면의 티비를 즐길 수 있어요.\n");
                    break;
                case "#Dolby Atmos 시네마룸":
                    careDescription.append("#Dolby Atmos 시네마룸 : 마치 나만의 영화관이 생긴 것 같은 느낌이 들게 해줘요.\n");
                    break;
                case "#프리미엄청정룸":
                    careDescription.append("#프리미엄청정룸 : 깨끗한 공기를 마시면 휴식 할 수 있어요.\n");
                    break;
            }
        }
        response.put("careDescription", careDescription.toString());

        return response;
    }
}
