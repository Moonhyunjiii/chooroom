package com.lgdx.chooroom.repository.user;


import com.lgdx.chooroom.domain.reservation.Reservation;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    Reservation findByRoomNumber(String roomNumber);
}

