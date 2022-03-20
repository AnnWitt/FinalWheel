package com.wheeloffortune.module.game.dto;

import com.wheeloffortune.core.enums.TurnEnum;
import java.util.Set;

public class WOTDto {

    private String uuid;
    private Integer playerOneScore;
    private Integer playerTwoScore;
    private String currentWordState;
    private TurnEnum turn;
    private Set<String> playersUuid;
    private String wordUuid;

    public WOTDto(String uuid, Integer playerOneScore, Integer playerTwoScore, String currentWordState, TurnEnum turn, Set<String> playersUuid, String wordUuid) {
        this.uuid = uuid;
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
        this.currentWordState = currentWordState;
        this.turn = turn;
        this.playersUuid = playersUuid;
        this.wordUuid = wordUuid;
    }

    public String getUuid() {
        return uuid;
    }

    public Integer getPlayerOneScore() {
        return playerOneScore;
    }

    public Integer getPlayerTwoScore() {
        return playerTwoScore;
    }

    public String getCurrentWordState() {
        return currentWordState;
    }

    public TurnEnum getTurn() {
        return turn;
    }

    public Set<String> getPlayersUuid() {
        return playersUuid;
    }

    public String getWordUuid() {
        return wordUuid;
    }
}
