package com.lgdx.chooroom.service.user;

import com.lgdx.chooroom.domain.room.Rooms;
import com.lgdx.chooroom.service.rooms.RoomTagsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.greaterThan;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@AutoConfigureMockMvc
public class FilterRoomTagServiceTest {

    @Autowired
    RoomTagsService roomTagsService;

    @Autowired
    private MockMvc mockMvc;  // MockMvc 주입

    @Test
    public void testGetRoomsByNoTags() {
        // 태그를 선택하지 않은 경우 모든 방을 반환
        List<Rooms> result = roomTagsService.getRoomsByTags(null);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetRoomsByTags() {
        // 태그 2개 선택
        List<String> tags = Arrays.asList("#LG스마트수전", "#프리미엄신발관리");
        List<Rooms> result = roomTagsService.getRoomsByTags(tags);

        assertNotNull(result);
        assertFalse(result.isEmpty());

        // 결과 출력 (Optional)
        result.forEach(room -> System.out.println(room.getRoomNumber() + " : " + room.getRoomType()));
    }

    @Test
    public void testGetFilteredRoomsByTags() throws Exception {
        List<String> tags = Arrays.asList("#LG스마트수전", "#프리미엄신발관리");

        mockMvc.perform(get("/api/rooms-by-tags")
                        .param("tags", String.join(",", tags)))  // 태그 파라미터 추가
                .andExpect(status().isOk())  // HTTP 200 상태 코드 확인
                .andExpect(jsonPath("$.length()").value(greaterThan(0)));  // JSON 응답의 길이가 0보다 큼
    }
}
