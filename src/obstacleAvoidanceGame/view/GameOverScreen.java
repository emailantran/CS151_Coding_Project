package obstacleAvoidanceGame.view;

import obstacleAvoidanceGame.Button;

import java.awt.*;
import javax.swing.*;

/**
 *  This class is for the screen that the user sees when they lose, which lets them retry or quit the game.
 */
public class GameOverScreen {

    /**
     *  Constructor which creates the frame with a Restart and a Quit button, as well as a text area for
     *  the player's score.
     */
    public GameOverScreen() {
        JFrame gameOverFrame = new JFrame();
        final int FRAME_WIDTH = 1920;
        final int FRAME_HEIGHT = 1080;

        Button restartButton = new Button("Restart", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 14));
        restartButton.getButton().addActionListener(event -> {
        	gameOverFrame.dispose();
        	//StartScreen ss = new StartScreen();
        });
        
        Button quitButton = new Button("Quit", Color.RED, new Font(Font.SERIF, Font.PLAIN, 14));
        quitButton.getButton().addActionListener(event -> {
        	gameOverFrame.dispose();
        });
        
        JTextArea scoreArea = new JTextArea();
        scoreArea.setText("Your Final Score: " + 0);
        scoreArea.setEditable(false);

        gameOverFrame.setLayout(new FlowLayout());

        gameOverFrame.add(restartButton.getButton());
        gameOverFrame.add(scoreArea);
        gameOverFrame.add(quitButton.getButton());


        gameOverFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameOverFrame.setVisible(true);
    }

//    /**
//     * Method stub for restarting the game, will use the Restart Button to do so
//     */
//    private void RestartGame() {
//
//    }
//
//    /**
//     * Method stub for quitting the game, will use the Quit Button to do so
//     */
//    private void QuitGame() {
//
//    }

}
