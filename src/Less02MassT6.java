/**
 * 6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
 * если в массиве есть место, в котором сумма левой и правой части массива равны.
 * Примеры: checkBalance([1, 1, 1, || 2, 1]) > true, checkBalance ([2, 1, 1, 2, 1]) > false,
 * checkBalance ([10, || 10]) > true, граница показана символами ||, эти символы в массив не входят;
 */
import java.util.Scanner;
public class Less02MassT6 {

    public static void main (String[] args){

        int[] arr = new int[6];
        Scanner numIns = new Scanner(System.in);

        for ( int i = 0; i < arr.length; i++){
            System.out.print("Введите число: ");
            int num = numIns.nextInt();
            arr[i] = num;
        }


        if (arr[0] + arr[1] + arr[2] == arr[3] + arr[4] + arr[5]){
            System.out.println("true");
        }else System.out.println("false");
    }
}
