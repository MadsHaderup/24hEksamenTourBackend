package com.example.demo.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class Rytter {
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
    private Time tid;

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

    public Time getTid() {
        return tid;
    }

    public void setTid(Time tid) {
        this.tid = tid;
    }

    public Hold getHold() {
        return hold;
    }

    public void setHold(Hold hold) {
        this.hold = hold;
    }
}
