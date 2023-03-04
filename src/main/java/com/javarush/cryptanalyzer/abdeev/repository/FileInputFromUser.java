package com.javarush.cryptanalyzer.abdeev.repository;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public  class fileInputFromUser {


    //    static String originalText;
//    static int CryptoKey;
//
//    public DataInputFromUser(String text,int key) {
//        originalText =text;
//        CryptoKey=key;
//
//    }

    public static String getTextForEncryption(){
        return fileToStringConversion(chooseFile());

    }

    public static Path chooseFile(){
        System.out.println("Укажите ссылку на файл, который требуется зашифровать:");
        Scanner console = new Scanner(System.in);
        String pathStr = console.nextLine();

        Path pathOfFile = Path.of(pathStr);
         while(!Files.isRegularFile(pathOfFile)){
             System.out.println("File not found! Choose another file!");
             pathStr = console.nextLine();
             pathOfFile = Path.of(pathStr);}
         return pathOfFile;



    }

    public static String fileToStringConversion(Path path){
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения из файла");
        }

    }

    public static int getKeyForEncryption(){
//        System.out.println("Укажите ключ для шифрования (целое число):");
//        Scanner console = new Scanner(System.in);
//        String key = console.nextLine();
//        while (!(Integer.parseInt(key)%1==0)){
//            System.out.println("Нужно ввести ЦЕЛОЕ число! Укажите ключ для шифрования: ");
//        }
//        int numericKey = Integer.parseInt(key);
//        return numericKey;
        Scanner console = new Scanner(System.in);
        System.out.println("Укажите ключ для шифрования (целое число):");
        String key = console.nextLine();
        while(!isNumeric(key)){
            System.out.println("Нужно ввести ЦЕЛОЕ число! Укажите ключ для шифрования: ");
            key = console.nextLine();}
        return Integer.parseInt(key);



    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int b = Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }





}
