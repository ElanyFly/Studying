package Less07TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameInterface implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private final int size = 3;

    private JButton newGameButton;
    private JButton[][] gameFieldButton = new JButton[size][size];


    private Font myFont = new Font("Helvetica", Font.BOLD, 15);
    private Font buttonFont = new Font("Tahoma", Font.BOLD, 35);

    private static Random compRand = new Random();


    GameInterface () {

        frame = new JFrame("Крестики-нолики");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 570);
        frame.setLocationRelativeTo(null);

        frame.setLayout(null);                      //без этого, у панели не будут устанавливаться границы


        gameFieldButton[0][0] = new JButton ("");
        gameFieldButton[0][1] = new JButton ("");
        gameFieldButton[0][2] = new JButton ("");
        gameFieldButton[1][0] = new JButton ("");
        gameFieldButton[1][1] = new JButton ("");
        gameFieldButton[1][2] = new JButton ("");
        gameFieldButton[2][0] = new JButton ("");
        gameFieldButton[2][1] = new JButton ("");
        gameFieldButton[2][2] = new JButton ("");



        newGameButton = new JButton("New game");
        newGameButton.setFont(myFont);
        newGameButton.setBounds(40, 35, 150, 40);
        newGameButton.setFocusable(false);

        panel = new JPanel();
        panel.setBounds(40, 90, 400, 400);
        panel.setLayout(new GridLayout(3, 3, 5, 5));
        //panel.setBackground(Color.CYAN);


        for (int i = 0; i < size; i++) {
           for (int j = 0; j < size; j++) {
               gameFieldButton[i][j].setFont(buttonFont);
               panel.add(gameFieldButton[i][j]);
               gameFieldButton[i][j].addActionListener(this);
               gameFieldButton[i][j].setFocusable(false);           //убирает рамку вокруг текста кнопки
           }
        }


        frame.add(newGameButton);
        frame.add(panel);

        frame.setVisible(true);

    }

    private ClickListener clickListener;
    public void subscribeOnClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (e.getSource()==gameFieldButton[i][j]) {
                    clickListener.listenActions(i, j);
                }
            }
        }

    }

    public void drawField(char[][] array) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char ibragim = array[i][j];
                gameFieldButton[i][j].setText(String.valueOf(ibragim));
            }
        }
    }
}
