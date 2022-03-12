package com.wheeloffortune.core.module.game.entity;

import com.wheeloffortune.core.module.game.user.entity.User;
import com.wheeloffortune.core.module.game.word.entity.Word;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game")
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
    @OneToOne(mappedBy = "wheelOfFortune")
    private Word word;
}
