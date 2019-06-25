package AgChSaJo.JumpOrDie;

import java.util.TimerTask;


public class PlayerJumpTimer extends TimerTask {

    private Board board = JumpOrDie.board;

    @Override
    public void run() {                                     //player increases is y-Coordinate linear
        board.jumpCounter++;                                //then he stops on top a short time
        if (board.jumpCounter<=20){                         //after that the y-Coordinate decreases linear
            board.activePlayer.jump(10);              //through that it looks nearly like a jumping curve
        }else if(board.jumpCounter == 45){
            board.resetJumpingVariables();
            this.cancel();
        } else if (board.jumpCounter >=25){
            board.activePlayer.jump(-10);
        }
    }
}
