package com.societegenerale;

import com.Mower;
import com.Garden;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String fileName = "src/main/java/com/societegenerale/file.txt";

        try {
             List<String> instructionFiles = Files.readAllLines(Paths.get(fileName));
             System.out.println("instructionFiles  " + instructionFiles);
             String field = instructionFiles.get(0);
             Garden garden = new Garden(field.charAt(0), field.charAt(field.length()-1));
             String mowersFinalPosition = "";
             Mower mower = new Mower(1,1,"N",garden);
            for (int i = 1; i < instructionFiles.size() ; i++) {
                boolean isMower = i % 2 == 1;
                if (isMower) {
                   String mowerParameter = instructionFiles.get(i);
                    int xMowerParameter = Integer.parseInt(String.valueOf(mowerParameter.charAt(0)));
                    int yMowerParameter = Integer.parseInt(String.valueOf(mowerParameter.charAt(2)));
                    String orientationMowerParameter = String.valueOf(mowerParameter.charAt(mowerParameter.length()-1));
                    mower.setX(xMowerParameter);
                    mower.setY(yMowerParameter);
                    mower.setOrientation(orientationMowerParameter);
                }
                boolean isInstruction = i % 2 == 0;
                if (isInstruction) {
                    String instruction = instructionFiles.get(i);
                    mowersFinalPosition = mowersFinalPosition + mower.execute(instruction);
                }
            }
            System.out.println("result   " + mowersFinalPosition);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}