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
    }

}
