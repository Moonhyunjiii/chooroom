package com.lgdx.chooroom.repository.user;

import com.lgdx.chooroom.domain.room.Rooms;
import com.lgdx.chooroom.domain.room.RoomCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDetailRepository extends JpaRepository<Rooms, String> {

    @Query("SELECT r FROM Rooms r WHERE r.roomNumber = :roomNumber")
    Rooms findRoomByNumber(@Param("roomNumber") String roomNumber);

    @Query("SELECT rc FROM RoomCondition rc WHERE rc.roomNumber = :roomNumber")
    RoomCondition findRoomConditionByNumber(@Param("roomNumber") String roomNumber);
}


