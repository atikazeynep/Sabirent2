import javax.swing.*;
import java.awt.*;

public class Game {
    public static void main(String[] args) {
        JFrame mazeFrame = new JFrame();
        MazePanel mazePanel = new MazePanel();

        mazeFrame.setTitle("ŞABİRENT");
        mazeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //mazeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mazeFrame.setSize(new Dimension(mazePanel.getWidth(), mazePanel.getHeight()));
        mazePanel.setPreferredSize(new Dimension(1000, 828));
        mazeFrame.getContentPane().add(mazePanel);
        mazeFrame.addKeyListener(mazePanel);
        mazeFrame.pack();

        //create scroll pane and add it to the frame
        JScrollPane scrollBar = new JScrollPane(mazePanel);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mazeFrame.add(scrollBar);

        mazeFrame.setVisible(true);
    }
}
