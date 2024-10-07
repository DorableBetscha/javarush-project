package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

import java.util.ArrayList;

public class MinMaxUtil {
    public static int max = Integer.MAX_VALUE;
    public static int min = Integer.MIN_VALUE;
    public static int max (int a, int b){
        if (a > b) {
            return a;
        }else {
            return b;
        }
    }
    public static int min (int a, int b){
        if (a < b) {
            return a;
        }else {
            return b;
        }
    }
    public static int max (int a, int b, int c){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(a); list.add(b); list.add(c);
        int temp = min;
        for (Integer value : list) {
            if (value > temp) {
                temp = value;
            }
        }
        return temp;
    }
    public static int min (int a, int b, int c){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(a); list.add(b); list.add(c);
        int temp = max;
        for (Integer value : list) {
            if (value < temp) {
                temp = value;
            }
        }
        return temp;
    }
    public static int max (int a, int b, int c, int d){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(a); list.add(b); list.add(c); list.add(d);
        int temp = min;
        for (Integer value : list) {
            if (value > temp) {
                temp = value;
            }
        }
        return temp;
    }
    public static int min (int a, int b, int c, int d){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(a); list.add(b); list.add(c); list.add(d);
        int temp = max;
        for (Integer value : list) {
            if (value < temp) {
                temp = value;
            }
        }
        return temp;
    }
    public static int max (int a, int b, int c, int d, int e){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(a); list.add(b); list.add(c); list.add(d); list.add(e);
        int temp = min;
        for (Integer value : list) {
            if (value > temp) {
                temp = value;
            }
        }
        return temp;
    }
    public static int min (int a, int b, int c, int d, int e){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(a); list.add(b); list.add(c); list.add(d); list.add(e);
        int temp = max;
        for (Integer value : list) {
            if (value < temp) {
                temp = value;
            }
        }
        return temp;
    }
}
