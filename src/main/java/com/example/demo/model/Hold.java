package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Hold {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="h_id")
    private Long id;

    private String navn;

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
}
