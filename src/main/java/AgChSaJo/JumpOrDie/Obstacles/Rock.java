package AgChSaJo.JumpOrDie.Obstacles;

public class Rock extends Obstacle {

    public Rock(){
        setHeight(45);
        setWidth(75);
    }

    @Override
    public String toString() {
        return "Rock";
    }

}