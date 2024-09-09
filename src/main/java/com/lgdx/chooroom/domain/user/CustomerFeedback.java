package com.lgdx.chooroom.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="CUSTOMER_FEEDBACK")
public class CustomerFeedback {

    @Id
    @Column(name="RESERV_ID")
    private String reservId;

    @Column(name="U_RATE")
    private int uRate;

    @Column(name="FB_CONT")
    private String fbCont;

    @Column(name="R_DATE")
    private Date rDate;

    public String getReservId() {
        return reservId;
    }

    public void setReservId(String reservId) {
        this.reservId = reservId;
    }

    public int getuRate() {
        return uRate;
    }

    public void setuRate(int uRate) {
        this.uRate = uRate;
    }

    public String getFbCont() {
        return fbCont;
    }

    public void setFbCont(String fbCont) {
        this.fbCont = fbCont;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    @Override
    public String toString() {
        return "CustomerFeedback{" +
                "reservId='" + reservId + '\'' +
                ", uRate=" + uRate +
                ", fbCont='" + fbCont + '\'' +
                ", rDate=" + rDate +
                '}';
    }
}
