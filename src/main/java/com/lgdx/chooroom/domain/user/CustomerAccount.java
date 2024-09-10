package com.lgdx.chooroom.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER_ACCOUNT")
public class CustomerAccount {

    @Id
    @Column(name="CUS_ID")
    private String customerId;

    @Column(name="CUS_PW")
    private String customerPw;

    @Column(name="CUS_NAME")
    private String customerName;

    @Column(name="CUS_AGE")
    private String customerAge;

    @Column(name="CUS_CALL")
    private String customerCallNumber;

    @Column(name="CUS_ADD")
    private String customerAdditionalRequest;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerPw() {
        return customerPw;
    }

    public void setCustomerPw(String customerPw) {
        this.customerPw = customerPw;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(String customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerCallNumber() {
        return customerCallNumber;
    }

    public void setCustomerCallNumber(String customerCallNumber) {
        this.customerCallNumber = customerCallNumber;
    }

    public String getCustomerAdditionalRequest() {
        return customerAdditionalRequest;
    }

    public void setCustomerAdditionalRequest(String customerAdditionalRequest) {
        this.customerAdditionalRequest = customerAdditionalRequest;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" +
                "customerId='" + customerId + '\'' +
                ", customerPw='" + customerPw + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAge='" + customerAge + '\'' +
                ", customerCallNumber='" + customerCallNumber + '\'' +
                ", customerAdditionalRequest='" + customerAdditionalRequest + '\'' +
                '}';
    }
}
