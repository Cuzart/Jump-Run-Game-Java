package AgChSaJo.JumpOrDie;

import java.util.TimerTask;

public class TestTimerTask extends TimerTask {

    @Override
    public void run() {
        Board.obstacle1.move();
        System.out.println(Board.obstacle1.x);
    }
}
