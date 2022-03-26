package com.wheeloffortune.core.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {


    @Test
    void returnTrueWhenLetterDoseMachThePattern() {
        //given
        String letter = "a";
        //when
        boolean result = Validator.validate(letter);
        //then
        assertTrue(result);
    }

    @Test
    void returnFalseWhenLetterDoseNotMachThePattern() {
        //given
        String letter = "0";
        //when
        boolean result = Validator.validate(letter);
        //then
        assertFalse(result);
    }

    @Test
    void returnTrueWhenGivenASpecialPolishCharacter() {
        //given
        String letter = "ą";
        //when
        boolean result = Validator.validate(letter);
        //then
        assertTrue(result);
    }

    @Test
    void returnFalseWhenGivenNull() {
        //given
        //when
        boolean result = Validator.validate(null);
        //then
        assertFalse(result);
    }

    @Test
    void returnFalseWhenGivenEmptyString() {
        //given
        //when
        boolean result = Validator.validate("");
        //then
        assertFalse(result);
    }
}