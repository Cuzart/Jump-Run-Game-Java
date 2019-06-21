package AgChSaJo.GUI;

import AgChSaJo.IGame;
import AgChSaJo.JumpOrDie.*;
import AgChSaJo.JumpOrDie.Obstacles.Obstacle;
import AgChSaJo.ScoreList.IllegalScoreException;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GameController {

    private static Logger log = LogManager.getLogger(GameController.class);

    IGame jumpOrDie = new JumpOrDie();
    private GameAnimationTimer animationTimer = new GameAnimationTimer();

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
    private boolean showHitbox = false;

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
        try{
        ScoreList.addNewScore(Board.activePlayer);
        }catch(IllegalScoreException e){
            log.info("Score not saved");
        }
        showGameOverControl(false);
        jumpOrDie.playAgain();
        startAnimation();
    }
    @FXML
    public void saveBackToMenu(){
        Board.activePlayer.setNickname(getNickname());
        try{
        ScoreList.addNewScore(Board.activePlayer);
        }catch(IllegalScoreException e){
            log.info("Score not saved");
        }
        showGameOverControl(false);
        App.window.setScene(App.menu);
    }

    void setUp() throws Exception{
        Parent gameLayout;
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

    /**
     * In case the user presses 'Space' or 'Up' the player has to jump
     * In case the user presses 'Down' the player should duck and if the key gets released
     * the player needs to get his normal size again
     *
     * If 'Esc' gets pressed the gameplay gets paused
     *
     */
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
            if (keyCode.equals(KeyCode.ESCAPE) && gameOverControl.isDisabled()){ //pause mode should only pop up if the game is still running and is not gameOver
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
        gc.drawImage(background,0,0);       //'resets' canvas so that player and obstacles
        animatePlayer();                          //can be drawn to their new position
        animateObstacles();
    }
    private void animatePlayer(){
        double x = Board.activePlayer.getX();
        double y = canvas.getHeight()-Board.activePlayer.getHeight()-Board.activePlayer.getY()-distanceFromBottom;
        gc.drawImage(player, x-39,y);

        if(showHitbox) {
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(2.5);
            double width = Board.activePlayer.getWidth();
            double height = Board.activePlayer.getHeight();
            gc.strokeRect(x, y, width, height);
        }
    }
    private void animateObstacles(){
        Obstacle ob1 = ObstacleManager.obstacle1;
        Obstacle ob2 = ObstacleManager.obstacle2;

        //draw Obstacle 1
        double x1 = ob1.getX();
        double y1 = canvas.getHeight()-ob1.getHeight()-ob1.getY()-distanceFromBottom;
        gc.drawImage(findObstacleImage(ob1),x1,y1);
        if (showHitbox) {
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(2.5);
            gc.strokeRect(x1, y1, ob1.getWidth(), ob1.getHeight());
        }
        //draw Obstacle 2
        //Obstacle 2 is null at the beginning an gets generated after a while
        if (ob2 !=null){
            double x2 = ob2.getX();
            double y2 = canvas.getHeight()-ob2.getHeight()-ob2.getY()-distanceFromBottom;
            gc.drawImage(findObstacleImage(ob2),x2,y2);
            if (showHitbox) {
                gc.strokeRect(x2, y2, ob2.getWidth(), ob2.getHeight());
            }
        }
    }

    /**
     * method to find out which obstacle is on the screen
     * and which image should be drawn to the canvas
     *
     * @param obstacle which is on the screen
     * @return  Image that belongs to obstacle
     */
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
        if (name.equals(" ")||name.equals("  ")){
            return "";
        }else{
            return name;
        }
    }
    void setShowHitbox(boolean b){
        showHitbox = b;
        log.debug("showHitbox set: "+ b);
    }
}
