package AgChSaJo.JumpOrDie;

public class Hedge extends Obstacle{

    public Hedge (){
        height=5;
        width=10;
    }

    void move(){
        x--;
    }
}
