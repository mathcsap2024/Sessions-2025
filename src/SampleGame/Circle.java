package SampleGame;

import java.awt.*;

public class Circle {
    Point location;
    Double radius;
    public Circle() {
        this(new Point(0,0),100);
    }
    public Circle(Point location, double radius) {
        super();
        this.location = location;
        this.radius= radius;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.fillOval(
                (int)(location.x - radius),
                (int)(location.y-radius),
                (int)(2*radius),
                (int)(2*radius));
    }
}
