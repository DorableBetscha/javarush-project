package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file;
        while (!(file = reader.readLine()).equals("exit")) {
            new ReadThread(file).start();
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
        @Override
        public void run() {
            byte[] bytesCount = new byte[256];
            try(FileInputStream inputStream = new FileInputStream(fileName)) {
                while (inputStream.available() > 0) {
                    int aByte = inputStream.read();
                    bytesCount[aByte]++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            int maxCount = 0;
            int maxCountByte = 0;
            for (int i = 0; i < bytesCount.length; i++) {
                if (bytesCount[i] > maxCount) {
                    maxCount = bytesCount[i];
                    maxCountByte = i;
                }
            }
            resultMap.put(fileName, maxCountByte);
        }
    }
}
