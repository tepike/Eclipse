package TeljesProgram;

import javax.swing.JFrame;

public class futattas {
	public JFrame keret= new JFrame();
	public static void main(String[] args) {
		System.out.println("Main metodus elindul");
		Grafikus ablak = new Grafikus();
		ablak.Ablakletrehoz();
		ablak.kiir();
		
	}

}
