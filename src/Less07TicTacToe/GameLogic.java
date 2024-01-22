package Less07TicTacToe;

import java.awt.*;
import java.util.Random;

public class GameLogic {


    public static boolean humanTurn = true;
    private static Random compRand = new Random();

//    public static void compTurn() {
//
//        GameInterface.gameFieldButton[][]
//
//        do {
//            i=compRand.nextInt(size);
//            j=compRand.nextInt(size);
//        }while (gameFieldButton[i][j].getText()=="");
//
//    }

    boolean cellValid(int raw, int column) {
        boolean result = true;

        if (GameInterface.gameFieldButton[raw][column].getText == "X" || GameInterface.gameFieldButton[raw][column].getText == "O" ) {         // Проверяет занятость ячейки. Проверить нужно ли -1.
            result = false;
        }
        if (raw > GameInterface.size || column > GameInterface.size) {              // Проверяет превышение размера
            result = false;
        }
        return result;
    }



    public void checkWin() {

    }


}
