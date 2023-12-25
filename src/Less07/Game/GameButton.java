package Less07.Game;

import javax.swing.*;

public class GameButton extends JButton {

    private int buttonIndex;
    private GameBoard board;

    public GameButton (int gameButtonIndex, GameBoard currentGameBoard) {
        buttonIndex = gameButtonIndex;
        board = currentGameBoard;

        int rowNumber = buttonIndex / GameBoard.dimension;              //пока не ясно мне для чего эти вычисления
        int cellNumber = buttonIndex % GameBoard.dimension;

        setSize (GameBoard.cellSize - 5, GameBoard.cellSize - 5);
        addActionListener(new GameActionListener (rowNumber, cellNumber, this));

    }

    public GameBoard getBoard(){            //что-то я запуталась с конструкторами. почему этот конструктор находится в кнопках?
        return board;                       //геттер который возвращает ссылку на игровую доску для кнопки. Как это работает?
    }


}
