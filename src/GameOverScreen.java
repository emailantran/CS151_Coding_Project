import java.awt.*;
import javax.swing.*;

public class GameOverScreen {

    public GameOverScreen() {
        JFrame gameOverFrame = new JFrame();
        final int FRAME_WIDTH = 1920;
        final int FRAME_HEIGHT = 1080;

        Button restartButton = new Button("Restart", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 14));
        Button quitButton = new Button("Quit", Color.RED, new Font(Font.SERIF, Font.PLAIN, 14));
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

    private void RestartGame() {

    }

    private void QuitGame() {

    }

    public static void main(String[] args) {
        GameOverScreen gos = new GameOverScreen();
    }
}
