package AgChSaJo.JumpOrDie;

import java.util.TimerTask;


public class PlayerJumpTimer extends TimerTask {

    @Override
    public void run() {                                     //player increases is y-Coordinate linear
        Board.jumpCounter++;                                //then he stops on top a short time
        if (Board.jumpCounter<=20){                         //after that the y-Coordinate decreases linear
            Board.activePlayer.jump(10);              //through that it looks nearly like a jumping curve
        }else if(Board.jumpCounter == 45){
            Board.resetJumpingVariables();
            this.cancel();
        } else if (Board.jumpCounter >=25){
            Board.activePlayer.jump(-10);
        }
    }
}
