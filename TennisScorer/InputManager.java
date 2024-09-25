package TennisScorer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {

    private Scanner scanner;

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    // 세트 수를 입력받고 반환
    public int getNumberOfSets() {
        int numSets = 0;
        while (true) {
            System.out.print("세트 수 입력? (3 or 5): ");
            try {
                numSets = scanner.nextInt(); // 세트 수 입력 받기
                if (numSets == 3 || numSets == 5) {
                    return numSets;
                } else {
                    System.out.println("3 or 5 선택!");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자(3 or 5) 입력!!");
                scanner.next();
            }
        }
    }

    // 플레이어 이름을 입력받고 반환
    public String getPlayerName(String playerNumber) {
        System.out.print(playerNumber + " 이름 입력?: ");
        return scanner.next();
    }

    // 포인트 승자 입력을 받고 반환
    public int getPointWinner() {
        while (true) {
            System.out.print("pointwinner 선택? (1 or 2): ");
            try {
                int pointWinner = scanner.nextInt();
                if (pointWinner == 1 || pointWinner == 2) {
                    return pointWinner;
                } else {
                    System.out.println("1 or 2 입력!");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력 1 or 2 입력!!");
                scanner.next(); 
            }
        }
    }
}
