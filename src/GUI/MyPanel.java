package GUI;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(10,10,200,300);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
