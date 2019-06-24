package AgChSaJo.JumpOrDie.Obstacles;

/**
 * An abstract class that defines an Obstacle with a height,
 * width and a general X and Y-Coordinate to start from.
 */
public abstract class Obstacle {

    private double height, width, x=800, y=0;

    /**
     * This method gets an Obstacle to move by defining
     * a new X-Coordinate position depending on a given speed.
     */
    public void move(double speed){
        setX(getX()-speed);
    }

    public double getHeight() {
        return height;
    }
    public double getWidth (){
        return width;
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
    void setX(double x) {
        this.x = x;
    }
    void setY(double y) {
        this.y = y;
    }

}