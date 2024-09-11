package com.lgdx.chooroom.repository.user;

import com.lgdx.chooroom.domain.user.CustomerRequestHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRequestHealthRepository extends JpaRepository<CustomerRequestHealth, String> {
    // customerId가 프라이머리 키가 아닐 때 사용
    List<CustomerRequestHealth> findByCustomerId(String customerId);
}