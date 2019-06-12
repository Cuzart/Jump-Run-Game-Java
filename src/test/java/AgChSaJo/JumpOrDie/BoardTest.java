package AgChSaJo.JumpOrDie;

import AgChSaJo.JumpOrDie.Obstacles.Fence;
import AgChSaJo.JumpOrDie.Obstacles.Obstacle;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    private void setUpTest(){
        Board.activePlayer = new Player();
    }




    @Test
    public void setJumpingTest(){
        setUpTest();
        Board.setDucking(true);
        assertTrue(Board.getDucking());

        Board.setDucking(false);
        assertFalse(Board.getDucking());
    }
    @Test
    public void playerJumpTest(){
        setUpTest();
        Board.playerJump();
        assertTrue(Board.getJumping());
        long start = System.currentTimeMillis();
        long time;
        do {
            time = System.currentTimeMillis();
        }while (start+5000< time);
        assertTrue(Board.getJumping());





    }
        /*@Test
        public void checkCollisionTest () {
            Board.activePlayer = new Player();
            Board.activePlayer.jump();
            Obstacle testObstacle = new Fence();
            testObstacle.setX(100);
            testObstacle.setY(0);


            assertTrue(true);

        }*/
    }