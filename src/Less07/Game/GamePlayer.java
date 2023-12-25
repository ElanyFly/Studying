package Less07.Game;

public class GamePlayer {

    private char playerSign;
    private boolean realPlayer = true;

    public GamePlayer (boolean isRealPlayer, char playerSign) {
        this.realPlayer = isRealPlayer;
        this.playerSign = playerSign;
    }

    public boolean isRealPlayer() {         //почему это геттер без гет?
        return realPlayer;
    }

    public char getPlayerSign() {
        return playerSign;
    }
}
