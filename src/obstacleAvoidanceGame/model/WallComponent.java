package obstacleAvoidanceGame.model;

import obstacleAvoidanceGame.model.Wall;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class WallComponent extends JComponent {
	private Wall wall;
	final int FRAME_WIDTH = 1920;
    final int FRAME_HEIGHT = 1080;
    final int MIN_HEIGHT = 100;
    final int MAX_HEIGHT = 500;
    final int WIDTH = 100;
	
	public WallComponent() {
		Random rand = new Random();
		int randomHeight = rand.nextInt(MAX_HEIGHT) + MIN_HEIGHT; // minimum height of 100, max height
		wall = new Wall(FRAME_WIDTH, 0, WIDTH, randomHeight); // test values only
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		wall.draw(g2);
		wall.translate(wall.SPEED);
		if (wall.getxPos() >= -wall.getWidth()) { 
			repaint();
		}
	}
}
