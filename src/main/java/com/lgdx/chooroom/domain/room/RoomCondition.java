package com.lgdx.chooroom.domain.room;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ROOM_CONDITION")
public class RoomCondition {

    @Id
    @Column(name="R_NUM") private String roomNumber;
    @Column(name="R_CLEAN") private int roomCleaness;
    @Column(name="R_NOISE") private int roomNoiselevel;
    @Column(name="R_AIRQ") private int roomAirquality;

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

    public int getRoomNoiselevel() {
        return roomNoiselevel;
    }

    public void setRoomNoiselevel(int roomNoiselevel) {
        this.roomNoiselevel = roomNoiselevel;
    }

    public int getRoomAirquality() {
        return roomAirquality;
    }

    public void setRoomAirquality(int roomAirquality) {
        this.roomAirquality = roomAirquality;
    }

    @Override
    public String toString() {
        return "RoomCondition{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomCleaness=" + roomCleaness +
                ", roomNoiselevel=" + roomNoiselevel +
                ", roomAirquality=" + roomAirquality +
                '}';
    }
}
