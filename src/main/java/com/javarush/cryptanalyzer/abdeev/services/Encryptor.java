package com.javarush.cryptanalyzer.abdeev.services;



import com.javarush.cryptanalyzer.abdeev.constants.Alphabet;


import java.util.HashMap;

public class Encryptor {


    public static String encryptor(String originalText, int key){
        char[] originalTextChars = originalText.toCharArray();
        char[] cryptoAlphabetChars = Alphabet.ALPHABET.toCharArray();
        char[] resultTextChars = new char[originalTextChars.length];
        HashMap<Character,Integer> mapOfAlphabet = new HashMap<>();
        for (int i = 0; i < cryptoAlphabetChars.length; i++) {
            mapOfAlphabet.put(cryptoAlphabetChars[i],i);
        }
        for (int i = 0; i < originalTextChars.length; i++) {
            int charIndex = mapOfAlphabet.get(originalTextChars[i]);
            if(charIndex+key<=cryptoAlphabetChars.length)
            resultTextChars[i]=cryptoAlphabetChars[charIndex+key];
            else resultTextChars[i]=cryptoAlphabetChars[(charIndex+key)-cryptoAlphabetChars.length];
        }
        return String.valueOf(resultTextChars);




    }
}
