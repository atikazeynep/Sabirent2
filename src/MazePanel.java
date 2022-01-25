import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;

public class MazePanel extends JPanel implements KeyListener {

    private int indexX;
    private int indexY;
    private ArrayList<Point> coinList;
    private ArrayList<Point> tirrekList;
    private int score;
    private JLabel scoreTable;
    private JLabel healthTable;
    private int health;
    private final int[][] maze = {
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1},
            {1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1},
            {1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1,0,1,0,1,1,1,1,1,0,1,1,1,0,1},
            {1,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,1,0,1},
            {1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1},
            {1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1},
            {1,0,1,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1},
            {1,0,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,0,1},
            {1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,1,0,1},
            {1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0,1},
            {1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,1,1,0,1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,0,1},
            {1,0,1,0,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,0,0,1},
            {1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1},
            {1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1},
            {1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1},
            {1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,1},
            {1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,0,1,1,1,1,1,0,1,1,1},
            {1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,1,1,1,1},
            {1,0,0,0,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1},
            {1,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1},
            {1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
            {1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
            {1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1},
            {1,0,0,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,0,1},
            {1,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1},
            {1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1},
            {1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,1},
            {1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1},
            {1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1},
            {1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1},
            {1,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
            {1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1},
            {1,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1},
            {1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1},
            {1,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1},
            {1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1},
            {1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1},
            {1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1},
            {1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,1},
            {1,0,1,0,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1},
            {1,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,1},
            {1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1},
            {1,0,1,0,1,0,0,0,1,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
            {1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1},
            {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,9},
    };

    public MazePanel() {
        indexX = 0;
        indexY = 0;

        coinList = new ArrayList<>();
        createCoins();
        tirrekList = new ArrayList<>();
        createTirreks();

        score = 0;
        health = 5;
        scoreTable = new JLabel("Score: " + score);
        healthTable = new JLabel("Health: " + health);
        scoreTable.setForeground(Color.BLUE);
        healthTable.setForeground(Color.BLUE);
        Font font = new Font(scoreTable.getFont().getName(), Font.BOLD, scoreTable.getFont().getSize());
        scoreTable.setFont(font);
        healthTable.setFont(font);
    }

    public JLabel getScoreTable() {
        return scoreTable;
    }

    public JLabel getHealthTable() {
        return healthTable;
    }

    public boolean isThereTirrek(){
        for (Point point : tirrekList) {
            if (indexX == point.x && indexY == point.y) {
                return true;
            }
        }
        return false;
    }

    public void createCoins(){
        for(int i = 0; i < 20; i++){
            int coinX;
            int coinY;

            do {
                coinX = (int)(Math.random() * 44) + 1;
                coinY = (int)(Math.random() * 44) + 1;
            }while(maze[coinY][coinX] == 1);

            coinList.add(new Point(coinX, coinY));
        }
    }

    public void createTirreks(){
        for(int i = 0; i < 20; i++){
            int tirrekX;
            int tirrekY;

            do {
                tirrekX = (int)(Math.random() * maze[0].length);
                tirrekY = (int)(Math.random() * maze.length);
            }while(maze[tirrekY][tirrekX] == 1);


            tirrekList.add(new Point(tirrekX, tirrekY));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw the maze
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Color color;
                if (maze[row][col] == 1) {
                    color = Color.BLACK;
                } else {
                    color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(15 * col, 15 * row, 15, 15);
            }
        }

        // draw the ball on path
        g.setColor(Color.CYAN);
        g.fillOval(indexX * 15, indexY * 15, 15, 15);

        if(maze[indexY][indexX] == 9){
            JOptionPane.showMessageDialog(null,
                    "Congratulations! You won!", null, JOptionPane.INFORMATION_MESSAGE);
        }

        //draw the coins;
        for (Point point : coinList) {
            g.setColor(Color.YELLOW);
            g.fillOval(point.x * 15, point.y * 15, 10, 10);
        }

        //draw the tirreks
        for (Point point : tirrekList) {
            g.setColor(Color.RED);
            g.fillOval(point.x * 15, point.y * 15, 15, 15);
        }

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent ke) {
        if (ke.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
            if(indexX >= 0 && indexX < maze[0].length && (maze[indexY][indexX + 1] != 1)){
                if(!isThereTirrek())
                    indexX++;
                else
                    health--;
            }
        }
        else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            if(indexX > 0 && indexX <= maze[0].length && (maze[indexY][indexX - 1] != 1)){
                if(!isThereTirrek())
                    indexX--;
                else
                    health--;
            }
        }
        else if(ke.getKeyCode() == KeyEvent.VK_DOWN){
            if(indexY >= 0 && indexY < maze.length && (maze[indexY + 1][indexX] != 1)){
                if(!isThereTirrek())
                    indexY++;
                else
                    health--;
            }
        }
        else if(ke.getKeyCode() == KeyEvent.VK_UP){
            if(indexY > 0 && indexY <= maze.length && (maze[indexY - 1][indexX] != 1)){
                if(!isThereTirrek())
                    indexY--;
                else
                    health--;
            }
        }
        else if(ke.getKeyCode() == KeyEvent.VK_0){
            //remove the tirrek if player press the space key appropriately
            if(indexY > 0 && indexY <= maze.length){
                for(int i = 0; i < tirrekList.size(); i++){
                    if((tirrekList.get(i).x == indexX + 1 || tirrekList.get(i).x == indexX - 1 ||
                            tirrekList.get(i).x == indexX) && (tirrekList.get(i).y == (indexY + 1)
                            || tirrekList.get(i).y == (indexY - 1) || tirrekList.get(i).y == indexY)){
                        tirrekList.remove(i);
                        i--;
                    }
                }
            }
        }


        if(isThereTirrek()){
            for(int i = 0; i < tirrekList.size(); i++){
                if(tirrekList.get(i).x == indexX && tirrekList.get(i).y == indexY){
                    tirrekList.remove(i);
                    health--;
                    i--;
                    healthTable.setText("Health: " + health);
                }
            }
        }

        for(int i = 0; i < coinList.size(); i++){
            if(coinList.get(i).x == indexX && coinList.get(i).y == indexY){
                coinList.remove(i);
                score+=5;
                i--;
                scoreTable.setText("Score: " + score);
            }
        }

        repaint();
    }

    public void keyReleased(KeyEvent e) {

    }
}