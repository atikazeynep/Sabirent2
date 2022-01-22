import javax.swing.*;
import java.awt.*;

public class Game {
    public static void main(String[] args) {
        JFrame mazeFrame = new JFrame();
        View view = new View();

        mazeFrame.setTitle("ŞABİRENT");
        mazeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //mazeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mazeFrame.setSize(new Dimension(view.getWidth(),view.getHeight()));
        view.setPreferredSize(new Dimension(695, 828));
        mazeFrame.getContentPane().add(view);
        mazeFrame.addKeyListener(view);
        mazeFrame.pack();

        //create scroll pane and add it to the frame
        JScrollPane scrollBar = new JScrollPane(view);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mazeFrame.add(scrollBar);

        mazeFrame.setVisible(true);
    }
}
