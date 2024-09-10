package com.lgdx.chooroom.domain.room;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ROOMS")
public class Rooms {

    @Id
    @Column(name="R_NUM") private String rNum;
    @Column(name="R_TYPE") private String rType;
    @Column(name="B_TYPE") private String bType;
    @Column(name="V_TYPE") private String vType;
    @Column(name="R_PRICE") private String rPrice;
    @Column(name="R_DESC") private String rDesc;
    @Column(name="R_AVLGUEST") private String rAvlguest;
    @Column(name="R_AVL") private String rAvl;
    @Column(name="R_STRUCT") private String rStruct;
    @Column(name="C_STATUS") private String cStatus;
    @Column(name="CIO_STATUS") private String cioStatus;
    @Column(name="R_CONTROL") private String rControl;


    public String getrNum() {
        return rNum;
    }

    public void setrNum(String rNum) {
        this.rNum = rNum;
    }

    public String getrType() {
        return rType;
    }

    public void setrType(String rType) {
        this.rType = rType;
    }

    public String getbType() {
        return bType;
    }

    public void setbType(String bType) {
        this.bType = bType;
    }

    public String getvType() {
        return vType;
    }

    public void setvType(String vType) {
        this.vType = vType;
    }

    public String getrPrice() {
        return rPrice;
    }

    public void setrPrice(String rPrice) {
        this.rPrice = rPrice;
    }

    public String getrDesc() {
        return rDesc;
    }

    public void setrDesc(String rDesc) {
        this.rDesc = rDesc;
    }

    public String getrAvlguest() {
        return rAvlguest;
    }

    public void setrAvlguest(String rAvlguest) {
        this.rAvlguest = rAvlguest;
    }

    public String getrAvl() {
        return rAvl;
    }

    public void setrAvl(String rAvl) {
        this.rAvl = rAvl;
    }

    public String getrStruct() {
        return rStruct;
    }

    public void setrStruct(String rStruct) {
        this.rStruct = rStruct;
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public String getCioStatus() {
        return cioStatus;
    }

    public void setCioStatus(String cioStatus) {
        this.cioStatus = cioStatus;
    }

    public String getrControl() {
        return rControl;
    }

    public void setrControl(String rControl) {
        this.rControl = rControl;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "rNum='" + rNum + '\'' +
                ", rType='" + rType + '\'' +
                ", bType='" + bType + '\'' +
                ", vType='" + vType + '\'' +
                ", rPrice='" + rPrice + '\'' +
                ", rDesc='" + rDesc + '\'' +
                ", rAvlguest='" + rAvlguest + '\'' +
                ", rAvl='" + rAvl + '\'' +
                ", rStruct='" + rStruct + '\'' +
                ", cStatus='" + cStatus + '\'' +
                ", cioStatus='" + cioStatus + '\'' +
                ", rControl='" + rControl + '\'' +
                '}';
    }
}
