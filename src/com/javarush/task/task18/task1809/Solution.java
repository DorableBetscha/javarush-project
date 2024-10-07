package com.javarush.task.task18.task1809;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        try (FileInputStream inputStream = new FileInputStream(fileName1);
             FileOutputStream outputStream = new FileOutputStream(fileName2)) {

            List<Integer> inputBytes = new ArrayList<>();
            while (inputStream.available() > 0) {
                inputBytes.add(inputStream.read());
            }
            Collections.reverse(inputBytes);
            for (Integer aByte : inputBytes) {
                outputStream.write(aByte);
            }
        }
    }
}
