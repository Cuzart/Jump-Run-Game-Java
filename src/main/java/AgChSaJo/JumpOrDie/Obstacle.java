package AgChSaJo.JumpOrDie;

public abstract class Obstacle {

    protected double height, width, x=100, y=0;

    abstract void move(double speed);


}
