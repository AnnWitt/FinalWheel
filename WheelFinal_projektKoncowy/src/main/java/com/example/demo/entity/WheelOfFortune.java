package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class WheelOfFortune {

    @Id
    @GeneratedValue
    private Long id;
    private Integer playerOneScore;
    private Integer playerTwoScore;
    private String currentWordState;
    private Turn turn;
    @OneToMany(mappedBy = "wheelOfFortune")
    private List<User> players;
    @OneToMany(mappedBy = "wheelOfFortune")
    private List<Word> wordsList;
}
