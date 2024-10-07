package com.javarush.task.pro.task10.task1010;

import java.util.Objects;

/* 
Два айфона
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) { // объект
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public boolean equals(Object iphone){  // это метод equals
        if (this == iphone){
            return true;
        }
        if (iphone == null){
            return false;
        }
        if (!(iphone instanceof Iphone)) {
            return false;
        }
        Iphone obj = (Iphone) iphone;
        return this.model == obj.model && this.color == obj.color && this.price == obj.price; //все равно что три раза написать equals для разных параметров
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999); // это obj (iphone equals(obj) equals не может работать сразу с тремя параметрами

        System.out.println(iphone1.equals(iphone2));
    }

}
