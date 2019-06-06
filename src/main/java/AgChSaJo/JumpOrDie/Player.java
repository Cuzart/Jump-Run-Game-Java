package AgChSaJo.JumpOrDie;

import AgChSaJo.IPlayer;

public class Player implements IPlayer {

    private String nickname;
    private double finalScore;
    private double height, width,
            y = 0,
            x = 100;

    Player(){
        height = 120;
        width = 60;
    }

    public Player(String nickname, double finalScore){
        this.nickname = nickname;
        this.finalScore = finalScore;
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

    public double getHeight() {
        return height;
    }
    public double getXEnd() {
        return x+width;
    }
    public double getY() {
        return y;
    }
    public double getX (){
        return x;
    }

    void jump(boolean maxHeight){
        if (!maxHeight){
            y+=2;
        }else{
            y-=2;
        }
    }
    /*void duck(){
        height/=2;
    }*/

}
