package AgChSaJo.JumpOrDie;

import java.util.Random;

public class ObstacleFactory {

    static Obstacle generate(){
        Random r = new Random();
        int kind = r.nextInt(3);
        switch (kind){
            case 1: return new Fence();
            case 2: return new Hedge();
            default: return new Fence();
        }
    }

}
