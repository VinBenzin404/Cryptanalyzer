package com.javarush.cryptanalyzer.abdeev.services;

import com.javarush.cryptanalyzer.abdeev.constants.Alphabet;

import java.util.HashMap;

public class Decoder {
    public static String decoder (String originalText, int key){

        char[] originalTextChars = originalText.toCharArray();

        char[] cryptoAlphabetChars = Alphabet.ALPHABET.toCharArray();

        char[] resultTextChars = new char[originalTextChars.length];

        int charIndex;

        HashMap<Character,Integer> mapOfAlphabet = new HashMap<>();
        for (int i = 0; i < cryptoAlphabetChars.length; i++) {
            mapOfAlphabet.put(cryptoAlphabetChars[i],i);
        }
        //Цикл строит массив символов resultTextChars из зашифрованных символов
        for (int i = 0; i < originalTextChars.length; i++) {
            //Проверка на наличие очередного символа из ориг. текста в криптоалфавите
            if(mapOfAlphabet.containsKey(originalTextChars[i])){
                charIndex = mapOfAlphabet.get(originalTextChars[i]);}
            //Если символа нет в криптоалфавите оставляем символ в неизмененном виде
            else {resultTextChars[i]=originalTextChars[i];
                continue;}
            //учитываем что ключ может быть отрицательным числом или быть больше чем длинна массива символов криптоалфавита
            if(charIndex-key>0) resultTextChars[i]=cryptoAlphabetChars[(charIndex-key)%cryptoAlphabetChars.length];
            else resultTextChars[i]=cryptoAlphabetChars[(charIndex-key)%cryptoAlphabetChars.length+cryptoAlphabetChars.length];

        }
        return String.valueOf(resultTextChars);




    }
}
