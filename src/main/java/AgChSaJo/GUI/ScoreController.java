package AgChSaJo.GUI;

import AgChSaJo.JumpOrDie.JumpOrDie;
import AgChSaJo.JumpOrDie.Player;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.*;

public class ScoreController implements Initializable {

    @FXML
    private TableView<Player> table;
    @FXML
    private TableColumn<Player, String> Nickname;
    @FXML
    private TableColumn<Player, Integer> Score;

    // Creating Observable Array List
    private ObservableList<Player> data = FXCollections.observableArrayList();

    // Set up the Scene
    private Parent scoreList;

    void setUp() throws Exception{
        scoreList = FXMLLoader.load(getClass().getResource("/fxml/Score.fxml"));
        App.scoreList = new Scene(scoreList,800,500);
    }


    // Adding data to the Observable List and setting Column Factories
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.add(new Player("Chris", 11));
        data.add(new Player("Agil", 12));
        Nickname.setCellValueFactory(new PropertyValueFactory<Player, String>("nickname"));
        Score.setCellValueFactory(new PropertyValueFactory<Player, Integer>("finaleScore"));
        table.setItems(data);
    }
}
