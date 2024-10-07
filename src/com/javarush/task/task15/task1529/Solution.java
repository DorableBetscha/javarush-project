package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() throws IllegalArgumentException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            if ("plane".equalsIgnoreCase(input)) {
                input = reader.readLine();
                result = new Plane(Integer.parseInt(input));
            } else if ("helicopter".equalsIgnoreCase(input)) {
                result = new Helicopter();
            }
            reader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
