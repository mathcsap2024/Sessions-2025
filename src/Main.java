import University.Point;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final int a;
        a=10;
        final String[] strings = new String[10];
        strings[2] = "sfdF";
        final Point p=new Point(10.0,12.0, true);
//        p.x=20;
//        p.x=10;
//        p.r=200;

        Human human = new Human("Ali",1);
        Human.Foot foot = human.new Foot();

        Geometry2D.Point p2d=new Geometry2D.Point();
        Geometry2D.Point p2d2=new Geometry2D.Point();
        Geometry3D.Point p3d=new Geometry3D.Point();

        Shape shape2 = new Shape() {
            @Override
            public Double getArea() {
                return 10.0;
            }
        };

        Runnable program = new Runnable() {
            @Override
            public void run() {
                System.out.println("Test");
            }
        };
    }
}
