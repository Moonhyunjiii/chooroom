package com.lgdx.chooroom.service.user;

import com.lgdx.chooroom.domain.room.Rooms;
import com.lgdx.chooroom.domain.user.CustomerAccount;
import com.lgdx.chooroom.service.rooms.RoomsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RoomServiceTest {

    @Autowired
    RoomsService roomsService;

    @Test
    public void getAllRoomsTest() {
        List<Rooms> rooms = roomsService.getAllRooms();

        for(Rooms room : rooms) {
            System.out.println(room);
            System.out.println("RoomCondition: " + room.getRoomCondition());
        }
    }


}
