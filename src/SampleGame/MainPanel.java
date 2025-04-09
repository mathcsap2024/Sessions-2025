package SampleGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class MainPanel extends JPanel {
    ArrayList<Circle> shapes;
    final private Random random = new Random();

    private int currentShape;

    public MainPanel() {
        super();
        shapes = new ArrayList<>();
        currentShape = 0;
        prepareListeners();
        setBackground(Color.GREEN);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;

        for(Circle shape:shapes) {
            if(shape==getCurrentShape()) {
                graphics2D.setColor(Color.RED);
            }
            else {
                graphics2D.setColor(Color.BLUE);
            }
            shape.draw(graphics2D);
        }
    }

    public void addCircle() {
        shapes.add(new Circle(
                new Point(
                    random.nextInt(getWidth()),
                    random.nextInt(getHeight()))
                ,
                random.nextInt(getHeight()/10)
        ));
    }

    private void prepareListeners() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'a':
                        System.out.println("a is pressed");
                        break;
                    case 'c':
                        System.out.println("c is pressed");
                        break;
                    case 'u':
                        System.out.println("u is pressed");
                        break;
                    case 'j':
                        System.out.println("j is pressed");
                        break;
                    case 'h':
                    case 'k':
                    case 'o':
                        System.out.println("another key is pressed");
                    default:
                }
                if(e.getKeyChar()=='a') {
                    addCircle();
                }
                if(e.getKeyChar()=='c') {
                    changeCurrentShape();
                }
                else if(e.getKeyChar()=='j') {
                    moveShape(0,1);
                }
                else if(e.getKeyChar()=='u') {
                    moveShape(0,-1);
                }
                else if(e.getKeyChar()=='k') {
                    moveShape(1,0);
                }
                else if(e.getKeyChar()=='h') {
                    moveShape(-1,0);
                }
                else if(e.getKeyChar()=='o') {
                    Timer timer = new Timer(10, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            moveShape(1,0);
                            repaint();
                        }
                    });
                    timer.start();
                }
                repaint();
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    private void moveShape(int x, int y) {
        Circle current = getCurrentShape();
        if(current != null) {
            current.location = new Point(
                    current.location.x+x,
                    current.location.y+y
            );
        }
    }

    private void changeCurrentShape() {
        currentShape++;
    }

    private Circle getCurrentShape() {
        if(shapes.size()==0) {
            return null;
        }
        return shapes.get(currentShape%shapes.size());
    }
}
