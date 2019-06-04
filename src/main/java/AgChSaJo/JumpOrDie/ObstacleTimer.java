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
        /*if (ObstacleManager.obstacle2 == null) {
            System.out.println("Obstacle 1: " + ObstacleManager.obstacle1.getX());
        }else {
            System.out.println("Obstacle 1: " + ObstacleManager.obstacle1.getX()+" | "+"Obstacle 2: "+ObstacleManager.obstacle2.getX());
        }*/
        ObstacleManager.manageObstacleLifetime();
        Board.checkCollision(ObstacleManager.getCloserObstacle());
    }
}
