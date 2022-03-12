package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue()
    private String uuid;
    private String name;
    @OneToMany (mappedBy = "category")
    private List<Word> wordlist;
}
