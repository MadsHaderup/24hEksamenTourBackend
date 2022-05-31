package com.example.demo.service;

import com.example.demo.model.Rytter;
import com.example.demo.repository.RytterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<Rytter> rytterList = rytterRepository.findAllByOrderByTidAsc();
        return rytterList;
    }

    public List<Rytter> findRytterByHoldId(Long id){
        return rytterRepository.getRytterByHold_Id(id);
    }
}
