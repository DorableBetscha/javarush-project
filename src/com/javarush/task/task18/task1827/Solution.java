package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0)
            return;

        String filePath = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String product = createToString(filePath, args[1], args[2], args[3]);
        createNewProduct(filePath, product);
    }
    public static String generateId(String filePath) {
        int maxId = Integer.MIN_VALUE;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.ready()) { // пока есть что читать
                String string = extractDigitsFromStart(reader.readLine()); // считываем строку в string
                if (Integer.parseInt(string) > maxId) {
                    maxId = Integer.parseInt(string);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        maxId++;
        return String.valueOf(maxId);
    }

    public static String extractDigitsFromStart(String input) {
        // Находим индекс первого нецифрового символа
        int startIndex = 0;
        while (startIndex < input.length() && Character.isDigit(input.charAt(startIndex))) {
            startIndex++;
        }
        // Извлекаем цифры из начала строки
        return input.substring(0, startIndex);
    }

    public static String createToString (String filePath, String productName, String price, String quantity) {
        while (productName.length() < 30)
            productName += " ";
        while (price.length() < 8)
            price += " ";
        while (quantity.length() < 4)
            quantity += " ";

        String maxId = generateId(filePath);
        while (maxId.length() < 8)
            maxId += " ";

        return maxId + productName + price + quantity;
    }
    public static void createNewProduct(String filePath, String product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.newLine();
            writer.write(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


