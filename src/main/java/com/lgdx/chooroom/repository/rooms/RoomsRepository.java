package com.lgdx.chooroom.repository.rooms;

import com.lgdx.chooroom.domain.room.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Long> {
    Rooms findByRoomNumber(String roomNumber);

/*    @Query("SELECT r FROM Rooms r JOIN FETCH r.roomCondition")
    List<Rooms> findAllJoinCondition();*/
}
