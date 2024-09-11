package com.lgdx.chooroom.repository.user;

import com.lgdx.chooroom.domain.room.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, String> {
    Rooms findByRoomNumber(String roomNumber);
}
