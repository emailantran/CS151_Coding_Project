package obstacleAvoidanceGame.model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class WallComponent extends JComponent {
	private ArrayList<Wall> walls = new ArrayList<>();
	Timer timer;
	public final static int DISTANCE_APART = 600;
	
	public WallComponent() {
		for (int i = 0; i < 1000; i++) {
			walls.add(new Wall(i * DISTANCE_APART));
		}
		
		timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (Wall n : walls) {
                    n.move();
                }
                repaint();
            }
        });
        
        timer.start();
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        pm.draw(g);
        Graphics2D g2 = (Graphics2D)g;
        for (Wall n : walls) {
        	g2.setColor(Color.GREEN);
	        g2.fillRect(n.getX(), n.getY(), n.getWidth(), n.getHeight());
	        g2.fillRect(n.getX(), n.getHeight() + n.GAP_SIZE, n.getWidth(), n.FRAME_HEIGHT - n.getHeight()); // bottom
        }
    }
}
