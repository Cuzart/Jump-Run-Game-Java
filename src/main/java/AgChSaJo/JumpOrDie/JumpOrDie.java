package AgChSaJo.JumpOrDie;

import java.util.Timer;

public class JumpOrDie {

    private static Timer timer = new Timer();
    static boolean playing = true;
    public static void main(String[] args) {
        play();

    }


    static Player player = new Player("Tom,", 10); //dummie Spieler

    public static Player getPlayer() { //weg zu greifen!! ich lösche es später, wann der path ist gestellt.
        return player;
    }

    static void play(){
        ObstacleManager.setUp();
        Board.activePlayer = new Player();
        timer.scheduleAtFixedRate(new ObstacleTimer(),1000,100);
    }
}
