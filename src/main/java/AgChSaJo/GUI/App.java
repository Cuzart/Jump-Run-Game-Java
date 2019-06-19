package AgChSaJo.GUI;

import AgChSaJo.ScoreList.ScoreList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App extends Application {

    private static Logger log = LogManager.getLogger(App.class);

    static Stage window;
    static Scene menu, jumpOrDie, scoreList;
    private static MenuController menuController = new MenuController();
    public static GameController gameController = new GameController();
    static ScoreController scoreController = new ScoreController();



    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        menuController.setUp();
        gameController.setUp();
        ScoreList.readScoreList();
        scoreController.setUp();

        window.setOnCloseRequest(e -> closeApp());
        window.setResizable(false);
        window.setTitle("JumpOrDie");

        window.setScene(menu);
        window.show();

        log.debug("App started");
    }


    static void closeApp (){
        gameController.jumpOrDie.closeGame();
        gameController.stopAnimation();
        log.info("Close request - saveScoreList");
        ScoreList.saveScoreList();
        System.exit(0);
    }

}
