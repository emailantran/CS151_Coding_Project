import java.awt.*;
import java.awt.geom.*;

public class Wall {
	final double SPEED = 1; // temporary speed value for walls to move across 
	// any SPEED value below 1 makes this weird glitch where the wall stays stuck at the top left of the screen
	
	final int GAP_SIZE = 300;
	final int FRAME_WIDTH = 1920;
    final int FRAME_HEIGHT = 1080;
	
	
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	/*
	 * Constructor for Wall Class
	 * @param xPos X position for Wall
     * @param yPos Y position for Wall
     * @param width Width of Wall
     * @param height Height of Wall
	 */
	public Wall(int xPos, int yPos, int width, int height) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}
	
	/*
	 * Function to increase the xPos across the screen to create the illusion of flying through the walls
	 * Don't need int dy since we are only moving across the screen
	 * @param dx the amount of pixels on the screen we are moving by
	 */
	public void translate(double dx) {
		if (this.onScreen())
			xPos -= dx;
	}
	
	/*
	 * @return xPos 
	 */
	public int getxPos() {
		return xPos;
	}
	
	/*
	 * @return yPos
	 */
	public int getyPos() {
		return yPos;
	}
	
	/*
	 * @return width 
	 */
	public int getWidth() {
		return width;
	}
	
	/*
	 * @return height
	 */
	public int getHeight() {
		return height;
	}
	
	/*
	 * Returns a boolean based on whether the full width of the wall is on the screen still
	 * @return true if wall is on the screen, false if off the screen
	 */
	public boolean onScreen() {
		return xPos >= -width;
	}
	
	/*
	 * Ideally draws the top and bottom rectangles that would be the pipes in Flappy Bird
	 * @param g2 shape to fully draw
	 */
	public void draw(Graphics2D g2) {
		Rectangle2D.Double topRectangle = new Rectangle2D.Double(xPos, yPos, width, height);
		Rectangle2D.Double bottomRectangle = new Rectangle2D.Double(xPos, height + GAP_SIZE, width, FRAME_HEIGHT - height);
		
		g2.draw(topRectangle);
		g2.draw(bottomRectangle);
		
		g2.setColor(Color.green);
		g2.fillRect(xPos, yPos, width, height);
		g2.fillRect(xPos, height + GAP_SIZE, width, FRAME_HEIGHT - height);
		
	}
}

