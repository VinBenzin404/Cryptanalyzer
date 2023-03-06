package com.javarush.cryptanalyzer.abdeev.controllers;

import com.javarush.cryptanalyzer.abdeev.repository.CryptoKey;


import java.util.Scanner;

public class ProgramMode {

    public static int programStart(){
        int mode;
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
}
