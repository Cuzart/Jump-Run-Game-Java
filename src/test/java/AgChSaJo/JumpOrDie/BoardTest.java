package AgChSaJo.JumpOrDie;

import AgChSaJo.JumpOrDie.Obstacles.Rock;
import AgChSaJo.JumpOrDie.Obstacles.Obstacle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Before
    public void setUpTest() {
        Board.activePlayer = new Player();
    }


    @Test
    public void setJumpingTest() {
        Board.setDucking(true);
        assertTrue(Board.getDucking());

        Board.setDucking(false);
        assertFalse(Board.getDucking());
    }

    /**
     * Diese Methode wartet eine bestimmte Zeit und kontrolliert dann den Springstatus des Spielers
     * Je nach Wartezeit ist der Spieler noch am springen oder wieder auf dem Boden
     */
    @Test
    public void playerJumpTest() {
        Board.playerJump();
        assertTrue(Board.getJumping());
        long start = System.currentTimeMillis();
        long time;
        //after 500ms the player is still jumping
        do {
            time = System.currentTimeMillis();
        } while (start + 500 >= time);
        assertTrue(Board.getJumping());
        //after 900ms the player is back on the ground
        do {
            time = System.currentTimeMillis();
        } while (start + 900 >= time);
        assertFalse(Board.getJumping());

    }

    @Test
    public void addToScoreTest() {
        Board.addToScore(10);
        assertEquals(Board.getScore(), 10);
        Board.addToScore(20);
        assertEquals(Board.getScore(), 30);
        Board.addToScore(20);
        assertEquals(Board.getScore(), 50);

        assertNotEquals(Board.getScore(), 60);
    }
    @Test
    public void resetScoreTest(){
        addToScoreTest();
        assertEquals(Board.getScore(),50);
        Board.resetScore();
        assertEquals(Board.getScore(),0);
    }

}