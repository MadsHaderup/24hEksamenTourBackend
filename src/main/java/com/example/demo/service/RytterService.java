package com.example.demo.service;

import com.example.demo.model.Rytter;
import com.example.demo.repository.RytterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class RytterService {
    private final RytterRepository rytterRepository;

    @Autowired
    public RytterService(RytterRepository rytterRepository){
        this.rytterRepository = rytterRepository;
    }

    public void createRytter(Rytter rytter){
        rytterRepository.save(rytter);
    }

    public void deleteRytter(Long id){
        rytterRepository.deleteById(id);
    }

    public Rytter updateRytter(Rytter rytter){
        return rytterRepository.save(rytter);
    }

    public List<Rytter> findAllRytter(){
        return rytterRepository.findAllByOrderByIdAsc();
    }

    public List<Rytter> findAllRytterSorted(){
        List<Rytter> rytterList = rytterRepository.findAll();
        Collections.sort(rytterList);
        return rytterList;
    }

    //TILFØJELSE
    public Rytter findQuickestRytter(){
        List<Rytter> rytterList = rytterRepository.findAll();
        Collections.sort(rytterList);
        return rytterList.get(0);
    }
    //TILFØJELSE
    public Rytter findQuickestRytterUnderTwentysix(){
        List<Rytter> rytterList = rytterRepository.findAll();
        Collections.sort(rytterList);
        for(Rytter r : rytterList){
            if(r.getAlder()<26){
                return r;
            }
        }
        return new Rytter();
    }
    //TILFØJELSE
    public Rytter findBjergRytter(){
        return rytterRepository.findFirstByOrderByBjergPointDesc();
    }
    //TILFØJELSE
    public Rytter findSpurtRytter(){
        return rytterRepository.findFirstByOrderBySpurtPointDesc();
    }


    public List<Rytter> findRytterByHoldId(Long id){
        return rytterRepository.getRytterByHold_Id(id);
    }
}
