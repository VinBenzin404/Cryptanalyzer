package com.javarush.cryptanalyzer.abdeev.repository;

import com.javarush.cryptanalyzer.abdeev.controllers.ProgramMode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataOutput {
    public static Path createResultFile(){
        Path newFilePath=Path.of("");
        if(ProgramMode.mode==1){newFilePath = Path.of("encoded.txt");}
        if(ProgramMode.mode==2 || ProgramMode.mode==3){newFilePath = Path.of("output.txt");}


        try {
            Files.deleteIfExists(newFilePath);
            Files.createFile(newFilePath);
            return newFilePath;
        } catch (IOException e) {
            throw new RuntimeException("Не удалось создать файл!");
        }
    }

    public static void writeResultToFile(String result){
        Path resultFile = createResultFile();
        try {
            Files.writeString(resultFile,result);
        } catch (IOException e) {
            throw new RuntimeException("Невозможно записать информацию в файл!");
        }
    }
}
