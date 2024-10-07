package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.5, "1.5");
        labels.put(1.6, "1.6");
        labels.put(1.7, "1.7");
        labels.put(1.8, "1.8");
        labels.put(1.9, "1.9");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
