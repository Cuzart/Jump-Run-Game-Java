package AgChSaJo.JumpOrDie;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Board {

    private static Logger log = LogManager.getLogger(Board.class);

    static Player activePlayer;

    static boolean checkCollision(Obstacle obstacle){
        double playerX = activePlayer.getX();
        double playerXEnd = activePlayer.getXEnd();

        //Check collision
        if (obstacle.getX()>=playerX && obstacle.getX()<=playerXEnd){
            if (activePlayer.getY()<=obstacle.getHeight()){
                log.info("Game Over - Collision detected");
                return true;
            }
        }else if (obstacle.getXEnd()>=playerX && obstacle.getXEnd()<=playerXEnd ){
            if (activePlayer.getY()<=obstacle.getHeight()){
                log.info("Game Over - Collision detected");
                return true;
            }
        }
        log.debug("all good");
        return false;
    }
}
