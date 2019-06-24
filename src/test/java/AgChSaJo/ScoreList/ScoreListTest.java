package AgChSaJo.ScoreList;

import AgChSaJo.JumpOrDie.Player;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ScoreListTest {

    @Test
    public void readScoreList() {
    }

    @Test
    public void saveScoreList() {
    }

    @Test
    public void addNewScore() {
        Player player1 = new Player("nickname",214);
        ArrayList<Player> testDaten = new ArrayList<>();
        testDaten.add(player1);
        ScoreList.createNewScoreList();
        ScoreList.addNewScore(player1);
        assertEquals(testDaten,ScoreList.getScoreList());

    }



}