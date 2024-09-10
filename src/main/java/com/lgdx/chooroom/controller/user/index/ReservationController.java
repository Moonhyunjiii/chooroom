package com.lgdx.chooroom.controller.user.index;

import com.lgdx.chooroom.domain.reservation.Reservation;
import com.lgdx.chooroom.service.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // 예약 생성 폼 페이지 (GET)
    @GetMapping("/new")
    public String showReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservationForm"; // 예약 생성 폼 페이지
    }

    // 예약 정보 저장 (POST)
    @PostMapping("/save")
    public String saveReservation(@ModelAttribute Reservation reservation) {
        reservationService.saveReservation(reservation);
        return "redirect:/reservation/list"; // 예약 목록 페이지로 리다이렉트
    }

    // 특정 예약 조회 (GET)
    @GetMapping("/view/{reservationId}")
    public String viewReservation(@PathVariable("reservationId") String reservationId, Model model) {
        Optional<Reservation> reservation = reservationService.findByReservationId(reservationId);
        if (reservation.isPresent()) {
            model.addAttribute("reservation", reservation.get());
            return "reservationDetail"; // 예약 상세 페이지
        } else {
            model.addAttribute("errorMessage", "예약을 찾을 수 없습니다.");
            return "error"; // 오류 페이지
        }
    }

    // 전체 예약 목록 조회 (GET)
    @GetMapping("/list")
    public String listReservations(Model model) {
        List<Reservation> reservations = reservationService.findAllReservations();
        model.addAttribute("reservations", reservations);
        return "reservationList"; // 예약 목록 페이지
    }

    // 예약 수정 페이지 (GET)
    @GetMapping("/edit/{reservationId}")
    public String showEditReservationForm(@PathVariable("reservationId") String reservationId, Model model) {
        Optional<Reservation> reservation = reservationService.findByReservationId(reservationId);
        if (reservation.isPresent()) {
            model.addAttribute("reservation", reservation.get());
            return "reservationForm"; // 수정 폼 페이지
        } else {
            model.addAttribute("errorMessage", "예약을 찾을 수 없습니다.");
            return "error"; // 오류 페이지
        }
    }

    // 예약 정보 수정 (POST)
    @PostMapping("/update")
    public String updateReservation(@ModelAttribute Reservation reservation) {
        reservationService.updateReservation(reservation);
        return "redirect:/reservation/list"; // 예약 목록 페이지로 리다이렉트
    }

    // 예약 삭제 (POST)
    @PostMapping("/delete/{reservationId}")
    public String deleteReservation(@PathVariable("reservationId") String reservationId) {
        reservationService.deleteReservation(reservationId);
        return "redirect:/reservation/list"; // 예약 목록 페이지로 리다이렉트
    }
}
