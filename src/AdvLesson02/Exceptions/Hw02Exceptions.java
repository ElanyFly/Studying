package AdvLesson02.Exceptions;

import java.util.Arrays;

public class Hw02Exceptions {
    /*1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

2. Далее метод должен пройтись по всем элементам массива, преобразовать в int,
и просуммировать. Если в каком-то элементе массива преобразование не удалось
(например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.

3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
и MyArrayDataException и вывести результат расчета.
*/
    public static void main(String[] args) {
        String[][] arrayOne = new String[4][4];
        String[][] arrayTwo = new String[6][7];
        String[][] arrayThree = new String[4][3];
        String[][] arrayThree3 = new String[4][0];

        fillArray(arrayOne);
        printArray(arrayOne);
        sumArray(arrayOne);


    }

    public static void fillArray(String[][] arrayInput) {

        if (arrayInput.length != 4 || arrayInput[0].length != 4) {
            throw new RuntimeException("denied");
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arrayInput[i][j] = String.valueOf(i);
            }
        }
        arrayInput[3][1] = "Hello!";

    }

    public static void sumArray(String[][] arrayInput) {

        int i = 0;
        int j = 0;
        int sum = 0;

        try {
            for (i = 0; i < arrayInput.length; i++) {
                for (j = 0; j < arrayInput.length; j++) {
                    int value = Integer.valueOf(arrayInput[i][j]);
                    sum = sum + value;

                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Ошибка возникла в ячейке массива: [" + i+ "][" + j + "]");
        }
        System.out.println("\nСумма чисел равна: " + sum);
    }

    public static void printArray(String[][] arrayInput) {

        System.out.println();
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {
                System.out.print(arrayInput[i][j] + "\t");
            }
            System.out.println();
        }
    }
}


