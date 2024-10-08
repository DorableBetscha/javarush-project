package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
                FileWriter fileWriter = new FileWriter(args[1])) {
            String fileReadLine;
            String[] splitedLine;

            while (fileReader.ready()) {
                fileReadLine = fileReader.readLine();
                splitedLine = fileReadLine.split(" ");

                for (String word : splitedLine) {
                    if (word.matches(".*[0-9].*")) {
                        fileWriter.write(word + " ");
                    }
                }
            }
        }
    }
}
