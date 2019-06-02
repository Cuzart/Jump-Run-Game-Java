package AgChSaJo.GUI;

import AgChSaJo.JumpOrDie.JumpOrDie;
import javafx.fxml.FXML;

public class GameController {

    @FXML
   public void backToMenu(){
        JumpOrDie.stop();
        App.window.setScene(App.menu);
    }
}
