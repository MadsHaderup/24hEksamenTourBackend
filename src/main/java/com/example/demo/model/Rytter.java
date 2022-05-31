package com.example.demo.model;

import javax.persistence.*;
import java.sql.Time;
import java.time.Duration;

@Entity
public class Rytter implements Comparable<Rytter> {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="r_id")
    private Long id;


    private String navn;
    private int alder;

    @Column(name="bjerg_point")
    private int bjergPoint;

    @Column(name="spurt_point")
    private int spurtPoint;

    private String tid;


    @ManyToOne
    @JoinColumn(name = "h_id")
    private Hold hold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public int getBjergPoint() {
        return bjergPoint;
    }

    public void setBjergPoint(int bjergPoint) {
        this.bjergPoint = bjergPoint;
    }

    public int getSpurtPoint() {
        return spurtPoint;
    }

    public void setSpurtPoint(int spurtPoint) {
        this.spurtPoint = spurtPoint;
    }

    public Hold getHold() {
        return hold;
    }

    public void setHold(Hold hold) {
        this.hold = hold;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public int compareTo(Rytter r) {
        String [] j = this.getTid().split(":");
        int k = Integer.parseInt(j[0])*3600+Integer.parseInt(j[1])*60+Integer.parseInt(j[1]);

        String [] l = r.getTid().split(":");
        int m = Integer.parseInt(l[0])*3600+Integer.parseInt(l[1])*60+Integer.parseInt(l[1]);
        return k-m;
    }
}
