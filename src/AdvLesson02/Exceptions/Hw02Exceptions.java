package AdvLesson02.Exceptions;

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

        fillArray(arrayThree3);


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
        arrayInput[3][3] = "Hello!";

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


