package AgChSaJo.JumpOrDie;

public class Player{

    private String nickname;
    private double finalScore, score;
    private double height, width, y;

    Player(){
        height = 15;
        width = 3;
        y = 0;
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
