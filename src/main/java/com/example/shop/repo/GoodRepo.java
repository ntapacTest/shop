package com.example.shop.repo;

import com.example.shop.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodRepo extends JpaRepository<Good,Long> {
}
