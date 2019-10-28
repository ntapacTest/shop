package com.example.shop.controller;

import com.example.shop.exception.UserNotFoundException;
import com.example.shop.model.Address;
import com.example.shop.model.User;
import com.example.shop.pojo.AddressPojo;
import com.example.shop.service.AddressService;
import com.example.shop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api/user/address", produces = "application/json")
public class AddressController {

    @Autowired
    AddressService addressService;

    @Autowired
    UserService userService;
    Address address;
    User user;

    @PostMapping
    public Address setAddress(@Valid @RequestBody AddressPojo addressPojo) throws UserNotFoundException {
        user = userService.findById(addressPojo.getId());
        address.setAddress(addressPojo.getAddress());
        address.setZip(addressPojo.getZip());
        address.setAddressUserId(user);
        addressService.save(address);
        return address;
    }


}
