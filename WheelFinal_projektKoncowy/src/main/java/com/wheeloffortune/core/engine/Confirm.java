package com.wheeloffortune.core.engine;

import com.wheeloffortune.core.exeptions.NoLetterException;
import com.wheeloffortune.core.exeptions.NoWordException;

import java.util.Arrays;

public class Confirm {

    private static String prepareWord(String word){
        return word.toUpperCase();
    }

    public static boolean letterIsLetterInWord(String letter, String word) {
        return prepareWord(word).contains(letter.toUpperCase());
    }
}
