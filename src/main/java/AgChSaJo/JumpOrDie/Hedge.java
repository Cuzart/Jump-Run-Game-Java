package AgChSaJo.JumpOrDie;


class Hedge extends Obstacle{

    Hedge (){
        setHeight(50);
        setWidth(100);
    }

    void move(double speed){
        setX(getX()-speed);
    }
}
