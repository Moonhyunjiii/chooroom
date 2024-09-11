package com.lgdx.chooroom.service.user;

import com.lgdx.chooroom.domain.user.CustomerAccount;
import com.lgdx.chooroom.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public CustomerAccount login(String customerId, String customerPw){
        return userRepository.login(customerId, customerPw);
    }

    public CustomerAccount join(CustomerAccount customerAccount){
        return userRepository.save(customerAccount);
    }

    public boolean isUserIdTaken(String customerId){
        return userRepository.existsById(customerId);
    }
}