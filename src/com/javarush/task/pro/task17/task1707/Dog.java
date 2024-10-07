package com.javarush.task.pro.task17.task1707;

import org.w3c.dom.ls.LSOutput;

public class Dog extends Pet {
    public static final String DOG = "Я люблю людей.";

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(DOG);
    }
}
