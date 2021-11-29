package obstacleAvoidanceGame.view;

import javax.swing.*;
import java.awt.*;

/**
 * Wall component draws shape of wall from the values kept in wall class
 * @author blues
 *
 */
public class WallComponent extends JComponent {
	int[] x;
	int[] y;
	int[] width;
	int[] height;
	int gapSize;
	int frameHeight;

	/**
	 * constructor to initialize variables
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param gapSize
	 * @param frameHeight
	 */
	public WallComponent(int[] x, int[] y, int[] width, int[] height, int gapSize, int frameHeight) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.gapSize = gapSize;
		this.frameHeight = frameHeight;
	}

	/**
	 * reinitializes variables when wall is moved
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param gapSize
	 * @param frameHeight
	 */
	public void UpdateWallComponent(int[] x, int[] y, int[] width, int[] height, int gapSize, int frameHeight) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.gapSize = gapSize;
		this.frameHeight = frameHeight;
	}

	/**
	 * paints shape of wall
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		for (int i = 0; i < 1000; i++) {
			g2.setColor(Color.GREEN);
			g2.fillRect(x[i], y[i], width[i], height[i]);
			g2.fillRect(x[i], height[i] + gapSize, width[i], frameHeight - height[i]); // bottom
		}
	}
}
