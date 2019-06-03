package AgChSaJo.JumpOrDie;


class Fence extends Obstacle{

    Fence (){
        setHeight(100);
        setWidth(50);
    }

    void move(double speed){
        setX(getX()-speed);
    }

}
