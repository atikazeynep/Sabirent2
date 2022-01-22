import javax.swing.*;
import java.awt.*;

public class Game {
    public static void main(String[] args) {
        JFrame mazeFrame = new JFrame();
        View view = new View();

        mazeFrame.setTitle("ŞABİRENT");
        mazeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mazeFrame.setSize(new Dimension(view.getWidth(),view.getHeight()));
        view.setPreferredSize(new Dimension(view.getWidth(),view.getHeight()));
        mazeFrame.getContentPane().add(view);
        mazeFrame.addKeyListener(view);
        mazeFrame.pack();
        mazeFrame.setVisible(true);
    }
}
