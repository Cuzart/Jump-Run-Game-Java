package AgChSaJo.GUI;

import AgChSaJo.ScoreList.ScoreList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;


public class MenuController {


    private Parent root;
    @FXML
    public VBox menu;
    @FXML
    public VBox instructions;
    @FXML
    public CheckBox hitbox;

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
    public void instructions (ActionEvent event){
        showInstructions(true);
    }
    @FXML
    public void instructionsBack (ActionEvent event){
        showInstructions(false);
    }
    @FXML
    public void checkHitboxStatus(){
        App.gameController.setShowHitbox(hitbox.isSelected());
    }
    @FXML
    public void exitGame (ActionEvent event){
        App.closeApp();
    }


    void setUp() throws Exception{
        root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
        hitbox = (CheckBox) root.lookup("#hitbox");
        App.menu = new Scene(root,800,500);
    }

    private void showInstructions (boolean b){
        instructions.setVisible(b);
        instructions.setDisable(!b);
        menu.setVisible(!b);
        menu.setDisable(b);
    }

}
