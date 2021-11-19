import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * PlayingGame Screen will allow the player to play the game. The screen will contain the playing area, a quit button, and the score of the player.
 * @author blues
 *
 */
public class PlayingGameScreen {
	/**
	 * obstacles will hold objects of Wall class to display on the game screen
	 */
	private ArrayList<Wall> obstacles;
	
	private int score;
	
	
	/**
	 * Constructor setting up the layout of the playing game screen
	 */
	public PlayingGameScreen() {
		/**
		 * score is set to 0 at beginning of game
		 */
		score = 0;
		
		/**
		 * setting up JFrame
		 */
		JFrame playingGameFrame = new JFrame();
		final int FRAME_WIDTH = 1920;
        final int FRAME_HEIGHT = 1080;
        
        /**
         * setting up layout of JFrame
         */
        playingGameFrame.setLayout(new BorderLayout());
        
        /**
         * creating instance of quit button
         */
        Button quitButton = new Button("Quit", Color.RED, new Font(Font.SERIF, Font.PLAIN, 14));
        playingGameFrame.add(quitButton.getButton(), BorderLayout.SOUTH);
        quitButton.getButton().addActionListener(event -> {
        	playingGameFrame.dispose();
        });
        
        /**
         * text display for score
         */
        JTextPane scoreArea = new JTextPane();
        scoreArea.setText("Score: " + score);
        scoreArea.setEditable(false);
        scoreArea.setAlignmentX(FRAME_WIDTH);
        playingGameFrame.add(scoreArea, BorderLayout.NORTH);
        
//        /**
//         * adding player to the screen
//         */
//        playingGameFrame.add(player, BorderLayout.CENTER);
//        
//        /**
//         * for future addition when wall is implmented
//         */
////        for (Wall w: obstacles) {
////        	playingGameFrame.add(w);
////        }
        
        playingGameFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        playingGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playingGameFrame.setVisible(true);
	}
	
	/**
	 * will use x,y position of player model to detect collision with walls from obstacle instance variable
	 * @param player -> player model
	 * @return returns true if x,y position coincides with x,y position of wall, false otherwise
	 */
	public boolean collisionDetected(PlayerModel player) {
		for (Wall w: obstacles) {
			System.out.println(player.getxPos() + " " + player.getyPos());
			if (player.getxPos() == w.getxPos() && player.getyPos() == w.getyPos()) {
				System.out.println(w.getxPos() + " " + w.getyPos());
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * checks if wall is passed by player without dying and adds 1 point to score
	 * @return returns true of wall is passed and adds 1 to score, returns false otherwise
	 */
	public boolean wallPassed() {
		return false;
		
	}
	
	/**
	 * will create walls to add to obstacle instance variable
	 */
	public void createWalls() {
		
	}
	
	/**
	 * getter for score variable
	 * @return returns score value
	 */
	public int getScore() {
		return score;
	}
	
	
	
	
	public static void main(String[] args) {
//		PlayerModel player = new PlayerModel(10,100,100,100);
//		ArrayList<Wall> obstacles = new ArrayList<Wall>();
//		Wall w = new Wall(30,30, 20,20);
//		obstacles.add(w);
		PlayingGameScreen pgs = new PlayingGameScreen();
	}
}
