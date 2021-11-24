package obstacleAvoidanceGame.view;

import obstacleAvoidanceGame.Button;

import javax.swing.*;
import java.awt.*;


public class PowerupScreen extends JPanel{
	
    public PowerupScreen() {
      
        final int FRAME_WIDTH = 540;
        final int FRAME_HEIGHT = 860;

        Button quitButton = new Button("Quit", Color.RED, new Font(Font.SERIF, Font.PLAIN, 75));
        Button power1Button = new Button("Power 1", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));
        Button power2Button = new Button("Power 2", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));
        Button power3Button = new Button("Power 3", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));
        Button power4Button = new Button("Power 4", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));
        
        quitButton.getButton().addActionListener(event -> {
            this.setVisible(false);
        });

        power1Button.getButton().addActionListener(event -> {

            //Add power up functionality
            
            StartScreen ss = new StartScreen();
        });

        power2Button.getButton().addActionListener(event -> {

            //Add power up functionality

            StartScreen ss = new StartScreen();
        });

        power3Button.getButton().addActionListener(event -> {

            //Add power up functionality

            StartScreen ss = new StartScreen();
        });

        power4Button.getButton().addActionListener(event -> {

            //Add power up functionality

            StartScreen ss = new StartScreen();
        });

        quitButton.getButton().addActionListener(event -> {
            //powerUpFrame.dispose();
            StartScreen ss = new StartScreen();
        });

        power1Button.getButton().addActionListener(event -> {
            //powerUpFrame.dispose();

            //Add power up functionality
            
            StartScreen ss = new StartScreen();
        });

        power2Button.getButton().addActionListener(event -> {
            //powerUpFrame.dispose();

            //Add power up functionality

            StartScreen ss = new StartScreen();
        });

        power3Button.getButton().addActionListener(event -> {
            //powerUpFrame.dispose();

            //Add power up functionality

            StartScreen ss = new StartScreen();
        });

        power4Button.getButton().addActionListener(event -> {
            //powerUpFrame.dispose();

            //Add power up functionality

            StartScreen ss = new StartScreen();
        });

        power1Button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        power2Button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        power3Button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        power4Button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);


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
        this.setVisible(true);
    }

    /**
     * Will implement actionListener that will switch to View.StartScreen when quit button is pressed.
     */
    private void QuitMenu() {

    }

    /**
     * Will implement actionListener that will activate power1 when Power1 button is pressed.
     */
    private void Power1() {

    }

    /**
     * Will implement actionListener that will activate power2 when Power2 button is pressed.
     */
    private void Power2() {

    }

    /**
     * Will implement actionListener that will activate power3 when Power3 button is pressed.
     */
    private void Power3() {

    }

    /**
     * Will implement actionListener that will activate power4 when Power4 button is pressed.
     */
    private void Power4() {

    }

}
