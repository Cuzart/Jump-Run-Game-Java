package AgChSaJo.JumpOrDie;

import AgChSaJo.IPlayer;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This class defines every Player with a nickname, a final score, a height and width
 * and a Y and X-Coordinate to show his position int the game.
 */
public class Player implements IPlayer, Comparable<Player> {

    private String nickname;
    private int finalScore;
    @JsonIgnore
    private double height, width,
            y = 0,
            x = 100;

    /**
     * A Players exact height and width.
     */
    Player(){
        height = 125;
        width = 60;
    }

    /**
     * A Player will get an own nickname and will reach an own score.
     *
     * @param nickname a players chosen name
     * @param finalScore the score a player reached
     */
    public Player(String nickname, int finalScore){
        setNickname(nickname);
        setFinalScore(finalScore);
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    void setFinalScore(int score){
        finalScore = score;
    }
    public String getNickname(){
        return nickname;
    }
    public int getFinalScore() {
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

    /**
     * When a player jumps with a given speed the Y-Coordinate increases and he can move horizontally.
     *
     * @param speed how fast the player moves
     */
    void jump(double speed){
        y += speed;
    }

    /**
     * When a player ducks his height gets cut in half. On the other
     * side, if he gets in his normal state, he is set back to the original height.
     *
     * @param b a variable that if true lets a player duck, if false sets him back
     */
    void duck(boolean b){
        if (b){
            height/=2;
        }else{
            height*=2;
        }

    }

    /**
     * returms the nickname and final score of a player.
     *
     * @return nickname, finalScore
     */
    @Override
    public String toString() {
        return getNickname()+"("+getFinalScore()+")";
    }
    @Override
    public int compareTo(Player other) {
        return other.getFinalScore()-getFinalScore();
    }
}
