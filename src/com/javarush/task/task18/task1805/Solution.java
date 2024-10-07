package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        Set<Byte> byteSet = new TreeSet<>();
        while (inputStream.available() > 0) {
            byteSet.add((byte) inputStream.read());
        }
        inputStream.close();
        byteSet
                .stream()
                .distinct()
                .sorted()
                .forEach(x -> System.out.print(x + " "));
    }
}
