package obstacleAvoidanceGame.view;

import obstacleAvoidanceGame.Button;
import obstacleAvoidanceGame.message.Message;
import obstacleAvoidanceGame.message.QuitGameMessage;
import obstacleAvoidanceGame.message.RestartGameScreenMessage;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 *  This class is for the screen that the user sees when they lose, which lets them retry or quit the game.
 */
public class GameOverScreen extends JPanel{

    BlockingQueue<Message> queue;

    Button restartButton;
    Button quitButton;
    JTextField scoreArea;

    private int score;

    /**
     *  Constructor which creates the frame with a Restart and a Quit button, as well as a text area for
     *  the player's score.
     */
    public GameOverScreen(BlockingQueue<Message> queue) {
        this.queue = queue;
        this.score = 0;

        this.restartButton = new Button("Restart", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 200));
        this.restartButton.getButton().setPreferredSize(new Dimension(50, 200));
        this.restartButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        this.quitButton = new Button("Quit", Color.RED, new Font(Font.SERIF, Font.PLAIN, 200));
        this.quitButton.getButton().setPreferredSize(new Dimension(50, 200));
        this.quitButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);


        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        scoreArea = new JTextField();
        scoreArea.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        scoreArea.setText("Score: " + score);
        scoreArea.setEditable(false);
        scoreArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreArea.setHorizontalAlignment(JTextField.CENTER);

        this.add(restartButton.getButton());
        this.add(Box.createVerticalGlue());
        this.add(scoreArea);
        this.add(Box.createVerticalGlue());
        this.add(quitButton.getButton());



        quitButton.getButton().addActionListener(event -> {
            try {
                this.queue.put(new QuitGameMessage());
            } catch (InterruptedException exception) {
                //nothing
            }
        });

        restartButton.getButton().addActionListener(event -> {
            try {
                this.queue.put(new RestartGameScreenMessage());
            } catch (InterruptedException exception) {
                //nothing
            }
        });
    }
    
    /**
     * updates score text box on game over screen
     * @param score
     */
    public void updateScore(int score){
        this.score = score;
        scoreArea.setText("Score: " + score);
    }

}
