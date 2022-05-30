package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Hold {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="h_id")
    private Long id;

    private String navn;

}
