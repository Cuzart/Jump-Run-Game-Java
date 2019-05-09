package AgChSaJo.JumpOrDie;

public class Fence extends Obstacle{

    public Fence (){
        height=10;
        width=3;
    }

    void move(){
        x--;
    }

}
