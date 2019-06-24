package AgChSaJo.JumpOrDie.Obstacles;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObstacleTest {

    private Obstacle obstacle;

    @Test
    public void obstacleSizeTest(){
        obstacle = new CactusRow();
        assertEquals(obstacle.getHeight(),50,0.001);
        assertEquals(obstacle.getWidth(),100,0.001);
        assertEquals(obstacle.getY(),0,0.001);
    }

    @Test
    public void move() {
        obstacle = new Mosquito();
        assertEquals(obstacle.getX(),800,0.001);
        obstacle.move(10);
        assertEquals(obstacle.getX(),790,0.001);
        obstacle.move(5);
        assertEquals(obstacle.getX(),785,0.001);
        obstacle.move(12);
        assertNotEquals(obstacle.getX(),770,0.001);
    }

    @Test
    public void setHeight() {
        obstacle = new Grass();
        obstacle.setHeight(123);
        assertEquals(obstacle.getHeight(),123,0.001);
    }

    @Test
    public void setWidth() {
        obstacle = new Shrub();
        obstacle.setWidth(321);
        assertEquals(obstacle.getWidth(),321,0.001);
    }
    @Test
    public void setX() {
        obstacle = new Tree();
        obstacle.setX(700);
        assertEquals(obstacle.getX(),700,0.001);
    }

    @Test
    public void setY() {
        obstacle = new Tree();
        obstacle.setY(70);
        assertEquals(obstacle.getY(),70,0.001);
    }
}