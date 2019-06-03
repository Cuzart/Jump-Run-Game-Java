package AgChSaJo.GUI;

import AgChSaJo.JumpOrDie.JumpOrDie;
import AgChSaJo.ScoreList.Scorelist;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class MenuController {

    @FXML
    public void startGame (ActionEvent event){
        App.window.setScene(App.jumpOrDie);
        JumpOrDie.play();
    }

    @FXML
    public void showScorelist(ActionEvent event){

    }

    @FXML
    public void exitGame (ActionEvent event){
        System.exit(0);
    }

}
