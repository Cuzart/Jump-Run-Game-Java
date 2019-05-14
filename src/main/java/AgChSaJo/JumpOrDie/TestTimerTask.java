package AgChSaJo.JumpOrDie;

import java.util.TimerTask;

public class TestTimerTask extends TimerTask {

    @Override
    public void run() {
        ObstacleManager.obstacle1.move();
        System.out.println(ObstacleManager.obstacle1.x);
        if (ObstacleManager.obstacle2 != null){
            ObstacleManager.obstacle2.move();
        }
        ObstacleManager.manageObstacleLifetime(1);
    }
}
