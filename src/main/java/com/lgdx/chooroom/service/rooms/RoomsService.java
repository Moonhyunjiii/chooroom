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
}
