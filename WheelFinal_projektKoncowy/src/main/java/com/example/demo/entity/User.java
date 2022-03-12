package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @ManyToOne
    private WheelOfFortune wheelOfFortune;
}
