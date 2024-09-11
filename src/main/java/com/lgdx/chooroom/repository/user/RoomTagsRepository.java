package com.lgdx.chooroom.repository.user;


import com.lgdx.chooroom.domain.room.RoomTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTagsRepository extends JpaRepository<RoomTags, Long> {
    List<RoomTags> findByRoomNumber(String roomNumber);
}

