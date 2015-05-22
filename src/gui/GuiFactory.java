package gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * This Class holds all the methods use to create buttons, labels, etc.
 */

public class GuiFactory {

	public static void addButton(JPanel currentPanel, String buttonName, int x,
			int y, ActionListener newAction) {

		// creates new button
		JButton newButtonHandle = new JButton(buttonName);
		newButtonHandle.setForeground(new Color(51, 0, 0));
		newButtonHandle.setBackground(new Color(210, 180, 140));
		newButtonHandle.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN,
				47));
		Border emptyBorder = BorderFactory.createEmptyBorder();
		newButtonHandle.setBorder(emptyBorder);

		newButtonHandle.addActionListener(newAction);
		newButtonHandle.setBounds(x, y, 400, 105);
		newButtonHandle.setLayout(null);
		currentPanel.add(newButtonHandle);
		newButtonHandle.setVisible(true);

	}// end AddButton()

	public static void addPianoWhiteButton(JPanel currentPanel,
			String buttonName, int x, int y, ActionListener newAction) {

		JButton button = new JButton(buttonName);
		button.setBounds(296, 55, 51, 192);

		// empty border
		Border emptyBorder = BorderFactory.createEmptyBorder();
		button.setBorder(emptyBorder);

		// adds action listener
		button.addActionListener(newAction);
		currentPanel.add(button);
		
	}

	public static void addPianoBlackButton(JPanel currentPanel,
			String buttonName, int x, int y, ActionListener newAction) {

		// creates new button
		JButton button = new JButton(buttonName);
		button.setBounds(113, 55, 51, 75);

		// empty border
		Border emptyBorder = BorderFactory.createEmptyBorder();
		button.setBorder(emptyBorder);

		// adds action listener
		button.addActionListener(newAction);
		currentPanel.add(button);

	}// end AddButton()

}
