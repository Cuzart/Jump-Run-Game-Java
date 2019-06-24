package AgChSaJo.GUI;

import AgChSaJo.ScoreList.ScoreList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;


public class MenuController {

    @FXML
    public VBox menu;
    @FXML
    public VBox instructions;
    @FXML
    public CheckBox hitbox;

    // event handling
    @FXML // starts the game animation
    public void startGame (){
        App.window.setScene(App.jumpOrDie);
        App.gameController.jumpOrDie.playAgain();
        App.gameController.startAnimation();
    }
    @FXML // opens updated score list
    public void showScorelist(){
        App.scoreController.resetScoreListView();
        App.window.setScene((App.scoreList));
        ScoreList.getScoreList("Jonas");
    }
    @FXML // opens instructions menu
    public void instructions (){
        showInstructions(true);
    }
    @FXML // go back to menu
    public void instructionsBack () { showInstructions(false); }
    @FXML // checks whether hit boxes are activated or not
    public void checkHitboxStatus(){
        App.gameController.setShowHitbox(hitbox.isSelected());
    }
    @FXML // exits the game
    public void exitGame (){
        App.closeApp();
    }

    // set up scene and FXML
    void setUp() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
        App.menu = new Scene(root,800,500);
    }

    // changes visibility of VBox for menu and instructions
    private void showInstructions (boolean b){
        instructions.setVisible(b);
        instructions.setDisable(!b);
        menu.setVisible(!b);
        menu.setDisable(b);
    }
}
