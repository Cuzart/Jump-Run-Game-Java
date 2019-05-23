package AgChSaJo.JumpOrDie;

import java.util.TimerTask;

public class PlayerJumpTimer extends TimerTask {

    private int count = 0;
    private boolean maxheight = false;

    @Override
    public void run() {
        count++;
        Board.activePlayer.jump(maxheight);
        if (count==15){
            maxheight = true;
        }else if (count == 30){
            this.cancel();
        }
    }
}
