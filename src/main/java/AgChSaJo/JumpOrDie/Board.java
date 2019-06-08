package AgChSaJo.JumpOrDie;

import AgChSaJo.GUI.App;
import AgChSaJo.GUI.GameController;
import AgChSaJo.JumpOrDie.Obstacles.Obstacle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Timer;

public class Board {

    private static Logger log = LogManager.getLogger(Board.class);

    private static Timer obstacleTimer = new Timer();
    private static Timer jumpTimer = new Timer();
    private static ObstacleTimer obstacleTimerTask;
    private static PlayerJumpTimer jumpTimerTask;
    private static int period = 20;

    public static Player activePlayer;
    private static boolean jumping;
    static int jumpCounter = 0;
    private static int score;

    static void checkCollision(Obstacle obstacle){
        double playerX = activePlayer.getX();
        double playerXEnd = activePlayer.getXEnd();

        if (obstacle.getX() <= playerXEnd && obstacle.getXEnd() >= playerX){
            if (activePlayer.getY()<=obstacle.getHeight()){
                log.info("GameOver - Collision detected");
                stopTimerTasks();
                App.gameController.gameOver();
            }
        }
    }
    private static void setJumping(boolean v){
        jumping = v;
        log.debug("Set Jumping to: "+ v);
    }
    public static void playerJump(){
        if (!jumping) {
            jumpTimerTask = new PlayerJumpTimer();
            jumpTimer.scheduleAtFixedRate(jumpTimerTask, 5,period);
            Board.setJumping(true);
        }
    }
    static void resetJumpingVariables(){
        setJumping(false);
        jumpCounter = 0;
    }

    static void startObstacleTimerTask(long delay){
        obstacleTimerTask = new ObstacleTimer();
        obstacleTimer.schedule(obstacleTimerTask,delay,period);
    }
    static void startJumpTimerTask(long delay){
        jumpTimerTask = new PlayerJumpTimer();
        jumpTimer.scheduleAtFixedRate(jumpTimerTask, delay, period);
    }
    static void stopTimerTasks(){
        obstacleTimerTask.cancel();
        if(jumpTimerTask != null) {
            jumpTimerTask.cancel();
        }
    }
    static void closeTimers(){
        obstacleTimer.cancel();
        jumpTimer.cancel();
    }

    static synchronized void addToScore(int add){
        score += add;
    }
    public static int getScore(){
        return score;
    }
    static void resetScore(){
        score = 0;
    }
}
