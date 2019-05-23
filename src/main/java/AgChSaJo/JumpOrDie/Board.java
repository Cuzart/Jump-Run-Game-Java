package AgChSaJo.JumpOrDie;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Board {

    private static Logger log = LogManager.getLogger(Board.class);

    static Player activePlayer;

    static boolean checkCollision(Obstacle obstacle){
        double playerX = activePlayer.getX();
        double playerXEnd = activePlayer.getXEnd();

        if (obstacle.getX() <= playerXEnd && obstacle.getXEnd() >= playerX){
            if (activePlayer.getY()<=obstacle.getHeight()){
                log.info("Game Over - Collision detected");
                return true;
            }
        }
        return false;
    }
}
