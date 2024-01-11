package Less07TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GameInterface {

    JFrame frame;
    JPanel panel;
    private final int size = 3;

    JButton newGameButton;
    JButton[][] gameField = new JButton[size][size];


    Font myFont = new Font("Helvetica", Font.BOLD, 15);

    private void initButtons(){



    }


    GameInterface () {

        frame = new JFrame("Крестики-нолики");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 570);
        frame.setLocationRelativeTo(null);

        frame.setLayout(null);                      //без этого, у панели не будут устанавливаться границы


        gameField[0][0] = new JButton ("1");
        gameField[0][1] = new JButton ("2");
        gameField[0][2] = new JButton ("3");
        gameField[1][0] = new JButton ("4");
        gameField[1][1] = new JButton ("5");
        gameField[1][2] = new JButton ("6");
        gameField[2][0] = new JButton ("7");
        gameField[2][1] = new JButton ("8");
        gameField[2][2] = new JButton ("9");



        newGameButton = new JButton("New game");
        newGameButton.setFont(myFont);
        newGameButton.setBounds(40, 35, 150, 40);

        panel = new JPanel();
        panel.setBounds(40, 90, 400, 400);
        panel.setLayout(new GridLayout(3, 3, 5, 5));
        //panel.setBackground(Color.CYAN);


        for (int i = 0; i < size; i++) {
           for (int j = 0; j < size; j++) {
               gameField[i][j].setFont(myFont);
              panel.add(gameField[i][j]);
           }
        }




        frame.add(newGameButton);
        frame.add(panel);
        //frame.add();

        frame.setVisible(true);

    }
}
