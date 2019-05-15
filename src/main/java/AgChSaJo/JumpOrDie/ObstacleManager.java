package AgChSaJo.JumpOrDie;

import java.util.Random;

class ObstacleManager {

    static Obstacle obstacle1, obstacle2;
    private static double obstacleSpeed = 1;
    private static int obstacleCount = 0;

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

    static void manageObstacleLifetime(){
        if (obstacle1.x <=-5){
            obstacle1 = generate();
            obstacleCount++;
        }
        if(obstacleCount >= 5){
            if (obstacle2 == null && obstacle1.x <=50){
                obstacle2 = generate();
            }
        }
        if (obstacle2 != null && obstacle2.x <=-5){
            obstacle2 = generate();
            obstacleCount++;
        }
        switch (obstacleCount){
            case 10: obstacleSpeed = 1.5; break;
            case 20: obstacleSpeed = 2; break;
        }
    }

    static double getObstacleSpeed(){
        return obstacleSpeed;
    }

}
