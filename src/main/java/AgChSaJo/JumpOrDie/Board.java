package AgChSaJo.JumpOrDie;

import AgChSaJo.GUI.App;
import AgChSaJo.JumpOrDie.Obstacles.Obstacle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Timer;

/**
 * The class Board holds the game logic as it is the framework of the game.
 */
public class Board {

    private static Logger log = LogManager.getLogger(Board.class);

    private static Timer timer = new Timer();
    private static Timer jumpTimer = new Timer();
    private static ObstacleTimer obstacleTimerTask;
    private static PlayerJumpTimer jumpTimerTask;
    private static ScoreTimer scoreTimerTask;
    private static int period = 20;

    public static Player activePlayer;
    private static boolean jumping, ducking;
    static int jumpCounter = 0;
    private static int score;

    /**
     * This method checks whether the player collided with an Obstacle by
     * checking their exact positions and finding out if they overlap.
     * If that is the case the game stops.
     *    y2|    |
     *      |    |
     *    y1|    |
     *      x1   x2
     *
     * @param obstacle which is near player
     * @return true or false
     */
    static boolean checkCollision(Obstacle obstacle){
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
                activePlayer.setFinalScore(score);
                App.gameController.gameOver();
                return true;
            }
        }
        return false;
    }

    /**
     * Saves in a variable whether a player is jumping or not.-
     *
     * @param v a variable true or false in case a player jumps or not
     */
    private static void setJumping(boolean v){
        jumping = v;
        log.debug("Set jumping to: "+ v);
    }

    /**
     * Only if a player is not currently jumping he is able to jump.
     */
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
        if(ducking != b){
            ducking = b;
            log.debug("Set ducking to: "+ b);
            if (!ducking){
                activePlayer.duck(false);
            }
        }
    }
    public static void playerDuck(){
        if (!ducking){
            activePlayer.duck(true);
            Board.setDucking(true);
        }

    }

    static void startTimerTasks(long delay){
        obstacleTimerTask = new ObstacleTimer();
        timer.schedule(obstacleTimerTask,delay,period);
        scoreTimerTask = new ScoreTimer();
        timer.schedule(scoreTimerTask, delay, 1000);

    }
    static void startJumpTimerTask(long delay){
        jumpTimerTask = new PlayerJumpTimer();
        jumpTimer.scheduleAtFixedRate(jumpTimerTask, delay, period);
    }
    static void stopTimerTasks(){
        obstacleTimerTask.cancel();
        scoreTimerTask.cancel();
        if(jumpTimerTask != null) {
            jumpTimerTask.cancel();
        }
    }
    static void closeTimers(){
        timer.cancel();
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

    //zum Testen
    static boolean getDucking(){
        return ducking;
    }
    static boolean getJumping(){
        return jumping;
    }
}
