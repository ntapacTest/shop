package com.example.shop.repo;

import com.example.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findUserByEmail(String email);

    Boolean existsByEmail(String email);

    @Query(value = "select u from User u where u.email=:email and u.isActive=true")
    User findActiveUserByEmail(@Param("email") String email);

    Optional<User> findUserByGoogleId(String googleId);
}
