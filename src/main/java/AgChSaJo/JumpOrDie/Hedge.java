package AgChSaJo.JumpOrDie;


class Hedge extends Obstacle{

    Hedge (){
        setHeight(5);
        setWidth(10);
    }

    void move(double speed){
        setX(getX()-speed);
    }
}
