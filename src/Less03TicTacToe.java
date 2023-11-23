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



    public static void main(String[] args) {


        initMap();
        printMap();
        //testFillColumn();
        printMap();
        turnHuman();
        checkWin();
        turnComp();
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
        int st = 0;
        int rd = 0;

        do {
            System.out.print("Введите сначала ряд, потом столбец: ");
            rd = scanner.nextInt(size);
            st = scanner.nextInt(size);
        } while (!cellValid(rd, st));

        map[rd-1][st-1] = dot_x;
        printMap();
    }

    private static void turnComp() {
        int rd = -1;
        int st = -1;

        do {
            System.out.println("Ход компьютера: ");
            rd = compRand.nextInt(size);
            st = compRand.nextInt(size);
        } while (!cellValid(rd, st));

        map[rd][st] = dot_o;
        printMap();
    }

    private static boolean cellValid(int rd, int st) {
        boolean result = true;
        if (map[rd-1][st-1] == dot_x || map[rd-1][st-1] == dot_o){
            result = false;
        }
        if (rd-1 > size || st-1 > size){
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
        map[0][0] = dot_x;
        map[0][2] = dot_o;
        map[1][0] = dot_o;
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

            for(int j = 0, x = map.length - 1; j < map.length; j++, x--) {
                if (i == x && map[i][j] == dot_x) {
                    diagonalCounterNeg++;
                }if (i == j && map[i][j] == dot_x) {
                    diagonalCounter++;
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







