package com.lgdx.chooroom.service.user;

import com.lgdx.chooroom.domain.reservation.Reservation;
import com.lgdx.chooroom.domain.user.CustomerAccount;
import com.lgdx.chooroom.domain.user.CustomerFeedback;
import com.lgdx.chooroom.domain.user.CustomerRequestHealth;
import com.lgdx.chooroom.repository.user.CustomerAccountRepository;
import com.lgdx.chooroom.repository.user.CustomerFeedbackRepository;
import com.lgdx.chooroom.repository.user.CustomerRequestHealthRepository;
import com.lgdx.chooroom.repository.user.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @Autowired
    private CustomerRequestHealthRepository customerRequestHealthRepository;

    @Autowired
    private CustomerFeedbackRepository customerFeedbackRepository;

    @Autowired
    private ReservationRepository reservationRepository;;

    @Transactional
    public void registerUser(CustomerAccount customerAccount, CustomerRequestHealth customerRequestHealth, CustomerFeedback customerFeedback) {
        // 1. CustomerAccount 저장
        customerAccountRepository.save(customerAccount);

        // 2. CustomerRequestHealth 저장
        customerRequestHealth.setCustomerId(customerAccount.getCustomerId());  // 연결할 때 필요한 참조값 설정
        customerRequestHealthRepository.save(customerRequestHealth);

        // 3. CustomerFeedback 저장
        customerFeedback.setReservationId(customerAccount.getCustomerId());  // 마찬가지로 참조값 설정
        customerFeedbackRepository.save(customerFeedback);
    }
}