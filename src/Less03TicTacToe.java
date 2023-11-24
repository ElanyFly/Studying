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
        //testFillColumn();
        printMap();
        //checkDiagonal();

        while (emptyFields()) {
            turnHuman();

            if (checkWinHuman()){
                winner();
            }else {
                turnComp();

                if (checkWinComputer()){
                    winner();
                }
            }
            if (!emptyFields()){
                System.out.println("Поля закончились. \nЭТО НИЧЬЯ!");
                break;
            }
        }


//        printMap();
//        turnHuman();
//        checkWin();
//        turnComp();
        //CheckWin();
        //winner();


    }

    private static void winner() {
        if (checkWinHuman()){
            System.out.println("Поздравляю, Игрок. Ты победил!");
        }
        if (checkWinComputer()){
            System.out.println("Увы! Компьютер победил! \nВ следующий раз получится лучше :)");
        }
    }

    private static boolean emptyFields() {
        boolean result = true;
        int count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == dot_x || map[i][j] == dot_o) {
                    count++;
                }
            }

            if (count == size * size) {
                result = false;
            }

        }
        return result;
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
        for (int i = 0; i <= size; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void turnHuman() {
        int st = 0;
        int rd = 0;

        do {
            System.out.print("Введите ряд и столбец (через пробел): ");
            rd = scanner.nextInt(size);
            st = scanner.nextInt(size);
        } while (!cellValid(rd, st));

        map[rd - 1][st - 1] = dot_x;
        printMap();
    }

    private static void turnComp() {
        int rd = -1;
        int st = -1;

        do {
            System.out.println("Ход компьютера: ");
            rd = compRand.nextInt(size-1);
            st = compRand.nextInt(size-1);
        } while (!cellValid(rd, st));

        map[rd][st] = dot_o;
        printMap();
    }

    private static boolean cellValid(int rd, int st) {
        boolean result = true;
        if (map[rd - 1][st - 1] == dot_x || map[rd - 1][st - 1] == dot_o) {
            result = false;
        }
        if (rd - 1 > size || st - 1 > size) {
            result = false;
        }
        return result;
    }

    private static void testFillColumn() {
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0, x = size; j < (x - (size - 1)); j++) {
                map[i][j] = dot_x;

            }
        }
        System.out.println();
        map[0][2] = dot_x;
        map[1][0] = dot_x;
        map[2][1] = dot_x;

    }

    private static boolean checkWinHuman() {
        boolean result = false;
        int diagonalCounter = 0;
        int diagonalCounterNeg = 0;
        int rowCounter = 0;
        int colCounter = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0, x = map.length - 1; j < map.length; j++, x--) {
                if (i == x && map[i][j] == dot_x) {
                    diagonalCounterNeg++;
                }
                if (i == j && map[i][j] == dot_x) {
                    diagonalCounter++;
                }
                if (map[i][j] == dot_x || map[j][i] == dot_x) {            // условие, для присвоения результата
                    rowCounter++;                                         // Каждый проход смотрит, нашлись ли совпадения из условия, в случае если да, начинает считать сколько.
                    colCounter++;
                }
            }
            if (diagonalCounter == size || diagonalCounterNeg == size || rowCounter == size || colCounter == size) {
                result = true;
            }
        }

        return result;
    }

    private static boolean checkWinComputer() {
        boolean result = false;
        int diagonalCounter = 0;
        int diagonalCounterNeg = 0;
        int rowCounter = 0;
        int colCounter = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0, x = map.length - 1; j < map.length; j++, x--) {
                if (i == x && map[i][j] == dot_o) {
                    diagonalCounterNeg++;
                }
                if (i == j && map[i][j] == dot_o) {
                    diagonalCounter++;
                }
                if (map[i][j] == dot_o || map[j][i] == dot_o) {            // условие, для присвоения результата
                    rowCounter++;                                         // Каждый проход смотрит, нашлись ли совпадения из условия, в случае если да, начинает считать сколько.
                    colCounter++;
                }
            }
            if (diagonalCounter == size || diagonalCounterNeg == size || rowCounter == size || colCounter == size) {
                result = true;
            }
        }

        return result;
    }


    private static boolean checkWin() {
        boolean result = false;
        //проверка колонок
        if (checkRowCol()) {
            result = true;
        }

        // проверка по диагоналям
        if (checkDiagonal()) {
            result = true;
        }

        return result;
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
        /*for (int i = 0; i < map.length; i++) {
            if (map[i][i] == dot_x) {
                diagonalCounterNeg++;
            }
            if (map[i][size - 1 - i] == dot_x) {
                diagonalCounter++;
            }
        }
        if (diagonalCounter == 3) {
            System.out.println("levo");
        }
        if (diagonalCounterNeg == 3) {
            System.out.println("pravo");
        }*/
        return result;
    }

    private static boolean checkRowCol() {
        boolean result = false;


        for (int i = 0; i < size; i++) {            // i = row / j = column /// сюда можно будет добавить dot_o так же, для проверки на неё.
            int rowCounter = 0;
            int colCounter = 0;
            for (int j = 0; j < size; j++) {
                if (map[i][j] == dot_x || map[j][i] == dot_x) {            // условие, для присвоения результата
                    rowCounter++;                                         // Каждый проход смотрит, нашлись ли совпадения из условия, в случае если да, начинает считать сколько.
                    colCounter++;
                }

                if (rowCounter == size || colCounter == size) {              // когда каунтер дойдет до размера поля, он присваивает тру - ряд или колонка полностью заполнены одним значением.
                    result = true;
                }
            }
        }

        return result;
    }

}







