package SampleGame;

import javax.swing.*;
import java.util.ArrayList;

class Shape {
    double arg;
    void setAndNormalize(double a) {

    }
}

public class GameFrame extends JFrame {
    MainPanel mainPanel;

    Shape shape;

    void rotate(double arg) {
        shape.arg+=arg;
//        shape.arg
        if(shape.arg>Math.PI*2) {

        }
    }

    public GameFrame() {
        super();
        setSize(800,600);
        mainPanel = new MainPanel();
        mainPanel.setLayout(null);
        getContentPane().add(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        mainPanel.grabFocus();
    }


}
