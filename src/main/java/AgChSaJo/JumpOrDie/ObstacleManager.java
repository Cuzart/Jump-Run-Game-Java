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

    public Obstacle obstacle1, obstacle2;
    private double obstacleSpeed;
    private int obstacleCount;
    private final int obstacleEnd = -50;

    /**
     *  Factory for Obstacles
     *
     * @return a random generated obstacle
     */
    private Obstacle generate(){
        Random r = new Random();
        int kind = r.nextInt(7);
        switch (kind){
            case 0:
                log.debug("new Rock generated");
                return new Rock();
            case 1:
                log.debug("new Tree generated");
                return new Tree();
            case 2:
                log.debug("new Shrub generated");
                return new Shrub();
            case 3:
                log.debug("new CactusRow generated");
                return new CactusRow();
            case 4:
                log.debug("new Mosquito generated");
                return new Mosquito();
            case 5:
                log.debug("new Seagull generated");
                return new Seagull();
            case 6:
                log.debug("new Grass generated");
                return new Grass();
            default:
                log.warn("Should not happen - Rock generated");
                return new Rock();
        }
    }

    /**
     * Defines the life of an obstacle. As soon as an obstacle reaches the end a new
     * obstacle will be made. All obstacles that made it though without a collision
     * will be counted, depending on that the score increases.
     * The speed of an obstacle increases depending on how many obstacles have come
     * through.
     */
    void manageObstacleLifetime(){

        //watches obstacle 1
        if (obstacle1.getX() <= obstacleEnd){
            obstacle1 = generate();
            obstacleCount++;
            JumpOrDie.board.addToScore(10);
        }

        //watches obstacle 2
        if(obstacle2 == null){
            if(obstacleCount >= 5){                             //after 5 obstacles a second obstacle gets added
                if (obstacle1.getX() <=400){                    //to increase the difficulty
                    obstacle2 = generate();
                    log.info("second Obstacle on screen");
                }
            }
        }else if (obstacle2.getX() <= obstacleEnd){
                obstacle2 = generate();
                obstacleCount++;
                JumpOrDie.board.addToScore(10);
        }

        //speed increase after a certain amount of obstacles to increase the difficulty
        switch (obstacleCount){
            case 5:
                obstacleSpeed = 7.5;
                log.debug("set obstacleSpeed to "+obstacleSpeed);
                break;
            case 10:
                obstacleSpeed = 8;
                log.debug("set obstacleSpeed to "+obstacleSpeed);
                break;
            case 15:
                obstacleSpeed = 8.5;
                log.debug("set obstacleSpeed to "+obstacleSpeed);
                break;
            case 20:
                obstacleSpeed = 9;
                log.debug("set obstacleSpeed to "+obstacleSpeed);
                break;
            case 25:
                obstacleSpeed = 9.5;
                log.debug("set obstacleSpeed to "+obstacleSpeed);
                break;
        }
    }

    /**
     * This method returns the obstacle that is closer to the player
     * to check a possible collision
     *
     * @return closer obstacle
     */
    Obstacle getCloserObstacle(){
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
    double getObstacleSpeed(){
        return obstacleSpeed;
    }
    int getObstacleCount(){
        return obstacleCount;
    }

    /**
     * If the game starts again this methods resets everything
     * The obstacles have their beginning speed and the counter is still on zero.
     */
    void setUp(){
        obstacle1 = generate();
        obstacle2 = null;
        obstacleSpeed = 7;
        obstacleCount = 0;
    }

}
