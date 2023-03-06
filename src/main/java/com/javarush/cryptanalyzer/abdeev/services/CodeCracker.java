package com.javarush.cryptanalyzer.abdeev.services;

import com.javarush.cryptanalyzer.abdeev.constants.Alphabet;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeCracker {

    public static String codeBreak(String originalText){
        int maybeKey=0;
        String text = originalText;

        Pattern p = Pattern.compile("[а-я]{3,}\\s[а-я]{3,}");
        Matcher m = p.matcher(text);



        while(maybeKey<Alphabet.ALPHABET.length()){
            if(m.find()){
                System.out.println("Key: "+(Alphabet.ALPHABET.length()-maybeKey)%Alphabet.ALPHABET.length());
                return text;
            }else{
                maybeKey++;
                text = Decoder.decoder(originalText,maybeKey);
                m = p.matcher(text);
                }}

        return "Не удалось расшифровать файл";

    }
}
