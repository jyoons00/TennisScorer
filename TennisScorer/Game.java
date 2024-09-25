package TennisScorer;

public class Game {
    private Player player1;
    private Player player2;
    private boolean deuce;
    private boolean advantagePlayer1;
    private boolean advantagePlayer2;
    private int currentSet;

    public Game(Player player1, Player player2, int currentSet) {
        this.player1 = player1;
        this.player2 = player2;
        this.deuce = false;
        this.advantagePlayer1 = false;
        this.advantagePlayer2 = false;
        this.currentSet = currentSet;
    }

    public void pointWinner(int playerNumber) {
        Player winner = (playerNumber == 1) ? player1 : player2;
        Player loser = (playerNumber == 1) ? player2 : player1;
   
        if ((playerNumber == 1 && advantagePlayer2) || (playerNumber == 2 && advantagePlayer1)) {
            // 둘중 하나라도 AD 면 
            advantagePlayer1 = false;
            advantagePlayer2 = false;
            deuce = true;         
            winner.setCurrentGamePoints(3);
            loser.setCurrentGamePoints(3);
        } else {
            winner.setCurrentGamePoints(winner.getCurrentGamePoints() + 1); //상대방이 AD가 아닌 경우, 포인트를 얻은 플레이어의 점수를 1점 증가
        }

        checkDeuceAndAdvantage(); //현재 게임의 듀스와 어드밴티지 상태를 체크하고 업데이트
        checkGameWinner(); 
    }

    private void checkDeuceAndAdvantage() {
        if (player1.getCurrentGamePoints() >= 3 && player2.getCurrentGamePoints() >= 3) {
            if (player1.getCurrentGamePoints() == player2.getCurrentGamePoints()) {
                deuce = true;
                advantagePlayer1 = false;
                advantagePlayer2 = false;
            } else if (player1.getCurrentGamePoints() - player2.getCurrentGamePoints() == 1) {
                if (deuce) {
                    advantagePlayer1 = true;
                }
            } else if (player2.getCurrentGamePoints() - player1.getCurrentGamePoints() == 1) {
                if (deuce) {
                    advantagePlayer2 = true;
                }
            }
        }
    }

    private void checkGameWinner() {
    	//player1의 점수가 4점 이상이고, player2의 점수보다 2점 이상 차이
        if (player1.getCurrentGamePoints() >= 4 && player1.getCurrentGamePoints() - player2.getCurrentGamePoints() >= 2) {
            player1.winGameInCurrentSet(currentSet);
            resetPoints();
        } else if (player2.getCurrentGamePoints() >= 4 && player2.getCurrentGamePoints() - player1.getCurrentGamePoints() >= 2) {
            player2.winGameInCurrentSet(currentSet);
            resetPoints();
        }
    }

    //게임 점수를 초기화하고 듀스 및 어드밴티지 상태를 리셋
    private void resetPoints() {
        player1.setCurrentGamePoints(0);
        player2.setCurrentGamePoints(0);
        advantagePlayer1 = false;
        advantagePlayer2 = false;
        deuce = false;
    }

    public void setCurrentSet(int currentSet) {
        this.currentSet = currentSet;
    }
}

