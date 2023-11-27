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

        while (emptyFields()) {
            turnHuman();

            if (checkWinSymbol(dot_x)){
                winner();
                break;
            }else {
                turnComp();

                if (checkWinSymbol(dot_o)){
                    winner();
                    break;
                }
            }
            if (!emptyFields()){
                System.out.println("Поля закончились. \nЭТО НИЧЬЯ!");
                break;
            }
        }
    }

    private static void winner() {
        if (checkWinSymbol(dot_x)){
            System.out.println("Поздравляю, Игрок. Ты победил!");
        }
        if (checkWinSymbol(dot_o)){
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
            rd = scanner.nextInt() - 1;
            st = scanner.nextInt() - 1;
        } while (!cellValid(rd, st));

        map[rd][st] = dot_x;
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
        if (map[rd][st] == dot_x || map[rd][st] == dot_o) {         // Проверяет занятость ячейки. Проверить нужно ли -1.
            result = false;
        }
        if (rd > size || st > size) {              // Проверяет превышение размера
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

    private static boolean checkWinSymbol(char playerSymbol) {
        boolean isWin = checkColumn(playerSymbol) || checkRows(playerSymbol) || checkDiagonal(playerSymbol) || checkDiagonalNegative(playerSymbol);
        return isWin;
    }

    private static boolean checkDiagonalNegative(char playerSymbol) {
        int diagonalCounterNeg = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0, x = map.length - 1; j < map.length; j++, x--) {
                if (i == x && map[i][j] == playerSymbol) {
                    diagonalCounterNeg++;
                }
            }
        }
        return diagonalCounterNeg == size;
    }

    private static boolean checkDiagonal(char playerSymbol) {
        int diagonalCounter = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i == j && map[i][j] == playerSymbol) {
                    diagonalCounter++;
                }
            }
        }
        return diagonalCounter == size;
    }

    private static boolean checkRows(char playerSymbol) {

        for (int i = 0; i < size; i++) {
            int rowCounter = 0;
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == playerSymbol) {            // условие, для присвоения результата
                    rowCounter++;
                }
            }
            if (rowCounter == size){
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumn(char playerSymbol) {
        for (int i = 0; i < size; i++) {
            int colCounter = 0;
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] == playerSymbol) {            // условие, для присвоения результата
                    colCounter++;
                }
            }
            if (colCounter == size){
                return true;
            }
        }
        return false;
    }


}







