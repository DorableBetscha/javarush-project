package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String reader;
        String writer;

        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            reader = bufReader.readLine();
            writer = bufReader.readLine();
        }

        try (BufferedReader read = new BufferedReader(new FileReader(reader));
             BufferedWriter write = new BufferedWriter(new FileWriter(writer))) {
            while (read.ready()) {
                Pattern pattern = Pattern.compile("\\b\\d+\\b");
                while (read.ready()) {
                    Matcher matcher = pattern.matcher(read.readLine());
                    while (matcher.find()) {
                        write.write(matcher.group() + " ");
                    }
                }
            }

        } catch (Exception e) {}
    }
}
