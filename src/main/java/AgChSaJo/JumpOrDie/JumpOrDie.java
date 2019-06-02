package AgChSaJo.JumpOrDie;

import java.util.Timer;

public class JumpOrDie {

    private static Timer timer = new Timer();
    private static ObstacleTimer obstacleTimer;


    public static void play(){
        ObstacleManager.setUp();
        Board.activePlayer = new Player();
        obstacleTimer = new ObstacleTimer();
        timer.schedule(obstacleTimer,1000,10);
    }
    public static void stop(){
        obstacleTimer.cancel();
    }
    public static void close(){
        timer.cancel();
    }
}
