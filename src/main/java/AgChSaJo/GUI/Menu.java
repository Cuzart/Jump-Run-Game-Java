package AgChSaJo.GUI;

import javafx.application.Application;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;


public class Menu extends Application {

    private static Logger log = LogManager.getLogger(Menu.class);

    public static void main(String[] args)
    {
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


    void setScene(String fxml, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(root, 500, 800);
        log.debug("FXML-Datei von " + fxml + " geladen");
        stage.setScene(scene);
        stage.setTitle(title);
    }


    private static Stage stage = null;
    private static Menu application;
    static Menu getApplication() { return application;
    }



}
