package com.lgdx.chooroom.service.rooms;

import com.lgdx.chooroom.domain.room.RoomCondition;
import com.lgdx.chooroom.domain.room.Rooms;
import com.lgdx.chooroom.repository.rooms.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomsService {

    @Autowired
    private RoomsRepository roomsRepository;

    public List<Rooms> getAllRooms() {
        List<Rooms> roomsList = roomsRepository.findAll();

        // roomNumber에서 숫자만 추출
        for(Rooms room : roomsList) {
            String roomNumber = room.getRoomNumber().replaceAll("[^0-9]", "");
            room.setRoomNumber(roomNumber);
        }

        return roomsList;
    }

//    public void updateCheckInStatus(String roomNumber, String status) {
//        Rooms room = roomsRepository.findByRoomNumber(roomNumber);
//        if (room != null) {
//            room.setCioStatus(status);  // 상태 업데이트
//            roomsRepository.save(room);  // DB에 저장
//        } else {
//            throw new RuntimeException("방 정보를 찾을 수 없습니다.");
//        }
//    }

}
