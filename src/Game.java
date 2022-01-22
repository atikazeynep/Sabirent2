import javax.swing.*;
import java.awt.*;

public class Game {
    public static void main(String[] args) {
        JFrame mazeFrame = new JFrame();
        View view = new View();

        mazeFrame.setTitle("ŞABİRENT");
        mazeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mazeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mazeFrame.add(view);
        mazeFrame.addKeyListener(view);

        //create scroll pane and ad it to the frame
        JScrollPane scrollBar = new JScrollPane(view);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mazeFrame.add(scrollBar);
        mazeFrame.setVisible(true);
    }
}
