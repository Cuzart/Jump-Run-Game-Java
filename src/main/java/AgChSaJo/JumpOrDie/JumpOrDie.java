package AgChSaJo.JumpOrDie;

import java.util.Timer;

public class JumpOrDie {

    private static Timer timer = new Timer();
    static boolean playing = true;

    public static void main(String[] args) {
        play();

    }

    static void play(){
        ObstacleManager.setUp();
        Board.activePlayer = new Player();
        timer.scheduleAtFixedRate(new ObstacleTimer(),1000,100);
    }
}
