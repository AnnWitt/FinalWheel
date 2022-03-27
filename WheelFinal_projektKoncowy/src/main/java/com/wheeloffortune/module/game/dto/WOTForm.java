package com.wheeloffortune.module.game.dto;

import com.wheeloffortune.core.enums.TurnEnum;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class WOTForm {

    private String uuid;
    private Integer playerOneScore;
    private Integer playerTwoScore;
    private String currentWordState;
    private TurnEnum turn;
    //@NotNull(message = "game requires players")
    private Set<String> playersUuid;
    @NotNull(message = "game requires a word to guess")
    private String wordUuid;

    public WOTForm() {
    }

    public String getUuid() {
        return uuid;
    }

    public WOTForm setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public Integer getPlayerOneScore() {
        return playerOneScore;
    }

    public WOTForm setPlayerOneScore(Integer playerOneScore) {
        this.playerOneScore = playerOneScore;
        return this;
    }

    public Integer getPlayerTwoScore() {
        return playerTwoScore;
    }

    public WOTForm setPlayerTwoScore(Integer playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
        return this;
    }

    public String getCurrentWordState() {
        return currentWordState;
    }

    public WOTForm setCurrentWordState(String currentWordState) {
        this.currentWordState = currentWordState;
        return this;
    }

    public TurnEnum getTurn() {
        return turn;
    }

    public WOTForm setTurn(TurnEnum turn) {
        this.turn = turn;
        return this;
    }

    public Set<String> getPlayersUuid() {
        return playersUuid;
    }

    public WOTForm setPlayersUuid(Set<String> playersUuid) {
        this.playersUuid = playersUuid;
        return this;
    }

    public String getWordUuid() {
        return wordUuid;
    }

    public WOTForm setWordUuid(String wordUuid) {
        this.wordUuid = wordUuid;
        return this;
    }
}
