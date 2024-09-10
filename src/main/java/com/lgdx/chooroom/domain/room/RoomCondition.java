package com.lgdx.chooroom.domain.room;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ROOM_CONDITION")
public class RoomCondition {

    @Id
    @Column(name="R_NUM") private String rNum;
    @Column(name="R_CLEAN") private int rClean;
    @Column(name="R_NOISE") private int rNoise;
    @Column(name="R_AIRQ") private int rAirq;

    public String getrNum() {
        return rNum;
    }

    public void setrNum(String rNum) {
        this.rNum = rNum;
    }

    public int getrClean() {
        return rClean;
    }

    public void setrClean(int rClean) {
        this.rClean = rClean;
    }

    public int getrNoise() {
        return rNoise;
    }

    public void setrNoise(int rNoise) {
        this.rNoise = rNoise;
    }

    public int getrAirq() {
        return rAirq;
    }

    public void setrAirq(int rAirq) {
        this.rAirq = rAirq;
    }

    @Override
    public String toString() {
        return "RoomCondition{" +
                "rNum='" + rNum + '\'' +
                ", rClean=" + rClean +
                ", rNoise=" + rNoise +
                ", rAirq=" + rAirq +
                '}';
    }
}
