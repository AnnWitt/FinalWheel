package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String wold;
    @ManyToOne
    private Category category;
    @ManyToOne
    private WheelOfFortune wheelOfFortune;
}
