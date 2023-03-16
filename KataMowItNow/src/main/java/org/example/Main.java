package org.example;

import org.Garden;
import org.Mower;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        String fileName = "src/main/java/org/example/file.txt";

        try {
             List<String> instructionFiles = Files.readAllLines(Paths.get(fileName));
            System.out.println("instructionFiles  " + instructionFiles);
             String field = instructionFiles.get(0);
             Garden garden = new Garden(field.charAt(0), field.charAt(field.length()-1));
             String result = "";
             Mower mower = new Mower(1,1,"N",garden);
            for (int i = 1; i < instructionFiles.size() ; i++) {
                if (i%2 == 1) {
                   String mowerIntance = instructionFiles.get(i);
                    mower.setX(Integer.parseInt(String.valueOf(mowerIntance.charAt(0))));
                    mower.setY(Integer.parseInt(String.valueOf(mowerIntance.charAt(2))));
                    mower.setOrientation(String.valueOf(mowerIntance.charAt(mowerIntance.length()-1)));
                }
                if (i%2 == 0) {
                    String instruction = instructionFiles.get(i);
                    result = result + mower.execute(instruction);
                }
            }
            System.out.println("result   " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}