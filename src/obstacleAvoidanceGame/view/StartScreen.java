package obstacleAvoidanceGame.view;

import obstacleAvoidanceGame.Button;

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

		JFrame startFrame = new JFrame();
		Button startButton = new Button("   Start   ", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 150));
		Button powerupButton = new Button("Powerup", Color.CYAN, new Font(Font.SERIF, Font.PLAIN, 150));
		Button quitButton = new Button("  Quit  ", Color.RED, new Font(Font.SERIF, Font.PLAIN, 150));

		startButton.getButton().setPreferredSize(new Dimension(50,200));
		powerupButton.getButton().setPreferredSize(new Dimension(50,200));
		quitButton.getButton().setPreferredSize(new Dimension(50,200));

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


		startButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
		powerupButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
		quitButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);

		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		//startFrame.add(Box.createVerticalGlue());
		this.add(powerupButton.getButton());
		this.add(Box.createVerticalGlue());
		this.add(startButton.getButton());
		this.add(Box.createVerticalGlue());
		this.add(quitButton.getButton());
		//startFrame.add(Box.createVerticalGlue());


//		startFrame.setSize(1920, 1080); // don't necessarily need this anymore with setExtendedState
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // default stretches out to max resolution
//		startFrame.setUndecorated(true); // real full screen, have to press alt f4 to get out
		this.setTitle("Game Title"); // change to whatever title we want for the game
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	
	public static void main(String[] args) {
		StartScreen ss = new StartScreen();
	}
}
