package com.javarush.cryptanalyzer.abdeev.services;

import com.javarush.cryptanalyzer.abdeev.constants.Alphabet;



public class Decoder {
    public static String decoder (String originalText, int key){

           return Encryptor.encryptor(originalText, Alphabet.ALPHABET.length()-key);


    }
}
