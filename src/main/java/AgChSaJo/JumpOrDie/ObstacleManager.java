package AgChSaJo.JumpOrDie;

import java.util.Random;

class ObstacleManager {

    static Obstacle obstacle1, obstacle2;

    static Obstacle generate(){
        Random r = new Random();
        int kind = r.nextInt(2);
        switch (kind){
            case 0:
                System.out.println("new Fence");
                return new Fence();
            case 1:
                System.out.println("new Hedge");
                return new Hedge();
            default: return new Fence();
        }
    }

    static void manageObstacleLifetime(int level){
        if (obstacle1.x <=-5){
            obstacle1 = generate();
        }
       /* if(level==2){
        }*/
    }

}
