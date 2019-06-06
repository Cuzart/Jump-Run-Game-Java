package AgChSaJo.JumpOrDie;

import java.util.TimerTask;

public class PlayerJumpTimer extends TimerTask {

    @Override
    public void run() {
        Board.jumpCounter++;
        Board.activePlayer.jump(Board.maxHeight);
        if (Board.jumpCounter==80){
            Board.maxHeight = true;
        }else if (Board.jumpCounter == 160){
            Board.resetJumpingVariables();
            this.cancel();
        }
    }
}
