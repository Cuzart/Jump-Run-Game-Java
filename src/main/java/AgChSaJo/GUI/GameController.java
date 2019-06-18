package AgChSaJo.GUI;

import AgChSaJo.IGame;
import AgChSaJo.JumpOrDie.*;
import AgChSaJo.JumpOrDie.Obstacles.Obstacle;
import AgChSaJo.ScoreList.ScoreList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;



public class GameController {


    IGame jumpOrDie = new JumpOrDie();
    private GameAnimationTimer animationTimer = new GameAnimationTimer();
    private Parent gameLayout;

    public VBox pauseControl;
    public VBox gameOverControl;
    public TextField nickname;
    public Label scoreView;
    public Canvas canvas;

    private GraphicsContext gc;
    private Image background = new Image(getClass().getResourceAsStream("/images/CanvasBackground.png"));

    private Image player = new Image(getClass().getResourceAsStream("/images/kangaroo.png"));
    private Image cactusRow = new Image(getClass().getResourceAsStream("/images/Obstacles/cactusRow.png"));
    private Image mosquito = new Image(getClass().getResourceAsStream("/images/Obstacles/mosquito.png"));
    private Image rock = new Image(getClass().getResourceAsStream("/images/Obstacles/rock.png"));
    private Image seagull = new Image(getClass().getResourceAsStream("/images/Obstacles/seagull.png"));
    private Image shrub = new Image(getClass().getResourceAsStream("/images/Obstacles/shrub.png"));
    private Image tree = new Image(getClass().getResourceAsStream("/images/Obstacles/tree.png"));
    private Image gras = new Image(getClass().getResourceAsStream("/images/Obstacles/grass.png"));
    private double distanceFromBottom = 25;


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
        Board.activePlayer.setNickname(getNickname());
        ScoreList.addNewScore(Board.activePlayer);
        showGameOverControl(false);
        jumpOrDie.playAgain();
        startAnimation();
    }
    @FXML
    public void saveBackToMenu(){
        Board.activePlayer.setNickname(getNickname());
        ScoreList.addNewScore(Board.activePlayer);
        showGameOverControl(false);
        App.window.setScene(App.menu);
    }

    void setUp() throws Exception{
        gameLayout = FXMLLoader.load(getClass().getResource("/fxml/Game.fxml"));
        App.jumpOrDie = new Scene(gameLayout,800,500);
        pauseControl = (VBox)gameLayout.lookup("#pauseControl");
        gameOverControl = (VBox)gameLayout.lookup("#gameOverControl");
        scoreView = (Label) gameLayout.lookup("#scoreView");
        nickname = (TextField) gameLayout.lookup("#nickname");
        canvas = (Canvas) gameLayout.lookup("#canvas");
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(background,0,0);
        setUpKeyListener();
    }
    private void setUpKeyListener(){
        App.jumpOrDie.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.SPACE)||keyCode.equals(KeyCode.UP)){
                Board.playerJump();
                return;
            }
            if (keyCode.equals((KeyCode.DOWN))){
                Board.playerDuck();
                return;
            }
            if (keyCode.equals(KeyCode.ESCAPE) && gameOverControl.isDisabled()){
                jumpOrDie.stopGame();
                showPauseControl(true);
            }

        });
        App.jumpOrDie.setOnKeyReleased(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals((KeyCode.DOWN))){
                Board.setDucking(false);
            }
        });
    }

    void animateGame (){

        gc.drawImage(background,0,0);
        animatePlayer();
        animateObstacles();
    }
    private void animatePlayer(){

        double x = Board.activePlayer.getX();
        double y = canvas.getHeight()-Board.activePlayer.getHeight()-Board.activePlayer.getY()-distanceFromBottom;
        gc.drawImage(player, x-39,y);

        //show hitBox
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(3);
        double width = Board.activePlayer.getWidth();
        double height = Board.activePlayer.getHeight();
        gc.strokeRect(x,y,width,height);
    }
    private void animateObstacles(){
        Obstacle ob1 = ObstacleManager.obstacle1;
        Obstacle ob2 = ObstacleManager.obstacle2;

        double x1 = ob1.getX();
        double y1 = canvas.getHeight()-ob1.getHeight()-ob1.getY()-distanceFromBottom;
        gc.drawImage(findObstacleImage(ob1),x1,y1);

        //show hitBox
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(3);
        gc.strokeRect(x1,y1, ob1.getWidth(), ob1.getHeight());

        if (ob2 !=null){
            double x2 = ob2.getX();
            double y2 = canvas.getHeight()-ob2.getHeight()-ob2.getY()-distanceFromBottom;
            gc.drawImage(findObstacleImage(ob2),x2,y2);

            //show hitBox
            gc.strokeRect(x2,y2, ob2.getWidth(), ob2.getHeight());

        }



    }
    private Image findObstacleImage(Obstacle obstacle){
        switch (obstacle.toString()){
            case "CactusRow": return cactusRow;
            case "Mosquito": return mosquito;
            case "Rock": return rock;
            case "Seagull": return seagull;
            case "Shrub": return shrub;
            case "Tree": return tree;
            case "Grass": return gras;
            default: return tree;
        }
    }
    void updateScoreView(){
        scoreView.setText(""+Board.getScore());
    }
    void startAnimation(){
        animationTimer.start();
    }
    void stopAnimation(){
        animationTimer.stop();
    }

    private void showPauseControl(boolean b){
        pauseControl.setVisible(b);
        pauseControl.setDisable(!b);
    }
    private void showGameOverControl(boolean b){
        gameOverControl.setVisible(b);
        gameOverControl.setDisable(!b);
        nickname.clear();
    }
    public void gameOver(){
        showGameOverControl(true);
        stopAnimation();
    }

    private String getNickname(){
        String name = nickname.getText();
        if (name.equals("")||name.equals(" ")){
            return "Unknown";
        }else{
            return name;
        }
    }

}
