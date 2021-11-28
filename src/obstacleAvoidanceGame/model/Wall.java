package obstacleAvoidanceGame.model;

import java.util.Random;

public class Wall {
	private int x;
	private int y;
	private int width;
	private int height;
	private int speed;

	final int GAP_SIZE = 150;
	final int FRAME_WIDTH = 1920;
	final int FRAME_HEIGHT = 1080;
	final int MIN_HEIGHT = 100;
	final int MAX_HEIGHT = 700;

	public Wall(int distanceApart) {

		Random rand = new Random();
		x = FRAME_WIDTH + distanceApart;
		y = 0;
		width = 100;
		speed = 4;
		height = rand.nextInt(MAX_HEIGHT) + MIN_HEIGHT; // minimum height of 100, max height
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getGAP_SIZE() {
		return GAP_SIZE;
	}

	public void setSpeed(int newSpeed) {
		this.speed = newSpeed;
	}

	public int getSpeed() {
		return speed;
	}

	public void move() {
		x -= speed;
	}
}
