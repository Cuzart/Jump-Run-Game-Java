package AgChSaJo.JumpOrDie;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObstacleManagerTest {

    @Test
    public void setUpTest() {
        assertNull(ObstacleManager.obstacle1);
        ObstacleManager.setUp();
        assertEquals(ObstacleManager.getObstacleSpeed(),7,0.001);
        assertEquals(ObstacleManager.getObstacleCount(),0);
        assertNull(ObstacleManager.obstacle2);
        assertNotNull(ObstacleManager.obstacle1);
    }

    @Test
    public void getCloserObstacle() {
        ObstacleManager.setUp();
        assertEquals(ObstacleManager.getCloserObstacle(),ObstacleManager.obstacle1);
    }

    @Test
    public void getObstacleSpeedTest() {
        ObstacleManager.setUp();
        assertNotEquals(ObstacleManager.getObstacleSpeed(),123,0.001);
    }


}