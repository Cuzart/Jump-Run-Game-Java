package AgChSaJo.JumpOrDie;

import java.util.TimerTask;


/**
 * This class includes a method for the temporal ongoing of an obstacle.
 * An obstacle will be able to move on a temporal, continuous basis with this class.
 */
public class ObstacleTimer extends TimerTask {

    private ObstacleManager obstacleManager = JumpOrDie.board.obstacleManager;

    /**
     * An obstacle moves by getting the speed(that can change throughout the game) and the move
     * Method from the ObstacleManager class.
     */
    @Override
    public void run() {
        double speed = obstacleManager.getObstacleSpeed();
        obstacleManager.obstacle1.move(speed);
        if (obstacleManager.obstacle2 != null){
            obstacleManager.obstacle2.move(speed);
        }

        obstacleManager.manageObstacleLifetime();
        JumpOrDie.board.checkCollision(obstacleManager.getCloserObstacle());
    }
}
