import java.awt.*;
import javax.swing.*;


/**
 * This class will allow users to either start or quit the game, or switch to the power up menu
 * @author blues
 *
 */
public class StartScreen {
	
	/**
	 * Constructor that creates a frame with Start, Quit, and Powerup button.
	 */
	public StartScreen() {
		JFrame startFrame = new JFrame();
		Button startButton = new Button("Start", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 14));
		Button powerupButton = new Button("Powerup", Color.CYAN, new Font(Font.SERIF, Font.PLAIN, 14));
		Button quitButton = new Button("Quit", Color.RED, new Font(Font.SERIF, Font.PLAIN, 14));
		
		startButton.getButton().addActionListener(event -> {
			startFrame.dispose();
			PlayingGameScreen pgs = new PlayingGameScreen();
			});
		quitButton.getButton().addActionListener(event -> startFrame.dispose());
		powerupButton.getButton().addActionListener(event -> {
			startFrame.dispose();
			PowerupScreen pus = new PowerupScreen();
		});
		
		
		startFrame.setLayout(new FlowLayout());
		startFrame.add(startButton.getButton());
		startFrame.add(powerupButton.getButton());
		startFrame.add(quitButton.getButton());
		
//		startFrame.setSize(1920, 1080); // don't necessarily need this anymore with setExtendedState
		startFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // default stretches out to max resolution
//		startFrame.setUndecorated(true); // real full screen, have to press alt f4 to get out
		startFrame.setTitle("Game Title"); // change to whatever title we want for the game
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.setVisible(true);
	}

	/*
	 * Not needed lmao, just using action listeners in the constructor
	 */
//	/**
//	 * Will implement actionListener that will switch to PlayingGameScreen when start button is pressed.
//	 */
//	private void StartGame() {
//		
//	}
//	
//	/**
//	 * Will implement actionListener that will close screen when quit button is pressed.
//	 */
//	private void QuitGame() {
//		
//	}
//	
//	/**
//	 * Will implement action listener that will open PowerupScreen when powerup button is pressed.
//	 */
//	private void PowerupMenu() {
//		
//	}
	
	
	public static void main(String[] args) {
		StartScreen ss = new StartScreen();
	}
}
