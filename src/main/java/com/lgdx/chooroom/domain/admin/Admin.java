package com.lgdx.chooroom.domain.admin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ROOM_CONDITION")
public class Admin {

    @Id
    @Column(name="R_NUM") private String roomNumber;
    @Column(name="R_CLEAN") private int roomCleaness;
    @Column(name="R_NOISE") private int roomNoiseLevel;
    @Column(name="R_AIRQ") private int roomAirQuality;

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomCleaness() {
        return roomCleaness;
    }

    public void setRoomCleaness(int roomCleaness) {
        this.roomCleaness = roomCleaness;
    }

    public int getRoomNoiseLevel() {
        return roomNoiseLevel;
    }

    public void setRoomNoiseLevel(int roomNoiseLevel) {
        this.roomNoiseLevel = roomNoiseLevel;
    }

    public int getRoomAirQuality() {
        return roomAirQuality;
    }

    public void setRoomAirQuality(int roomAirQuality) {
        this.roomAirQuality = roomAirQuality;
    }

    @Override
    public String toString() {
        return "RoomCondition{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomCleaness=" + roomCleaness +
                ", roomNoiseLevel=" + roomNoiseLevel +
                ", roomAirQuality=" + roomAirQuality +
                '}';
    }
}
