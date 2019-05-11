package AgChSaJo.JumpOrDie;

import AgChSaJo.IPlayer;

public class Player implements IPlayer {

    private String nickname;
    private double finalScore, score;
    private double pHeight, pWidth, pY;

    public void setNickname(String nickname) {
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
        pY += 2;
    }
    void duck(){
        pHeight/=2;
    }

}
