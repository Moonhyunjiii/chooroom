package com.lgdx.chooroom.repository.user;


import com.lgdx.chooroom.domain.user.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CustomerAccount, String> {
    @Query(value = "SELECT * FROM CUSTOMER_ACCOUNT WHERE CUS_ID = :customerId AND CUS_PW = :customerPw", nativeQuery = true)
    CustomerAccount login(@Param("customerId") String customerId, @Param("customerPw") String customerPw);

}
