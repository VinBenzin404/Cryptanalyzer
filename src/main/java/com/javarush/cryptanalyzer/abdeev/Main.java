package com.javarush.cryptanalyzer.abdeev;


import com.javarush.cryptanalyzer.abdeev.repository.CryptoKey;
import com.javarush.cryptanalyzer.abdeev.repository.DataOutputToUser;
import com.javarush.cryptanalyzer.abdeev.repository.FileInputFromUser;
import com.javarush.cryptanalyzer.abdeev.services.Encryptor;



public class Main {
    public static void main(String[] args) {

        String resultText = (Encryptor.encryptor(FileInputFromUser.getTextForEncryption(),CryptoKey.getKeyForEncryption()));
        DataOutputToUser.writeResultToFile(resultText);



    }




}