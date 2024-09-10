package com.lgdx.chooroom.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="CUSTOMER_REQUEST_HEALTH")
public class CustomerRequestHealth {

    @Id
    @Column(name="H_NO") private int hNo;
    @Column(name="H_INFO") private String hInfo;
    @Column(name="H_DATE") private Date hDate;
    @Column(name="CUS_ID") private String cusId;

    public int gethNo() {
        return hNo;
    }

    public void sethNo(int hNo) {
        this.hNo = hNo;
    }

    public String gethInfo() {
        return hInfo;
    }

    public void sethInfo(String hInfo) {
        this.hInfo = hInfo;
    }

    public Date gethDate() {
        return hDate;
    }

    public void sethDate(Date hDate) {
        this.hDate = hDate;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "CustomerRequestHealth{" +
                "hNo=" + hNo +
                ", hInfo='" + hInfo + '\'' +
                ", hDate=" + hDate +
                ", cusId='" + cusId + '\'' +
                '}';
    }
}
