import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * PlayingGame Screen will allow the player to play the game. The screen will contain the playing area, a quit button, and the score of the player.
 * @author blues
 *
 */
public class PlayingGameScreen extends JPanel {
	/**
	 * obstacles will hold objects of Wall class to display on the game screen
	 */
	private ArrayList<Wall> obstacles;
	
	public PlayerModel pm = new PlayerModel(230,100,100,100);
	
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
//		JFrame playingGameFrame = new JFrame();
//		final int FRAME_WIDTH = 1920;
//        final int FRAME_HEIGHT = 1080;
        
        /**
         * setting up layout of JFrame
         */
//        playingGameFrame.setLayout(new BorderLayout());
//        
//        JPanel dick = new JPanel();
        	
        
        /**
         * creating instance of quit button
         */
//        Button quitButton = new Button("Quit", Color.RED, new Font(Font.SERIF, Font.PLAIN, 14));
////        playingGameFrame.add(quitButton.getButton(), BorderLayout.SOUTH);
//        dick.add(quitButton.getButton());
//        playingGameFrame.add(dick, BorderLayout.SOUTH);
          
          

//        playingGameFrame.add(quitButton.getButton());
//        quitButton.getButton().addActionListener(event -> {
//        	playingGameFrame.dispose();
//        });
        
        
//        Button Button1 = new Button("Quit", Color.RED, new Font(Font.SERIF, Font.PLAIN, 14));
//        Button Button2 = new Button("Quit", Color.RED, new Font(Font.SERIF, Font.PLAIN, 14));
//        playingGameFrame.add(Button1.getButton(), BorderLayout.WEST);
//        playingGameFrame.add(Button2.getButton(), BorderLayout.WEST);

        
        
        
        /**
         * text display for score
         */
//        JTextPane scoreArea = new JTextPane();
//        scoreArea.setText("Score: " + score);
//        scoreArea.setEditable(false);
//        scoreArea.setAlignmentX(FRAME_WIDTH);
//        playingGameFrame.add(scoreArea, BorderLayout.NORTH);
//        playingGameFrame.add(scoreArea);
        
//        /**
//         * adding player to the screen
//         */
        
        
        
//        PlayerModel player = new PlayerModel(10, 100, 100, 100);
//        playingGameFrame.add(player);
//        
//        /**
//         * for future addition when wall is implmented
//         */
////        for (Wall w: obstacles) {
////        	playingGameFrame.add(w);
////        }
        
//        playingGameFrame.setSize(800, 800);
//        playingGameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        playingGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        playingGameFrame.setVisible(true);
//        System.out.println(playingGameFrame.getMaximizedBounds());
		this.setLayout(new BorderLayout());
		Button downButton = new Button("Down", Color.BLUE, new Font(Font.SERIF, Font.PLAIN, 14));
		downButton.getButton().addActionListener(event -> {
			pm.setyPos(10);
			this.repaint();
		});
		this.add(downButton.getButton(), BorderLayout.NORTH);
		this.add(new DIFFWALL());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		pm.draw(g);
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
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
//		Button downButton = new Button("Down", Color.BLUE, new Font(Font.SERIF, Font.PLAIN, 14));
//		downButton.getButton().addActionListener(event -> {
//			pm.setyPos(10);
//		});
		//frame.add(downButton.getButton(), BorderLayout.NORTH);
		//PlayingGameScreen pgs = new PlayingGameScreen();
		frame.add(new PlayingGameScreen(), BorderLayout.CENTER);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}