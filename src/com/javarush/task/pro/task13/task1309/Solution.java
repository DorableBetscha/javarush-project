package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Greeb Supes", 5.0);
        grades.put("Dik See4keen", 5.0);
        grades.put("Zoom4ik", 5.0);
        grades.put("Денис Говнов", 0.0);
        grades.put("Piter Gnidin", 500.0);
    }
}
