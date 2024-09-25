package TennisScorer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        	
            InputManager inputManager = new InputManager(scanner);

    // 세트 수 입력
            int numSets = inputManager.getNumberOfSets();

   // 이름 입력
            String player1Name = inputManager.getPlayerName("Player1");
            String player2Name = inputManager.getPlayerName("Player2");

    //게임 시작
            TennisScoreKeeper scoreKeeper = new TennisScoreKeeper(numSets, player1Name, player2Name, inputManager);

            scoreKeeper.startGame();
        }
    }
}