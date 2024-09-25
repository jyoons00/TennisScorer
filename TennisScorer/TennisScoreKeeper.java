package TennisScorer;

public class TennisScoreKeeper {
    private int numSets;
    private Player player1;
    private Player player2;
    private Game game;
    private Set set;
    private ScoreBoard scoreBoard;
    private FileManager fileManager;
    private InputManager inputManager;

    public TennisScoreKeeper(int numSets, String player1Name, String player2Name, InputManager inputManager) {
        this.numSets = numSets;
        this.player1 = new Player(player1Name, numSets);
        this.player2 = new Player(player2Name, numSets);
        this.set = new Set(player1, player2, 0);
        this.game = new Game(player1, player2, set.getCurrentSet());
        this.scoreBoard = new ScoreBoard();
        this.fileManager = new FileManager(".\\src\\TennisScorer\\ResultTennis.txt");
        this.inputManager = inputManager;
    }

    public void pointWinner(int p) {
        game.pointWinner(p);
        set.checkSetWinner();

        game.setCurrentSet(set.getCurrentSet());

        if (player1.getSetsWon() > numSets / 2 || player2.getSetsWon() > numSets / 2) {
            String resultMessage = "FINAL "
            		+ "WINNER! : " + (player1.getSetsWon() > player2.getSetsWon() ? player1.getName() : player2.getName());
            fileManager.printToConsole(resultMessage);
            fileManager.printToFile(resultMessage);
            fileManager.close();
            System.exit(0);
        }

        String score = scoreBoard.getCurrentScore(player1, player2, set.getCurrentSet());
        fileManager.printToConsole(score);
        fileManager.printToFile(score);
    }

    public void startGame() {
        while (true) {
            int pointWinner = inputManager.getPointWinner();
            String pointWinnerMessage;
            if (pointWinner == 1) {
                pointWinnerMessage = String.format("pointWinner : %s", player1.getName());
            } else if (pointWinner == 2) {
                pointWinnerMessage = String.format("pointWinner : %s", player2.getName());
            } else {
                continue;
            }
            fileManager.printToConsole(pointWinnerMessage);
            fileManager.printToFile(pointWinnerMessage);
            pointWinner(pointWinner);
        }
    }
}
