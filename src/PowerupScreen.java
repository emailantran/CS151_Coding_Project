import javax.swing.*;
import java.awt.*;


public class PowerupScreen extends JFrame{
    public PowerupScreen() {
        JFrame powerUpScreen = new JFrame();
        final int FRAME_WIDTH = 540;
        final int FRAME_HEIGHT = 860;

        Button quitButton = new Button("Quit", Color.RED, new Font(Font.SERIF, Font.PLAIN, 75));
        Button power1Button = new Button("Power 1", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));
        Button power2Button = new Button("Power 2", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));
        Button power3Button = new Button("Power 3", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));
        Button power4Button = new Button("Power 4", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 75));

        power1Button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        power2Button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        power3Button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        power4Button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);

        powerUpScreen.setLayout(new BoxLayout(powerUpScreen.getContentPane(),BoxLayout.Y_AXIS));

        powerUpScreen.add(quitButton.getButton());
        powerUpScreen.add(Box.createVerticalGlue());
        powerUpScreen.add(power1Button.getButton());
        powerUpScreen.add(Box.createVerticalGlue());
        powerUpScreen.add(power2Button.getButton());
        powerUpScreen.add(Box.createVerticalGlue());
        powerUpScreen.add(power3Button.getButton());
        powerUpScreen.add(Box.createVerticalGlue());
        powerUpScreen.add(power4Button.getButton());

        powerUpScreen.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        powerUpScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        powerUpScreen.setVisible(true);
    }

    /**
     * Will implement actionListener that will switch to StartScreen when quit button is pressed.
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

    public static void main(String[] args) {
        PowerupScreen ss = new PowerupScreen();
    }
}
