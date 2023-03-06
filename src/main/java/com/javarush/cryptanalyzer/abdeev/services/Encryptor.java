package com.javarush.cryptanalyzer.abdeev.services;

import com.javarush.cryptanalyzer.abdeev.constants.Alphabet;
import java.util.HashMap;

public class Encryptor {


    public static String encryptor(String originalText, int passWord){

        char[] originalTextChars = originalText.toCharArray();

        char[] cryptoAlphabetChars = Alphabet.ALPHABET.toCharArray();

        char[] resultTextChars = new char[originalTextChars.length];

        int charIndex;

        HashMap<Character,Integer> mapOfAlphabet = Alphabet.toMapAlphabet();


        for (int i = 0; i < originalTextChars.length; i++) {

            if(mapOfAlphabet.containsKey(originalTextChars[i])){
                charIndex = mapOfAlphabet.get(originalTextChars[i]);}
            else {resultTextChars[i]=originalTextChars[i];
                    continue;}

            resultTextChars[i]=cryptoAlphabetChars[(charIndex+passWord)%cryptoAlphabetChars.length];

        }
        return String.valueOf(resultTextChars);

    }
}
