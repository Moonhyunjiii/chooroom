package com.lgdx.chooroom.repository.rooms;

import com.lgdx.chooroom.domain.room.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilterRoomTagsRepository extends JpaRepository<Rooms, String> {

    /*    @Query(value = "SELECT * FROM ROOMS R WHERE R.R_NUM IN (SELECT RT.R_NUM FROM ROOM_TAG RT WHERE RT.TAG_NAME IN :tags)", nativeQuery = true)
    List<Rooms> findByTagNames(@Param("tags") List<String> tags);*/

    @Query("SELECT r FROM Rooms r WHERE r.roomNumber IN (" +
            "SELECT rt.roomNumber FROM RoomTags rt WHERE rt.tagName IN :tags " +
            "GROUP BY rt.roomNumber HAVING COUNT(DISTINCT rt.tagName) = :tagCount)")
    List<Rooms> findRoomsByTags(@Param("tags") List<String> tags, @Param("tagCount") long tagCount);

}
