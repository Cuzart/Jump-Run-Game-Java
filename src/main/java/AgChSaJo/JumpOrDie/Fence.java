package AgChSaJo.JumpOrDie;


class Fence extends Obstacle{

    Fence (){
        setHeight(10);
        setWidth(5);
    }

    void move(double speed){
        setX(getX()-speed);
    }

}
