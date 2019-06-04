package AgChSaJo.JumpOrDie;

import java.util.TimerTask;

public class PlayerJumpTimer extends TimerTask {

    private int count = 0;
    private boolean maxHeight = false;


    @Override
    public void run() {
        count++;
        Board.activePlayer.jump(maxHeight);
        if (count==80){
            maxHeight = true;
        }else if (count == 160){
            Board.setJumping(false);
            this.cancel();
        }
    }
}
