package com.wheeloffortune.module.game.entity;

import com.wheeloffortune.core.enums.TurnEnum;
import com.wheeloffortune.module.user.entity.UserEntity;
import com.wheeloffortune.module.word.entity.WordEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "game")
public class WheelOfFortuneEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Integer playerOneScore;
    private Integer playerTwoScore;
    private String currentWordState;
    private TurnEnum turn;
    @OneToMany(mappedBy = "wheelOfFortune")
    private Set<UserEntity> userEntity;
    @OneToOne(mappedBy = "wheelOfFortune")
    private WordEntity wordEntity;

}
