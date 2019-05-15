package AgChSaJo.JumpOrDie;

class Fence extends Obstacle{

    Fence (){
        height=10;
        width=3;
    }

    void move(double speed){
        x -= speed;
    }

}
