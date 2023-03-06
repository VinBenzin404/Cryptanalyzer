package com.javarush.cryptanalyzer.abdeev.constants;

import java.util.HashMap;

public class Alphabet {
    private static final String LETTERS_UPPER_CASE = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String LETTERS_LOWER_CASE = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = ".,\":-!? ";

    public static final String ALPHABET = LETTERS_UPPER_CASE+LETTERS_LOWER_CASE+DIGITS+SYMBOLS;

    public static HashMap<Character,Integer> toMapAlphabet(){
        char[]array = ALPHABET.toCharArray();
        HashMap<Character,Integer> mapOfAlphabet = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            mapOfAlphabet.put(array[i],i);
        }return mapOfAlphabet;
    }

}
