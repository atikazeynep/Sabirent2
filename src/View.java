import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

/**
 *
 * @author leo
 */
public class View extends JFrame {

    /**
     * Conventions:
     *
     * maze[row][col]
     *
     * Values: 0 = not-visited node
     *         1 = wall (blocked)
     *         2 = visited node
     *         9 = target node
     */

    private int [][] maze =
            { {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
              {1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
              {1,0,1,0,0,0,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
              {1,0,0,0,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
              {1,0,1,0,0,0,0,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
              {1,0,1,0,1,1,1,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
              {1,0,1,0,1,0,0,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
              {1,0,1,0,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
              {1,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
              {1,1,1,1,1,1,1,1,1,1,1,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
            };

    int indexX;
    int indexY;

    public View() {
        setTitle("Simple Maze Solver");
        setSize(1200, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        indexX = 0;
        indexY = 0;

        // game loop each 0.5 seconds
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                update();
//                repaint();
//            }
//        }, 100, 500);        
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.translate(10, 40);

        // draw the maze
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Color color;
                switch (maze[row][col]) {
                    case 1 : color = Color.BLACK; break;
                    default : color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(30 * col, 30 * row, 30, 30);
            }
        }

        // draw the ball on path
        g.setColor(Color.RED);
        g.fillOval(indexX* 30, indexY * 30, 30, 30);
    }

    @Override
    protected void processKeyEvent(KeyEvent ke) {
        if (ke.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT && maze[indexY][indexX + 1] != 1){
            if(indexX >= 0 && indexX < maze[0].length){
                indexX++;
            }
        }
        else if (ke.getKeyCode() == KeyEvent.VK_LEFT && maze[indexY][indexX - 1] != 1) {
            if(indexX > 0 && indexX <= maze[0].length){
                indexX--;
            }
        }
        else if(ke.getKeyCode() == KeyEvent.VK_DOWN){
            if(indexY >= 0 && indexY < maze.length && maze[indexY + 1][indexX] != 1){
                indexY++;
            }
        }
        else if(ke.getKeyCode() == KeyEvent.VK_UP && maze[indexY - 1][indexX] != 1){
            if(indexY > 0 && indexY <= maze.length){
                indexY--;
            }
        }

        if(maze[indexY][indexX] == 9){
            JOptionPane.showMessageDialog(null,
                    "Congratulations! You won!", null, JOptionPane.INFORMATION_MESSAGE);
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View view = new View();
                view.setVisible(true);
            }
        });
    }
}