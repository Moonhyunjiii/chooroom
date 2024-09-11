package com.lgdx.chooroom.service.admin;

import com.lgdx.chooroom.dto.RoomsRoomConditionDTO;
import com.lgdx.chooroom.repository.admin.AdminRoomDetailRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RoomDetailServiceAdminTest {
    @Autowired
    RoomDetailServiceAdmin roomDetailServiceAdmin;

    @Test
    public void 전체조회() {
        List<RoomsRoomConditionDTO> results = roomDetailServiceAdmin.getRoomsWithCondition();

        for(RoomsRoomConditionDTO result : results) {
            System.out.println(result);
        }

    }
}
