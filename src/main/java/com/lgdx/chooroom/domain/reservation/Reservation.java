package com.lgdx.chooroom.domain.reservation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="RESERVATION")
public class Reservation {

    @Id
    @Column(name="RESERV_ID") private String reservationId;
    @Column(name="CHIN_DATE") private Date checkinDate;
    @Column(name="CHOUT_DATE") private Date checkoutDate;
    @Column(name="GUEST_CNT") private int guestCount;
    @Column(name="RESERV_DATE") private Date reservationDate;
    @Column(name="CUS_ID") private String customerId;
    @Column(name="R_NUM") private String roomNumber;
    @Column(name="PAY_AMOUNT") private int payAmount;
    @Column(name="PAY_DATE") private Date payDate;

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", checkinDate=" + checkinDate +
                ", checkoutDate=" + checkoutDate +
                ", guestCount=" + guestCount +
                ", reservationDate=" + reservationDate +
                ", customerId='" + customerId + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", payAmount=" + payAmount +
                ", payDate=" + payDate +
                '}';
    }
}
