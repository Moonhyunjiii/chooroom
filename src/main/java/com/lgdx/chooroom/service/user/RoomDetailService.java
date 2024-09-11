package com.lgdx.chooroom.service.user;

import com.lgdx.chooroom.domain.room.Rooms;
import com.lgdx.chooroom.domain.room.RoomCondition;
import com.lgdx.chooroom.repository.user.RoomDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomDetailService {

    @Autowired
    public RoomDetailRepository roomDetailRepository;

    public Rooms getRoomByNumber(String roomNumber) {
        return roomDetailRepository.findRoomByNumber(roomNumber);
    }

    public RoomCondition getRoomConditionByNumber(String roomNumber) {
        return roomDetailRepository.findRoomConditionByNumber(roomNumber);
    }
}

