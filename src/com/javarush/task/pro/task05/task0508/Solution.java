package com.javarush.task.pro.task05.task0508;

import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings = new String[6];

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int i;
        String str = "odj";
        for (i = 0; i < strings.length; i++) {
            strings[i] = console.nextLine();
            if (strings[i] != null) {
                for (int k = 0; k < strings.length; k++) {
                    if (k != i && strings[k] != null && strings[k].equals(strings[i])) {
                        str = strings[k];  // сохраняем, чтобы проверить третье значение, если их нечетное количество
                        strings[k] = null;
                        strings[i] = null;
                    }
                        if (str.equals(strings[k]))
                            strings[k] = null;
                }
            }
        }
        for (i = 0; i < strings.length; i++)
        System.out.print(strings[i] + ", ");
    }
    }

