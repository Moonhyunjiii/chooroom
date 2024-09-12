package com.lgdx.chooroom.service.admin;

import com.lgdx.chooroom.dto.RoomsRoomAdminDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @Test
    public void 모델에_room이_잘_담겼는지() {
        List<RoomsRoomAdminDTO> roomDetails = adminService.getAllRoomDetailsWithCustomer();

        for (RoomsRoomAdminDTO roomDetail : roomDetails) {
            System.out.println("확인확인" + roomDetail);
            System.out.flush();  // 콘솔 출력을 즉시 반영
        }
    }

}
