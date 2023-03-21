package com.javarush.cryptanalyzer.abdeev.controllers;

import com.javarush.cryptanalyzer.abdeev.repository.CryptoKey;
import com.javarush.cryptanalyzer.abdeev.repository.DataOutput;
import com.javarush.cryptanalyzer.abdeev.repository.FileInput;
import com.javarush.cryptanalyzer.abdeev.services.CodeCracker;
import com.javarush.cryptanalyzer.abdeev.services.Decoder;
import com.javarush.cryptanalyzer.abdeev.services.Encryptor;


import java.util.Scanner;

public class ProgramMode {
    public static int mode;

    //Выбор режима работы
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


    //Режимы работы программы

    public void start(){
        ProgramMode programMode = new ProgramMode();

        switch (programMode.programStart()) {
            case 1 -> {
                String inputFile = FileInput.getTextForEncryption();

                int cryptoKey = CryptoKey.getKeyForEncryption();

                String codedText = (Encryptor.encryptor(inputFile, cryptoKey));
                DataOutput.writeResultToFile(codedText);
                System.out.println("Успешно!");
            }
            case 2 -> {
                String inputFile = FileInput.getTextForEncryption();

                int cryptoKey = CryptoKey.getKeyForEncryption();

                String decodedText = (Decoder.decoder(inputFile, cryptoKey));
                DataOutput.writeResultToFile(decodedText);
                System.out.println("Успешно!");
            }
            case 3 -> {
                String inputFile = FileInput.getTextForEncryption();

                String decodedText = CodeCracker.codeBreak(inputFile);
                DataOutput.writeResultToFile(decodedText);
                System.out.println("Успешно!");

            }
        }

    }




}
