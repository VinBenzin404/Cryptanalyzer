package com.javarush.cryptanalyzer.abdeev.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataOutputToUser {
    public static Path createResultFile(Path pathOfOriginalFile){
        String pathStr = pathOfOriginalFile.toString();
        String newFileDir = Path.of(pathStr).getParent().toString();
        Path newFilePath = Path.of(newFileDir+"\\0.txt");
        int i=1;
        while(Files.exists(newFilePath)){

            newFilePath = Path.of(newFileDir+"\\"+i+".txt"); ////// МСПРАВИТЬ НАЗВАНИЕ ВЫВООДА
            i++;

        }


        try {
            Files.createFile(newFilePath);
            return newFilePath;
        } catch (IOException e) {
            throw new RuntimeException("Не удалось создать файл!");
        }
    }

    public static void writeResultToFile(String result){
        Path resultFile = createResultFile(FileInputFromUser.pathOfOriginalFile);
        try {
            Files.writeString(resultFile,result);
        } catch (IOException e) {
            throw new RuntimeException("Невозможно записать информацию в файл!");
        }
    }
}
