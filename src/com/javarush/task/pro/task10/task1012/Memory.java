package com.javarush.task.pro.task10.task1012;

import java.util.Arrays;
import java.util.Objects;

/* 
Дефрагментация памяти
*/

public class Memory {

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }

    public static void executeDefragmentation(String[] array) {
        String[] temp = new String[array.length]; // временный массив той же длины, будет использоваться для хранения ненулевых элементов исходного массива
        int j = 0;
        for (int i = 0; i < array.length; i++) { // метод перебирает каждый элемент входного массива
            if (array[i] != null) {  //Если элемент не равен нулю, он копируется в следующую доступную позицию
                temp[j] = array[i];  // во временном массиве (temp[j]), а счетчик j увеличивается.
                j++;                 // все ненулевые элементы перемещаются в начало временного массива
            }
        }
        for (int i = 0; i < array.length; i++) { // метод перезаписывает каждый элемент исходного массива соответствующим элементом временного массива
            array[i] = temp[i];
        }
    }
}
