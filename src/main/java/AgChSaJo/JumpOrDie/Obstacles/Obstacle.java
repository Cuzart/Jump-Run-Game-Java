package AgChSaJo.JumpOrDie.Obstacles;

public abstract class Obstacle {

    private double height, width, x=800, y=0;

    public void move(double speed){
        setX(getX()-speed);
    }

    public double getHeight() {
        return height;
    }
    public double getWidth (){
        return width;
    }
    public double getXEnd() {
        return x+width;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    void setHeight(double height) {
        this.height = height;
    }
    void setWidth(double width) {
        this.width = width;
    }
    private void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
}
