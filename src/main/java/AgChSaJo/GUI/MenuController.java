package AgChSaJo.GUI;

import AgChSaJo.ScoreList.Scorelist;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void startGame (ActionEvent event){

    }

    @FXML
    public void showScorelist(ActionEvent event){

    }

    @FXML
    public void exitGame (ActionEvent event){
        System.exit(0);
    }

}
