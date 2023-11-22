import java.util.Random;
import java.util.Scanner;

public class Less03TicTacToe {

    private static char[][] map;
    private static int size = 3;

    private static final char dot_x = 'X';
    private static final char dot_o = 'O';
    private static final char dot_empty = '%';

    private static Scanner scanner = new Scanner(System.in);
    private static Random compRand = new Random();

    private static boolean cellValid = true;
    private static int rd = 0;
    private static int st = 0;


    public static void main(String[] args) {


        initMap();
        printMap();
        testFillColumn();
        printMap();
        //turnHuman();
        checkWin();
        //turnComp();
        //CheckWin();
        //winner();



    }

    private static void initMap() {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = dot_empty;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i <= size ; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private static void turnHuman() {
        int st, rd;

        do {
            System.out.print("Введите сначала столбец, потом ряд: ");
            st = scanner.nextInt();
            rd = scanner.nextInt();
        } while (!cellValid);

        map[rd-1][st-1] = dot_x;
        printMap();

    }

    private static boolean cellValid(int rd, int st) {
        boolean result = true;
        if (rd > size || st > size){
            result = false;
        }
        return result;
    }
    private static void testFillColumn() {
        /*for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0, x = size; j < (x - (size - 1)); j++) {
                map[i][j] = dot_x;

            }
        }*/
        System.out.println();
        map[0][2] = dot_x;
        map[1][1] = dot_x;
        map[2][0] = dot_x;
        map[2][2] = dot_x;
    }

    private static void checkWin() {
       // boolean result = false;
        //проверь диагонали
        if (checkRowCol()){
            System.out.println("if (checkRowCol()) winner");       //doSomething()
        } else {
            System.out.println("if (checkRowCol()) LOOSER");
        }

        if (checkDiagonal()){
            System.out.println("if (checkDiagonal()) winner");
        } else {
            System.out.println("if (checkDiagonal()) LOOSER");
        }
        //    result = true;
    }

    private static boolean checkDiagonal() {
        boolean result = false;
        int diagonalCounter = 0;
        int diagonalCounterNeg = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j && map[i][j] == dot_x) {
                    diagonalCounter++;
                }
            }
            for (int x = size - 1; x >= 0; x--) {
                if(map[i][x + (size - 1 - x)] == dot_x){
                    diagonalCounterNeg++;
                }
            }

            if(diagonalCounter == size || diagonalCounterNeg == size){
                result = true;
            }

        }
        return result;
    }

    private static boolean checkRowCol(){
        boolean result = false;


        for (int i = 0; i < size; i++) {            // i = row / j = column /// сюда можно будет добавить dot_o так же, для проверки на неё.
            int rowCounter = 0;
            int colCounter = 0;
            for (int j = 0; j < size; j++) {
                if (map[i][j] == dot_x || map[j][i] == dot_x){            // условие, для присвоения результата
                    rowCounter++;                                         // Каждый проход смотрит, нашлись ли совпадения из условия, в случае если да, начинает считать сколько.
                    colCounter++;
                }

                if(rowCounter == size || colCounter == size){              // когда каунтер дойдет до размера поля, он присваивает тру - ряд или колонка полностью заполнены одним значением.
                    result = true;
                }
            }
        }

        return result;
    }

}


//проверь колонки
    //проверь ряды




