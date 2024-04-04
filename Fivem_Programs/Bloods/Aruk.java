package Bloods;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Aruk extends Menu{
	public static int Pisztoly=100_000;
	public static int Tec9=150_000;
	public static int Micro_SMG=300_000;
	public static int Ap_Pisztoly=250_000;
	
	 static JLabel Pistoly_kep = new JLabel();
	 static JLabel Tec9_kep = new JLabel();
	 static JLabel Micro_SMG_kep = new JLabel();
	 static JLabel Ap_Pistoly_kep = new JLabel();
	
	
	public static int Pisztoly_Loszer=250;
	public static int SMG_Loszer=350;
	public static int Rifle_Loszer=550;
	public static int Shotgun_Loszer=550;
	
	static JLabel Pisztoly_szoveg = new JLabel("Pistol");
	static JLabel Ap_Pisztoly_szoveg = new JLabel("AP Pistol");
	
	
	static int Fegyver_szeles=90;
	static int Fegyver_magas=90;
	static JPanel Pisztoly_panel = new JPanel();
	static JPanel AP_Pisztoly_panel = new JPanel();
	
	static int Fegyver_Tavolsag = 20;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void Aruk_Futtat() {
		//Pisztoly kép és szöveg dekralizálása
		Pistoly_kep.setBounds(8, 5, Fegyver_szeles, Fegyver_magas);
		Pistoly_kep.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Fegvyerek/Pistol.png")));
		Pistoly_kep.setVisible(true);
		
		Pisztoly_szoveg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Pisztoly_szoveg.setHorizontalAlignment(SwingConstants.CENTER);
		Pisztoly_szoveg.setBounds(25, 98, 56, 25);
		Pisztoly_szoveg.setForeground(Color.white);
		
		//AP pisztoly kép és szöveg dekralizálása
		Ap_Pistoly_kep.setBounds(8, 5, Fegyver_szeles, Fegyver_magas);
		Ap_Pistoly_kep.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Fegvyerek/AP_Pistol.png")));
		Ap_Pistoly_kep.setVisible(true);
		
		Ap_Pisztoly_szoveg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Ap_Pisztoly_szoveg.setHorizontalAlignment(SwingConstants.CENTER);
		Ap_Pisztoly_szoveg.setBounds(5, 98, 100, 25);
		Ap_Pisztoly_szoveg.setForeground(Color.white);
		
		//Pisztoly panelhez aádsa
		Pisztoly_panel.setSize(Fegyver_szeles+16,Fegyver_magas+35);
		Pisztoly_panel.setLocation(20, 20);
		Pisztoly_panel.setLayout(null);
		Pisztoly_panel.add(Pistoly_kep);
		Pisztoly_panel.add(Pisztoly_szoveg);
		Pisztoly_panel.setBackground(new Color(50,50,50,200));
		
		//AP pisztoly panelhoz adása
		AP_Pisztoly_panel.setSize(Fegyver_szeles+17,Fegyver_magas+35);
		AP_Pisztoly_panel.setLocation((int)Pisztoly_panel.getLocation().getX()+Fegyver_szeles+36, (int)Pisztoly_panel.getLocation().getY());
		AP_Pisztoly_panel.setLayout(null);
		AP_Pisztoly_panel.add(Ap_Pistoly_kep);
		AP_Pisztoly_panel.add(Ap_Pisztoly_szoveg);
		AP_Pisztoly_panel.setBackground(new Color(50,50,50,200));
		
		
		Menu_panel.add(AP_Pisztoly_panel);
		Menu_panel.add(Pisztoly_panel);
		

		
	
		
		
		
		
		
	}
	

}
