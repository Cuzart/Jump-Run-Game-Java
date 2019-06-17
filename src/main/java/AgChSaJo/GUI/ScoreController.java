package AgChSaJo.GUI;

import AgChSaJo.JumpOrDie.*;
import AgChSaJo.ScoreList.ScoreList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ScoreController {

    @FXML
    public VBox container;

    // Set up the Scene
    private Parent scoreList;

    private TableView<Player> table = new TableView<>();


    void setUp() throws Exception{
        // Load Scene
        scoreList = FXMLLoader.load(getClass().getResource("/fxml/Score.fxml"));
        App.scoreList = new Scene(scoreList,800,500);


        // Nickname Column set up
        TableColumn<Player, String> nickname = new TableColumn<>("Nickname");
        nickname.setMinWidth(200);
        nickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        // Score Column set up
        TableColumn<Player, Integer> score = new TableColumn<>("Score");
        score.setMinWidth(200);
        score.setCellValueFactory(new PropertyValueFactory<>("finalScore"));

        table.getColumns().add(nickname);
        table.getColumns().add(score);


        // get Children
        container = (VBox) scoreList.lookup("#container");
        container.getChildren().addAll(table);



    }

    @FXML
    public void backToMenu(){
        App.window.setScene(App.menu);
    }

    public void updateScorelist(){
        table.setItems(getData());
    }

    // Creating Observable Array List
    private ObservableList<Player> getData(){
        ArrayList<Player> scoreTest = ScoreList.getScoreList();
        ObservableList<Player> data = FXCollections.observableArrayList(scoreTest);
        return data;
    }

}
