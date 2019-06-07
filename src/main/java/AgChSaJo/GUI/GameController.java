package AgChSaJo.GUI;

import AgChSaJo.IGame;
import AgChSaJo.JumpOrDie.*;
import AgChSaJo.JumpOrDie.Obstacles.Obstacle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.util.Timer;

public class GameController {


    IGame jumpOrDie = new JumpOrDie();

    private Parent gameLayout;
    private static Timer timer = new Timer();
    private static GameAnimationTimer animation;

    public Rectangle player;
    public Rectangle obstacle1;
    public Rectangle obstacle2;
    public VBox pauseControl;
    public VBox gameOverControl;
    public TextField nickname;
    public Label scoreView;


    @FXML
    public void backToMenu(){
        jumpOrDie.stopGame();
        showPauseControl(false);
        stopAnimation();
        App.window.setScene(App.menu);
    }
    @FXML
    public void resumeGame(){
        showPauseControl(false);
        jumpOrDie.resumeGame();
    }
    @FXML
    public void savePlayAgain(){
        //saveScore
        scoreView.setText(getNickname());
        showGameOverControl(false);
        jumpOrDie.playAgain();
        startAnimation();
    }
    @FXML
    public void saveBackToMenu(){
        scoreView.setText(getNickname());
        showGameOverControl(false);
        App.window.setScene(App.menu);
    }

    void setUp() throws Exception{
        gameLayout = FXMLLoader.load(getClass().getResource("/fxml/Game.fxml"));
        App.jumpOrDie = new Scene(gameLayout,800,500);
        obstacle1 = (Rectangle) gameLayout.lookup("#obstacle1");
        obstacle2 = (Rectangle) gameLayout.lookup("#obstacle2");
        player = (Rectangle) gameLayout.lookup("#player");
        pauseControl = (VBox)gameLayout.lookup("#pauseControl");
        gameOverControl = (VBox)gameLayout.lookup("#gameOverControl");
        scoreView = (Label) gameLayout.lookup("#scoreView");
        App.jumpOrDie.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.SPACE)){
                Board.playerJump();
                return;
            }
            if (keyCode.equals(KeyCode.ESCAPE) && gameOverControl.isDisabled()){
                jumpOrDie.stopGame();
                showPauseControl(true);
            }
        });
    }

    void startAnimation(){
        resetGUI();
        animation = new GameAnimationTimer();
        timer.scheduleAtFixedRate(animation,10,10);
    }
    void stopAnimation(){
        animation.cancel();
    }

    void animatePlayer(){
        player.setTranslateY(-Board.activePlayer.getY());
    }
    void animateObstacles(){
        Obstacle[] obstacles = ObstacleManager.getObstacles();

        if (obstacles[0].getX()==800){
            resizeObstacle(obstacles[0],1);
        }
        obstacle1.setTranslateX(obstacles[0].getX()-800);

        if (obstacles[1]!=null) {
            if (obstacles[1].getX()==800){
                resizeObstacle(obstacles[1],2);
            }
            obstacle2.setTranslateX(obstacles[1].getX()-800);
        }

    }
    void updateScoreView(){
        //scoreView.setText(Double.toString(Board.getScore()));
    }
    private void resizeObstacle(Obstacle o, int i){
        Rectangle rec;
        if (i == 2){
            rec=obstacle2;
        }else{
            rec=obstacle1;
        }

        if (o.getHeight()== 100){
            rec.setTranslateY(-50);
        }else{
            rec.setTranslateY(0);
        }
        rec.setHeight(o.getHeight());
        rec.setWidth(o.getWidth());
    }
    private void resetGUI(){
        obstacle1.setTranslateX(0);
        obstacle2.setTranslateX(0);
        player.setTranslateY(0);
    }

    private void showPauseControl(boolean b){
        pauseControl.setVisible(b);
        pauseControl.setDisable(!b);
    }
    private void showGameOverControl(boolean b){
        gameOverControl.setVisible(b);
        gameOverControl.setDisable(!b);
    }
    public void gameOver(){
        showGameOverControl(true);
        stopAnimation();
    }

    private String getNickname(){
        String name = nickname.getText();
        if (name.equals("")){
            return "Unknown";
        }else{
            return name;
        }
    }

}
