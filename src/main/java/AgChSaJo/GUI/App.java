package AgChSaJo.GUI;

import AgChSaJo.JumpOrDie.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App extends Application {

    private static Logger log = LogManager.getLogger(App.class);

    static Stage window;
    static Scene menu, jumpOrDie;
    private static MenuController menuController = new MenuController();
    static GameController gameController = new GameController();



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        menuController.setUp();
        gameController.setUp();

        window.setOnCloseRequest(e -> closeApp());
        window.setResizable(false);
        window.setTitle("JumpOrDie");
        window.setScene(menu);
        window.show();

        log.debug("App started");
    }


    private void closeApp (){
        JumpOrDie.close();
        GameController.stop();
        log.info("Close request");
        //safeScorelist
    }

}
