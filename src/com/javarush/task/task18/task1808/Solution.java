package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();

        try (FileInputStream inputStream = new FileInputStream(fileName1);
             FileOutputStream outputStream1 = new FileOutputStream(fileName2);
             FileOutputStream outputStream2 = new FileOutputStream(fileName3)) {

            int halfOfBytes = (inputStream.available() + 1) / 2;
            long totalBytes = 0;
            while (inputStream.available() > 0) {
                if (totalBytes < halfOfBytes) {
                    outputStream1.write(inputStream.read());
                    totalBytes++;
                } else {
                    outputStream2.write(inputStream.read());
                }
            }
        }
    }
}
