package AgChSaJo.JumpOrDie;

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
            obstacleCount++;
        }

        if(obstacle2 == null){
            if(obstacleCount >= 5){
                if (obstacle2 == null && obstacle1.getX() <=50){
                    obstacle2 = generate();
                    log.info("second Obstacle on screen");
                }
            }
        }else if (obstacle2.getX() <=0){
                obstacle2 = generate();
                obstacleCount++;
        }





        switch (obstacleCount){
            case 10:
                log.debug("set obstacleSpeed to 1.5");
                obstacleSpeed = 1.5;
                break;
            case 20:
                obstacleSpeed = 2;
                log.debug("set obstacleSpeed to 2");
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
        obstacle2 = null;
        obstacleSpeed = 1;
        obstacleCount = 0;
    }

}
