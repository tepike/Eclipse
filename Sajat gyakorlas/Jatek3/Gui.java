package Jatek3;

import javax.swing.JFrame;

public class Gui extends JFrame {
	
	
	Gui(){
		
	setSize(1920, 1080);
	setVisible(true);
	setLocationRelativeTo(null);

}
	public void update() {
		Gui.this.setVisible(true);
	}


public static void main (String[] args) {
	new Gui();
}
}
