package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());

        System.out.println(getNOD(x, y));
    }
    private static int getNOD (int x, int y) {
        if (x < 1 || y < 1) {
            throw new IllegalArgumentException();
        }
        while (x != y) {
            if (x > y) {
                x -= y;
            }
            if (y > x) {
                y -= x;
            }
        }
        return x;
    }
}
