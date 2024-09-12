package com.lgdx.chooroom.service.user;

import com.lgdx.chooroom.domain.room.Rooms;
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

    @Test
    public void getFilteredRooms() {
        List<Rooms> rooms = roomsService.getFilteredRooms("오션뷰", "SINGLE", "낮은순");

        System.out.println(rooms);

    }

    @Test
    public void getNoiseLevelAvg() {
        Double standartresult = roomsService.getNoiseLevelAvg("STANDARD");
        Double deluxeresult = roomsService.getNoiseLevelAvg("DELUXE");
        Double suiteresult = roomsService.getNoiseLevelAvg("SUITE");

        System.out.println(standartresult);
        System.out.println(deluxeresult);
        System.out.println(suiteresult);
    }

}
