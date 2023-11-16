/**
 * 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
 */
public class Less02MassT2 {

    public static void main (String[] args) {

        int[] arr = new int[8];
        int counter = 0;

        for(int i = 0; i < 8; i++){
            arr[i] = counter;
            counter += 3;
            System.out.println("i- " + i +" arrval- " + arr[i]);
        }
    }
}
