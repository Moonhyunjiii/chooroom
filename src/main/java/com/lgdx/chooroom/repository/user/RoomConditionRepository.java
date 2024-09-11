package com.lgdx.chooroom.repository.user;

import com.lgdx.chooroom.domain.room.RoomCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomConditionRepository extends JpaRepository<RoomCondition, String> {
    RoomCondition findByRoomNumber(String roomNumber);
}

