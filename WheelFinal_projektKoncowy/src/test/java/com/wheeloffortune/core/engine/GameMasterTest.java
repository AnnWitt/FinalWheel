package com.wheeloffortune.core.engine;

import com.wheeloffortune.core.enums.TurnEnum;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

class GameMasterTest {

    @Test
    void shouldReturnAStringOfTheSameLength() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //given
        String expected = "abcdef";
        String actual = expected;
        //when
        actual = actual.replaceAll("[A-Za-z0-9]", "_");
        //then
        System.out.println(actual);
        System.out.println(expected);
        Assertions.assertEquals(expected.length(),actual.length());
    }

    @Test
    void shouldChangeTurnToPlayerTwo() {
        //given
        TurnEnum turn = TurnEnum.PLAYER1;
        //when
        switch (turn){
            case PLAYER1:
                turn = TurnEnum.PLAYER2;
                break;
            case PLAYER2:
                turn = TurnEnum.PLAYER1;
                break;
        }
        //then
        Assertions.assertEquals(TurnEnum.PLAYER2,turn);
    }

    @Test
    void shouldChangeTurnToPlayerOne() {
        //given
        TurnEnum turn = TurnEnum.PLAYER2;
        //when
        switch (turn){
            case PLAYER1:
                turn = TurnEnum.PLAYER2;
                break;
            case PLAYER2:
                turn = TurnEnum.PLAYER1;
                break;
        }
        //then
        Assertions.assertEquals(TurnEnum.PLAYER1,turn);
    }

    @Test
    void shouldUpdatePlayerOneScore() {
        //given
        Integer playerOneScore = 0;
        Integer playerTwoScore = 0;
        TurnEnum turn = TurnEnum.PLAYER1;
        final int pointValue = 10;
        //when
        switch (turn){
            case PLAYER1:
                playerOneScore += pointValue;
                break;
            case PLAYER2:
                playerTwoScore += pointValue;
                break;
        }
        //then
        Assertions.assertEquals(10, (int) playerOneScore);
        Assertions.assertEquals(0, (int) playerTwoScore);
    }

    @Test
    void shouldUpdatePlayerTwoScore() {
        //given
        Integer playerOneScore = 0;
        Integer playerTwoScore = 0;
        TurnEnum turn = TurnEnum.PLAYER2;
        final int pointValue = 10;
        //when
        switch (turn){
            case PLAYER1:
                playerOneScore += pointValue;
                break;
            case PLAYER2:
                playerTwoScore += pointValue;
                break;
        }
        //then
        Assertions.assertEquals(10, (int) playerTwoScore);
        Assertions.assertEquals(0, (int) playerOneScore);
    }

    @Test
    void shouldReplaceTheCorrectSpaceInCurrentWordStateWithLetter() {
        //given
        String expected = "abcdef";
        String actual = "______";
        String letter = "a";
        //when
        char[] chars = actual.toCharArray();
        for(int i = 0; i < expected.length(); i++){
            if(expected.charAt(i) == letter.charAt(0)){
                chars[i] = letter.charAt(0);
            }
        }
        actual = String.valueOf(chars);
        //then
        System.out.println(actual);
        System.out.println(expected);
        Assertions.assertEquals(expected.charAt(0), actual.charAt(actual.indexOf(letter.charAt(0))));
    }
}