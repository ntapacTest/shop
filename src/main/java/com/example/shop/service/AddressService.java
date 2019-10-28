package com.example.shop.service;

import com.example.shop.model.Address;
import com.example.shop.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    AddressRepo addressRepo;

    @Autowired
    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }


    public Optional<Address> findById(Long id) {
        return addressRepo.findById(id);
    }

    public void save(Address address) {
        addressRepo.save(address);
    }

    public void update(Address address) {
        addressRepo.save(address);
    }

    public void delete(Address address) {
        addressRepo.delete(address);
    }

    public List<Address> findAll() {
        return addressRepo.findAll();
    }
}

