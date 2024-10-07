package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> fileNames = new TreeSet<>();
        while (true) {
            String fileName = reader.readLine();
            if ("end".equalsIgnoreCase(fileName)) {
                break;
            }
            fileNames.add(fileName);
        }
        String baseName = fileNames.first().substring(0, fileNames.first().lastIndexOf(".part"));
        File outputFile = new File(baseName);

        try (FileOutputStream fos = new FileOutputStream(outputFile);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            for (String fname : fileNames) {
                try (FileInputStream fin = new FileInputStream(fname);
                     BufferedInputStream bis = new BufferedInputStream(fin)) {
                    byte[] buffer = new byte[bis.available()];
                    int bytesRead;
                    while ((bytesRead = bis.read(buffer)) != -1) {
                        bos.write(buffer, 0, bytesRead);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
