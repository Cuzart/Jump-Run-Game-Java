package AgChSaJo.GUI;

import javafx.animation.AnimationTimer;


public class GameAnimationTimer extends AnimationTimer {

    @Override
    public void handle(long l) {
        App.gameController.animateGame();
        App.gameController.updateScoreView();
    }
}
