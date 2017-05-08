/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.WindowConstants;
/**
 *
 * @author benjaminwong
 */
@SuppressWarnings("serial")
public class Game extends JPanel {
    int x = 0;
    int y = 0;
    
    Point topLeftLocation = new Point(10, 10);
    int rows = 5; int cols = 10; int dimension = 10;
    
    // Testing
    private void moveBall() {
        x = x + 1;
        y = y + 1;
    }
    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Start Antialias
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // End Antialias
        
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                g2d.drawRect(topLeftLocation.x + col * dimension, topLeftLocation.y + row * dimension, 
                        dimension, dimension);
            }
        }
        
        //g2d.fillOval(x, y, 30, 30);
    }
    
    

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Sample Frame");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            //game.moveBall();
            game.repaint();
            Thread.sleep(10);
        }
    }
}