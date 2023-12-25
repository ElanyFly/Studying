package Less07.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameActionListener implements ActionListener {

    private int row;
    private int cell;
    private GameButton button;

    public GameActionListener(int rowNumber, int cellNumber, GameButton gButton) {
        this.row = rowNumber;
        this.cell = cellNumber;
        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
