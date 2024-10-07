package com.javarush.task.pro.task06.task0613;

/* 
Города-гиганты
*/

public class Solution {
    public static String city = "Токио";
    public static double population = 34.5;

    public static void main(String[] args) {
        printCityPopulation("Джакарта", 25.3, city, population);
        printCityPopulation("Сеул", 25.2, city, population);
        printCityPopulation("Дели", 23.1, city, population);
        printCityPopulation("Нью-Йорк", 21.6, city, population);
    }

    public static void printCityPopulation(String city, double population, String bCity, double bPop){
        System.out.println("Население города " + city + " составляет " + population + " млн человек.");
        System.out.println("В то время как в самом густонаселенном городе " + bCity + " население составляет " + bPop + " млн человек.");
    }
}
