package com.lgdx.chooroom.repository.admin;

import com.lgdx.chooroom.domain.room.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRoomDetailRepository extends JpaRepository<Rooms, String> {
    @Query(value = "select a.r_type , b.* from rooms a , room_condition b where a.r_num = b.r_num" , nativeQuery = true)
    List<Object[]> testtest() ;
}
