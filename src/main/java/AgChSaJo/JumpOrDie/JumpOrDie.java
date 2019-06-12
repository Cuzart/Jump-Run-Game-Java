package AgChSaJo.JumpOrDie;

import AgChSaJo.IGame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JumpOrDie implements IGame {

    private static Logger log = LogManager.getLogger(JumpOrDie.class);

    /**
     * resets activePlayer and all variables and starts a new game
     */
    public void playAgain(){
        ObstacleManager.setUp();
        Board.activePlayer = new Player();
        Board.startTimerTasks(1000);
        Board.resetJumpingVariables();
        Board.resetScore();
        log.info("Start new Game");
    }

    /**
     * game will be continued after short delay
     */
    public void resumeGame(){
        Board.startTimerTasks(5000);
        Board.startJumpTimerTask(5000);
    }

    /**
     * stops timer and game
     */
    public void stopGame(){
        Board.stopTimerTasks();
    }

    /**
     * quits timer and game
     */
    public void closeGame(){
        Board.closeTimers();
    }

}
