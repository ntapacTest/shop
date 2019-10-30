package com.example.shop.service;

import com.example.shop.ShopApplication;
import com.example.shop.exception.UserNotFoundException;
import com.example.shop.model.User;
import com.example.shop.repo.UserRepo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {ShopApplication.class})
public class UserServiceTest {

    private final String USER_MAIL="test@mail.com";

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @Before
    public void setUp() throws Exception {
        User user=new User();
        user.setFirstName("TestFN");
        user.setLastName("TestLN");
        user.setEmail(USER_MAIL);
        user.setIsActive(true);

        userRepo.save(user);
    }

    @After
    public void tearDown() throws Exception {
        userRepo.delete(userRepo.findUserByEmail(USER_MAIL).orElseThrow(()->new UserNotFoundException(USER_MAIL)));
    }

    @Test
    public void findUserByEmail() throws UserNotFoundException {
        //User user =userRepo.findUserByEmail(USER_MAIL).orElseThrow(()->new UserNotFoundException(USER_MAIL));

        User user=userService.findUserByEmail(USER_MAIL);

        Assert.assertEquals(USER_MAIL,user.getEmail());
    }
}