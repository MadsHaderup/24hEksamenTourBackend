package com.example.demo;

import com.example.demo.model.Rytter;
import com.example.demo.service.RytterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private RytterService rytterService;
    @Test
    void contextLoads() {
        List<Rytter> rytterList = rytterService.findAllRytterSorted();
        int lngth = rytterList.size();

        for(int i=1; i<lngth; i++){
            String [] j = rytterList.get(i-1).getTid().split(":");
            int k = Integer.parseInt(j[0])*3600+Integer.parseInt(j[1])*60+Integer.parseInt(j[1]);
            String [] l = rytterList.get(i).getTid().split(":");
            int m = Integer.parseInt(l[0])*3600+Integer.parseInt(l[1])*60+Integer.parseInt(l[1]);
            System.out.println(k + " < " + m);
            assert k < m;

        }


    }



}
