package com.javarush.cryptanalyzer.abdeev.repository;

import com.javarush.cryptanalyzer.abdeev.constants.Alphabet;

import java.util.Scanner;

public class CryptoKey {


    public static int getKeyForEncryption() {
        Scanner console = new Scanner(System.in);
        System.out.println("Укажите ключ шифрования (целое число):");
        String key = console.nextLine();
        while (!isNumeric(key)) {
            System.out.println("Нужно ввести ЦЕЛОЕ число! Укажите ключ для шифрования: ");
            key = console.nextLine();
        }


        return Math.abs((Integer.parseInt(key))% Alphabet.ALPHABET.length());


    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {

            Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
