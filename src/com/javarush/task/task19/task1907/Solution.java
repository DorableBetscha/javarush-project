package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String reader;
        int countWord = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            reader = bufferedReader.readLine();
        }

        try (BufferedReader read = new BufferedReader(new FileReader(reader))) {

            Pattern pattern = Pattern.compile("(\\bworld\\b)|(^world\\W)|(\\Wworld$)");
            while (read.ready()) {
                Matcher matcher = pattern.matcher(read.readLine());
                while (matcher.find()) {
                    countWord++;
                }
            }

        } catch (Exception e) {
        }

        System.out.println(countWord);
    }
}
