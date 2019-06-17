package AgChSaJo.JumpOrDie.Obstacles;

public class Mosquito extends Obstacle{

    public Mosquito(){
        setHeight(40);
        setWidth(50);
        setY(70);
    }
    @Override
    public String toString() {
        return "Mosquito";
    }
}
