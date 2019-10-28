package com.example.shop;

import com.example.shop.model.User;
import com.example.shop.service.AddressService;
import com.example.shop.service.GoodService;
import com.example.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {ShopApplication.class})
public class ShopApplicationTests {

    @Autowired
    AddressService addressService;

    @Autowired
    GoodService goodService;

    @Autowired
    UserService userService;


    @Test
    public void contextLoads() {
    }


    @Test
    @Transactional
    @Commit
    public void testAddUserCrudRepository() {
        User anton = new User();
        anton.setFirstName("Anton");
        anton.setLastName("Anton'ch");
        anton.setLocale("ua");
        userService.save(anton);
    }
//
//    @Test
//    @Transactional
//    public void testUserCrudRepository() {
//        Optional<User> optionalUser = userService.findById(Long.valueOf(1));
//        System.out.println(optionalUser
//                .map(e -> e.getFirstName() + " " + e.getLastName())
//                .orElse("not found"));
//    }
}
