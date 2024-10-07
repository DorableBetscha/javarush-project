package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try (FileInputStream inputStream1 = new FileInputStream(fileName1);
             FileInputStream inputStream2 = new FileInputStream(fileName2)) {
            while (inputStream2.available() > 0) {
                byteArrayOutputStream.write(inputStream2.read());
            }
            while (inputStream1.available() > 0) {
                byteArrayOutputStream.write(inputStream1.read());
            }
        }
        try (FileOutputStream outputStream = new FileOutputStream(fileName1)) {
            byteArrayOutputStream.writeTo(outputStream);
        }
    }
}
