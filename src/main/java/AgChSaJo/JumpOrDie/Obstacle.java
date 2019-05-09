package AgChSaJo.JumpOrDie;

public abstract class Obstacle implements IObstacle{

    private double height, width, x, y;

    public void move(){
        x--;
    }
}
