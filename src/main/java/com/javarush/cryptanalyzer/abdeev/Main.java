package com.javarush.cryptanalyzer.abdeev;



import com.javarush.cryptanalyzer.abdeev.controllers.ProgramMode;
import com.javarush.cryptanalyzer.abdeev.repository.CryptoKey;
import com.javarush.cryptanalyzer.abdeev.repository.DataOutputToUser;
import com.javarush.cryptanalyzer.abdeev.repository.FileInputFromUser;
import com.javarush.cryptanalyzer.abdeev.services.CodeCracker;
import com.javarush.cryptanalyzer.abdeev.services.Decoder;
import com.javarush.cryptanalyzer.abdeev.services.Encryptor;




public class Main {
    public static void main(String[] args) {



        switch (ProgramMode.programStart()) {
            case 1 -> {
                String codedText = (Encryptor.encryptor(FileInputFromUser.getTextForEncryption(), CryptoKey.getKeyForEncryption()));
                DataOutputToUser.writeResultToFile(codedText);
            }
            case 2 -> {
                String decodedText = (Decoder.decoder(FileInputFromUser.getTextForEncryption(), CryptoKey.getKeyForEncryption()));
                DataOutputToUser.writeResultToFile(decodedText);
            }
            case 3 -> {
                String decodedText = CodeCracker.codeBreak(FileInputFromUser.getTextForEncryption());
                DataOutputToUser.writeResultToFile(decodedText);

            }
        }








    }
}




