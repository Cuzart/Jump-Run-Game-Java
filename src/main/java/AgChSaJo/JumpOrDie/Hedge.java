package AgChSaJo.JumpOrDie;


class Hedge extends Obstacle{

    Hedge (){
        height=5;
        width=10;
    }

    void move(double speed){
        x -= speed;
    }
}
