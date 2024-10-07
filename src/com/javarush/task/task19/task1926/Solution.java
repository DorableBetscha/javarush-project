package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String line;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fReader = new BufferedReader(new FileReader(reader.readLine()))) {
            while ((line = fReader.readLine()) != null) {
                String reversedLine = new StringBuilder(line).reverse().toString();
                System.out.println(reversedLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
