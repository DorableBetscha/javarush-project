package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String line;
        String[] words;
        StringBuilder sb = new StringBuilder();


        try (BufferedReader fileOneReader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter fileSecondWriter = new BufferedWriter(new FileWriter(args[1]))) {

            while ((line = fileOneReader.readLine()) != null) {
                words = line.split("\\s+");
                for (String word : words) {
                    if (word.length() > 6) {
                        sb.append(word).append(",");
                    }
                }
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.setLength(sb.length() - 1);
            }

            fileSecondWriter.write(sb.toString());
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        }
    }
}
