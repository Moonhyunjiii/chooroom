package com.lgdx.chooroom.repository.user;

import com.lgdx.chooroom.domain.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

    // 예약 번호(ReservationNumber)를 통해 예약 정보를 가져오는 메소드
    Optional<Reservation> findByReservationId(String reservationId);
}
