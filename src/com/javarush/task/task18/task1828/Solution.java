package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0)
            return;

        String filePath = new BufferedReader(new InputStreamReader(System.in)).readLine();

        List<String> products = readProductsFromFile(filePath);

        if (!args[0].equals("-u") && !args[0].equals("-d"))
            return;

        if (args[0].equals("-u")) {
            updateProduct(products, args[1], args[2], args[3], args[4]);
        }
        if (args[0].equals("-d")) {
            deleteProduct(products, args[1]);
        }
        writeProductsToFile(filePath, products);
    }

    public static List<String> readProductsFromFile(String filePath) {
        List<String> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                products.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void updateProduct(List<String> products, String id, String productName, String price, String quantity) {
        for (int i = 0; i < products.size(); i++) {
            if (extractDigitsFromStart(products.get(i)).equals(id)) {
                String updatedLine = createToString(id, productName, price, quantity);
                products.set(i, updatedLine);
                break;
            }
        }
    }

    public static void deleteProduct(List<String> products, String id) {
        products.removeIf(line -> line.startsWith(id));
    }

    public static void writeProductsToFile(String filePath, List<String> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String product : products) {
                writer.write(product);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String createToString(String id, String productName, String price, String quantity) {
        while (id.length() < 8)
            id += " ";
        while (productName.length() < 30)
            productName += " ";
        while (price.length() < 8)
            price += " ";
        while (quantity.length() < 4)
            quantity += " ";
        return id + productName + price + quantity;
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
}
