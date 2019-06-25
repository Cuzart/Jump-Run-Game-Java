package AgChSaJo.JumpOrDie;

import AgChSaJo.JumpOrDie.Obstacles.Rock;
import AgChSaJo.JumpOrDie.Obstacles.Obstacle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board = JumpOrDie.board;

    @Before
    public void setUpTest() {
        board.activePlayer = new Player();
    }


    @Test
    public void setJumpingTest() {
        board.setDucking(true);
        assertTrue(board.getDucking());

        board.setDucking(false);
        assertFalse(board.getDucking());
    }

    /**
     * Diese Methode wartet eine bestimmte Zeit und kontrolliert dann den Springstatus des Spielers
     * Je nach Wartezeit ist der Spieler noch am springen oder wieder auf dem Boden
     */
    @Test
    public void playerJumpTest() {
        board.activePlayer = new Player();
        board.playerJump();
        assertTrue(board.getJumping());
        long start = System.currentTimeMillis();
        long time;
        //after 500ms the player is still jumping
        do {
            time = System.currentTimeMillis();
        } while (start + 500 >= time);
        assertTrue(board.getJumping());
        //after 900ms the player is back on the ground
        do {
            time = System.currentTimeMillis();
        } while (start + 900 >= time);
        assertFalse(board.getJumping());

    }

    @Test
    public void addToScoreTest() {
        board.addToScore(10);
        assertEquals(board.getScore(), 10);
        board.addToScore(20);
        assertEquals(board.getScore(), 30);
        board.addToScore(20);
        assertEquals(board.getScore(), 50);

        assertNotEquals(board.getScore(), 60);
    }
    @Test
    public void resetScoreTest(){
        addToScoreTest();
        assertEquals(board.getScore(),50);
        board.resetScore();
        assertEquals(board.getScore(),0);
    }

}