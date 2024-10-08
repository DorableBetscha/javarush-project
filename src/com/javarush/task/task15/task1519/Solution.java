package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = reader.readLine()).equalsIgnoreCase("exit")) {
            try {
                if (input.contains(".")) {
                    print(Double.parseDouble(input));
                } else {
                    int integer = Integer.parseInt(input);
                        if (integer > 0 && integer < 128) {
                            print((short)integer);
                        } else {
                            print(integer);
                        }
                }
            } catch (Exception e) {
                print(input);
            }
        }
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
