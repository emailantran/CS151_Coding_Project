package obstacleAvoidanceGame.view;

import obstacleAvoidanceGame.model.DIFFWALL;
import obstacleAvoidanceGame.model.Wall;
import obstacleAvoidanceGame.model.PlayerModel;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;


/**
 * PlayingGame Screen will allow the player to play the game. The screen will contain the playing area, a quit button, and the score of the player.
 * @author blues
 *
 */
public class PlayingGameScreen extends JPanel {
	/**
	 * obstacles will hold objects of Model.Wall class to display on the game screen
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
		final int FRAME_WIDTH = 1920;
        final int FRAME_HEIGHT = 1080;
        
		this.setLayout(new BorderLayout());
        
        
        
        /**
         * text display for score
         */
        JTextPane scoreArea = new JTextPane();
        scoreArea.setText("Score: " + score);
        scoreArea.setEditable(false);
        scoreArea.setAlignmentX(FRAME_WIDTH);
        this.add(scoreArea, BorderLayout.NORTH);
//        this.add(scoreArea);
        
        JTextPane instructions = new JTextPane();
        instructions.setText("'W' to go up, 'S' to go down");
        instructions.setEditable(false);
        instructions.setAlignmentX(FRAME_WIDTH);
        this.add(instructions, BorderLayout.SOUTH);
        
    
        
        
        

       
		
		this.setFocusable(true);
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					pm.setyPos(-10);
					repaint();
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					pm.setyPos(10);
					repaint();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		DIFFWALL wall = new DIFFWALL();
		this.add(wall, BorderLayout.CENTER);
		
		
		this.setPreferredSize(new Dimension(1920,1080));
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
//		for (Wall w: obstacles) {
//			System.out.println(player.getxPos() + " " + player.getyPos());
//			if (player.getxPos() == w.getxPos() && player.getyPos() == w.getyPos()) {
//				System.out.println(w.getxPos() + " " + w.getyPos());
//				return true;
//			}
//		}
		return false;
		
	}
	
	
	public int getScore() {
		return score;
	}
	
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
//		frame.add(new PlayingGameScreen(), BorderLayout.CENTER);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
