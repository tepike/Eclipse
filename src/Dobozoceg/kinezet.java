package Dobozoceg;

import javax.swing.JPanel;

import Ablak.Gui;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;

public class kinezet extends JPanel {

	/**
	 * Create the panel.
	 */
	public kinezet() {
		setBackground(new Color(0, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(108, 132, 175, 162);
		add(panel);
		
		
		JLabel lblNewLabel = new JLabel("Test");
		panel.add(lblNewLabel);
		setVisible(true);

	}
	
	public static void main (String[] args) {
		new kinezet();
	}
}
