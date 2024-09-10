package com.lgdx.chooroom.repository.user;

import com.lgdx.chooroom.domain.user.CustomerFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedback, Long> {
    // 필요시 커스텀 쿼리 추가 가능
}
