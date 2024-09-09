package com.lgdx.chooroom.repository.user;


import com.lgdx.chooroom.domain.user.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CustomerAccount, String> {
    

}
