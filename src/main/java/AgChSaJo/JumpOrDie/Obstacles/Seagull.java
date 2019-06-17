package AgChSaJo.JumpOrDie.Obstacles;

public class Seagull extends Obstacle{

    public Seagull(){
        setHeight(45);
        setWidth(99);
        setY(100);
    }
    @Override
    public String toString() {
        return "Seagull";
    }
}
