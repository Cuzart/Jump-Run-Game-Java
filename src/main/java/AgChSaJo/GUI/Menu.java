package AgChSaJo.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Menu extends Application {

    private static Logger log = LogManager.getLogger(Menu.class);


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
        Scene menu = new Scene(root);

        primaryStage.setTitle("JumpOrDie");
        primaryStage.setScene(menu);
        primaryStage.show();
        log.debug("Application started");
    }
}
