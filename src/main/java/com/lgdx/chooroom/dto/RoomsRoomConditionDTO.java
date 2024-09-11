package com.lgdx.chooroom.dto;

import jakarta.persistence.Column;

public class RoomsRoomConditionDTO {

    private String roomType; //rooms

    private String roomNumber;  //roomConditions
    private int roomNoiseLevel;
    private int roomAirQuality;
    private int roomHumidity;
    private int roomTemperature;

    public RoomsRoomConditionDTO(String roomType, String roomNumber, int roomNoiseLevel, int roomAirQuality, int roomHumidity, int roomTemperature) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.roomNoiseLevel = roomNoiseLevel;
        this.roomAirQuality = roomAirQuality;
        this.roomHumidity = roomHumidity;
        this.roomTemperature = roomTemperature;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
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

    public int getRoomHumidity() {
        return roomHumidity;
    }

    public void setRoomHumidity(int roomHumidity) {
        this.roomHumidity = roomHumidity;
    }

    public int getRoomTemperature() {
        return roomTemperature;
    }

    public void setRoomTemperature(int roomTemperature) {
        this.roomTemperature = roomTemperature;
    }

    @Override
    public String toString() {
        return "RoomsRoomConditionDTO{" +
                "roomType='" + roomType + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomNoiseLevel=" + roomNoiseLevel +
                ", roomAirQuality=" + roomAirQuality +
                ", roomHumidity=" + roomHumidity +
                ", roomTemperature=" + roomTemperature +
                '}';
    }
}
