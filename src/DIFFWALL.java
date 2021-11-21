import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DIFFWALL extends JComponent {
	final int GAP_SIZE = 250;
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
                    try {Thread.sleep(5andre0);} catch (Exception ex) {}
                }
            }
        });

        animationThread.start();
    }
	

    public void paintComponent(Graphics g) {
        Graphics2D gg = (Graphics2D) g;

        
        // use a ticks thing?
        
        int w = getWidth();
        int h = getHeight();

        int wallW = 100;
        height = 300;
        int wallSpeed = -20;

        xPos = lastX + wallSpeed;
        
        Random rand = new Random();
    	int randomHeight = rand.nextInt(MAX_HEIGHT) + MIN_HEIGHT; // height range of 100-600
    	

        if (xPos < -wallW + 5) { // when x is off the right side of the screen
        	// randomize the wall gap here
        	height = randomHeight;
            xPos = w;	// x resets back to -width -100 to start again
        }
        
        

        gg.setColor(Color.BLACK);
        gg.fillRect(xPos, 0, wallW, height);		// top
        gg.fillRect(xPos, height + GAP_SIZE, wallW, FRAME_HEIGHT - height); // bottom
        

        lastX = xPos;
    }
}
