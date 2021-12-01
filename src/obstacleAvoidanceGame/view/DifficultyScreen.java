package obstacleAvoidanceGame.view;

import obstacleAvoidanceGame.Button;
import obstacleAvoidanceGame.message.*;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * Screen that displays buttons which the player can select and adjust speed of walls depending on difficulty chosen
 * @author blues
 *
 */
public class DifficultyScreen extends JPanel{

    BlockingQueue<Message> queue;

    Button quitButton;
    Button easyButton;
    Button normalButton;
    Button hardButton;

    final int FRAME_WIDTH = 540;
    final int FRAME_HEIGHT = 860;

    /**
     * Constructor to initialize buttons, queue, and screen dimensions and format
     * @param queue
     */
    public DifficultyScreen(BlockingQueue<Message> queue) {
        this.queue = queue;

        this.quitButton = new Button("Quit", Color.RED, new Font(Font.SERIF, Font.PLAIN, 75));
        this.quitButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        this.easyButton = new Button("Easy", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));
        this.easyButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        this.normalButton = new Button("Normal", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));
        this.normalButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        this.hardButton = new Button("Hard", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));
        this.hardButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);

        quitButton.getButton().addActionListener(event -> {
            try {
                this.queue.put(new QuitDifficultyScreenMessage());
            } catch (InterruptedException exception) {
                //nothing
            }
        });

        easyButton.getButton().addActionListener(event -> {
            try {
                this.queue.put(new EasyDifficultyMessage());
            } catch (InterruptedException exception) {
                //nothing
            }
        });

        normalButton.getButton().addActionListener(event -> {
            try {
                this.queue.put(new NormalDifficultyMessage());
            } catch (InterruptedException exception) {
                //nothing
            }
        });

        hardButton.getButton().addActionListener(event -> {
            try {
                this.queue.put(new HardDifficultyMessage());
            } catch (InterruptedException exception) {
                //nothing
            }
        });

        /**
         * Formatting power up screen
         */
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(quitButton.getButton());
        this.add(Box.createVerticalGlue());
        this.add(easyButton.getButton());
        this.add(Box.createVerticalGlue());
        this.add(normalButton.getButton());
        this.add(Box.createVerticalGlue());
        this.add(hardButton.getButton());
        this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
    }
}