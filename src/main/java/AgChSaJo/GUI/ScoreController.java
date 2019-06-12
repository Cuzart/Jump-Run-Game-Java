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
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.*;

public class ScoreController implements Initializable {

    private Parent scoreList;

    void setUp() throws Exception{
        scoreList = FXMLLoader.load(getClass().getResource("/fxml/Score.fxml"));
        App.scoreList = new Scene(scoreList,800,500);
    }

    @FXML private TableView<Player> table;
    //@FXML private TableColumn<Integer> Ranking;
    @FXML public TableColumn<Player, String> nameColumn = new TableColumn<>("Nickname");
    @FXML private TableColumn<Player, Double> scoreColumn = new TableColumn<>("Score");



    private ObservableList<Player> getScoreList(){
        ObservableList<Player> data = FXCollections.observableArrayList();
        data.addAll();
        return data;
    }
    @Override
    public void initialize(URL url, ResourceBundle fxml) {
        /*TableColumn rank = new TableColumn("Ranking");
        TableColumn nick = new TableColumn("Nickname");
        TableColumn score= new TableColumn("Score");
        table.getColumns().addAll(rank,nick,score);
        //table.setItems();*/
    }
/*
    // create ArrayList 1-10 for Ranking table
    ArrayList<Integer> rankList = new ArrayList<Integer>(10);{
        for (int i = 1;i <= 10; i++) {
            rankList.add(i);
        }
    }
    //
     ObservableList rankList = FXCollections.observableArrayList();

    public void setScoreTable(TableView<List<StringProperty>> scoreTable) {
        this.scoreTable = scoreTable;
        scoreTable.setItems(ranking);
    }

    // here to Agils Arraylist


    public Parent getScoreList() {
        return scoreList;
    }

    public TableView<List<StringProperty>> getScoreTable() {
        return scoreTable;
    }

    ObservableList<Player> scoreList = FXCollections.observableArrayList(
            new Player("Chris",20)
    );
*/
}