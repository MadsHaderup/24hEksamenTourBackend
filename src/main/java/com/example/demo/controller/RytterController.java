package com.example.demo.controller;

import com.example.demo.model.Rytter;
import com.example.demo.service.RytterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rytter")
@CrossOrigin
public class RytterController {

    private final RytterService rytterService;

    @Autowired
    public RytterController(RytterService rytterService){
        this.rytterService = rytterService;
    }

    @PostMapping
    public ResponseEntity<Rytter> createRytter(@RequestBody Rytter rytter) throws IOException {
        rytterService.createRytter(rytter);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rytter> updateRytter(@PathVariable Long id, @RequestBody Rytter rytter) throws IOException {
        rytter.setId(id);
        return new ResponseEntity<>(rytterService.updateRytter(rytter), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rytter> deleteRytter(@PathVariable Long id){
        rytterService.deleteRytter(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Rytter>> findAllRytter() {
        return new ResponseEntity<>(rytterService.findAllRytter(), HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Rytter>> findAllRytterSorted() {
        return new ResponseEntity<>(rytterService.findAllRytterSorted(), HttpStatus.OK);
    }

    @GetMapping("hold/{id}")
    public ResponseEntity<List<Rytter>> findRytterByHoldId(@PathVariable Long id){
        return new ResponseEntity<>(rytterService.findRytterByHoldId(id), HttpStatus.OK);
    }


    //TILFØJELSE
    @GetMapping("/trojer")
    public ResponseEntity<List<Rytter>> findAllTrojer() {
        List<Rytter> rytterList = new ArrayList<>();
        rytterList.add(rytterService.findQuickestRytter());
        rytterList.add(rytterService.findBjergRytter());
        rytterList.add(rytterService.findSpurtRytter());
        rytterList.add(rytterService.findQuickestRytterUnderTwentysix());
        return new ResponseEntity<>(rytterList, HttpStatus.OK);
    }

}
