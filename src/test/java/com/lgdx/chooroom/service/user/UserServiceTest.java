package com.lgdx.chooroom.service.user;

import com.lgdx.chooroom.domain.user.CustomerAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void 회원가입_테스트() {
        CustomerAccount customer = new CustomerAccount();
        customer.setCustomerName("Narin");
        customer.setCustomerAge("20");
        customer.setCustomerId("narin");
        customer.setCustomerPw("12345");
//        customer.setCustomerEmail("test@test.com");
        customer.setCustomerCallNumber("010-1234-5678");

        CustomerAccount newCustomer = userService.join(customer);
        System.out.println("@@@@@@@@@@@@@@@@@@@@"+newCustomer);
    }

}
