package com.javarush.task.pro.task05.task0504;

/* 
Объединяем массивы
*/

public class Solution {
    public static int[] firstArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int[] secondArray = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    public static int[] resultArray  = new int[firstArray.length + secondArray.length]; // resultArray инициализируется размером, равным сумме длин firstArray и secondArray.Это гарантирует, что места хватит для хранения всех элементов из обоих массивов

    public static void main(String[] args) {

        int count = 0; //  инициализация переменной count нулем. Этот счетчик будет отслеживать текущий индекс в resultArray, куда должен быть помещен следующий элемент.
        for(int i = 0; i < firstArray.length; i++) {
            resultArray[i] = firstArray[i];
            count++;                                  // Цикл for выполняет итерацию по каждому элементу в firstArray. На каждой итерации он присваивает текущему элементу firstArray соответствующий индекс в resultArray, а затем увеличивает переменную count.
        }
        for(int j = 0; j < secondArray.length;j++) {
            resultArray[count++] = secondArray[j];         // В другом цикле for выполняется итерация по каждому элементу второго массива secondArray. На каждой итерации он помещает текущий элемент secondArray в следующий доступный индекс resultArray, на который указывает count, а затем снова увеличивает count.
        }
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + ", ");     // Наконец, третий цикл for выполняет итерацию по каждому элементу resultArray и печатает его через запятую и пробел. Это завершает процесс слияния и выводит объединенный массив.
        }
    }
}
