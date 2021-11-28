package obstacleAvoidanceGame.view;

import obstacleAvoidanceGame.Button;
import obstacleAvoidanceGame.message.*;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;


public class PowerupScreen extends JPanel{

    BlockingQueue<Message> queue;

    Button quitButton;
    Button power1Button;
    Button power2Button;
    Button power3Button;
    Button power4Button;

    final int FRAME_WIDTH = 540;
    final int FRAME_HEIGHT = 860;

    public PowerupScreen(BlockingQueue<Message> queue) {
        this.queue = queue;

        this.quitButton = new Button("Quit", Color.RED, new Font(Font.SERIF, Font.PLAIN, 75));
        this.quitButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        this.power1Button = new Button("Power 1", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));
        this.power1Button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        this.power2Button = new Button("Power 2", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));
        this.power2Button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        this.power3Button = new Button("Power 3", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));
        this.power3Button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        this.power4Button = new Button("Power 4", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));
        this.power4Button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);

        quitButton.getButton().addActionListener(event -> {
            try {
                this.queue.put(new QuitPowerupScreenMessage());
            } catch (InterruptedException exception) {
                //nothing
            }
        });

        power1Button.getButton().addActionListener(event -> {
            try {
                this.queue.put(new Powerup1Message());
            } catch (InterruptedException exception) {
                //nothing
            }
        });

        power2Button.getButton().addActionListener(event -> {
            try {
                this.queue.put(new Powerup2Message());
            } catch (InterruptedException exception) {
                //nothing
            }
        });

        power3Button.getButton().addActionListener(event -> {
            try {
                this.queue.put(new Powerup3Message());
            } catch (InterruptedException exception) {
                //nothing
            }
        });

        power4Button.getButton().addActionListener(event -> {
            try {
                this.queue.put(new Powerup4Message());
            } catch (InterruptedException exception) {
                //nothing
            }
        });


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(quitButton.getButton());
        this.add(Box.createVerticalGlue());
        this.add(power1Button.getButton());
        this.add(Box.createVerticalGlue());
        this.add(power2Button.getButton());
        this.add(Box.createVerticalGlue());
        this.add(power3Button.getButton());
        this.add(Box.createVerticalGlue());
        this.add(power4Button.getButton());
        this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
    }
}
