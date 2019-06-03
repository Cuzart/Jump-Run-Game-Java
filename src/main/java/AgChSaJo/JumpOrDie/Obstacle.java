package AgChSaJo.JumpOrDie;

public abstract class Obstacle {

    private double height, width, x=800, y=450;

    abstract void move(double speed);

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

    public void setHeight(double height) {
        this.height = height;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
}
