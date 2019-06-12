package AgChSaJo.JumpOrDie;

import AgChSaJo.JumpOrDie.Obstacles.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;

/**
 * The ObstacleManager manages the life and behaviour of obstacles.
 * It creates obstacles, defines their speed, counts obstacles that
 * have been created and stops an obstacle from moving at a certain
 * point on the x scale.
 */

public class ObstacleManager {

    private static Logger log = LogManager.getLogger(ObstacleManager.class);

    public static Obstacle obstacle1, obstacle2;
    private static double obstacleSpeed;
    private static int obstacleCount;

    private static final int obstacleEnd = -50;

    /**
     *  This method generates an exact Kind of an Obstacle by choosing a random number.
     *  If something is not working a Fence is created(default case).
     *
     * @return new Fence(), new Tree(), new Hedge(), new BigHedge(), new Butterfly(), new Eagle()
     */
    private static Obstacle generate(){
        Random r = new Random();
        int kind = r.nextInt(6);
        switch (kind){
            case 0:
                log.debug("new Fence generated");
                return new Fence();
            case 1:
                log.debug("new Tree generated");
                return new Tree();
            case 2:
                log.debug("new Hedge generated");
                return new Hedge();
            case 3:
                log.debug("new BigHedge generated");
                return new BigHedge();
            case 4:
                log.debug("new Butterfly generated");
                return new Butterfly();
            case 5:
                log.debug("new Eagle generated");
                return new Eagle();
            default:
                log.warn("Should not happen - Fence generated");
                return new Fence();
        }
    }

    /**
     * Defines the life of an obstacle. As soon as an obstacle reaches the end a new
     * obstacle will be made. All obstacles that made it though without a collision
     * will be counted, depending on that the score increases.
     * The speed of an obstacle increases depending on how many obstacles have come
     * through.
     */
    static void manageObstacleLifetime(){

        if (obstacle1.getX() <= obstacleEnd){
            obstacle1 = generate();
            obstacleCount++;
            Board.addToScore(10);
        }

        if(obstacle2 == null){
            if(obstacleCount >= 5){
                if (obstacle1.getX() <=400){
                    obstacle2 = generate();
                    log.info("second Obstacle on screen");
                }
            }
        }else if (obstacle2.getX() <= obstacleEnd){
                obstacle2 = generate();
                obstacleCount++;
                Board.addToScore(10);
        }

        switch (obstacleCount){
            case 5:
                obstacleSpeed = 7;
                log.debug("set obstacleSpeed to "+obstacleSpeed);
                break;
            case 10:
                obstacleSpeed = 7.5;
                log.debug("set obstacleSpeed to "+obstacleSpeed);
                break;
            case 15:
                obstacleSpeed = 8;
                log.debug("set obstacleSpeed to "+obstacleSpeed);
                break;
            case 20:
                obstacleSpeed = 8.5;
                log.debug("set obstacleSpeed to "+obstacleSpeed);
                break;
            case 25:
                obstacleSpeed = 9;
                log.debug("set obstacleSpeed to "+obstacleSpeed);
                break;
        }
    }

    /**
     * This method returns that obstacle that is closer to the player.
     *
     * @return obstacle1, obstacle2
     */
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

    /**
     * Gets the (new) obstacle speed.
     *
     * @return obstacleSpeed;
     */
    static double getObstacleSpeed(){
        return obstacleSpeed;
    }

    /**
     * This method is the starting point of the life of an obstacle.
     * The obstacles have their beginning speed and the counter is still on zero.
     */
    static void setUp(){
        obstacle1 = generate();
        obstacle2 = null;
        obstacleSpeed = 6;
        obstacleCount = 0;
    }


}
