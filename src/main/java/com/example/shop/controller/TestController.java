package com.example.shop.controller;

import com.example.shop.pojo.UserResponce;
import com.example.shop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController(value = "/test")
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping()
    public UserResponce getUsersData() {
        log.info("TEST select all users from UserDetailPojo");
        UserResponce userResponce = new UserResponce(userService.findAll());
        return userResponce;
    }
}
