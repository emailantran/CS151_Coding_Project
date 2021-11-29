package obstacleAvoidanceGame.view;

import obstacleAvoidanceGame.message.*;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class ScreenView extends JFrame {
    BlockingQueue<Message> queue;

    JPanel startScreen;
    JPanel powerUpScreen;
    PlayingGameScreen playingGameScreen;

    WallComponent wallComponent;

    //JPanel gameOverScreen;
    
    GameOverScreen gameOverScreen;

    final int FRAME_HEIGHT = 1080;

    public ScreenView(BlockingQueue<Message> queue) {
        this.queue = queue;
        this.startScreen = new StartScreen(this.queue);
        this.powerUpScreen = new PowerupScreen(this.queue);
        this.gameOverScreen = new GameOverScreen(this.queue);

        this.setLayout(new CardLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // default stretches out to max resolution
//		startFrame.setUndecorated(true); // real full screen, have to press alt f4 to get out
        this.setTitle("Obstacle Avoidance Game"); // change to whatever title we want for the game
        this.add(startScreen);
        this.add(powerUpScreen);
        this.add(gameOverScreen);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startGame(int playerXPos, int playerYPos, int[] x, int[] y, int[] width, int[] height, int gapSize) {
        this.setLayout(new CardLayout());
        wallComponent = new WallComponent(x, y, width, height, gapSize, FRAME_HEIGHT);
        playingGameScreen = new PlayingGameScreen(this.queue, playerXPos, playerYPos, wallComponent,0);
        this.add(playingGameScreen);
        startScreen.setVisible(false);
        powerUpScreen.setVisible(false);
        gameOverScreen.setVisible(false);
        playingGameScreen.setVisible(true);
    }

    public void quitGame() {
        this.dispose();
    }

    public void goToPowerupScreen() {
        startScreen.setVisible(false);
        powerUpScreen.setVisible(true);
    }

    public void goToGameOverScreen() {
        playingGameScreen.setVisible(false);
        gameOverScreen.setVisible(true);
    }

    public void goToStartGameScreen() {
    	startScreen.setVisible(true);
    	powerUpScreen.setVisible(false);
    	playingGameScreen.setVisible(false);
    	gameOverScreen.setVisible(false);
    }

    public void returnToStartScreen() {
        powerUpScreen.setVisible(false);
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

    public void activatePowerup4() {
        returnToStartScreen();
    }

    public void movePlayer(int playerX, int playerY) {
        playingGameScreen.updatePlayer(playerX, playerY);
        playingGameScreen.repaint();
    }

    public void updateWalls(int[] x, int[] y, int[] width, int[] height, int gapSize) {
        wallComponent.UpdateWallComponent(x, y, width, height, gapSize, FRAME_HEIGHT);
        wallComponent.repaint();
    }

    public void updateScore(int score){
        playingGameScreen.updateScore(score);
    }
    
    public void updateGameOverScore(int score) {
    	gameOverScreen.updateScore(score);
    }

    public void stopTimer(){
        playingGameScreen.stopTimer();
    }
}
