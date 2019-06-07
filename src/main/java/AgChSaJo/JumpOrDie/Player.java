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
    void setFinalScore(double score){
        finalScore = score;
    }
    public String getNickname(){
        return nickname;
    }
    public double getFinalScore() {
        return finalScore;
    }

    double getHeight() {
        return height;
    }
    double getXEnd() {
        return x+width;
    }
    public double getY() {
        return y;
    }
    double getX (){
        return x;
    }


    void jump(double speed){
        y += speed;
    }
    /*void duck(){
        height/=2;
    }*/

}
