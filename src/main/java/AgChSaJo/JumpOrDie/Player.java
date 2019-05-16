package AgChSaJo.JumpOrDie;

import AgChSaJo.IPlayer;

public class Player implements IPlayer {

    private String nickname;
    private double finalScore, score;
    private double height, width, y;

    Player(){
        height = 15;
        width = 3;
        y = 0;
    }

    void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNickname(){
        return nickname;
    }
    public double getFinalScore() {
        return finalScore;
    }
    public String[] getStats (){
        return new String[]{nickname, Double.toString(finalScore)};
    }
    void jump(){
        boolean maxHeight = false;
        if (!maxHeight){
            y++;
            if (y==15){
                maxHeight = true;
            }
        }else{
            y--;
        }
    }
    void duck(){
        height/=2;
    }

}
