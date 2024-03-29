package Less07TicTacToe;

public class MainGame implements ResultListener, ClickListener {
    private final GameLogic gameLogic = new GameLogic();
    private final GameInterface gameInterface = new GameInterface();

    public void run() {
        gameLogic.subscribeOnResultListener(this);
        gameInterface.subscribeOnClickListener(this);

        gameLogic.runGame();
    }


    @Override
    public void listenActions(int x, int y) {
        gameLogic.putTurn(x, y);
    }

    @Override
    public void clickNewGame() {
        gameLogic.startNewGame();
    }

    @Override
    public void listenResult(char[][] array) {
        gameInterface.drawField(array);
    }

    @Override
    public void listenMessage(String text) {
        gameInterface.receiveMessage(text);
    }

}
