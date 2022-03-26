package com.wheeloffortune.core.engine;

import com.wheeloffortune.core.exeptions.NoLetterException;
import com.wheeloffortune.core.exeptions.NoWordException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConfirmTest {

    @Test
    void returnTrueWhenLetterIsInTheWord() throws Exception {
        //given
        String word = "BabaYaga";
        String letter = "a";
        //when
        boolean actual = Confirm.letterIsLetterInWord(letter,word);
        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void returnTrueWhenLetterIsInTheWordRegardlessOfCapitalization() throws Exception {
        //given
        String word = "BabaYaga";
        String letter = "A";
        //when
        boolean actual = Confirm.letterIsLetterInWord(letter,word);
        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void returnFalseWhenLetterIsNotInTheWord() throws Exception {
        //given
        String word = "BabaYaga";
        String letter = "d";
        //when
        boolean actual = Confirm.letterIsLetterInWord(letter,word);
        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void returnFalseWhenLetterIsNotInTheWordRegardlessOfCapitalization() throws Exception {
        //given
        String word = "BabaYaga";
        String letter = "D";
        //when
        boolean actual = Confirm.letterIsLetterInWord(letter,word);
        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void shouldTrowNoWordExceptionIfWordIsMissing() {
        //given
        String word = "";
        String letter = "d";
        //when
        //then
        Assertions.assertThrows(NoWordException.class,() -> Confirm.letterIsLetterInWord(letter,word));
    }

    @Test
    void shouldTrowNoWordExceptionIfLetterIsMissing() {
        //given
        String word = "BabaYaga";
        String letter = "";
        //when
        //then
        Assertions.assertThrows(NoLetterException.class,() -> Confirm.letterIsLetterInWord(letter,word));
    }
}