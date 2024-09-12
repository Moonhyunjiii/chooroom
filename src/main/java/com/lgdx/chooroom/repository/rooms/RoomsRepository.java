package com.lgdx.chooroom.repository.rooms;

import com.lgdx.chooroom.domain.room.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, String> {
    Rooms findByRoomNumber(String roomNumber);

    // viewType과 bedType에 따라 방을 필터링하는 쿼리 메서드
    @Query(value = "SELECT * FROM ROOMS WHERE (:viewType IS NULL OR V_TYPE = :viewType) AND (:bedType IS NULL OR B_TYPE = :bedType)", nativeQuery = true)
    List<Rooms> findRoomsByFilters(@Param("viewType") String viewType, @Param("bedType") String bedType);

    @Query(value = "SELECT ROUND(AVG(B.R_NOISE),1) FROM ROOMS A JOIN ROOM_CONDITION B ON A.R_NUM = B.R_NUM where A.R_TYPE = :roomType GROUP BY A.R_TYPE ", nativeQuery = true)
    Double noiseLevelAvg(@Param("roomType") String roomType);
}
