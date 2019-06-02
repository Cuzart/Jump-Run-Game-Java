package AgChSaJo.JumpOrDie;

import AgChSaJo.GUI.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;



class ObstacleManager {

    private static Logger log = LogManager.getLogger(ObstacleManager.class);

    static Obstacle obstacle1, obstacle2;
    private static double obstacleSpeed;
    private static int obstacleCount;

    static Obstacle generate(){
        Random r = new Random();
        int kind = r.nextInt(2);
        switch (kind){
            case 0:
                log.debug("new Fence generated");
                return new Fence();
            case 1:
                log.debug("new Hedge generated");
                return new Hedge();
            default:
                log.warn("Should not happen - Fence generated");
                return new Fence();
        }
    }

    static void manageObstacleLifetime(){

        if (obstacle1.getX() <=0){
            obstacle1 = generate();
            App.setupGUIObstacle(1,obstacle1);
            obstacleCount++;
        }

        if(obstacle2 == null){
            if(obstacleCount >= 5){
                if (obstacle1.getX() <=50){
                    obstacle2 = generate();
                    App.setupGUIObstacle(2,obstacle2);
                    log.info("second Obstacle on screen");
                }
            }
        }else if (obstacle2.getX() <=0){
                obstacle2 = generate();
                App.setupGUIObstacle(2,obstacle2);
                obstacleCount++;
        }





        switch (obstacleCount){
            case 10:

                obstacleSpeed = 4;
                log.debug("set obstacleSpeed to "+obstacleSpeed);
                break;
            case 20:
                obstacleSpeed = 6;
                log.debug("set obstacleSpeed to "+obstacleSpeed);
                break;
        }
    }

    static double getObstacleSpeed(){
        return obstacleSpeed;
    }

    static Obstacle getCloserObstacle(){
        if (obstacle2 ==null ){
            return obstacle1;
        }else {
            if (obstacle1.getX()<obstacle2.getX()){
                return obstacle1;
            }else{
                return obstacle2;
            }
        }
    }

    static void setUp(){
        obstacle1 = generate();
        App.setupGUIObstacle(1,obstacle1);
        obstacle2 = null;
        obstacleSpeed = 2;
        obstacleCount = 0;
    }

}
