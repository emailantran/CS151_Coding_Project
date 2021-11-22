import java.awt.*;
import javax.swing.*;


/**
 * This class will allow users to either start or quit the game, or switch to the power up menu
 * @author blues
 *
 */
public class StartScreen extends JFrame{
	
	/**
	 * Constructor that creates a frame with Start, Quit, and Powerup button.
	 */
	public StartScreen() {
		//JFrame startFrame = new JFrame();
		Button startButton = new Button("Start", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 14));
		Button powerupButton = new Button("Powerup", Color.CYAN, new Font(Font.SERIF, Font.PLAIN, 14));
		Button quitButton = new Button("Quit", Color.RED, new Font(Font.SERIF, Font.PLAIN, 14));
		
		startButton.getButton().addActionListener(event -> {
//			PlayingGameScreen pgs = new PlayingGameScreen();

			startButton.getButton().setVisible(false);
			powerupButton.getButton().setVisible(false);
			quitButton.getButton().setVisible(false);

//			startFrame.remove(startButton.getButton());
//			startFrame.remove(powerupButton.getButton());
//			startFrame.remove(quitButton.getButton());
			this.add(new PlayingGameScreen());

			});
		quitButton.getButton().addActionListener(event -> {
			this.dispose();
		});
		powerupButton.getButton().addActionListener(event -> {
			startButton.getButton().setVisible(false);
			powerupButton.getButton().setVisible(false);
			quitButton.getButton().setVisible(false);
			this.add(new PowerupScreen());
		});
		
//		this.setLayout(new FlowLayout());
//		this.add(startButton.getButton());
//		this.add(powerupButton.getButton());
//		this.add(quitButton.getButton());
		

		
		
		
		this.setLayout(new FlowLayout());
		this.add(startButton.getButton());
		this.add(powerupButton.getButton());
		this.add(quitButton.getButton());
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // default stretches out to max resolution
		this.setTitle("Game Title"); // change to whatever title we want for the game
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		StartScreen ss = new StartScreen();
	}
}
