package com.wheeloffortune.core.module.game.entity;

import com.wheeloffortune.core.module.game.user.entity.UserEntity;
import com.wheeloffortune.core.module.game.word.entity.WordEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game")
public class WheelOfFortuneEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Integer playerOneScore;
    private Integer playerTwoScore;
    private String currentWordState;
    private Turn turn;
    @OneToMany(mappedBy = "wheelOfFortune")
    private List<UserEntity> players;
    @OneToOne(mappedBy = "wheelOfFortune")
    private WordEntity wordEntity;
}
