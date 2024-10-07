package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String reader;
        String writer;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            reader = bufferedReader.readLine();
            writer = bufferedReader.readLine();
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        try (FileReader fileReader = new FileReader(reader)) {
            while(fileReader.ready()) {
                list.add(fileReader.read());
            }
        }

        try (FileWriter fileWriter = new FileWriter(writer)) {
            for (int i = 1; i < list.size(); i += 2) {
                fileWriter.write((byte) (int) list.get(i));
            }
        }
    }
}
