package TennisScorer;


public class Player {
    private String name; 
    private int setsWon;
    private int currentGamePoints;
    private int[] gamesWonPerSet;

 
    public Player(String name, int numSets) {
        this.name = name;
        this.setsWon = 0; // 0으로 먼저 초기화
        this.currentGamePoints = 0;
        this.gamesWonPerSet = new int[numSets+1];
    }

    public String getName() {
        return name; //이름
    }

    public int getSetsWon() {
        return setsWon; // 이긴 set의 수
    }

    public void winSet() {
        setsWon++; //이긴 세트의 수 증가
    }

    public int getCurrentGamePoints() {
        return currentGamePoints; //현재 게임 point 반환
    }

    public void setCurrentGamePoints(int points) {
        this.currentGamePoints = points; //현재의 point 점수 반환
    }

    public int getGamesWonInCurrentSet(int currentSet) {
        return gamesWonPerSet[currentSet]; // 현재 세트수 배열 생성
    }

    public void winGameInCurrentSet(int currentSet) {
        gamesWonPerSet[currentSet]++; //증가
    }
}
