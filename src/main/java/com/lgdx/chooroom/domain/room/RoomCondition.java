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
    @Column(name="R_HUMID") private int roomHUMIDITY;
    @Column(name="R_NOISE") private int roomNoiseLevel;
    @Column(name="R_AIRQ") private int roomAirQuality;
    @Column(name="R_TEMP") private int roomTemperature;
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomHUMIDITY() {
        return roomHUMIDITY;
    }

    public void setRoomHUMIDITY(int roomHUMIDITY) {
        this.roomHUMIDITY = roomHUMIDITY;
    }

    public int getroomNoiseLevel() {
        return roomNoiseLevel;
    }

    public void setroomNoiseLevel(int roomNoiseLevel) {
        this.roomNoiseLevel = roomNoiseLevel;
    }

    public int getroomAirQuality() {
        return roomAirQuality;
    }

    public void setroomAirQuality(int roomAirQuality) {
        this.roomAirQuality = roomAirQuality;
    }

    public int getRoomTemperature() {
        return roomTemperature;
    }

    public void setRoomTemperature(int roomTemperature) {
        this.roomTemperature = roomTemperature;
    }

    @Override
    public String toString() {
        return "RoomCondition{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomHUMIDITY=" + roomHUMIDITY +
                ", roomNoiseLevel=" + roomNoiseLevel +
                ", roomAirQuality=" + roomAirQuality +
                ", roomTemperature=" + roomTemperature +
                '}';
    }
}
