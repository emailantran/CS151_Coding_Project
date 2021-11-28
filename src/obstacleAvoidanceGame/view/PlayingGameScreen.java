package obstacleAvoidanceGame.view;

<<<<<<< HEAD
import obstacleAvoidanceGame.message.*;
=======
import obstacleAvoidanceGame.model.PlayerModel;
import obstacleAvoidanceGame.model.WallComponent;
>>>>>>> main

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
<<<<<<< HEAD
import java.awt.geom.Ellipse2D;
import java.util.concurrent.BlockingQueue;
=======
import javax.swing.*;
>>>>>>> main

/**
 * PlayingGame Screen will allow the player to play the game. The screen will contain the playing area, a quit button, and the score of the player.
 * @author blues
 *
 */
public class PlayingGameScreen extends JPanel {
<<<<<<< HEAD

	BlockingQueue<Message> queue;

	Timer timer;

	int playerX;
	int playerY;

	WallComponent wallComponent;

	private int score;

	final int FRAME_WIDTH = 1920;
	final int FRAME_HEIGHT = 1080;

=======
	
	public PlayerModel pm = new PlayerModel(230,100,100,100);
	public PlayerModel pm2 = new PlayerModel(100, 100, 100, 100);
	
	private int score;
	
	final int FRAME_WIDTH = 1920;
    final int FRAME_HEIGHT = 1080;
	
>>>>>>> main
	/**
	 * Constructor setting up the layout of the playing game screen
	 */
	public PlayingGameScreen(BlockingQueue<Message> queue, int playerX, int playerY, WallComponent wallComponent) {
		this.queue = queue;
		this.wallComponent = wallComponent;
		this.playerX = playerX;
		this.playerY = playerY;

		/**
		 * score is set to 0 at beginning of game
		 */
		this.score = 0;


		this.setLayout(new BorderLayout());

		/**
		 * text display for score
		 */
<<<<<<< HEAD
		JTextPane scoreArea = new JTextPane();
		scoreArea.setText("Score: " + score);
		scoreArea.setEditable(false);
		scoreArea.setAlignmentX(FRAME_WIDTH);

		JTextPane instructions = new JTextPane();
		instructions.setText("'W' to go up, 'S' to go down");
		instructions.setEditable(false);
		instructions.setAlignmentX(FRAME_WIDTH);

		timer = new Timer(40, ae -> {
			try {
				this.queue.put(new UpdateWallMessage());
			} catch (InterruptedException exception) {
				//nothing
			}
		});

		timer.start();

=======
//		JFrame playingGameFrame = new JFrame();
		
        
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
        
    
>>>>>>> main
		
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					try {
						queue.put(new MoveUpMessage());
					} catch (InterruptedException exception) {
						//nothing
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					try {
						queue.put(new MoveDownMessage());
					} catch (InterruptedException exception) {
						//nothing
					}
				}
			}
		});
<<<<<<< HEAD

		this.add(scoreArea, BorderLayout.NORTH);
		this.add(instructions, BorderLayout.SOUTH);
		this.setFocusable(true);
		this.add(wallComponent); // adds all the walls to the screen
		this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
=======
			
		this.add(new WallComponent()); // adds all the walls to the screen
		this.setPreferredSize(new Dimension(1920,1080));
>>>>>>> main
	}

	public void updatePlayer(int x, int y) {
		this.playerX = x;
		this.playerY = y;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
<<<<<<< HEAD

		Graphics2D g2d = (Graphics2D) g;
		Ellipse2D.Double circle = new Ellipse2D.Double(this.playerX, this.playerY,100,100);

		g2d.setColor(Color.yellow);
		g2d.fill(circle);
=======
		pm.draw(g);
		
>>>>>>> main
	}



	/**
	 * will use x,y position of player model to detect collision with walls from obstacle instance variable
	 *
	 * @return returns true if x,y position coincides with x,y position of wall, false otherwise
	 */
	/*public boolean collisionDetected(PlayerModel player) {
		for (Wall w: obstacles) {
			System.out.println(player.getxPos() + " " + player.getyPos());
			if (player.getxPos() == w.getxPos() && player.getyPos() == w.getyPos()) {
				System.out.println(w.getxPos() + " " + w.getyPos());
				return true;
			}
		}
		return false;
	}*/


	public int getScore() {
		return score;
	}
<<<<<<< HEAD
=======
	
	
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

>>>>>>> main
}
