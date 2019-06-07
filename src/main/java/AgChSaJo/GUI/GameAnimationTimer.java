package AgChSaJo.GUI;

import java.util.TimerTask;

public class GameAnimationTimer extends TimerTask {

    @Override
    public void run() {
        App.gameController.animatePlayer();
        App.gameController.animateObstacles();
        App.gameController.updateScoreView();
    }
}
