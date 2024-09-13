package com.lgdx.chooroom.domain.room;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="ROOMS")
public class  Rooms {

    @Id
    @Column(name="R_NUM")
    private String roomNumber;

    @Column(name="R_TYPE")
    private String roomType;

    @Column(name="B_TYPE")
    private String bedType;

    @Column(name="V_TYPE")
    private String viewType;

    @Column(name="R_PRICE")
    private int roomPrice;

    @Column(name="R_DESC")
    private String roomDescription;

    @Column(name="R_AVLGUEST")
    private int roomAvlGuest;

    @Column(name="R_AVL")
    private String roomReservationAvl;

    @Column(name="R_STRUCT")
    private String roomStructure;

    @Column(name="C_STATUS")
    private String cleanStatus;

    @Column(name="CIO_STATUS")
    private String checkInOutStatus;

    @Column(name="R_CONTROL")
    private String roomControl;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="R_NUM", referencedColumnName="R_NUM")
    private RoomCondition roomCondition;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomNumber")
    private List<RoomTags> tags;

    public List<RoomTags> getTags() {
        return tags;
    }

    public void setTags(List<RoomTags> tags) {
        this.tags = tags;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public int getRoomAvlGuest() {
        return roomAvlGuest;
    }

    public void setRoomAvlGuest(int roomAvlGuest) {
        this.roomAvlGuest = roomAvlGuest;
    }

    public String getRoomReservationAvl() {
        return roomReservationAvl;
    }

    public void setRoomReservationAvl(String roomReservationAvl) {
        this.roomReservationAvl = roomReservationAvl;
    }

    public String getRoomStructure() {
        return roomStructure;
    }

    public void setRoomStructure(String roomStructure) {
        this.roomStructure = roomStructure;
    }

    public String getCleanStatus() {
        return cleanStatus;
    }

    public void setCleanStatus(String cleanStatus) {
        this.cleanStatus = cleanStatus;
    }

    public String getCheckInOutStatus() {
        return checkInOutStatus;
    }

    public void setCheckInOutStatus(String checkInOutStatus) {
        this.checkInOutStatus = checkInOutStatus;
    }

    public String getRoomControl() {
        return roomControl;
    }

    public void setRoomControl(String roomControl) {
        this.roomControl = roomControl;
    }

    public RoomCondition getRoomCondition() {
        return roomCondition;
    }

    public void setRoomCondition(RoomCondition roomCondition) {
        this.roomCondition = roomCondition;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", bedType='" + bedType + '\'' +
                ", viewType='" + viewType + '\'' +
                ", roomPrice='" + roomPrice + '\'' +
                ", roomDescription='" + roomDescription + '\'' +
                ", roomAvlGuest='" + roomAvlGuest + '\'' +
                ", roomReservationAvl='" + roomReservationAvl + '\'' +
                ", roomStructure='" + roomStructure + '\'' +
                ", cleanStatus='" + cleanStatus + '\'' +
                ", checkInOutStatus='" + checkInOutStatus + '\'' +
                ", roomControl='" + roomControl + '\'' +
                '}';
    }
}