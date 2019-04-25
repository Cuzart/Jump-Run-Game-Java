package AgChSaJo.JumpOrDie;

public abstract class Obstacle implements IObstacle{

    private double oHeight, oWidth, oX, oY;

    public void move(){
        oX--;
    }
}
