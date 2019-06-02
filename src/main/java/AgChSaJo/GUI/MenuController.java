package AgChSaJo.GUI;

import AgChSaJo.ScoreList.Scorelist;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import AgChSaJo.JumpOrDie.JumpOrDie;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuController {


    @FXML
    public void startGame (ActionEvent event) throws IOException {
        //Menu.getApplication().setScene("/fxml/Menu.fxml", "Menu");
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
