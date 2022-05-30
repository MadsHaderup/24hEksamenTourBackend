package com.example.demo.repository;

import com.example.demo.model.Hold;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoldRepository extends JpaRepository<Hold, Long> {
}
