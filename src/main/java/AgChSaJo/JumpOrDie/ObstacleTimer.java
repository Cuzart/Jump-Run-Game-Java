package AgChSaJo.JumpOrDie;

import java.util.TimerTask;

/*
 * This class includes a method for the temporal ongoing of an obstacle.
 * An obstacle will be able to move on a temporal, continuous basis with this class.
 */
public class ObstacleTimer extends TimerTask {

    /*
     * An obstacle moves by getting the speed(that can change throughout the game) and the move
     * Method from the ObstacleManager class.
     */
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
