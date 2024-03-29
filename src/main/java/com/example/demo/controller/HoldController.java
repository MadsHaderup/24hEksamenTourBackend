package com.example.demo.controller;

import com.example.demo.model.Hold;
import com.example.demo.service.HoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hold")
@CrossOrigin
public class HoldController {

    private final HoldService holdService;

    @Autowired
    public HoldController(HoldService holdService){
        this.holdService = holdService;
    }

    @GetMapping
    public ResponseEntity<List<Hold>> findAllHold(){
        return new ResponseEntity<>(holdService.findAllHold(), HttpStatus.OK);
    }
}
