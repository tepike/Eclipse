package Bloods;

import java.awt.Color;

import javax.swing.JPanel;

public class Rendeles extends Menu {
	 static JPanel Rendeles_panel= new JPanel();
	
	
	public static void Rendeles_lathato()  {
		System.out.println("Rendeles betoltese");
		Menu_panel.setVisible(false);
		Menu_Osszesito_panel.setVisible(false);
		
		Hatterkep_Keret.add(Rendeles_panel);
		Rendeles_panel.setBounds(35, 100, 1250, 580);
		Rendeles_panel.setLayout(null);
		Rendeles_panel.setBackground(new Color(10,10,10,200));
		Rendeles_panel.setVisible(true);


	}
	
	public static void Bolt_lathato()  {
		System.out.println("Bolt betoltese");
		Menu_panel.setVisible(true);
		Menu_Osszesito_panel.setVisible(true);
		Rendeles_panel.setVisible(false);



	}

}
