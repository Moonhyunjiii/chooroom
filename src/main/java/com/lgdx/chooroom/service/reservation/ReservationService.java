package com.lgdx.chooroom.service.reservation;

import com.lgdx.chooroom.domain.reservation.Reservation;
import com.lgdx.chooroom.repository.user.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // 예약 정보 저장
    @Transactional
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // 예약 ID로 예약 정보 조회
    @Transactional(readOnly = true)
    public Optional<Reservation> findByReservationId(String reservationId) {
        return reservationRepository.findByReservationId(reservationId);
    }

    // 전체 예약 목록 조회
    @Transactional(readOnly = true)
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    // 예약 정보 업데이트
    @Transactional
    public Reservation updateReservation(Reservation reservation) {
        Optional<Reservation> existingReservation = reservationRepository.findByReservationId(reservation.getReservationId());
        if (existingReservation.isPresent()) {
            return reservationRepository.save(reservation);
        } else {
            throw new IllegalArgumentException("해당 예약이 존재하지 않습니다: " + reservation.getReservationId());
        }
    }

    // 예약 정보 삭제
    @Transactional
    public void deleteReservation(String reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
