package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                String readedString = fileReader.readLine();
                String[] splittedReadedString = readedString.split(" ");

                int wordCount = 0;

                for (String s : splittedReadedString) {
                    if (words.contains(s)) {
                        wordCount++;
                    }
                }
                if (wordCount == 2) {
                    System.out.println(readedString);
                }
            }

        }
    }
}
