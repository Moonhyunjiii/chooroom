package com.lgdx.chooroom.service.admin;

import com.lgdx.chooroom.dto.RoomsRoomConditionDTO;
import com.lgdx.chooroom.repository.admin.AdminRoomDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class RoomDetailServiceAdmin {
    @Autowired
    AdminRoomDetailRepository adminRoomDetailRepository;

    public List<RoomsRoomConditionDTO> getRoomsWithCondition() {

        List<Object[]> results = adminRoomDetailRepository.testtest();
        List<RoomsRoomConditionDTO> realResults = new ArrayList<>(); //변환.. 귀찮긴 하지만 ㅠ

        for(Object[] result : results) { //변환중중주웆ㅇ...
            realResults.add(new RoomsRoomConditionDTO(
                    (String)result[0] ,
                    (String)result[1] ,
                    ((BigDecimal)result[2]).intValue() ,
                    ((BigDecimal)result[3]).intValue() ,
                    ((BigDecimal)result[4]).intValue(),
                    ((BigDecimal)result[5]).intValue()));
        }

        return realResults;
    }
}
