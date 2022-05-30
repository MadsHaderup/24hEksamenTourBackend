package com.example.demo.repository;

import com.example.demo.model.Rytter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RytterRepository extends JpaRepository<Rytter, Long> {

    @Query("SELECT r FROM  Rytter r WHERE r.hold.id = : id")
    List<Rytter> getRytterByHold_Id(Long id);

    List<Rytter> findAllByOrderByTidAsc();
}
