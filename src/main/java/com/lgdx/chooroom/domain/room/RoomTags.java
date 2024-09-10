package com.lgdx.chooroom.domain.room;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ROOM_TAG")
public class RoomTags {

    @Id
    @Column(name="TAG_ID")
    private String tagId;

    @Column(name="R_NUM")
    private String rNum;

    @Column(name="TAG_NAME")
    private String tagName;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getrNum() {
        return rNum;
    }

    public void setrNum(String rNum) {
        this.rNum = rNum;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "RoomTags{" +
                "tagId='" + tagId + '\'' +
                ", rNum='" + rNum + '\'' +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}
