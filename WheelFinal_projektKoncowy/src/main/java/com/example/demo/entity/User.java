package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String username;
    @ManyToOne
    private WheelOfFortune wheelOfFortune;
}
