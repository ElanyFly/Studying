package Less07TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GameInterface {

    JFrame frame;
    private final int size = 3;

    JButton newGame;
    JButton[][] gameField = new JButton[size][size];

    Font myFont = new Font("Helvetica", Font.BOLD, 30);


    GameInterface () {
        frame = new JFrame("Крестики-нолики");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        frame.setVisible(true);

    }
}
