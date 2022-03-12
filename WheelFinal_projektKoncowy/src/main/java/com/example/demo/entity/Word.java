package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    @ManyToOne
    private Category category;
    @ManyToOne
    private WheelOfFortune wheelOfFortune;
}
