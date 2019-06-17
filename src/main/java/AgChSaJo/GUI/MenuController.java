package AgChSaJo.GUI;

import AgChSaJo.ScoreList.ScoreList;
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
        App.gameController.jumpOrDie.playAgain();
        App.gameController.startAnimation();
    }
    @FXML
    public void showScorelist(ActionEvent event){
        App.scoreController.updateScorelist();
        App.window.setScene((App.scoreList));
    }
    @FXML
    public void exitGame (ActionEvent event){
        App.closeApp();
    }

    void setUp() throws Exception{
        root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
        App.menu = new Scene(root,800,500);
    }

}
