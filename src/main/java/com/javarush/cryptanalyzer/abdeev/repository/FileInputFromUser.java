package com.javarush.cryptanalyzer.abdeev.repository;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public  class FileInputFromUser {
    public static Path pathOfOriginalFile;


    public static String getTextForEncryption(){
        return fileToStringConversion(chooseFile());

    }

    public static Path chooseFile(){
        System.out.println("Укажите ссылку на файл, который требуется зашифровать:");
        Scanner console = new Scanner(System.in);
        String pathStr = console.nextLine();
        Path pathOfFile = Path.of(pathStr);
         while(!Files.isRegularFile(pathOfFile)){
             System.out.println("Файл по вашей ссылке не найден! Укажите действительный путь к файлу: ");
             pathStr = console.nextLine();
             pathOfFile = Path.of(pathStr);}
         pathOfOriginalFile=pathOfFile;
         return pathOfFile;



    }


    public static String fileToStringConversion(Path path){
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения из файла");
        }

    }

//    public static int getKeyForEncryption(){
//        Scanner console = new Scanner(System.in);
//        System.out.println("Укажите ключ для шифрования (целое число):");
//        String key = console.nextLine();
//        while(!isNumeric(key)){
//            System.out.println("Нужно ввести ЦЕЛОЕ число! Укажите ключ для шифрования: ");
//            key = console.nextLine();}
//        return Integer.parseInt(key);
//
//
//
//    }
//    public static boolean isNumeric(String strNum) {
//        if (strNum == null) {
//            return false;
//        }
//        try {
//            Integer.parseInt(strNum);
//        } catch (NumberFormatException e) {
//            return false;
//        }
//        return true;
//    }





}
