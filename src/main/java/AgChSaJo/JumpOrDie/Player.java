package AgChSaJo.JumpOrDie;

import AgChSaJo.IPlayer;

public class Player implements IPlayer {

    private String nickname;
    private int finalScore;
    private double height, width,
            y = 0,
            x = 100;

    Player(){
        height = 120;
        width = 60;
    }

    public Player(String nickname, int finalScore){
        this.nickname = nickname;
        this.finalScore = finalScore;
    }

    void setNickname(String nickname) {
        this.nickname = nickname;
    }
    void setFinalScore(int score){
        finalScore = score;
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
    public double getWidth(){
        return width;
    }
    double getXEnd() {
        return x+width;
    }
    public double getY() {
        return y;
    }
    public double getX (){
        return x;
    }


    void jump(double speed){
        y += speed;
    }
    /*void duck(){
        height/=2;
    }*/

}
