package TeljesProgram;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.Scanner;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;



public class Grafikus extends futattas {
	//Timer timer = new Timer(0, null);
	Scanner bevitel = new Scanner(System.in);
	private String felhasznalonev="test";
	private String jelszo="test";
	
	private int Ablak_Magas=700;
	private int Ablak_Szeles=900;
	public static JFrame keret= new JFrame();


	public static JLabel Login_Hatterkep = new JLabel("");
	

	/**
	 * @throws InterruptedException 
	 * @wbp.parser.entryPoint
	 */

	public void Ablakletrehoz() throws InterruptedException {
		MenuPanel loginpanel = new MenuPanel();
		int Screen_Magas=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int Screen_Szeles=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		keret.getContentPane().setLayout(null);
		keret.setUndecorated(true);
		keret.add(Login_Hatterkep);

		
		keret.setResizable(false);
		keret.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		keret.setLocation((Screen_Szeles/2-Ablak_Szeles/2), (Screen_Magas/2)-Ablak_Magas/2);
		keret.setSize(Ablak_Szeles, Ablak_Magas);
		
		Login_Hatterkep.setBounds(0, 0, keret.getWidth(), keret.getHeight());
		Login_Hatterkep.setHorizontalAlignment(SwingConstants.CENTER);
		Login_Hatterkep.setIcon(new ImageIcon(Grafikus.class.getResource("/TeljesProgram/kepek/Hatterkep.png")));
		Login_Hatterkep.setVisible(true);
		keret.setVisible(true);
		
		System.out.println("Keret letrehozva");
		loginpanel.Bejelentkezo_Menu();

		
		
	}

	
	
	public void kiir() {
		System.out.println("Keret letrehozas elindul");
	}

	public void meretezesTiltas() {
		keret.setResizable(false);
		System.out.println("Kepernyo meretezes letiltva");
	}
	public void meretezesEnged() {
		System.out.println("Kepernyo meretezes engedelyezve");
		keret.setResizable(true);
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



	public String getFelhasznalonev() {
		return felhasznalonev;
	}



	public void setFelhasznalonev(String felhasznalonev) {
		this.felhasznalonev = felhasznalonev;
	}



	public String getJelszo() {
		return jelszo;
	}



	public void setJelszo(String jelszo) {
		this.jelszo = jelszo;
	}
	




}
