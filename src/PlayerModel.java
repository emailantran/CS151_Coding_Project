import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class PlayerModel {
    private int xPos;
    private int yPos;
    private int width;
    private int height;

    /**
     * Constructor for the PlayerModel class
     * @param xPos X position for the Player Model
     * @param yPos Y position for the Player Model
     * @param width Width of the Player Model
     * @param height Height of the Player Model
     */
    public PlayerModel (int xPos, int yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        
    }

    /**
     * @return xPos
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * @return yPos
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * Changes the y position by change amount
     * @param change amount of y cordinates to move the blocks position up or down
     */
    public void setyPos(int change){
        yPos += change;
    }

    /**
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return height
     */
    public int getHeight() {
        return height;
    }

    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos,yPos,100,100);
        
        g2d.setColor(Color.yellow);
        g2d.fill(circle);
    }

    }
