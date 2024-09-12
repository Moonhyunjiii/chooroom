package com.lgdx.chooroom.service.rooms;

import com.lgdx.chooroom.domain.room.RoomCondition;
import com.lgdx.chooroom.domain.room.Rooms;
import com.lgdx.chooroom.repository.rooms.RoomsRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;

@Service
public class RoomsService {

    @Autowired
    private RoomsRepository roomsRepository;

    public List<Rooms> getAllRooms() {
        List<Rooms> roomsList = roomsRepository.findAll();

        // roomNumber에서 숫자만 추출
        for(Rooms room : roomsList) {
            String roomNumber = room.getRoomNumber().replaceAll("[^0-9]", "");
            room.setRoomNumber(roomNumber);
        }

        return roomsList;
    }

    // 필터 조건에 따라 데이터를 조회하는 메서드 추가
    public List<Rooms> getFilteredRooms(String viewType, String bedType, String priceOrder) {
        // 필터 조건을 적용하여 데이터를 조회
        List<Rooms> roomsList = roomsRepository.findRoomsByFilters(viewType, bedType);

        // roomNumber에서 숫자만 추출
        for(Rooms room : roomsList) {
            String roomNumber = room.getRoomNumber().replaceAll("[^0-9]", "");
            room.setRoomNumber(roomNumber);
        }

        // priceOrder가 null인 경우 기본 정렬 또는 정렬 없음
        if (priceOrder == null || priceOrder.isEmpty()) {
            // 기본 정렬이 필요한 경우 추가
            // roomsList.sort(Comparator.comparing(Rooms::getPrice)); // 기본 정렬 (오름차순 예시)
            return roomsList;
        }

        // 가격 정렬 처리
        if ("높은순".equals(priceOrder)) {
            roomsList.sort(Comparator.comparing(Rooms::getRoomPrice).reversed()); // 가격 높은순
        } else if ("낮은순".equals(priceOrder)) {
            roomsList.sort(Comparator.comparing(Rooms::getRoomPrice)); // 가격 낮은순
        }

        return roomsList;
    }

    public Double getNoiseLevelAvg(String roomType) {
        Double noiseLevelAvg = roomsRepository.noiseLevelAvg(roomType);
        return noiseLevelAvg != null ? noiseLevelAvg : 0.0;
    }

    public String getMinRoomPrice(String roomType) {
        Double minRoomPrice = roomsRepository.minRoomPrice(roomType);

        // DecimalFormat을 사용하여 가격을 #,### 형식으로 포맷
        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        // 가격이 null이 아니면 포맷된 가격 반환, null이면 0을 반환
        return minRoomPrice != null ? decimalFormat.format(minRoomPrice) : decimalFormat.format(0);
    }
}
