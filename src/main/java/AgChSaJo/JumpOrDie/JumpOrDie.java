package AgChSaJo.JumpOrDie;

public class JumpOrDie {


    public static void playAgain(){
        ObstacleManager.setUp();
        Board.activePlayer = new Player();
        Board.startObstacleTimerTask(1000);
        Board.resetJumpingVariables();
    }
    public static void resumeGame(){
        Board.startObstacleTimerTask(5000);
        Board.startJumpTimerTask(5000);
    }
    public static void stop(){
        Board.stopTimerTasks();
    }
    public static void closeGame(){
        Board.closeTimers();
    }
}
