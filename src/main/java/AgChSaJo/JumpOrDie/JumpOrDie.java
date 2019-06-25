package AgChSaJo.JumpOrDie;

import AgChSaJo.IGame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * This class contains the general game mechanism.
 * Someone can stop the game, resume it, finish it and play again.
 */
public class JumpOrDie implements IGame {

    private static Logger log = LogManager.getLogger(JumpOrDie.class);

    public static Board board = new Board();

    /**
     * resets activePlayer and all variables and starts a new game
     */
    public void playAgain(){
        board.obstacleManager.setUp();
        board.activePlayer = new Player();
        board.startTimerTasks(1000);
        board.resetJumpingVariables();
        board.resetScore();
        log.info("Start new Game");
    }

    /**
     * game will be continued after short delay
     * in case the game was paused
     */
    public void resumeGame(){
        board.startTimerTasks(3000);
        board.startJumpTimerTask(3000);
    }

    /**
     * stops timer and game
     * this happens in 2 options
     * 1: game got paused
     * 2: game Over
     */
    public void stopGame(){
        board.stopTimerTasks();
    }

    /**
     * quits timer and game
     */
    public void closeGame(){
        board.closeTimers();
    }

}
