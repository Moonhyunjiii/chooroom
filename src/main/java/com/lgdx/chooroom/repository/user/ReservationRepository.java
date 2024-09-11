package com.lgdx.chooroom.repository.user;

import com.lgdx.chooroom.domain.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    Reservation findByReservationId(String reservationId);
}

