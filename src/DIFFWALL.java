import javax.swing.*;
import java.awt.*;

public class DIFFWALL extends JComponent {
	final int GAP_SIZE = 300;
	final int FRAME_WIDTH = 1920;
    final int FRAME_HEIGHT = 1080;
    final int MIN_HEIGHT = 100;
    final int MAX_HEIGHT = 500;
    final int WIDTH = 100;
	
	
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private int lastX = 1920;
	
	public DIFFWALL() {
        Thread animationThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    repaint();
                    try {Thread.sleep(10);} catch (Exception ex) {}
                }
            }
        });

        animationThread.start();
    }
	

    public void paintComponent(Graphics g) {
        Graphics2D gg = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight();

        int wallW = 100;
        int wallH = 300;
        int wallSpeed = -5;

        int x = lastX + wallSpeed;

        if (x < -wallW + 5) { // when x is off the right side of the screen
        	// randomize the wall gap here
            x = w;	// x resets back to -width -100 to start again
        }

        gg.setColor(Color.BLACK);
        gg.fillRect(x, h/2 + wallH, wallW, wallH); // bottom
        gg.fillRect(x, 0, wallW, wallH + 300);				// top

        lastX = x;
    }
}
