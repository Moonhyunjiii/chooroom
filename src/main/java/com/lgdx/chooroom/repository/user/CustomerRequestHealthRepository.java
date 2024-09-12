package com.lgdx.chooroom.repository.user;

import com.lgdx.chooroom.domain.user.CustomerRequestHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRequestHealthRepository extends JpaRepository<CustomerRequestHealth, Long> {
    List<CustomerRequestHealth> findByCustomerId(String customerId);
}
