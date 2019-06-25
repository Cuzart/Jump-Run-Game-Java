package AgChSaJo.JumpOrDie;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObstacleManagerTest {

    private Board board = new Board();
    private ObstacleManager obstacleManager = board.obstacleManager;

    @Test
    public void setUpTest() {
        assertNull(obstacleManager.obstacle1);
        obstacleManager.setUp();
        assertEquals(obstacleManager.getObstacleSpeed(),7,0.001);
        assertEquals(obstacleManager.getObstacleCount(),0);
        assertNull(obstacleManager.obstacle2);
        assertNotNull(obstacleManager.obstacle1);
    }

    @Test
    public void getCloserObstacle() {
        obstacleManager.setUp();
        assertEquals(obstacleManager.getCloserObstacle(),obstacleManager.obstacle1);
    }

    @Test
    public void getObstacleSpeedTest() {
        obstacleManager.setUp();
        assertNotEquals(obstacleManager.getObstacleSpeed(),123,0.001);
    }


}