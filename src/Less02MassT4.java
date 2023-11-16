/**
 * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
 * заполнить его диагональные элементы единицами;
 */
public class Less02MassT4 {

    public static void main(String[] args){

        byte counter = 1;
        byte[][] table = new byte[3][3];

        for (int i = 0; i < table.length; i++){
            for(int k = 0, x = table.length - 1; k < table.length; k++, x--){
                if(i == k || i == x){
                    table[i][k] = 1;
                }
            }

        }

        printTable(table);

    }
    public static void printTable(byte[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int k = 0; k < arr.length; k++){
                System.out.print(arr[i][k] + "\t");
            }
            System.out.println();
        }
    }
}
