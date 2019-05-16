package AgChSaJo.JumpOrDie;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Fence extends Obstacle{

    private static Logger log = LogManager.getLogger(Obstacle.class);

    Fence (){
        height=10;
        width=3;
        log.debug("new Fence");
    }

    void move(double speed){
        x -= speed;
    }

}
