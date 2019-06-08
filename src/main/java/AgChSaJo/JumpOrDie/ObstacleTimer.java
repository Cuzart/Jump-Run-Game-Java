package AgChSaJo.JumpOrDie;

import java.util.TimerTask;

public class ObstacleTimer extends TimerTask {

    @Override
    public void run() {
        double speed = ObstacleManager.getObstacleSpeed();
        ObstacleManager.obstacle1.move(speed);
        if (ObstacleManager.obstacle2 != null){
            ObstacleManager.obstacle2.move(speed);
        }

        ObstacleManager.manageObstacleLifetime();
        Board.checkCollision(ObstacleManager.getCloserObstacle());
    }
}
