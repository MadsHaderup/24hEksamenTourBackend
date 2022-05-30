package com.example.demo.service;

import com.example.demo.model.Hold;
import com.example.demo.repository.HoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoldService {

    private final HoldRepository holdRepository;

    @Autowired
    public HoldService(HoldRepository holdRepository){
        this.holdRepository = holdRepository;
    }

    public List<Hold> findAllHold(){
        return holdRepository.findAll();
    }
}
