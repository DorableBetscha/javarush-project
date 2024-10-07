package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }
    public static String toHex(String binaryNumber) {
        String hexNumber = "";
        if (binaryNumber == null) {
            return hexNumber;
        }
        while (binaryNumber.length() % 4 != 0) {
            binaryNumber = "0" + binaryNumber;
        }
        for (int i = 0; i < binaryNumber.length(); i += 4){
            switch (binaryNumber.substring(i, i + 4)){
                case "0000":
                    hexNumber = hexNumber + "0"; continue;
                case "0001":
                    hexNumber = hexNumber + "1"; continue;
                case "0010":
                    hexNumber = hexNumber + "2"; continue;
                case "0011":
                    hexNumber = hexNumber + "3"; continue;
                case "0100":
                    hexNumber = hexNumber + "4"; continue;
                case "0101":
                    hexNumber = hexNumber + "5"; continue;
                case "0110":
                    hexNumber = hexNumber + "6"; continue;
                case "0111":
                    hexNumber = hexNumber + "7"; continue;
                case "1000":
                    hexNumber = hexNumber + "8"; continue;
                case "1001":
                    hexNumber = hexNumber + "9"; continue;
                case "1010":
                    hexNumber = hexNumber + "a"; continue;
                case "1011":
                    hexNumber = hexNumber + "b"; continue;
                case "1100":
                    hexNumber = hexNumber + "c"; continue;
                case "1101":
                    hexNumber = hexNumber + "d"; continue;
                case "1111":
                    hexNumber = hexNumber + "f"; continue;
                default:
                    hexNumber = "";
                    break;
            }
        }
        return hexNumber;
    }
    public static String toBinary(String hexNumber) {
        String binaryNumber = "";
        if (hexNumber == null || !hexNumber.matches("[0-9,a-f]+")) {
            return binaryNumber;
        }
        for (int i = 0; i < hexNumber.length(); i++) {
            switch (String.valueOf(hexNumber.charAt(i))) {
                case "0":
                    binaryNumber = binaryNumber + "0000";
                    continue;
                case "1":
                    binaryNumber = binaryNumber + "0001";
                    continue;
                case "2":
                    binaryNumber = binaryNumber + "0010";
                    continue;
                case "3":
                    binaryNumber = binaryNumber + "0011";
                    continue;
                case "4":
                    binaryNumber = binaryNumber + "0100";
                    continue;
                case "5":
                    binaryNumber = binaryNumber + "0101";
                    continue;
                case "6":
                    binaryNumber = binaryNumber + "0110";
                    continue;
                case "7":
                    binaryNumber = binaryNumber + "0111";
                    continue;
                case "8":
                    binaryNumber = binaryNumber + "1000";
                    continue;
                case "9":
                    binaryNumber = binaryNumber + "1001";
                    continue;
                case "a":
                    binaryNumber = binaryNumber + "1010";
                    continue;
                case "b":
                    binaryNumber = binaryNumber + "1011";
                    continue;
                case "c":
                    binaryNumber = binaryNumber + "1100";
                    continue;
                case "d":
                    binaryNumber = binaryNumber + "1101";
                    continue;
                case "f":
                    binaryNumber = binaryNumber + "1111";
                    continue;
                default:
                    binaryNumber = null;
                    break;
            }
        }
        return binaryNumber;
    }
}
