package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = reader.readLine();

        Scanner scanner = new Scanner(new FileInputStream(sourceFileName));
        List<Integer> data = new ArrayList<>();

        while (scanner.hasNext()) {
            int value = scanner.nextInt();
            if (value % 2 == 0)
                data.add(value);
        }
        Collections.sort(data);
        for (Integer value : data) {
            System.out.println(value);
        }
        scanner.close();
    }
}
