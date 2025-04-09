package SampleGame;

import javax.swing.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {
    MainPanel mainPanel;

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
