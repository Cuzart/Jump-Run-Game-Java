package AgChSaJo.JumpOrDie;

public class ObstacleManager {


    static Obstacle generate (int kind){
        switch (kind){
            case 1: return new Fence();

            default: return new Fence();
        }
    }
    static void delete(){}

}
