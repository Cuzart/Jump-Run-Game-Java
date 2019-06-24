package AgChSaJo.ScoreList;

import AgChSaJo.JumpOrDie.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ScoreListTest {

    private ArrayList<Player> testDaten = new ArrayList<>();
    private ArrayList<Player> originalScoreList;

    @Before
    public void setUpTest(){
        ScoreList.readScoreList();
        originalScoreList = ScoreList.getScoreList();
        ScoreList.createNewScoreList();
    }


    @Test
    public void addNewScoreTestValid() {
        Player player1 = new Player("nickname",214);
        Player player2 = new Player("nick2",119);
        testDaten.add(player1);
        ScoreList.addNewScore(player1);
        assertEquals(testDaten,ScoreList.getScoreList());
        testDaten.add(player2);
        ScoreList.addNewScore(player2);
        assertEquals(testDaten,ScoreList.getScoreList());
    }
    @Test (expected = IllegalScoreException.class)
    public void addNewScoreTestInvalid1(){
        ScoreList.addNewScore(new Player("Nickname",-1));
    }
    @Test (expected = IllegalScoreException.class)
    public void addNewScoreTestInvalid2(){
        ScoreList.addNewScore(new Player("",123));
    }


    /**
     * Zu den Testdaten wird zuerst der Player2 hinzugefügt und dann Player1
     * getScoreList sortiert die Spieler schon automatisch in der richtigen Reihenfolge des Scores.
     * Wenn der Test akztepiert wurde hat die Methode die Spieler erfolgreich sortiert!!
     */
    @Test
    public void getScoreListTest1() {
        Player player1 = new Player("nick1",214);
        Player player2 = new Player("nick2",519);
        ScoreList.addNewScore(player1);
        ScoreList.addNewScore(player2);
        testDaten.add(player2);
        testDaten.add(player1);

        assertEquals(testDaten,ScoreList.getScoreList());
    }
    /**
     * In diesem Test wird noch zusätzlich gefiltert nach einem nickname
     */
    @Test
    public void getScoreListTest2() {
        Player player1 = new Player("nick1",214);
        Player player2 = new Player("nick1",325);
        Player player3 = new Player("nick2",593);
        Player player4 = new Player("nick3",519);
        testDaten.add(player2);
        testDaten.add(player1);
        ScoreList.addNewScore(player1);
        ScoreList.addNewScore(player2);
        ScoreList.addNewScore(player3);
        ScoreList.addNewScore(player4);

        assertEquals(testDaten,ScoreList.getScoreList("nick1"));
    }

    @Test
    public void getScoreListTest3() {
        Player player1 = new Player("nick1",214);
        Player player2 = new Player("nick2",519);
        ScoreList.addNewScore(player1);
        ScoreList.addNewScore(player2);
        testDaten.add(player1);
        testDaten.add(player2);

        assertNotEquals(testDaten,ScoreList.getScoreList());
    }

    @Test
    public void saveANDreadScoreListTest() {
        Player player1 = new Player("nick1",614);
        Player player2 = new Player("nick2",519);
        testDaten.add(player1);
        testDaten.add(player2);
        ScoreList.addNewScore(player1);
        ScoreList.addNewScore(player2);
        ScoreList.saveScoreList();      //Player werden gespeichert in ScoreList.json
        ScoreList.readScoreList();      //Beim lesen werden neue Player erstellt (Objektreferenz not equals)
        Player newPlayer1 = ScoreList.getScoreList().get(0);
        Player newPlayer2 = ScoreList.getScoreList().get(1);

        assertEquals(player1.getNickname(),newPlayer1.getNickname());
        assertEquals(player1.getFinalScore(),newPlayer1.getFinalScore());
        assertEquals(player2.getNickname(),newPlayer2.getNickname());
        assertEquals(player2.getFinalScore(),newPlayer2.getFinalScore());
        assertNotEquals(testDaten,ScoreList.getScoreList());
        assertNotEquals(player1.getNickname(),newPlayer2.getNickname());

        saveOriginalScoreList();
    }

    private void saveOriginalScoreList(){
        ScoreList.createNewScoreList();
        for (Player player: originalScoreList) {
            ScoreList.addNewScore(player);
        }
        ScoreList.saveScoreList();
    }






}