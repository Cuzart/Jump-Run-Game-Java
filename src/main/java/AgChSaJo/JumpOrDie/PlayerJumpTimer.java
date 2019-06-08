package AgChSaJo.JumpOrDie;

import java.util.TimerTask;

public class PlayerJumpTimer extends TimerTask {

    @Override
    public void run() {
        Board.jumpCounter++;
        if (Board.jumpCounter<=20){
            Board.activePlayer.jump(10);
        }else if(Board.jumpCounter == 45){
            Board.resetJumpingVariables();
            this.cancel();
        } else if (Board.jumpCounter >=25){
            Board.activePlayer.jump(-10);
        }
    }
}
