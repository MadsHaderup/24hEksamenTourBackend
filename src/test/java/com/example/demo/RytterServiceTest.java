package com.example.demo;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import com.example.demo.model.Hold;
import com.example.demo.model.Rytter;
import com.example.demo.repository.RytterRepository;
import com.example.demo.service.RytterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class RytterServiceTest {

    @Mock
    private RytterRepository rytterRepository;

    private RytterService rytterService;

    @BeforeEach
    void setUp()
    {
        this.rytterService = new RytterService(this.rytterRepository);
    }

    @Test
    void findQuickestRytter() {
        Rytter rytter = new Rytter();
        rytter.setId(1L);
        rytter.setNavn("jens Test");
        rytter.setTid("22:22:22");

        Rytter rytter1 = new Rytter();
        rytter1.setId(2L);
        rytter1.setNavn("jens Test den anden");
        rytter1.setTid("22:21:21");

        Rytter rytter2 = new Rytter();
        rytter2.setId(3L);
        rytter2.setNavn("jens Test den tredje");
        rytter2.setTid("22:22:20");

        List<Rytter> rytterList = new ArrayList<>();
        rytterList.add(rytter);
        rytterList.add(rytter1);
        rytterList.add(rytter2);

        Mockito.when(rytterRepository.findAll()).thenReturn(rytterList);
        assertEquals(rytter1, rytterService.findQuickestRytter());

    }

    @Test
    void findQuickestRytterUnderTwentysix() {
        Rytter rytter = new Rytter();
        rytter.setId(1L);
        rytter.setNavn("jens Test");
        rytter.setTid("22:22:22");
        rytter.setAlder(20);

        Rytter rytter1 = new Rytter();
        rytter1.setId(2L);
        rytter1.setNavn("jens Test den anden");
        rytter1.setTid("22:21:21");
        rytter1.setAlder(29);

        Rytter rytter2 = new Rytter();
        rytter2.setId(3L);
        rytter2.setNavn("jens Test den tredje");
        rytter2.setTid("22:22:20");
        rytter2.setAlder(39);

        List<Rytter> rytterList = new ArrayList<>();
        rytterList.add(rytter);
        rytterList.add(rytter1);
        rytterList.add(rytter2);
        Mockito.when(rytterRepository.findAll()).thenReturn(rytterList);
        assertEquals(rytter, rytterService.findQuickestRytterUnderTwentysix());

    }

    @Test
    void findBjergRytter() {
        Rytter rytter = new Rytter();
        rytter.setId(1L);
        rytter.setNavn("jens Test");
        rytter.setBjergPoint(10);
        Mockito.when(rytterRepository.findFirstByOrderByBjergPointDesc()).thenReturn(rytter);
        rytterService.findBjergRytter();
        verify(rytterRepository).findFirstByOrderByBjergPointDesc();


    }
}