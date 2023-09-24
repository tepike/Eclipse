package Ablak;

import javax.swing.JFrame;

public class Gui extends JFrame {
	
	
	Gui(){
		
	setSize(400,400);
	setVisible(true);

}
	public void update() {
		Gui.this.setVisible(true);
	}


public static void main (String[] args) {
	new Gui();
}
}
