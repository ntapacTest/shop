package com.example.shop.controller;

import com.example.shop.exception.UserNotFoundException;
import com.example.shop.model.User;
import com.example.shop.pojo.UserDetailPojo;
import com.example.shop.pojo.UserResponce;
import com.example.shop.security.jwt.JwtUser;
import com.example.shop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api/user", produces = "application/json")
public class UserInfoController {

    @Autowired
    UserService userService;
    User user;
    UserResponce userResponce;

    @GetMapping("users")
    public UserResponce getUsersData() {
        log.info("select all users from UserDetailPojo");
        userResponce = new UserResponce(userService.findAll());
        return userResponce;
    }

    @GetMapping()
    public UserResponce getUserData(@AuthenticationPrincipal JwtUser user) throws UserNotFoundException {
        log.info("select user from UserDetailPojo");
        userResponce = new UserResponce();
        userResponce.addUser(userService.findUserByEmail(user.getEmail()));
        return userResponce;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping()
    public User createUser(@Valid @RequestBody @AuthenticationPrincipal UserDetailPojo userDetailPojo) {
        user = new User();
        user.setFirstName(userDetailPojo.getFirstName());
        user.setLastName(userDetailPojo.getLastName());
        user.setEmail(userDetailPojo.getEmail());
        userService.save(user);
        return user;
    }

}
