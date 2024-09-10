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
    @Column(name="RESERV_ID") private String reservId;
    @Column(name="CHIN_DATE") private Date chinDate;
    @Column(name="CHOUT_DATE") private Date choutDate;
    @Column(name="GUEST_CNT") private int guestCnt;
    @Column(name="RESERV_DATE") private Date reservDate;
    @Column(name="CUS_ID") private String cusId;
    @Column(name="R_NUM") private String rNum;
    @Column(name="PAY_AMOUNT") private int payAmount;
    @Column(name="PAY_DATE") private Date payDate;

    public String getReservId() {
        return reservId;
    }

    public void setReservId(String reservId) {
        this.reservId = reservId;
    }

    public Date getChinDate() {
        return chinDate;
    }

    public void setChinDate(Date chinDate) {
        this.chinDate = chinDate;
    }

    public Date getChoutDate() {
        return choutDate;
    }

    public void setChoutDate(Date choutDate) {
        this.choutDate = choutDate;
    }

    public int getGuestCnt() {
        return guestCnt;
    }

    public void setGuestCnt(int guestCnt) {
        this.guestCnt = guestCnt;
    }

    public Date getReservDate() {
        return reservDate;
    }

    public void setReservDate(Date reservDate) {
        this.reservDate = reservDate;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getrNum() {
        return rNum;
    }

    public void setrNum(String rNum) {
        this.rNum = rNum;
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
                "reservId='" + reservId + '\'' +
                ", chinDate=" + chinDate +
                ", choutDate=" + choutDate +
                ", guestCnt=" + guestCnt +
                ", reservDate=" + reservDate +
                ", cusId='" + cusId + '\'' +
                ", rNum='" + rNum + '\'' +
                ", payAmount=" + payAmount +
                ", payDate=" + payDate +
                '}';
    }
}
