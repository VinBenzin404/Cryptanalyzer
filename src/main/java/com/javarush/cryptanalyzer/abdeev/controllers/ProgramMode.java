package com.javarush.cryptanalyzer.abdeev.controllers;

import com.javarush.cryptanalyzer.abdeev.repository.CryptoKey;
import com.javarush.cryptanalyzer.abdeev.repository.DataOutputToUser;
import com.javarush.cryptanalyzer.abdeev.repository.FileInputFromUser;
import com.javarush.cryptanalyzer.abdeev.services.CodeCracker;
import com.javarush.cryptanalyzer.abdeev.services.Decoder;
import com.javarush.cryptanalyzer.abdeev.services.Encryptor;


import java.util.Scanner;

public class ProgramMode {
    int mode;
    private int programStart(){

        do {
            System.out.println("Выберите режим работы программы:\n1 - шифрование файла; 2 - расшифровка файла; 3 - взлом шифра");
            Scanner console = new Scanner(System.in);
            String modeStr = console.nextLine();
            while(!(CryptoKey.isNumeric(modeStr))){
                System.out.println("Введено не число! Выберите режим работы программы:\n1 - шифрование файла; 2 - расшифровка файла; 3 - взлом шифра");
                modeStr = console.nextLine();
            }
            mode = Integer.parseInt(modeStr);
            if(mode!=1 && mode!=2 && mode!=3) System.out.println("Число не соответствует номеру режима.");
        } while (mode != 1 && mode != 2 && mode!=3);
        return  mode;
    }

    public static void start(){
        ProgramMode programMode = new ProgramMode();

        switch (programMode.programStart()) {
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
