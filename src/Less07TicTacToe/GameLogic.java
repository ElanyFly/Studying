package Less07TicTacToe;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    private  char[][] map;
    private  int size = 3;

    private final char dot_x = 'X';
    private final char dot_o = 'O';
    private  final char dot_empty = '%';

    private  Scanner scanner = new Scanner(System.in);
    private  Random compRand = new Random();

    private  boolean cellValid = true;

    private ResultListener resultListener;

    private final int defaultValueNumber = 999;

    int st = defaultValueNumber;
    int rd = defaultValueNumber;

    public void subscribeOnResultListener(ResultListener resultListener){
        this.resultListener = resultListener;
    }

    public void runGame(){
        new Thread(
            () -> {
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
                        showMessage("ЭТО НИЧЬЯ!");
                        System.out.println("Поля закончились. \nЭТО НИЧЬЯ!");
                        break;
                    }
                }
            }
        ).start();
    }

    private void showMessage (String message){

    }

    public void putTurn(int x, int y){
        st = y;
        rd = x;
    }

    private void winner(){
        if (checkWinSymbol(dot_x)){
            showMessage("Игрок победил");
            System.out.println("Поздравляю, Игрок. Ты победил!");
        }
        if (checkWinSymbol(dot_o)){
            System.out.println("Увы! Компьютер победил! \nВ следующий раз получится лучше :)");
        }
    }

    private boolean emptyFields(){
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

    private void initMap() {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = dot_empty;
            }
        }
    }

    private void printMap() {
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
        resultListener.listenResult(map);
    }

    private synchronized void turnHuman() {

        do {
            try {
                wait(16L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (!cellValid(rd, st));
        map[rd][st] = dot_x;
        printMap();
        st = defaultValueNumber;
        rd = defaultValueNumber;
    }


    private void turnComp() {
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

    private  boolean cellValid(int rd, int st) {
        if (rd == defaultValueNumber || st == defaultValueNumber) return false;
        boolean result = true;
        if (map[rd][st] == dot_x || map[rd][st] == dot_o) {         // Проверяет занятость ячейки. Проверить нужно ли -1.
            result = false;
        }
        if (rd > size || st > size) {              // Проверяет превышение размера
            result = false;
        }
        return result;
    }

    private  void testFillColumn() {
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

    private boolean checkWinSymbol(char playerSymbol) {
        boolean isWin = checkColumn(playerSymbol) || checkRows(playerSymbol) || checkDiagonal(playerSymbol) || checkDiagonalNegative(playerSymbol);
        return isWin;
    }

    private  boolean checkDiagonalNegative(char playerSymbol) {
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

    private  boolean checkDiagonal(char playerSymbol) {
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

    private  boolean checkRows(char playerSymbol) {

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

    private  boolean checkColumn(char playerSymbol) {
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
