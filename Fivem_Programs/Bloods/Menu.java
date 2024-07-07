package Bloods;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class Menu extends Bejelentkezes{
	public static int Rendelesek_Adatbazis;
	public static int Rendelesek_Adatbazis_Kulonbseg;
	public static JPanel Menu_panel= new JPanel();
	public static JPanel Menu_Felso_panel= new JPanel();
	public static JPanel Menu_Osszesito_panel= new JPanel();
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void Menu_futtat() {
		Adatbazis.Rendelesek();
		
		Label_Kilepes.setForeground(Color.RED);
		Label_Kilepes.setBackground(new Color(255,100,100,100));
		Label_Kilepes.setOpaque(true);
		Menu_Osszesito_panel.setSize(200,665);
		Menu_Osszesito_panel.setLocation(1045, 15);
		Menu_Osszesito_panel.setBackground(new Color(0,0,0,100));
		
		Menu_Felso_panel.setSize(1000,60);
		Menu_Felso_panel.setLocation(35, 15);
		Menu_Felso_panel.setBackground(new Color(0,0,0,100));
		
		Menu_panel.setSize(1000,580);
		Menu_panel.setLocation(35, 100);
		Menu_panel.setBackground(new Color(0,0,0,100));
		
		Hatterkep_Keret.add(Menu_panel);
		
		Menu_panel.setLayout(null);
		Menu_Felso_panel.setLayout(null);
		Menu_Osszesito_panel.setLayout(null);
		
		
		Hatterkep_Keret.add(Menu_Felso_panel);
		Hatterkep_Keret.add(Menu_Osszesito_panel);
		Bejelentkezes.Bejelentkezes_bezar();
		keret.setSize((int)keret.getSize().getWidth()+700,(int)keret.getSize().getHeight()+100);
		keret.setLocation(((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-((int)keret.getSize().getWidth()/2)), ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-((int)keret.getSize().getHeight()/2));
		Label_Kilepes.setLocation((int)keret.getSize().width-48, 0);
		Hatterkep_Keret.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Menu_Hatterkep.jpg")));
		Hatterkep_Keret.setSize((int)keret.getSize().width,(int)keret.getSize().height);
		System.out.println(keret.getSize());
		
		Aruk.Aruk_Futtat();
		Adatbazis.Rendeles_darab();
		
		
		
		
		
	}
}
