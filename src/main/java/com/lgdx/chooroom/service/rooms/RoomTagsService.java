package com.lgdx.chooroom.service.rooms;


import com.lgdx.chooroom.domain.room.Rooms;
import com.lgdx.chooroom.repository.rooms.FilterRoomTagsRepository;
import com.lgdx.chooroom.repository.user.RoomTagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTagsService {

    @Autowired
    private FilterRoomTagsRepository filterRoomTagsRepository;

/*    public List<Rooms> getRoomsByTags(List<String> tags) {
        return roomTagsRepository.findByTagNames(tags);
    }*/

    public List<Rooms> getRoomsByTags(List<String> tags) {
        if (tags == null || tags.isEmpty()) {
            // 태그가 선택되지 않았을 때 모든 방을 반환
            return filterRoomTagsRepository.findAll();
        } else {
            // 선택된 태그에 맞는 방을 반환
            return filterRoomTagsRepository.findRoomsByTags(tags, tags.size());
        }
    }
}
