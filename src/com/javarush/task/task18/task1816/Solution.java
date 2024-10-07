package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        try (FileReader fileReader = new FileReader(args[0])) {
            while (fileReader.ready()) {
                char character = (char) fileReader.read();
                if ((character >= 'A' && character <= 'Z') || (character >= 'a' && character <= 'z')) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
