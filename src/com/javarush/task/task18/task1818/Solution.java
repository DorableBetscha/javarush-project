package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        try(FileOutputStream outputStream = new FileOutputStream(fileName1);
            FileInputStream inputStream1 = new FileInputStream(fileName2);
            FileInputStream inputStream2 = new FileInputStream(fileName3);) {

            while (inputStream1.available() > 0) {
                outputStream.write(inputStream1.read());
            }
            while (inputStream2.available() > 0) {
                outputStream.write(inputStream2.read());
            }
        }
    }
}
