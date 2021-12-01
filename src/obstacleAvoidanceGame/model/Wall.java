package obstacleAvoidanceGame.model;

import java.util.Random;

import obstacleAvoidanceGame.DifficultyLevel;

/**
 * Holds dimensions and characteristics of wall obstacles
 * @author blues
 *
 */
public class Wall {
	private int x;
	private int y;
	private int width;
	private int height;
	private int speed;
	
	/**
	 * Constant variables used to determine frame size and gaps in walls
	 */
	final int GAP_SIZE = 150;
	final int FRAME_WIDTH = 1920;
	final int FRAME_HEIGHT = 1080;
	final int MIN_HEIGHT = 100;
	final int MAX_HEIGHT = 700;

	/**
	 * 
	 * @param distanceApart : space in between walls
	 */
	public Wall(int distanceApart) {

		Random rand = new Random();
		x = FRAME_WIDTH + distanceApart;
		y = 0;
		width = 100;
		speed = 4;
		height = rand.nextInt(MAX_HEIGHT) + MIN_HEIGHT; // minimum height of 100, max height
	}

	/**
	 * x position of wall
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * y position of wall
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * width of wall
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * height of wall
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * gap size of wall
	 * @return GAP_SIZE
	 */
	public int getGAP_SIZE() {
		return GAP_SIZE;
	}

	/**
	 * sets speed of wall
	 * @param newSpeed : speed of wall
	 */
	public void setSpeed(int newSpeed) {
		this.speed = newSpeed;
	}

	/**
	 * returns speed of wall
	 * @return speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * moves wall at certain speed
	 */
	public void move() {
		x -= speed;
	}
	
}
