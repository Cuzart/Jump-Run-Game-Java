package AgChSaJo.JumpOrDie;

import AgChSaJo.IPlayer;
import javafx.beans.property.SimpleStringProperty;

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
        setNickname(nickname);
        setFinalScore(finalScore);
    }

    private void setNickname(String nickname) {
        this.nickname = nickname;
    }
    private void setFinalScore(int score){
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
    public double getY() {
        return y;
    }
    public double getX (){
        return x;
    }


    void jump(double speed){
        y += speed;
    }
    void duck(boolean b){
        if (b){
            height/=2;
        }else{
            height*=2;
        }

    }

    @Override
    public String toString() {
        return getNickname()+"("+getFinalScore()+")";
    }
}
