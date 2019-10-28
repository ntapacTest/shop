package com.example.shop.service;

import com.example.shop.exception.UserNotFoundException;
import com.example.shop.model.User;
import com.example.shop.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Slf4j
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserService() { }

    public User findById(Long id) throws UserNotFoundException {
        return userRepo
                .findById(id)
                .orElseThrow(()-> new UserNotFoundException("user not found by Id: "+id));
    }

    public User findByGoogleId(String id) throws UserNotFoundException {
        return userRepo
                .findUserByGoogleId(id)
                .orElseThrow(()-> new UserNotFoundException("user not found by googleId: "+id));
    }

    public void save(User user) {
        userRepo.findUserByEmail(user.getEmail()).orElse(userRepo.save(user));
        logger.info("user: "+ user.toString()+" added");
    }

    public User findUserByEmail(String email) {
        try {
            return userRepo.findUserByEmail(email)
                    .orElseThrow(()-> new UserNotFoundException("user by email {} not found "+email));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(User user) {
        userRepo.save(user);
    }

    public void delete(User user) {
        userRepo.delete(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }
}
