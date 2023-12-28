package Less02;

/**
 * 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
 */
public class Less02MassT5 {

    public static void main (String[] args){


        int[] arr = {73, 15, 2, 5, 16, 9, 4, -3, 8, 79};
        int min = arr[0];
        int max = arr[0];

        for (int j : arr) {
            if (j < min) {
                min = j;
            } else if (j > max) {
                max = j;
            }
        }

        System.out.println("min = " + min);
        System.out.println("max = " + max);

    }

}
