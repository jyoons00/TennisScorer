package TennisScorer;

public class Set {
    private Player player1;
    private Player player2;
    private int currentSet;
    private static final int GAMES_TO_WIN_SET = 6;
    private static final int MIN_GAMES_DIFF = 2;

    public Set(Player player1, Player player2, int currentSet) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentSet = currentSet;
    }

    public void checkSetWinner() { //6게임 이상 차이2로
        if (player1.getGamesWonInCurrentSet(currentSet) >= GAMES_TO_WIN_SET && player1.getGamesWonInCurrentSet(currentSet) - player2.getGamesWonInCurrentSet(currentSet) >= MIN_GAMES_DIFF) {
            player1.winSet();
            currentSet++;
        } else if (player2.getGamesWonInCurrentSet(currentSet) >= GAMES_TO_WIN_SET && player2.getGamesWonInCurrentSet(currentSet) - player1.getGamesWonInCurrentSet(currentSet) >= MIN_GAMES_DIFF) {
            player2.winSet();
            currentSet++;
        }
    }

    public int getCurrentSet() {
        return currentSet;
    }
}
