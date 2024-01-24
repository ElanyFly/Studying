package Less07TicTacToe;

public class MainGame implements ResultListener, ClickListener {
    private final GameLogic gameLogic = new GameLogic();
    private final GameInterface gameInterface = new GameInterface();

    public void run() {

        gameLogic.subscribeOnResultListener(this);

        gameLogic.runGame();
        
    }


    @Override
    public void listenActions(int x, int y) {

    }

    @Override
    public void listenResult(char[][] array) {
        gameInterface.drawField(array);
    }
}
