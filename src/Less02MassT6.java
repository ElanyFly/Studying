/**
 * 6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
 * если в массиве есть место, в котором сумма левой и правой части массива равны.
 * Примеры: checkBalance([1, 1, 1, || 2, 1]) > true, checkBalance ([2, 1, 1, 2, 1]) > false,
 * checkBalance ([10, || 10]) > true, граница показана символами ||, эти символы в массив не входят;
 */
import java.util.Scanner;
public class Less02MassT6 {

    private static Scanner tableSize = new Scanner(System.in);
    private static Scanner numIns = new Scanner(System.in);
    private static int size;
    private static int[] numbersArr;

    public static void main (String[] args){

        initTable();
        printTable(numbersArr);
        if (checkBalance(numbersArr)){
            System.out.println("\nПоловинки равны");
        } else {
            System.out.println("\nПоловинки НЕ равны");
        }

    }

    public static void initTable(){
        System.out.print("Задайте размер массива: ");
        size = tableSize.nextInt();

        numbersArr = new int[size];

        for ( int i = 0; i < size; i++){
            System.out.print("Введите число: ");
            int num = numIns.nextInt();
            numbersArr[i] = num;
        }
    }

    public static void printTable (int[] arr) {
        System.out.print("\nСоздан массив: ");
        for (int i : arr ) {
            System.out.print(i + "\t");
        }

    }
    public static boolean checkBalance (int[] arr) {

        boolean result = false;
        int leftSide = 0;
        int rightSide = 0;
        boolean equalSize = size % 2 == 0;
        int middleNumber = size / 2;

        for (int i = 0; i < size/2; i++) {
            leftSide += arr[i];
            rightSide += arr[size-1-i];
        }

        if (!equalSize) {
            leftSide += arr[middleNumber];
        }
        if (leftSide == rightSide){
            result = true;
        }

        return result;
    }
}
