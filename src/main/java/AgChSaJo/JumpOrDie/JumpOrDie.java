package AgChSaJo.JumpOrDie;

import AgChSaJo.IGame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JumpOrDie implements IGame {

    private static Logger log = LogManager.getLogger(JumpOrDie.class);


    public void playAgain(){
        ObstacleManager.setUp();
        Board.activePlayer = new Player();
        Board.startObstacleTimerTask(1000);
        Board.resetJumpingVariables();
        Board.resetScore();
        log.info("Start new Game");
    }
    public void resumeGame(){
        Board.startObstacleTimerTask(5000);
        Board.startJumpTimerTask(5000);
    }
    public void stopGame(){
        Board.stopTimerTasks();
    }
    public void closeGame(){
        Board.closeTimers();
    }

}
