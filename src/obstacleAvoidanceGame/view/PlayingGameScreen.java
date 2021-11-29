package obstacleAvoidanceGame.view;

import obstacleAvoidanceGame.message.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.*;
import java.util.concurrent.BlockingQueue;


/**
 * PlayingGame Screen will allow the player to play the game. The screen will contain the playing area, a quit button, and the score of the player.
 * @author blues
 *
 */
public class PlayingGameScreen extends JPanel {

	BlockingQueue<Message> queue;

	Timer timer;
	Timer scoreTimer;

	int playerX;
	int playerY;

	WallComponent wallComponent;

	private int score;

	final int FRAME_WIDTH = 1920;
	final int FRAME_HEIGHT = 1080;
	JTextPane scoreArea = new JTextPane();

	/**
	 * Constructor setting up the layout of the playing game screen
	 */
	public PlayingGameScreen(BlockingQueue<Message> queue, int playerX, int playerY, WallComponent wallComponent,int score) {
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
		//JTextPane scoreArea = new JTextPane();
		scoreArea.setText("Score: " + score);
		scoreArea.setEditable(false);
		scoreArea.setAlignmentX(FRAME_WIDTH);

		JTextPane instructions = new JTextPane();
		instructions.setText("'W' to go up, 'S' to go down");
		instructions.setEditable(false);
		instructions.setAlignmentX(FRAME_WIDTH);

		timer = new Timer(10, ae -> {
			try {
				this.queue.put(new UpdateWallMessage());
				this.queue.put(new CollisionCheckMessage());
			} catch (InterruptedException exception) {
				//nothing
			}
		});

		timer.start();

		scoreTimer = new Timer(200, ae -> {
			try {
				this.queue.put(new ScoreCheckMessage());
			} catch (InterruptedException exception) {
				//nothing
			}
		});

		scoreTimer.start();

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

		this.add(scoreArea, BorderLayout.NORTH);
		this.add(instructions, BorderLayout.SOUTH);
		this.setFocusable(true);
		this.add(wallComponent); // adds all the walls to the screen
		this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
	}

	public void updatePlayer(int x, int y) {
		this.playerX = x;
		this.playerY = y;
	}

	public void updateScore(int score){
		this.score = score;
		scoreArea.setText("Score: " + score);
	}

	public void stopTimer(){
		timer.stop();
		scoreTimer.stop();
	}
	
	public int getScore() {
		return this.score;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		Rectangle2D.Double circle = new Rectangle2D.Double(this.playerX, this.playerY,100,100);

		g2d.setColor(Color.yellow);
		g2d.fill(circle);
	}
}

