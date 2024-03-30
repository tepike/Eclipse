package TeljesProgram;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;



public class Grafikus extends futattas{
	//Timer timer = new Timer(0, null);
	private int Ablak_Magas=600;
	private int Ablak_Szeles=800;
	JFrame keret= new JFrame();

	/**
	 * @wbp.parser.entryPoint
	 */

	public void Ablakletrehoz() {
		int Screen_Magas=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int Screen_Szeles=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		keret.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel Login_Hatterkep = new JLabel("");
		Login_Hatterkep.setHorizontalAlignment(SwingConstants.CENTER);
		Login_Hatterkep.setIcon(new ImageIcon(Grafikus.class.getResource("/TeljesProgram/kepek/Hatterkep.png")));
		keret.getContentPane().add(Login_Hatterkep);
		keret.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		keret.setLocation((Screen_Szeles/2-Ablak_Szeles/2), (Screen_Magas/2)-Ablak_Magas/2);
		keret.setSize(Ablak_Szeles, Ablak_Magas);
		keret.setVisible(true);
		
		System.out.println("Keret letrehozva");
	}

	
	
	public void kiir() {
		System.out.println("Keret letrehozas elindul");
	}


	public int getAblak_Magas() {
		return Ablak_Magas;
	}


	public void setAblak_Magas(int ablak_Magas) {
		Ablak_Magas = ablak_Magas;
	}


	public int getAblak_Szeles() {
		return Ablak_Szeles;
	}


	public void setAblak_Szeles(int ablak_Szeles) {
		Ablak_Szeles = ablak_Szeles;
	}
	

}
