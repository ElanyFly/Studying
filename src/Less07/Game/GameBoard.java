package Less07.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame {

    static int dimension = 3;               // размерность поля
    static int cellSize = 150;              //размер одной клетки
    private char[][] gameField;             //поле игровое
    private GameButton[] gameButtons;       //Массив кнопок

    private Game game;                      //ссылка на игру ?? мне не очень понятно, что за ссылка на игру

    static char nullSymbol = '\u0000';

    public GameBoard (Game currentGame) {   //конструктор игры
        this.game = currentGame;
        initField();
    }

    private void initField() {
        //основные настройки окна
        setBounds(cellSize * dimension, cellSize * dimension, 400, 300);
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout((new BorderLayout()));

        JPanel controlPanel = new JPanel();
        JButton newGameButton = new JButton("Новая игра");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyField();
            }
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));      // а это что?
        controlPanel.add(newGameButton);                                            //добавили кнопку на панель
        controlPanel.setSize(cellSize * dimension, 150);

        JPanel gameFieldPanel = new JPanel();                                       //панель самой игры
        gameFieldPanel.setLayout(new GridLayout(dimension, dimension));
        gameFieldPanel.setSize(cellSize * dimension, cellSize * dimension);

        gameField = new char[dimension][dimension];
        gameButtons = new GameButton[dimension * dimension];

        for (int i = 0; i < (dimension * dimension); i++) {
            GameButton fieldButton = new GameButton(i, this);       //что за this он везде вставляет\\ создаем кнопки с указанием их индекса
            gameFieldPanel.add(fieldButton);                                        //добавили кнопки на игровое поле
            gameButtons[i] = fieldButton;                                           //вставляем в массив полученную ссылку на кнопку?
        }

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    void emptyField() {

        for (int i = 0; i < (dimension * dimension); i++) {
            gameButtons[i].setText("");

            int x = i / GameBoard.dimension;
            int y = i % GameBoard.dimension;

            gameField[x][y] = nullSymbol;
        }

    }

    Game getGame() {
        return game;
    }

    boolean isTurnable (int x, int y) {
        boolean result = false;

        if (gameField[y][x] == nullSymbol) {
            result = true;
        }

        return result;
    }

    void updateGameField (int x, int y) {
        gameField[y][x] = game.getCurrentPlayer().getPlayerSign();
    }

  /*  boolean checkWin() {
        boolean result = false;

        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();

        if (checkWinDiagonal(playerSymbol) || checkWinLines(playerSymbol)) {
            result = true;
        }

        return result;
    }*/
}
