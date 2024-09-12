package com.lgdx.chooroom.repository.admin;

import com.lgdx.chooroom.domain.admin.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    // 모든 방 정보를 가져오는 메서드
    @Query(value = """
            SELECT 
                res.R_NUM, res.CHIN_DATE, res.CHOUT_DATE, res.CUS_ID,
                rc.R_TEMP,
                r.R_TYPE, r.CIO_STATUS,
                ca.CUS_NAME, ca.CUS_CALL
            FROM 
                RESERVATION res 
            JOIN 
                ROOM_CONDITION rc ON res.R_NUM = rc.R_NUM
            JOIN 
                ROOMS r ON res.R_NUM = r.R_NUM
            JOIN 
                CUSTOMER_ACCOUNT ca ON res.CUS_ID = ca.CUS_ID
            """, nativeQuery = true)
    List<Object[]> getAllRoomDetailsWithCustomer();
}
