package AgChSaJo.JumpOrDie;

import java.util.TimerTask;

/**
 * This class is a TimerTask for a Score Timer.
 */
public class ScoreTimer extends TimerTask {

    /**
     * This method adds one point to the score while the ScoreTimer is running.
     * It gets called every second
     */
    @Override
    public void run() {
        JumpOrDie.board.addToScore(1);
    }
}
