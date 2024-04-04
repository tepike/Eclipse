package Bloods;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Aruk extends Menu{
	//Fegyver árak
	public static int Pisztoly=100_000;
	public static int Tec9=150_000;
	public static int Micro_SMG=300_000;
	public static int Ap_Pisztoly=250_000;
	
	//Lőszer árak
	static int Pisztoly_Loszer=250;
	static int SMG_Loszer=350;
	static int Rifle_Loszer=550;
	static int Shotgun_Loszer=550;
	
	//Craftolási plusszok
	static int Craftolsai_ido=13;

	
	//Egységenkénti craftolás összerakás darab
	static int Tec_9_osszerak_darab=3;
	static int Ap_pisztoly_osszerak_darab=4;
	static int Micro_SMG_osszerak_darab=4;
	static int Pisztoly_osszerak_darab=3;
	
	
	//Képek label
	static JLabel Pistoly_kep = new JLabel();
	static JLabel Tec9_kep = new JLabel();
	static JLabel Micro_SMG_kep = new JLabel();
	static JLabel Ap_Pistoly_kep = new JLabel();
	
	//Fegyvere nevek label
	static JLabel Pisztoly_szoveg = new JLabel("Pistol");
	static JLabel Ap_Pisztoly_szoveg = new JLabel("AP Pistol");
	static JLabel Tec9_szoveg = new JLabel("Tec-9");
	static JLabel Micro_SMG_szoveg = new JLabel("SMG");
	
	
	//Fegyver kep és szöveg panel
	static JPanel Pisztoly_panel = new JPanel();
	static JPanel AP_Pisztoly_panel = new JPanel();
	static JPanel Tec_9_panel = new JPanel();
	static JPanel Micro_SMG_panel = new JPanel();
	
	//Elhelyezés
	static int Fegyver_szeles=90;
	static int Fegyver_magas=90;
	static int Fegyver_Tavolsag = 50;
	
	//Mennyiseg panel
	static JPanel Mennyiseg_panel= new JPanel();
	
	//Mennyiseg megadas
	static JLabel Plusz =new JLabel();
	static JLabel Minusz = new JLabel();
	static JTextField Mennyiseg = new JTextField();
	
	
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
		
		//Tec-9 kép és szöveg dekralizálása
		Tec9_kep.setBounds(8, 5, Fegyver_szeles, Fegyver_magas);
		Tec9_kep.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Fegvyerek/Machine_Pistol.png")));
		Tec9_kep.setVisible(true);
		
		Tec9_szoveg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Tec9_szoveg.setHorizontalAlignment(SwingConstants.CENTER);
		Tec9_szoveg.setBounds(22, 98, 60, 25);
		Tec9_szoveg.setForeground(Color.white);
		
		//Micro SMG kép és szöveg dekralizálása
		Micro_SMG_kep.setBounds(8, 5, Fegyver_szeles, Fegyver_magas);
		Micro_SMG_kep.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Fegvyerek/Micro_SMG.png")));
		Micro_SMG_kep.setVisible(true);
		
		Micro_SMG_szoveg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Micro_SMG_szoveg.setHorizontalAlignment(SwingConstants.CENTER);
		Micro_SMG_szoveg.setBounds(22, 98, 60, 25);
		Micro_SMG_szoveg.setForeground(Color.white);
		
		
		//Pisztoly panelhez aádsa
		Pisztoly_panel.setSize(Fegyver_szeles+16,Fegyver_magas+35);
		Pisztoly_panel.setLocation(20, 20);
		Pisztoly_panel.setLayout(null);
		Pisztoly_panel.add(Pistoly_kep);
		Pisztoly_panel.add(Pisztoly_szoveg);
		Pisztoly_panel.setBackground(new Color(50,50,50,200));
		
		//AP pisztoly panelhoz adása
		AP_Pisztoly_panel.setSize(Fegyver_szeles+17,Fegyver_magas+35);
		AP_Pisztoly_panel.setLocation((int)Pisztoly_panel.getLocation().getX()+Fegyver_szeles+Fegyver_Tavolsag, (int)Pisztoly_panel.getLocation().getY());
		AP_Pisztoly_panel.setLayout(null);
		AP_Pisztoly_panel.add(Ap_Pistoly_kep);
		AP_Pisztoly_panel.add(Ap_Pisztoly_szoveg);
		AP_Pisztoly_panel.setBackground(new Color(50,50,50,200));
		
		//Tec-9 panelhoz adása
		Tec_9_panel.setSize(Fegyver_szeles+17,Fegyver_magas+35);
		Tec_9_panel.setLocation((int)AP_Pisztoly_panel.getLocation().getX()+Fegyver_szeles+Fegyver_Tavolsag, (int)AP_Pisztoly_panel.getLocation().getY());
		Tec_9_panel.setLayout(null);
		Tec_9_panel.add(Tec9_kep);
		Tec_9_panel.add(Tec9_szoveg);
		Tec_9_panel.setBackground(new Color(50,50,50,200));
		
		//Micro SMG panelhoz adása
		Micro_SMG_panel.setSize(Fegyver_szeles+17,Fegyver_magas+35);
		Micro_SMG_panel.setLocation((int)Tec_9_panel.getLocation().getX()+Fegyver_szeles+Fegyver_Tavolsag, (int)Tec_9_panel.getLocation().getY());
		Micro_SMG_panel.setLayout(null);
		Micro_SMG_panel.add(Micro_SMG_kep);
		Micro_SMG_panel.add(Micro_SMG_szoveg);
		Micro_SMG_panel.setBackground(new Color(50,50,50,200));
		
		
		//Mennyiség 
		Mennyiseg_panel.setBounds(200, 200, 100, 100);
		Plusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Plusz.png")));
		
		Mennyiseg_panel.add(Plusz);
		
		
		Mennyiseg.setBounds(300, 300, 50, 30);
		Mennyiseg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Mennyiseg.setHorizontalAlignment(SwingConstants.RIGHT);
		Mennyiseg.setText("0");
		Mennyiseg.setEditable(false);
		
		Menu_panel.add(Pisztoly_panel);
		Menu_panel.add(AP_Pisztoly_panel);
		Menu_panel.add(Tec_9_panel);
		Menu_panel.add(Micro_SMG_panel);
		Menu_panel.add(Mennyiseg_panel);
		
		
	
		
		
		
		
		
	}
	

}
