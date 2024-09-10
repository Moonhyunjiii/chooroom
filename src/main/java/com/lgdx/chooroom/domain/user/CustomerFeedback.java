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
    @Column(name="RESERV_ID") private String reservationId;
    @Column(name="U_RATE") private int userRating;
    @Column(name="FB_CONT") private String feedbackContents;
    @Column(name="R_DATE") private Date reviewDate;

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public String getFeedbackContents() {
        return feedbackContents;
    }

    public void setFeedbackContents(String feedbackContents) {
        this.feedbackContents = feedbackContents;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "CustomerFeedback{" +
                "reservationId='" + reservationId + '\'' +
                ", userRating=" + userRating +
                ", feedbackContents='" + feedbackContents + '\'' +
                ", reviewDate=" + reviewDate +
                '}';
    }
}
