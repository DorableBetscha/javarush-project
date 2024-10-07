package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Пунктуация
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
                write.write(read.readLine().replaceAll("\\p{P}",""));
            }

        } catch (Exception e) {}

    }
}
