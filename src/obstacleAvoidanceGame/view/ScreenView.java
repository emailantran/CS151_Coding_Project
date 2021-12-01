package obstacleAvoidanceGame.view;

import obstacleAvoidanceGame.message.*;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * Main frame in which start, playing game, and game over screens are added or hidden depending on status of game
 * @author blues
 *
 */
public class ScreenView extends JFrame {
    BlockingQueue<Message> queue;

    JPanel startScreen;
    JPanel difficultyScreen;
    PlayingGameScreen playingGameScreen;
    GameOverScreen gameOverScreen;

    WallComponent wallComponent;

    final int FRAME_HEIGHT = 1080;

    /**
     * constructor in order to set up layout of frame
     * @param queue
     */
    public ScreenView(BlockingQueue<Message> queue) {
        this.queue = queue;
        this.startScreen = new StartScreen(this.queue);
        this.difficultyScreen = new DifficultyScreen(this.queue);
        this.gameOverScreen = new GameOverScreen(this.queue);

        this.setLayout(new CardLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Obstacle Avoidance Game"); // change to whatever title we want for the game
        this.add(startScreen);
        this.add(difficultyScreen);
        this.add(gameOverScreen);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Initializes the game and sets up initial state of frame
     * @param playerXPos
     * @param playerYPos
     * @param x
     * @param y
     * @param width
     * @param height
     * @param gapSize
     */
    public void startGame(int playerXPos, int playerYPos, int[] x, int[] y, int[] width, int[] height, int gapSize) {
        this.setLayout(new CardLayout());
        wallComponent = new WallComponent(x, y, width, height, gapSize, FRAME_HEIGHT);
        playingGameScreen = new PlayingGameScreen(this.queue, playerXPos, playerYPos, wallComponent,0);
        this.add(playingGameScreen);
        startScreen.setVisible(false);
        difficultyScreen.setVisible(false);
        gameOverScreen.setVisible(false);
        playingGameScreen.setVisible(true);
    }

    /**
     * disposes frame when player wants to quit
     */
    public void quitGame() {
        this.dispose();
    }

    /**
     * sets up power up screen layout
     */
    public void goToPowerupScreen() {
        startScreen.setVisible(false);
        difficultyScreen.setVisible(true);
    }

    /**
     * sets up game over screen layout
     */
    public void goToGameOverScreen() {
        playingGameScreen.setVisible(false);
        gameOverScreen.setVisible(true);
    }

    /**
     * sets up start game screen layout
     */
    public void goToStartGameScreen() {
    	startScreen.setVisible(true);
    	difficultyScreen.setVisible(false);
    	playingGameScreen.setVisible(false);
    	gameOverScreen.setVisible(false);
    }

    /**
     * sets up start screen layout after game over
     */
    public void returnToStartScreen() {
    	difficultyScreen.setVisible(false);
        startScreen.setVisible(true);
    }

    public void activatePowerup1() {
        returnToStartScreen();
    }

    public void activatePowerup2() {
        returnToStartScreen();
    }

    public void activatePowerup3() {
        returnToStartScreen();
    }

    /**
     * updates player location and repaints player model
     * @param playerX
     * @param playerY
     */
    public void movePlayer(int playerX, int playerY) {
        playingGameScreen.updatePlayer(playerX, playerY);
        playingGameScreen.repaint();
    }

    /**
     * updates wall locations' and repaints them
     * @param x
     * @param y
     * @param width
     * @param height
     * @param gapSize
     */
    public void updateWalls(int[] x, int[] y, int[] width, int[] height, int gapSize) {
        wallComponent.UpdateWallComponent(x, y, width, height, gapSize, FRAME_HEIGHT);
        wallComponent.repaint();
    }

    /**
     * updates playing game screen score
     * @param score
     */
    public void updateScore(int score){
        playingGameScreen.updateScore(score);
    }
    
    /**
     * updates game over screen score
     * @param score
     */
    public void updateGameOverScore(int score) {
    	gameOverScreen.updateScore(score);
    }

    /**
     * stops timer of player game screen
     */
    public void stopTimer(){
        playingGameScreen.stopTimer();
    }
}
