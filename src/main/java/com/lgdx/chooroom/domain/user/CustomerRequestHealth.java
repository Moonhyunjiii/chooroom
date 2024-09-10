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
    @Column(name="H_NO") private int healthNumber;
    @Column(name="H_INFO") private String healthInfo;
    @Column(name="H_DATE") private Date healthDate;
    @Column(name="CUS_ID") private String customerId;

    public int getHealthNumber() {
        return healthNumber;
    }

    public void setHealthNumber(int healthNumber) {
        this.healthNumber = healthNumber;
    }

    public String getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(String healthInfo) {
        this.healthInfo = healthInfo;
    }

    public Date getHealthDate() {
        return healthDate;
    }

    public void setHealthDate(Date healthDate) {
        this.healthDate = healthDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "CustomerRequestHealth{" +
                "healthNumber=" + healthNumber +
                ", healthInfo='" + healthInfo + '\'' +
                ", healthDate=" + healthDate +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
