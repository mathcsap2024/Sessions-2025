package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class FirstApplication implements Runnable {
    @Override
    public void run() {
        JFrame jFrame = new JFrame("My First Frame");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(new Dimension(800,600));

        JPanel nativePanel = (JPanel) jFrame.getContentPane();

        JPanel mainPanel = new JPanel(new BorderLayout());
        nativePanel.add(mainPanel);

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(100,100));
        leftPanel.setLocation(new Point(30,70));
        leftPanel.setBackground(Color.RED);

        JPanel rightPanel = new MyPanel();
        rightPanel.setPreferredSize(new Dimension(400,250));
        rightPanel.setLocation(new Point(130,40));
        rightPanel.setBackground(Color.BLUE);

        mainPanel.add(leftPanel, BorderLayout.SOUTH);
        mainPanel.add(rightPanel, BorderLayout.NORTH);

        JButton button = new JButton("Click Me!");
        button.setPreferredSize(new Dimension(140,250));
        button.setLocation(new Point(410,240));
        mainPanel.add(button, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rightPanel.setBackground(Color.CYAN);
                rightPanel.setPreferredSize(new Dimension(
                        rightPanel.getPreferredSize().width+10,
                        rightPanel.getPreferredSize().height+10
                        ));
                jFrame.revalidate();
                jFrame.repaint();
            }
        });

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Random random = new Random();
                button.setLocation(
                        new Point(
                                random.nextInt(mainPanel.getWidth()),
                                random.nextInt(mainPanel.getHeight())));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        button.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        button.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        JLabel label = new JLabel("This is the text");
        mainPanel.add(label, BorderLayout.EAST);

        JButton button2 = new JButton("Keyboard");
        button2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()=='r') {
                    leftPanel.setBackground(Color.RED);
                }
                else if(e.getKeyChar()=='b') {
                    leftPanel.setBackground(Color.BLUE);
                }
                else if(e.getKeyChar()=='g') {
                    leftPanel.setBackground(Color.GREEN);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        mainPanel.add(button2, BorderLayout.WEST);

        jFrame.setVisible(true);

        Timer timer = new Timer(1, new ActionListener() {

            int offset = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
//                jFrame.setVisible(!jFrame.isVisible());
                leftPanel.repaint();
                Graphics2D graphics2D = (Graphics2D) leftPanel.getGraphics();
                graphics2D.drawLine(offset,10, 100, 150);
                offset+=1;
                offset%=300;
            }
        } );
        timer.start();

        jFrame.repaint();
        jFrame.revalidate();

        leftPanel.repaint();
    }
}
