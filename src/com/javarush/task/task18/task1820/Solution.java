package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();


        try (BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)))) {
            while (read.ready()) {
                String[] splittedLine = read.readLine().split(" ");
                for (String numberInString : splittedLine) {
                    double number = Double.parseDouble(numberInString);
                    long roundedNumber = Math.round(number);
                    write.write(roundedNumber + " ");
                }
            }
        }
    }
}
