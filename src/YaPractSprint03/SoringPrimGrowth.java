package YaPractSprint03;

import java.util.Arrays;

public class SoringPrimGrowth {
    public static void main(String[] args) {
        final int[] array = {4, 1, 7, 3};

        // простая сортировка массива
        bubbleSort(array);
        // статический метод toString() класса Arrays позволяет нам отображать массив в виде читаемой строки
        System.out.println(Arrays.toString(array));
    }
    private static void bubbleSort(final int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
