package AgChSaJo.JumpOrDie;

import AgChSaJo.GUI.App;
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
    private static boolean jumping, ducking;
    static int jumpCounter = 0;
    private static int score;

    /**
     *    y2|    |
     *      |    |
     *    y1|    |
     *      x1   x2
     *
     * @param obstacle which is near player
     */
    static void checkCollision(Obstacle obstacle){
        double playerX1 = activePlayer.getX();
        double playerX2 = playerX1 + activePlayer.getWidth();
        double obstacleX1 = obstacle.getX();
        double obstacleX2 = obstacleX1 + obstacle.getWidth();

        //Collision zone
        if (obstacleX1 <= playerX2 && obstacleX2 >= playerX1){
            double playerY1 = activePlayer.getY();
            double playerY2 = playerY1 + activePlayer.getHeight();
            double obstacleY1 = obstacle.getY();
            double obstacleY2 = obstacleY1 + obstacle.getHeight();

            if (playerY1<= obstacleY2 && playerY2 >= obstacleY1){
                log.info("GameOver - Collision detected");
                stopTimerTasks();
                App.gameController.gameOver();
            }
        }
    }
    private static void setJumping(boolean v){
        jumping = v;
        log.debug("Set jumping to: "+ v);
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

    public static void setDucking(boolean b){
        ducking = b;
        log.debug("Set ducking to: "+ b);
        if(!b){
            activePlayer.duck(false);
        }
    }
    public static void playerDuck(){
        if (!ducking){
            activePlayer.duck(true);
            Board.setDucking(true);
        }

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
