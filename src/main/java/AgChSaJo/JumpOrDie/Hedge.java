package AgChSaJo.JumpOrDie;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Hedge extends Obstacle{

    private static Logger log = LogManager.getLogger(Obstacle.class);

    Hedge (){
        height=5;
        width=10;
        log.debug("new Hedge");
    }

    void move(double speed){
        x -= speed;
    }
}
