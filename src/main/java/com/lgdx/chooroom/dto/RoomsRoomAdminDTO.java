package com.lgdx.chooroom.dto;

import java.util.Date;

public class RoomsRoomAdminDTO {

    private String roomNumber;       // 방 번호
    private String roomType;         // 방 타입
    private String cleanStatus;      // 청소 상태
    private String checkInOutStatus; // 체크인/체크아웃 상태
    private int roomTemperature;     // 방 온도
    private Date checkInDate;        // 체크인 날짜
    private Date checkOutDate;       // 체크아웃 날짜
    private String customerId;       // 고객 ID
    private String customerName;     // 고객 이름
    private String customerCall;     // 고객 연락처

    // 생성자
    public RoomsRoomAdminDTO(String roomNumber, Date checkInDate, Date checkOutDate,
                             String customerId, int roomTemperature,
                             String roomType,  String checkInOutStatus,
                              String customerName, String customerCall) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.checkInOutStatus = checkInOutStatus;
        this.roomTemperature = roomTemperature;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerCall = customerCall;
    }

    // Getter와 Setter 메소드들
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public String getCleanStatus() { return cleanStatus; }
    public void setCleanStatus(String cleanStatus) { this.cleanStatus = cleanStatus; }

    public String getCheckInOutStatus() { return checkInOutStatus; }
    public void setCheckInOutStatus(String checkInOutStatus) { this.checkInOutStatus = checkInOutStatus; }

    public int getRoomTemperature() { return roomTemperature; }
    public void setRoomTemperature(int roomTemperature) { this.roomTemperature = roomTemperature; }

    public Date getCheckInDate() { return checkInDate; }
    public void setCheckInDate(Date checkInDate) { this.checkInDate = checkInDate; }

    public Date getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(Date checkOutDate) { this.checkOutDate = checkOutDate; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerCall() { return customerCall; }
    public void setCustomerCall(String customerCall) { this.customerCall = customerCall; }

    @Override
    public String toString() {
        return "RoomsRoomAdminDTO{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", cleanStatus='" + cleanStatus + '\'' +
                ", checkInOutStatus='" + checkInOutStatus + '\'' +
                ", roomTemperature=" + roomTemperature +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerCall='" + customerCall + '\'' +
                '}';
    }
}
