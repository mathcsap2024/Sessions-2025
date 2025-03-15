package University;

import java.io.Serializable;

public class Point implements Serializable {
    protected double x,y;
    double r,theta;
    public static double origin_x, origin_y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static double getOrigin_x() {
        return origin_x;
    }

    public Point() {
        this(0,0,false);
    }

    public Point(double x, double y) {
//        super();
        this(x,y,false);
    }

    public Point(double first, double second, boolean isPolar) {
        if(isPolar) {
            this.r=first;
            this.theta=second;

        }
        else {
            this.x = first;
            this.y = second;
        }
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
