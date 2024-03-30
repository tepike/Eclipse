package TeljesProgram;

import javax.swing.JPanel;

public class LoginPanel extends Grafikus {
	public void Bejelentkezo_Menu() {
		JPanel MenuPanel= new JPanel();
		MenuPanel.setSize(400,400);
		MenuPanel.setVisible(true);
		keret.add(MenuPanel);
		System.out.println("Valami");
	}

}
