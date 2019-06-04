package AgChSaJo.GUI;

import AgChSaJo.JumpOrDie.JumpOrDie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class MenuController {

    private Parent root;

    @FXML
    public void startGame (ActionEvent event){
        App.window.setScene(App.jumpOrDie);
        JumpOrDie.play();
        GameController.start();
    }
    @FXML
    public void showScorelist(ActionEvent event){

    }
    @FXML
    public void exitGame (ActionEvent event){
        System.exit(0);
    }

    void setUp() throws Exception{
        root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
        App.menu = new Scene(root,800,500);
    }

}
