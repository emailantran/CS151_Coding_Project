package obstacleAvoidanceGame.view;

import javax.swing.*;
import java.awt.*;


public class WallComponent extends JComponent {
	int[] x;
	int[] y;
	int[] width;
	int[] height;
	int gapSize;
	int frameHeight;

	public WallComponent(int[] x, int[] y, int[] width, int[] height, int gapSize, int frameHeight) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.gapSize = gapSize;
		this.frameHeight = frameHeight;
	}

	public void UpdateWallComponent(int[] x, int[] y, int[] width, int[] height, int gapSize, int frameHeight) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.gapSize = gapSize;
		this.frameHeight = frameHeight;
	}

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
