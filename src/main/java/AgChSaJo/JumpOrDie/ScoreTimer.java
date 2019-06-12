package AgChSaJo.JumpOrDie;

import java.util.TimerTask;

public class ScoreTimer extends TimerTask {

    @Override
    public void run() {
        Board.addToScore(1);
    }
}
