package com.lgdx.chooroom.repository.user;

import com.lgdx.chooroom.domain.user.CustomerRequestHealth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRequestHealthRepository extends JpaRepository<CustomerRequestHealth, Long> {
    // 필요시 커스텀 쿼리 추가 가능
}
