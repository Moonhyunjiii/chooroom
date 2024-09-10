package com.lgdx.chooroom.domain.reservation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="RESERVATION")
public class Reservation {

    @Id
    @Column(name="RESERV_ID", nullable = false)
    private String reservationId;

    @Column(name="CHIN_DATE", nullable = false)
    private LocalDate checkinDate;

    @Column(name="CHOUT_DATE", nullable = false)
    private LocalDate checkoutDate;

    @Column(name="GUEST_CNT", nullable = false)
    private int guestCount;

    @Column(name="RESERV_DATE", nullable = false)
    private LocalDate reservationDate;

    @Column(name="CUS_ID", nullable = false)
    private String customerId;

    @Column(name="R_NUM", nullable = false)
    private String roomNumber;

    @Column(name="PAY_AMOUNT", nullable = false)
    private int payAmount;

    @Column(name="PAY_DATE", nullable = false)
    private LocalDate payDate;

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
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

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }


    // Override equals() and hashCode() based on reservationId
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(reservationId, that.reservationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId);
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
