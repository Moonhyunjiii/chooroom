package com.lgdx.chooroom.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;

@Enabled
@Table(name = "CUSTOMER_ACCOUNT")
public class CustomerAccount {

    @Id
    @Column(name="CUS_ID")
    private String cusId;

    @Column(name="CUS_PW")
    private String cusPw;

    @Column(name="CUS_NAME")
    private String cusName;

    @Column(name="CUS_AGE")
    private String cusAge;

    @Column(name="CUS_CALL")
    private String cusCall;

    @Column(name="CUS_ADD")
    private String cusAdd;

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusPw() {
        return cusPw;
    }

    public void setCusPw(String cusPw) {
        this.cusPw = cusPw;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAge() {
        return cusAge;
    }

    public void setCusAge(String cusAge) {
        this.cusAge = cusAge;
    }

    public String getCusCall() {
        return cusCall;
    }

    public void setCusCall(String cusCall) {
        this.cusCall = cusCall;
    }

    public String getCusAdd() {
        return cusAdd;
    }

    public void setCusAdd(String cusAdd) {
        this.cusAdd = cusAdd;
    }

    @Override
    public String toString() {
        return "User{" +
                "cusId='" + cusId + '\'' +
                ", cusPw='" + cusPw + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusAge='" + cusAge + '\'' +
                ", cusCall='" + cusCall + '\'' +
                ", cusAdd='" + cusAdd + '\'' +
                '}';
    }
}
