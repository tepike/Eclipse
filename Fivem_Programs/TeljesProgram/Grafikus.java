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



public class Grafikus extends futattas {
	//Timer timer = new Timer(0, null);
	Scanner bevitel = new Scanner(System.in);
	private String felhasznalonev="test";
	private String jelszo="test";
	
	private int Ablak_Magas=600;
	private int Ablak_Szeles=800;
	JFrame keret= new JFrame();
	JPanel panel= new JPanel();
	private JTextField Felhasznalonev_TextFielad;
	private JPasswordField Jelszo_Textfield;

	/**
	 * @wbp.parser.entryPoint
	 */

	public void Ablakletrehoz() {
		int Screen_Magas=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int Screen_Szeles=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		keret.getContentPane().setLayout(null);
		panel.setSize(100,100);
		panel.setBounds(194, 279, 431, 166);
		panel.setBackground(new Color(200, 200, 200, 180));
		keret.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Felhasznalonev_Szoveg = new JLabel("Felhasználónév:");
		Felhasznalonev_Szoveg.setHorizontalAlignment(SwingConstants.RIGHT);
		Felhasznalonev_Szoveg.setBounds(10, 76, 146, 22);
		panel.add(Felhasznalonev_Szoveg);
		Felhasznalonev_Szoveg.setBackground(Color.LIGHT_GRAY);
		Felhasznalonev_Szoveg.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel Jelszo_Szoveg = new JLabel("Jelszó:");
		Jelszo_Szoveg.setHorizontalAlignment(SwingConstants.RIGHT);
		Jelszo_Szoveg.setFont(new Font("Tahoma", Font.BOLD, 18));
		Jelszo_Szoveg.setBackground(Color.LIGHT_GRAY);
		Jelszo_Szoveg.setBounds(10, 114, 146, 22);
		panel.add(Jelszo_Szoveg);
		
		JLabel BejelentkezoDoboz_Szoveg = new JLabel("Bejelentkezés");
		BejelentkezoDoboz_Szoveg.setHorizontalAlignment(SwingConstants.RIGHT);
		BejelentkezoDoboz_Szoveg.setFont(new Font("Tahoma", Font.BOLD, 18));
		BejelentkezoDoboz_Szoveg.setBackground(Color.LIGHT_GRAY);
		BejelentkezoDoboz_Szoveg.setBounds(137, 11, 146, 22);
		panel.add(BejelentkezoDoboz_Szoveg);
		
		Felhasznalonev_TextFielad = new JTextField();
		Felhasznalonev_TextFielad.setHorizontalAlignment(SwingConstants.CENTER);
		Felhasznalonev_TextFielad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Felhasznalonev_TextFielad.setBounds(166, 75, 209, 30);
		panel.add(Felhasznalonev_TextFielad);
		Felhasznalonev_TextFielad.setColumns(10);
		
		Jelszo_Textfield = new JPasswordField();
		Jelszo_Textfield.setHorizontalAlignment(SwingConstants.CENTER);
		Jelszo_Textfield.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Jelszo_Textfield.setToolTipText("");
		Jelszo_Textfield.setBounds(166, 113, 209, 30);
		panel.add(Jelszo_Textfield);
		
		JButton btnNewButton = new JButton("Bejelentkezés");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(Felhasznalonev_TextFielad.getText().equals(getFelhasznalonev())&&Jelszo_Textfield.getText().equals(getJelszo())) {
					System.out.println("Sikeres bejelentkezes");
				}else if(Felhasznalonev_TextFielad.getText().length()==0) {
					System.err.println("Nem adtal meg felhasznalo nevet");
				}else if (Jelszo_Textfield.getText().length()==0) {
					System.err.println("Nem adtal meg kodot");
				}else if(!Felhasznalonev_TextFielad.getText().equals(getFelhasznalonev())&&!Jelszo_Textfield.getText().equals(getJelszo())){
					System.err.println("Hibas bejelntkezesi adatok");
			}
			}
		});
		btnNewButton.setBackground(new Color(5, 173, 254));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(600, 504, 150, 30);
		keret.getContentPane().add(btnNewButton);
		
		JLabel Login_Hatterkep = new JLabel("");
		Login_Hatterkep.setBounds(0, 0, 784, 561);
		Login_Hatterkep.setHorizontalAlignment(SwingConstants.CENTER);
		Login_Hatterkep.setIcon(new ImageIcon(Grafikus.class.getResource("/TeljesProgram/kepek/Hatterkep.png")));
		keret.getContentPane().add(Login_Hatterkep);
		keret.setResizable(false);
		keret.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		keret.setLocation((Screen_Szeles/2-Ablak_Szeles/2), (Screen_Magas/2)-Ablak_Magas/2);
		keret.setSize(Ablak_Szeles, Ablak_Magas);
		keret.setVisible(true);
		System.out.println("Keret letrehozva");
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
