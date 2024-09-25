package TennisScorer;

public class ScoreBoard {

/*	
    public void displayScore(Player player1, Player player2, int currentSet) {
        String score = getCurrentScore(player1, player2, currentSet);
        System.out.println(score);
    }
 */  

    public String getCurrentScore(Player player1, Player player2, int currentSet) {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================================================\n");
        sb.append(String.format("%-10s\t%-7s\t%-5s\t%-4s\n", "이름", "Point", "Game", "Set"));
        sb.append("------------------------------------------------------------------------\n");
        sb.append(String.format("%-10s\t%-7s\t%-5d\t%-4d\n", player1.getName(),
                                pointToString(player1.getCurrentGamePoints()),
                                player1.getGamesWonInCurrentSet(currentSet),
                                player1.getSetsWon()));
        sb.append("------------------------------------------------------------------------\n");
        sb.append(String.format("%-10s\t%-7s\t%-5d\t%-4d\n", player2.getName(),
                                pointToString(player2.getCurrentGamePoints()),
                                player2.getGamesWonInCurrentSet(currentSet),
                                player2.getSetsWon()));
        sb.append("========================================================================");
        return sb.toString();
    }

    private String pointToString(int points) {
        switch (points) {
        case 0: return "0";
        case 1: return "15";
        case 2: return "30";
        case 3: return "40";
        default: return "AD"; // Advantage
        }
    }
}
