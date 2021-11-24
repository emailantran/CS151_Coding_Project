package obstacleAvoidanceGame;

import java.awt.*;
import javax.swing.*;

/**
 * This class is an outline for all further buttons created for the game. Takes text color and font input.
 * @author blues
 *
 */
public class Button {
	/**
	 * declaring button outside to be able to return it.
	 */
	private JButton button;
	
	/**
	 * Constructor to set text, color, and font of button
	 * @param text Text of button
	 * @param color Color of button
	 * @param font Font of button
	 */
	public Button (String text, Color color, Font font) {
		button = new JButton(text);
		button.setBackground(color);
		button.setFont(font);
	}
	
	/**
	 * Method returns button object
	 * @return returns button object
	 */
	public JButton getButton() {
		return button;
	}
}
