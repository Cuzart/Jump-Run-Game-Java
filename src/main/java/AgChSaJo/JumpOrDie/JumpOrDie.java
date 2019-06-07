package AgChSaJo.JumpOrDie;

import AgChSaJo.IGame;

public class JumpOrDie implements IGame {


    public void playAgain(){
        ObstacleManager.setUp();
        Board.activePlayer = new Player();
        Board.startObstacleTimerTask(1000);
        Board.resetJumpingVariables();
        Board.resetScore();
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
