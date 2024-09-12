package com.lgdx.chooroom.service.admin;

import com.lgdx.chooroom.dto.RoomsRoomAdminDTO;
import com.lgdx.chooroom.repository.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<RoomsRoomAdminDTO> getAllRoomDetailsWithCustomer() {
        List<Object[]> results = adminRepository.getAllRoomDetailsWithCustomer();
        List<RoomsRoomAdminDTO> roomDetails = new ArrayList<>();

        for (Object[] result : results) {


            RoomsRoomAdminDTO dto = new RoomsRoomAdminDTO(
                    (String) result[0],              //
                    (Date) result[1],              //
                    (Date) result[2],              //
                    (String) result[3],              //
                    ((BigDecimal) result[4]).intValue(), //
                    (String) result[5],                //
                    (String) result[6],                //
                    (String) result[7],              //
                    (String) result[8]             //
            );
            roomDetails.add(dto);

        }

        return roomDetails;
    }
}
