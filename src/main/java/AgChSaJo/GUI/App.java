package AgChSaJo.GUI;

import AgChSaJo.JumpOrDie.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App extends Application {

    private static Logger log = LogManager.getLogger(App.class);

    static Stage window;
    static Scene menu, jumpOrDie;
    private static Rectangle obstacle1, obstacle2, player;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        //menu
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
        menu = new Scene(root,800,500);
        //Game
        Parent gameLayout = FXMLLoader.load(getClass().getResource("/fxml/Game.fxml"));
        jumpOrDie = new Scene(gameLayout,800,500);
        obstacle1 = (Rectangle) gameLayout.lookup("#obstacle1");
        obstacle2 = (Rectangle) gameLayout.lookup("#obstacle2");
        player = (Rectangle) gameLayout.lookup("#player");
        jumpOrDie.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.SPACE)){
                if (!Board.getJumping()) {
                    JumpOrDie.jumpTimer.scheduleAtFixedRate(new PlayerJumpTimer(), 10, 10);
                    Board.setJumping(true);
                }
                return;
            }
            if (keyCode.equals(KeyCode.ESCAPE)){
                JumpOrDie.stop();
                App.window.setScene(App.menu);
            }
        });

        window.setOnCloseRequest(e -> closeApp());
        window.setResizable(false);
        window.setTitle("JumpOrDie");
        window.setScene(menu);
        window.show();
        log.debug("App started");
    }
    void closeApp (){
        JumpOrDie.close();
        log.info("Close request");
        //safeScorelist
    }

    public static void moveGUIObstacle(int obstacle, double speed){
        Node node;
        if (obstacle == 2){
            node = obstacle2;
        }else {
            node = obstacle1;
        }
        node.setTranslateX(node.getTranslateX()-speed);
    }
    public static void setupGUIObstacle(int obNumber, Obstacle o){
        Rectangle rectangle;
        if (obNumber == 2){
            rectangle = obstacle2;
        }else{
            rectangle = obstacle1;
        }

        if(o.getHeight()==100){ // if obstacle is Fence
            rectangle.setTranslateY(-50);
        }else{      //obstacle is Hedge
            rectangle.setTranslateY(0);
        }
        rectangle.setTranslateX(0);
        rectangle.setHeight(o.getHeight());
        rectangle.setWidth(o.getWidth());
    }
    public static void moveGUIPlayer(Player p){
        player.setTranslateY(-p.getY());
    }



}
