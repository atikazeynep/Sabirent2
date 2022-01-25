import javax.swing.*;
import java.awt.*;

public class Game {
    public static void main(String[] args) {
        JFrame mazeFrame = new JFrame();
        MazePanel mazePanel = new MazePanel();

        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setPreferredSize(new Dimension(691, 24));
        panel.add(mazePanel.getScoreTable());
        panel.add(mazePanel.getHealthTable());

        mazeFrame.setTitle("ŞABİRENT");
        mazeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mazeFrame.setSize(new Dimension(mazePanel.getWidth(), mazePanel.getHeight()));
        mazePanel.setPreferredSize(new Dimension(691, 828));
        mazeFrame.setLayout(new BorderLayout());
        mazeFrame.getContentPane().add(panel, BorderLayout.NORTH);
        mazeFrame.add(mazePanel, BorderLayout.CENTER);
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
