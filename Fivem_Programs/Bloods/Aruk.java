package Bloods;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Aruk extends Menu{
	//Fegyver árak
	public static int Pisztoly_ar=100_000;
	public static int Tec9_ar=150_000;
	public static int Micro_SMG_ar=300_000;
	public static int Ap_Pisztoly_ar=250_000;

	//Craftolási plusszok
	static int Alapanyag_craftolsai_ido=13;
	static int Fegyver_craftolsai_ido=20;
	
	//Fegyver súlyok
	static double Pisztoly_suly=0.97;
	static double Tec9_suly=1.4;
	static double Micro_SMG_suly=4;
	static double AP_pisztoly_suly=1.22;
	
	//Lőszer súlyok
	static double Pisztoly_Loszer_Suly=0.003;
	static double SMG_Loszer_Suly=0.003;
	static double Rifle_Loszer_Suly=0.010;
	static double Shotgun_Loszer_Suly=0.030;
	static double MG_Loszer_Suly=0.030;
	
	static JLabel Pisztoly_suly_label= new JLabel("Pisztoly súlya 970gramm craftolható: 22db");

	//Egységenkénti craftolás összerakás darab
	static int Tec_9_osszerak_darab=3;
	static int Ap_pisztoly_osszerak_darab=4;
	static int Micro_SMG_osszerak_darab=4;
	static int Pisztoly_osszerak_darab=3;
	
	static int Craft_Szukseglet=1;
	
	
	//Fegyver képek label
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
	
	//Fegyver_Mennyiseg panel
	static JPanel Pistoly_Mennyiseg_panel= new JPanel();
	static JPanel AP_Pistoly_Mennyiseg_panel= new JPanel();
	static JPanel Tec9_Mennyiseg_panel= new JPanel();
	static JPanel Micro_SMG_Mennyiseg_panel= new JPanel();
	
	static JLabel Pistoly_Plusz =new JLabel();
	static JLabel Pistoly_Minusz = new JLabel();
	static JTextField Pistoly_Mennyiseg = new JTextField();
	
	static JLabel AP_Pistoly_Plusz =new JLabel();
	static JLabel AP_Pistoly_Minusz = new JLabel();
	static JTextField AP_Pistoly_Mennyiseg = new JTextField();
	
	static JLabel Tec9_Plusz =new JLabel();
	static JLabel Tec9_Minusz = new JLabel();
	static JTextField Tec9_Mennyiseg = new JTextField();
	
	static JLabel Micro_SMG_Plusz =new JLabel();
	static JLabel Micro_SMG_Minusz = new JLabel();
	static JTextField Micro_SMG_Mennyiseg = new JTextField();
	
	
	
	
	
	
	//Összegző_panel + felirat
	static JPanel Fegyver_Osszegzo_Panel= new JPanel();
	static JLabel Fegyver_Osszegzo_Label = new JLabel("Fegyver összes adat");
	static JLabel Fegyver_Osszegzo_Suly_Label= new JLabel("Súly:");
	static JLabel Fegyver_Osszegzo_Sulykg_Label= new JLabel("0");
	static JLabel Fegyver_Osszegzo_Anyagok_Label = new JLabel("Szükséges anyagok:");
	static JLabel Fegyver_Osszegzo_Ar_Label = new JLabel("Ár:");
	static JLabel Fegyver_Osszegzo_Armenny_Label = new JLabel("0");
	static JLabel Fegyver_Osszegzo_Acel_Label= new JLabel("Acél:");
	static JLabel Fegyver_Osszegzo_Vas_Label= new JLabel("Vas:");
	static JLabel Fegyver_Osszegzo_Rez_Label= new JLabel("Réz:");
	static JLabel Fegyver_Osszegzo_Aceldb_Label= new JLabel("0");
	static JLabel Fegyver_Osszegzo_Vasdb_Label= new JLabel("0");
	static JLabel Fegyver_Osszegzo_Rezdb_Label= new JLabel("0");
	static JLabel Fegyver_Osszegzo_Craft_Label= new JLabel("Craftolás:");
	static JLabel Fegyver_Osszegzo_Craft_ora_Label= new JLabel("0");
	static JLabel Fegyver_Osszegzo_Craft_perc_Label= new JLabel("0");
	static JLabel Fegyver_Osszegzo_Craft_masodperc_Label= new JLabel("0");
	
	static JPanel Loszer_Osszegzo_Panel= new JPanel();
	static JLabel Loszer_Osszegzo_Label = new JLabel("Lőszer összes adat");
	static JLabel Loszer_Osszegzo_Suly_Label= new JLabel("Súly:");
	static JLabel Loszer_Osszegzo_Sulykg_Label= new JLabel("0");
	static JLabel Loszer_Osszegzo_Anyagok_Label = new JLabel("Szükséges anyagok:");
	static JLabel Loszer_Osszegzo_Ar_Label = new JLabel("Ár:");
	static JLabel Loszer_Osszegzo_Armenny_Label = new JLabel("0");
	static JLabel Loszer_Osszegzo_Acel_Label= new JLabel("Acél:");
	static JLabel Loszer_Osszegzo_Vas_Label= new JLabel("Vas:");
	static JLabel Loszer_Osszegzo_Rez_Label= new JLabel("Réz:");
	static JLabel Loszer_Osszegzo_Aceldb_Label= new JLabel("0");
	static JLabel Loszer_Osszegzo_Vasdb_Label= new JLabel("0");
	static JLabel Loszer_Osszegzo_Rezdb_Label= new JLabel("0");
	static JLabel Loszer_Osszegzo_Craft_Label= new JLabel("Craftolás:");
	static JLabel Loszer_Osszegzo_Craft_ora_Label= new JLabel("0");
	static JLabel Loszer_Osszegzo_Craft_perc_Label= new JLabel("0");
	static JLabel Loszer_Osszegzo_Craft_masodperc_Label= new JLabel("0");
	
	static JPanel Osszes_Osszegzo_Panel= new JPanel();
	static JLabel Osszes_Osszegzo_Label = new JLabel("Teljes adat");
	static JLabel Osszes_Osszegzo_Suly_Label= new JLabel("Súly össz:");
	static JLabel Osszes_Osszegzo_Sulykg_Label= new JLabel("0");
	static JLabel Osszes_Osszegzo_Anyagok_Label = new JLabel("Szükséges anyagok:");
	static JLabel Osszes_Osszegzo_Ar_Label = new JLabel("Ár össz:");
	static JLabel Osszes_Osszegzo_Armenny_Label = new JLabel("0");
	static JLabel Osszes_Osszegzo_Acel_Label= new JLabel("Acél:");
	static JLabel Osszes_Osszegzo_Vas_Label= new JLabel("Vas:");
	static JLabel Osszes_Osszegzo_Rez_Label= new JLabel("Réz:");
	static JLabel Osszes_Osszegzo_Aceldb_Label= new JLabel("0");
	static JLabel Osszes_Osszegzo_Vasdb_Label= new JLabel("0");
	static JLabel Osszes_Osszegzo_Rezdb_Label= new JLabel("0");
	static JLabel Osszes_Osszegzo_Craft_Label= new JLabel("Craftolás össz:");
	static JLabel Osszes_Osszegzo_Craft_ora_Label= new JLabel("0");
	static JLabel Osszes_Osszegzo_Craft_perc_Label= new JLabel("0");
	static JLabel Osszes_Osszegzo_Craft_masodperc_Label= new JLabel("0");
	
	//Lőszer_Mennyiseg panel
	static int Pisztoly_Loszer_Acel=10;
	static int SMG_Loszer_Acel=15;
	static int Rifle_Loszer_Acel=25;
	
	static int Pisztoly_Loszer_Ar=250;
	static int SMG_Loszer_Ar=350;
	static int MG_Loszer_Ar=650;
	static int Rifle_Loszer_Ar=550;
	static int Shotgun_Loszer_Ar=550;
	
	
	static JPanel Pisztoly_Loszer_Panel = new JPanel();
	static JPanel SMG_Loszer_Panel = new JPanel();
	static JPanel Shotgun_Loszer_Panel = new JPanel();
	static JPanel Rifle_Loszer_Panel = new JPanel();
	static JPanel MG_Loszer_Panel = new JPanel();
	
	static JLabel Shotgun_Loszer_Kep=new JLabel();
	static JLabel Pisztoly_Loszer_Kep=new JLabel();
	static JLabel SMG_Loszer_Kep=new JLabel();
	static JLabel Rifle_Loszer_Kep=new JLabel();
	static JLabel MG_Loszer_Kep=new JLabel();
	
	static JLabel Shotgun_Loszer_Szoveg=new JLabel("Shotgun");
	static JLabel Pisztoly_Loszer_Szoveg=new JLabel("Pistoly");
	static JLabel SMG_Loszer_Szoveg=new JLabel("SMG");
	static JLabel Rifle_Loszer_Szoveg=new JLabel("Rifle");
	static JLabel MG_Loszer_Szoveg=new JLabel("MG");

	
	static JPanel Pisztoly_Loszer_Mennyiseg_panel= new JPanel();
	static JLabel Pisztoly_Loszer_Plusz =new JLabel();
	static JLabel Pisztoly_Loszer_Minusz = new JLabel();
	static JTextField Pisztoly_Loszer_Mennyiseg = new JTextField();
	
	static JPanel SMG_Loszer_Mennyiseg_panel= new JPanel();
	static JLabel SMG_Loszer_Plusz =new JLabel();
	static JLabel SMG_Loszer_Minusz = new JLabel();
	static JTextField SMG_Loszer_Mennyiseg = new JTextField();
	
	static JPanel Shotgun_Loszer_Mennyiseg_panel= new JPanel();
	static JLabel Shotgun_Loszer_Plusz =new JLabel();
	static JLabel Shotgun_Loszer_Minusz = new JLabel();
	static JTextField Shotgun_Loszer_Mennyiseg = new JTextField();
	
	static JPanel Rifle_Loszer_Mennyiseg_panel= new JPanel();
	static JLabel Rifle_Loszer_Plusz =new JLabel();
	static JLabel Rifle_Loszer_Minusz = new JLabel();
	static JTextField  Rifle_Loszer_Mennyiseg = new JTextField();
	
	static JPanel MG_Loszer_Mennyiseg_panel= new JPanel();
	static JLabel MG_Loszer_Plusz =new JLabel();
	static JLabel MG_Loszer_Minusz = new JLabel();
	static JTextField MG_Loszer_Mennyiseg = new JTextField();
	
	
	static JButton Reset_gomb=new JButton("Reset");
	
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void Aruk_Futtat() {
		
		//Pisztoly kép és szöveg dekralizálása
		Pistoly_kep.setBounds(8, 5, Fegyver_szeles, Fegyver_magas);
		Pistoly_kep.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Pistol.png")));
		Pistoly_kep.setVisible(true);
		
		Pisztoly_szoveg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Pisztoly_szoveg.setHorizontalAlignment(SwingConstants.CENTER);
		Pisztoly_szoveg.setBounds(25, 98, 56, 25);
		Pisztoly_szoveg.setForeground(Color.white);
		
		//AP pisztoly kép és szöveg dekralizálása
		Ap_Pistoly_kep.setBounds(8, 5, Fegyver_szeles, Fegyver_magas);
		Ap_Pistoly_kep.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/AP_Pistol.png")));
		Ap_Pistoly_kep.setVisible(true);
		
		Ap_Pisztoly_szoveg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Ap_Pisztoly_szoveg.setHorizontalAlignment(SwingConstants.CENTER);
		Ap_Pisztoly_szoveg.setBounds(5, 98, 100, 25);
		Ap_Pisztoly_szoveg.setForeground(Color.white);
		
		//Tec-9 kép és szöveg dekralizálása
		Tec9_kep.setBounds(8, 5, Fegyver_szeles, Fegyver_magas);
		Tec9_kep.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Machine_Pistol.png")));
		Tec9_kep.setVisible(true);
		
		Tec9_szoveg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Tec9_szoveg.setHorizontalAlignment(SwingConstants.CENTER);
		Tec9_szoveg.setBounds(22, 98, 60, 25);
		Tec9_szoveg.setForeground(Color.white);
		
		//Micro SMG kép és szöveg dekralizálása
		Micro_SMG_kep.setBounds(8, 5, Fegyver_szeles, Fegyver_magas);
		Micro_SMG_kep.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Micro_SMG.png")));
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
		
	
		
		Reset_gomb.setBounds(900, 530, 80, 30);
		Reset_gomb.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Reset");
				Pistoly_Mennyiseg.setText("0");
				AP_Pistoly_Mennyiseg.setText("0");
				Tec9_Mennyiseg.setText("0");
				Micro_SMG_Mennyiseg.setText("0");
				Fegyver_Frissites();
				
				Pisztoly_Loszer_Mennyiseg.setText("0");
				SMG_Loszer_Mennyiseg.setText("0");
				MG_Loszer_Mennyiseg.setText("0");
				Rifle_Loszer_Mennyiseg.setText("0");
				Shotgun_Loszer_Mennyiseg.setText("0");
				Loszer_Frissites();

		}});
		
		
		
		//Mennyiség 
		kiegeszitok_hozzadasa();
		
		

		//Fegyver panelhez adása
		Menu_panel.add(Pisztoly_panel);
		Menu_panel.add(AP_Pisztoly_panel);
		Menu_panel.add(Tec_9_panel);
		Menu_panel.add(Micro_SMG_panel);
		
		//Fegyver mennyiség panelhez adása
		Menu_panel.add(Pistoly_Mennyiseg_panel);
		Menu_panel.add(AP_Pistoly_Mennyiseg_panel);
		Menu_panel.add(Tec9_Mennyiseg_panel);
		Menu_panel.add(Micro_SMG_Mennyiseg_panel);
		
		//Lőszerek panelhez adása
		Menu_panel.add(Pisztoly_Loszer_Panel);
		Menu_panel.add(SMG_Loszer_Panel);
		Menu_panel.add(MG_Loszer_Panel);
		Menu_panel.add(Shotgun_Loszer_Panel);
		Menu_panel.add(Rifle_Loszer_Panel);
		
		//Lőszer mennyiseg panelhez adása
		Menu_panel.add(Pisztoly_Loszer_Mennyiseg_panel);
		Menu_panel.add(SMG_Loszer_Mennyiseg_panel);
		Menu_panel.add(MG_Loszer_Mennyiseg_panel);
		Menu_panel.add(Rifle_Loszer_Mennyiseg_panel);
		Menu_panel.add(Shotgun_Loszer_Mennyiseg_panel);
		
		Menu_panel.add(Reset_gomb);
	
		
	}
	
	//Átláthatóságot segítő részek
	
	private static void kiegeszitok_hozzadasa() {
		Osszegzo_Panel_Letrehozas();
		
		Pisztoly_Megadas();
		AP_Pisztoly_Megadas();
		Tec9_Megadas();
		Micro_SMG_Megadas();
		Fegyver_Osszegzo_Panel_Feltoltes();
		
		Pisztoly_Loszer_Megadas();
		SMG_Loszer_Megadas();
		MG_Loszer_Megadas();
		Rifle_Loszer_Megadas();
		Shotgun_Loszer_Megadas();
		Loszer_Osszegzo_Panel_Feltoltes();
		
		Osszes_Panel_Feltoltes();
		Osszes_Panel_Frissites(); 
		
	}
	//Panelok alap szöveggel ellátása
	private static void Osszegzo_Panel_Letrehozas() {
		//Összegző panel kitöltés
		Fegyver_Osszegzo_Panel.setBackground(new Color(50,50,50,150));
		Fegyver_Osszegzo_Panel.setBounds(5,5,190,215);
		Fegyver_Osszegzo_Panel.setLayout(null);
		
		Fegyver_Osszegzo_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		Fegyver_Osszegzo_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Label.setBounds(5, 3, 190, 30);
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Label);
		
		
		Loszer_Osszegzo_Panel.setBackground(new Color(50,50,50,150));
		Loszer_Osszegzo_Panel.setBounds(5,227,190,215);
		Loszer_Osszegzo_Panel.setLayout(null);
		
		Loszer_Osszegzo_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		Loszer_Osszegzo_Label.setForeground(Color.white);
		Loszer_Osszegzo_Label.setBounds(10, 0, 190, 30);
		Loszer_Osszegzo_Panel.add(Loszer_Osszegzo_Label);
		
		Osszes_Osszegzo_Panel.setBackground(new Color(50,50,50,150));
		Osszes_Osszegzo_Panel.setBounds(5,450,190,210);
		Osszes_Osszegzo_Panel.setLayout(null);
		
		Osszes_Osszegzo_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		Osszes_Osszegzo_Label.setForeground(Color.white);
		Osszes_Osszegzo_Label.setBounds(45, 0, 190, 30);
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Label);
		
		Menu_Osszesito_panel.add(Fegyver_Osszegzo_Panel);
		Menu_Osszesito_panel.add(Loszer_Osszegzo_Panel);
		Menu_Osszesito_panel.add(Osszes_Osszegzo_Panel);
	}
	
	//Fegyver panel alap szöveggel feltöltése
	private static void Fegyver_Osszegzo_Panel_Feltoltes() {
		//Fegyver_Osszegzo_Label.setBounds(10, 3, 190, 30);
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Anyagok_Label);

		
		Fegyver_Osszegzo_Anyagok_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Fegyver_Osszegzo_Anyagok_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Anyagok_Label.setBounds(10,35,170,20);
		Fegyver_Osszegzo_Anyagok_Label.setHorizontalAlignment(SwingConstants.LEFT);
		
		Fegyver_Osszegzo_Acel_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Fegyver_Osszegzo_Acel_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Acel_Label.setBounds(40,55,170,20);
		Fegyver_Osszegzo_Acel_Label.setHorizontalAlignment(SwingConstants.LEFT);
		
		Fegyver_Osszegzo_Aceldb_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Fegyver_Osszegzo_Aceldb_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Aceldb_Label.setBounds(80,55,170,20);
		Fegyver_Osszegzo_Aceldb_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Fegyver_Osszegzo_Aceldb_Label.setText(Fegyver_Osszegzo_Aceldb_Label.getText()+" db");
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Acel_Label);
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Aceldb_Label);
		
		Fegyver_Osszegzo_Vas_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Fegyver_Osszegzo_Vas_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Vas_Label.setBounds(40,75,170,20);
		Fegyver_Osszegzo_Vas_Label.setHorizontalAlignment(SwingConstants.LEFT);
		
		Fegyver_Osszegzo_Vasdb_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Fegyver_Osszegzo_Vasdb_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Vasdb_Label.setBounds(80,75,170,20);
		Fegyver_Osszegzo_Vasdb_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Fegyver_Osszegzo_Vasdb_Label.setText(Fegyver_Osszegzo_Vasdb_Label.getText()+" db");
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Vas_Label);
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Vasdb_Label);
		
		Fegyver_Osszegzo_Rez_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Fegyver_Osszegzo_Rez_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Rez_Label.setBounds(40,95,170,20);
		Fegyver_Osszegzo_Rez_Label.setHorizontalAlignment(SwingConstants.LEFT);
		
		Fegyver_Osszegzo_Rezdb_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Fegyver_Osszegzo_Rezdb_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Rezdb_Label.setBounds(80,95,170,20);
		Fegyver_Osszegzo_Rezdb_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Fegyver_Osszegzo_Rezdb_Label.setText(Fegyver_Osszegzo_Rezdb_Label.getText()+" db");
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Rez_Label);
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Rezdb_Label);
		
		
		Fegyver_Osszegzo_Suly_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Fegyver_Osszegzo_Suly_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Suly_Label.setBounds(10,120,170,20);
		Fegyver_Osszegzo_Sulykg_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Fegyver_Osszegzo_Sulykg_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Fegyver_Osszegzo_Sulykg_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Sulykg_Label.setBounds(55,120,170,20);
		Fegyver_Osszegzo_Sulykg_Label.setText(Fegyver_Osszegzo_Sulykg_Label.getText()+" kg");
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Suly_Label);
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Sulykg_Label);
		
		Fegyver_Osszegzo_Craft_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Fegyver_Osszegzo_Craft_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Craft_Label.setBounds(50,145,170,20);
		
		Fegyver_Osszegzo_Craft_ora_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Fegyver_Osszegzo_Craft_ora_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Fegyver_Osszegzo_Craft_ora_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Craft_ora_Label.setBounds(10,165,170,20);
		Fegyver_Osszegzo_Craft_ora_Label.setText(Fegyver_Osszegzo_Craft_ora_Label.getText()+" h");
		
		Fegyver_Osszegzo_Craft_perc_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Fegyver_Osszegzo_Craft_perc_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Fegyver_Osszegzo_Craft_perc_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Craft_perc_Label.setBounds(50,165,170,20);
		Fegyver_Osszegzo_Craft_perc_Label.setText(Fegyver_Osszegzo_Craft_perc_Label.getText()+" min");
		
		Fegyver_Osszegzo_Craft_masodperc_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Fegyver_Osszegzo_Craft_masodperc_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Fegyver_Osszegzo_Craft_masodperc_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Craft_masodperc_Label.setBounds(110,165,170,20);
		Fegyver_Osszegzo_Craft_masodperc_Label.setText(Fegyver_Osszegzo_Craft_masodperc_Label.getText()+" sec");
		
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Craft_Label);
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Craft_ora_Label);
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Craft_perc_Label);
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Craft_masodperc_Label);
		
		
		Fegyver_Osszegzo_Ar_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Fegyver_Osszegzo_Ar_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Ar_Label.setBounds(10,190,170,20);
		Fegyver_Osszegzo_Armenny_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Fegyver_Osszegzo_Armenny_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Fegyver_Osszegzo_Armenny_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Armenny_Label.setBounds(40,190,170,20);
		Fegyver_Osszegzo_Armenny_Label.setText(Fegyver_Osszegzo_Armenny_Label.getText()+" $");
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Ar_Label);
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Armenny_Label);
		
	}
	
	//Fegyverek feltöltése és figyelése
	private static void Pisztoly_Megadas() {
		Pistoly_Mennyiseg_panel.setBounds(18, 150, 110, 40);
		Pistoly_Mennyiseg_panel.setBackground(new Color(50,50,50,100));
		Pistoly_Mennyiseg_panel.setLayout(null);
		
		Pistoly_Plusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Plusz.png")));
		Pistoly_Plusz.setBounds(85, 8, 30, 25);
		Pistoly_Plusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Pisztoly darabszam nott");
				Integer text=Integer.parseInt(Pistoly_Mennyiseg.getText());
				Integer Valtozott = text+1;
				Pistoly_Mennyiseg.setText(Valtozott.toString());
				Fegyver_Frissites();
			}
		});
		Pistoly_Minusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Minusz.png")));
		Pistoly_Minusz.setBounds(5, 9, 30, 20);
		Pistoly_Minusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Pisztoly darabszam csokkent");
				Integer text=Integer.parseInt(Pistoly_Mennyiseg.getText());
				Integer Valtozott = text-1;
				if(Valtozott<0) {
					Valtozott=0;
				}
				Pistoly_Mennyiseg.setText(Valtozott.toString());
				Fegyver_Frissites();
			}
		});
		
		Pistoly_Mennyiseg.setLocation(30, 10);
		Pistoly_Mennyiseg.setSize(50, 20);
		Pistoly_Mennyiseg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Pistoly_Mennyiseg.setHorizontalAlignment(SwingConstants.CENTER);
		Pistoly_Mennyiseg.setText("0");
		Pistoly_Mennyiseg.setEditable(true);
		Pistoly_Mennyiseg.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				}
			public void keyReleased(KeyEvent e) {
				if(Pistoly_Mennyiseg.getText().length()==0) {
					Pistoly_Mennyiseg.setText("");
				}
					Pistoly_Mennyiseg.setText(Pistoly_Mennyiseg.getText());
				if(Pistoly_Mennyiseg.getText().length()>0) {
					Fegyver_Frissites();
				}}
			public void keyPressed(KeyEvent e) {
		}});
		Pistoly_Mennyiseg.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				Fegyver_Mennyiseg_Figyeles();	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mouseExited(MouseEvent e) {

				
			}
		});
		
		
		
		Pistoly_Mennyiseg_panel.add(Pistoly_Minusz);
		Pistoly_Mennyiseg_panel.add(Pistoly_Mennyiseg);
		Pistoly_Mennyiseg_panel.add(Pistoly_Plusz);
		
	}
	private static void AP_Pisztoly_Megadas() {
		AP_Pistoly_Mennyiseg_panel.setBounds((int)Pistoly_Mennyiseg_panel.getLocation().getX()+Fegyver_szeles+Fegyver_Tavolsag+1, 150, 110, 40);
		//AP_Pistoly_Mennyiseg_panel.setBounds(18, 150, 110, 40);
		AP_Pistoly_Mennyiseg_panel.setBackground(new Color(50,50,50,100));
		AP_Pistoly_Mennyiseg_panel.setLayout(null);
		
		AP_Pistoly_Plusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Plusz.png")));
		AP_Pistoly_Plusz.setBounds(85, 8, 30, 25);
		AP_Pistoly_Plusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("AP pisztoly darabszam nott");
				Integer text=Integer.parseInt(AP_Pistoly_Mennyiseg.getText());
				Integer Valtozott = text+1;
				AP_Pistoly_Mennyiseg.setText(Valtozott.toString());
				Fegyver_Frissites();
			}
		});
		AP_Pistoly_Minusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Minusz.png")));
		AP_Pistoly_Minusz.setBounds(5, 9, 30, 20);
		AP_Pistoly_Minusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("AP pisztoly darabszam csokkent");
				Integer text=Integer.parseInt(AP_Pistoly_Mennyiseg.getText());
				Integer Valtozott = text-1;
				if(Valtozott<0) {
					Valtozott=0;
				}
				AP_Pistoly_Mennyiseg.setText(Valtozott.toString());
				Fegyver_Frissites();
			}
		});
		
		AP_Pistoly_Mennyiseg.setLocation(30, 10);
		AP_Pistoly_Mennyiseg.setSize(50, 20);
		AP_Pistoly_Mennyiseg.setFont(new Font("Tahoma", Font.BOLD, 20));
		AP_Pistoly_Mennyiseg.setHorizontalAlignment(SwingConstants.CENTER);
		AP_Pistoly_Mennyiseg.setText("0");
		AP_Pistoly_Mennyiseg.setEditable(true);
		AP_Pistoly_Mennyiseg.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				}
			public void keyReleased(KeyEvent e) {
				if(AP_Pistoly_Mennyiseg.getText().length()==0) {
					AP_Pistoly_Mennyiseg.setText("");
				}
				AP_Pistoly_Mennyiseg.setText(AP_Pistoly_Mennyiseg.getText());
				if(AP_Pistoly_Mennyiseg.getText().length()>0) {
					Fegyver_Frissites();
				}}
			public void keyPressed(KeyEvent e) {
		}});
		AP_Pistoly_Mennyiseg.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				Fegyver_Mennyiseg_Figyeles();	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mouseExited(MouseEvent e) {

				
			}
		});
		
		
		
		AP_Pistoly_Mennyiseg_panel.add(AP_Pistoly_Minusz);
		AP_Pistoly_Mennyiseg_panel.add(AP_Pistoly_Mennyiseg);
		AP_Pistoly_Mennyiseg_panel.add(AP_Pistoly_Plusz);
		
	}
	private static void Tec9_Megadas() {
		Tec9_Mennyiseg_panel.setBounds((int)AP_Pistoly_Mennyiseg_panel.getLocation().getX()+Fegyver_szeles+Fegyver_Tavolsag+1, 150, 110, 40);
		//AP_Pistoly_Mennyiseg_panel.setBounds(18, 150, 110, 40);
		Tec9_Mennyiseg_panel.setBackground(new Color(50,50,50,100));
		Tec9_Mennyiseg_panel.setLayout(null);
		
		Tec9_Plusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Plusz.png")));
		Tec9_Plusz.setBounds(85, 8, 30, 25);
		Tec9_Plusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Tec9 darabszam nott");
				Integer text=Integer.parseInt(Tec9_Mennyiseg.getText());
				Integer Valtozott = text+1;
				Tec9_Mennyiseg.setText(Valtozott.toString());
				Fegyver_Frissites();
			}
		});
		Tec9_Minusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Minusz.png")));
		Tec9_Minusz.setBounds(5, 9, 30, 20);
		Tec9_Minusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Tec9 darabszam csokkent");
				Integer text=Integer.parseInt(Tec9_Mennyiseg.getText());
				Integer Valtozott = text-1;
				if(Valtozott<0) {
					Valtozott=0;
				}
				Tec9_Mennyiseg.setText(Valtozott.toString());
				Fegyver_Frissites();
			}
		});
		
		Tec9_Mennyiseg.setLocation(30, 10);
		Tec9_Mennyiseg.setSize(50, 20);
		Tec9_Mennyiseg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Tec9_Mennyiseg.setHorizontalAlignment(SwingConstants.CENTER);
		Tec9_Mennyiseg.setText("0");
		Tec9_Mennyiseg.setEditable(true);
		Tec9_Mennyiseg.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				}
			public void keyReleased(KeyEvent e) {
				if(Tec9_Mennyiseg.getText().length()==0) {
					Tec9_Mennyiseg.setText("");
				}
				Tec9_Mennyiseg.setText(Tec9_Mennyiseg.getText());
				if(Tec9_Mennyiseg.getText().length()>0) {
					Fegyver_Frissites();
				}}
			public void keyPressed(KeyEvent e) {
		}});
		Tec9_Mennyiseg.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				Fegyver_Mennyiseg_Figyeles();	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mouseExited(MouseEvent e) {

				
			}
		});
		
		Tec9_Mennyiseg_panel.add(Tec9_Minusz);
		Tec9_Mennyiseg_panel.add(Tec9_Mennyiseg);
		Tec9_Mennyiseg_panel.add(Tec9_Plusz);
		
	}	
	private static void Micro_SMG_Megadas() {
		Micro_SMG_Mennyiseg_panel.setBounds((int)Tec9_Mennyiseg_panel.getLocation().getX()+Fegyver_szeles+Fegyver_Tavolsag+1, 150, 110, 40);
		//AP_Pistoly_Mennyiseg_panel.setBounds(18, 150, 110, 40);
		Micro_SMG_Mennyiseg_panel.setBackground(new Color(50,50,50,100));
		Micro_SMG_Mennyiseg_panel.setLayout(null);
		
		Micro_SMG_Plusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Plusz.png")));
		Micro_SMG_Plusz.setBounds(85, 8, 30, 25);
		Micro_SMG_Plusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Micro SMG darabszam nott");
				Integer text=Integer.parseInt(Micro_SMG_Mennyiseg.getText());
				Integer Valtozott = text+1;
				Micro_SMG_Mennyiseg.setText(Valtozott.toString());
				Fegyver_Frissites();
			}
		});
		Micro_SMG_Minusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Minusz.png")));
		Micro_SMG_Minusz.setBounds(5, 9, 30, 20);
		Micro_SMG_Minusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Micro SMG darabszam csokkent");
				Integer text=Integer.parseInt(Micro_SMG_Mennyiseg.getText());
				Integer Valtozott = text-1;
				if(Valtozott<0) {
					Valtozott=0;
				}
				Micro_SMG_Mennyiseg.setText(Valtozott.toString());
				Fegyver_Frissites();
			}
		});
		
		Micro_SMG_Mennyiseg.setLocation(30, 10);
		Micro_SMG_Mennyiseg.setSize(50, 20);
		Micro_SMG_Mennyiseg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Micro_SMG_Mennyiseg.setHorizontalAlignment(SwingConstants.CENTER);
		Micro_SMG_Mennyiseg.setText("0");
		Micro_SMG_Mennyiseg.setEditable(true);
		
		Micro_SMG_Mennyiseg.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				}
			public void keyReleased(KeyEvent e) {
				if(Micro_SMG_Mennyiseg.getText().length()==0) {
					Micro_SMG_Mennyiseg.setText("");
				}
				Micro_SMG_Mennyiseg.setText(Micro_SMG_Mennyiseg.getText());
				if(Micro_SMG_Mennyiseg.getText().length()>0) {
					Fegyver_Frissites();
				}}
			public void keyPressed(KeyEvent e) {
		}});
		
		Micro_SMG_Mennyiseg.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				Fegyver_Mennyiseg_Figyeles();	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mouseExited(MouseEvent e) {

				
			}
		});
		
		Micro_SMG_Mennyiseg_panel.add(Micro_SMG_Minusz);
		Micro_SMG_Mennyiseg_panel.add(Micro_SMG_Mennyiseg);
		Micro_SMG_Mennyiseg_panel.add(Micro_SMG_Plusz);
		
	}	
	
	//Szövegek olvashatóvá tétele illetve adatok ki írása
	private static void Fegyver_Frissites() {
		DecimalFormat df = new DecimalFormat("#,###");
		DecimalFormat df2 = new DecimalFormat("#.###");
		

		int Pisztoly_darab=Integer.parseInt(Pistoly_Mennyiseg.getText());
		int Ap_Pisztoly_darab=Integer.parseInt(AP_Pistoly_Mennyiseg.getText());
		int Tec9_darab=Integer.parseInt(Tec9_Mennyiseg.getText());
		int Micro_SMG_darab=Integer.parseInt(Micro_SMG_Mennyiseg.getText());
		
		//Nyers anyagok
		int Pisztoly_Nyersanyag=(Pisztoly_darab*Pisztoly_osszerak_darab);
		int AP_Pisztoly_Nyersanyag=(Ap_Pisztoly_darab*Ap_pisztoly_osszerak_darab);
		int Tec9_Nyersanyag=(Tec9_darab*Tec_9_osszerak_darab);
		int Micro_SMG_Nyersanyag=(Micro_SMG_darab*Micro_SMG_osszerak_darab);
		int Osszes_Nyersanyag=(Pisztoly_Nyersanyag+AP_Pisztoly_Nyersanyag+Tec9_Nyersanyag+Micro_SMG_Nyersanyag);
        String Osszes_Fegyver_Nyersanyag_Formazott = df.format(Osszes_Nyersanyag);
        Fegyver_Osszegzo_Aceldb_Label.setText(Osszes_Fegyver_Nyersanyag_Formazott+" db");
        Fegyver_Osszegzo_Vasdb_Label.setText(Osszes_Fegyver_Nyersanyag_Formazott+" db");
        Fegyver_Osszegzo_Rezdb_Label.setText(Osszes_Fegyver_Nyersanyag_Formazott+" db");
		
		//Súly
        double Pisztoly_Suly=(Pisztoly_darab*((double)Pisztoly_suly));
        double AP_Pisztoly_Suly=(Ap_Pisztoly_darab*((double)AP_pisztoly_suly));
        double Tec9_Suly=(Tec9_darab*((double)Tec9_suly));
        double Micro_SMG_Suly=(Micro_SMG_darab*((double)Micro_SMG_suly));
		double Osszes_Suly=(Pisztoly_Suly+AP_Pisztoly_Suly+Tec9_Suly+Micro_SMG_Suly);
        String Osszes_Suly_Formazott = df2.format(Osszes_Suly);
        Fegyver_Osszegzo_Sulykg_Label.setText(Osszes_Suly_Formazott+" kg");
        
        //Craftolási idő
    	//int Alapanyag_craftolsai_ido=13;
    	// int Fegyver_craftolsai_ido=20;
        int Pisztoly_Teljes_Craft_Ido=(Pisztoly_darab*Alapanyag_craftolsai_ido*Pisztoly_osszerak_darab+Pisztoly_darab*Fegyver_craftolsai_ido);
        int AP_Pisztoly_Teljes_Craft_Ido=(Ap_Pisztoly_darab*Alapanyag_craftolsai_ido*Ap_pisztoly_osszerak_darab+Ap_Pisztoly_darab*Fegyver_craftolsai_ido);
        int Tec9_Teljes_Craft_Ido=(Tec9_darab*Alapanyag_craftolsai_ido*Tec_9_osszerak_darab+Tec9_darab*Fegyver_craftolsai_ido);
        int Micro_SMG_Teljes_Craft_Ido=(Micro_SMG_darab*Alapanyag_craftolsai_ido*Micro_SMG_osszerak_darab+Micro_SMG_darab*Fegyver_craftolsai_ido);
        
        int Fegyver_Teljes_Craft_Ido=(Pisztoly_Teljes_Craft_Ido+AP_Pisztoly_Teljes_Craft_Ido+Tec9_Teljes_Craft_Ido+Micro_SMG_Teljes_Craft_Ido);
        
        int Orak=Fegyver_Teljes_Craft_Ido/3600;
        int Percek=(Fegyver_Teljes_Craft_Ido%3600)/60;
        int Masodpercek=Fegyver_Teljes_Craft_Ido%60;
        Fegyver_Osszegzo_Craft_ora_Label.setText(Integer.toString(Orak)+" h");
        Fegyver_Osszegzo_Craft_perc_Label.setText(Integer.toString(Percek)+" min");
        Fegyver_Osszegzo_Craft_masodperc_Label.setText(Integer.toString(Masodpercek)+" sec");
        
        if(Orak==0) {
        	Fegyver_Osszegzo_Craft_ora_Label.setText("0 h");
        }
        if(Percek==0) {
        	Fegyver_Osszegzo_Craft_perc_Label.setText("0 min");
        }
        if(Masodpercek==0) {
        	Fegyver_Osszegzo_Craft_masodperc_Label.setText("0 sec");
        }
        
        
        //String Fegyver_Teljes_Craft_Ido_String=(Integer.toString(Fegyver_Teljes_Craft_Ido));
       // System.out.println("Craft ido = "+Fegyver_Teljes_Craft_Ido_String);
        //System.out.println("String hossza = "+Fegyver_Teljes_Craft_Ido_String.length());
        
		
		//Ár
		int Pisztoly_Ar=(Pisztoly_darab*Pisztoly_ar);
			if(Pisztoly_darab>4&Pisztoly_darab<=9) {
				double Pisztoly_Ar2=(Pisztoly_Ar*0.9);
				Pisztoly_Ar=((int)Pisztoly_Ar2);
			}if(Pisztoly_darab>9) {
				double Pisztoly_Ar2=(Pisztoly_Ar*0.7);
				Pisztoly_Ar=((int)Pisztoly_Ar2);
			}
			
		int AP_Pisztoly_Ar=(Ap_Pisztoly_darab*Ap_Pisztoly_ar);
			if(Ap_Pisztoly_darab>4&Ap_Pisztoly_darab<=9) {
				double AP_Pisztoly_Ar2=(AP_Pisztoly_Ar*0.92);
				AP_Pisztoly_Ar=((int)AP_Pisztoly_Ar2);
			}if(Ap_Pisztoly_darab>9) {
				double AP_Pisztoly_Ar2=(AP_Pisztoly_Ar*0.84);
				AP_Pisztoly_Ar=((int)AP_Pisztoly_Ar2);
			}
			
		int Tec9_Ar=(Tec9_darab*Tec9_ar);
			if(Tec9_darab>4&Tec9_darab<=9) {
				double Tec9_Ar2=(Tec9_Ar*0.86);
				Tec9_Ar=((int)Tec9_Ar2);
			}if(Tec9_darab>9) {
				double Tec9_Ar2=(Tec9_Ar*0.73);
				Tec9_Ar=((int)Tec9_Ar2);
			}
			
		int Micro_SMG_Ar=(Micro_SMG_darab*Micro_SMG_ar);
			if(Micro_SMG_darab>4&Micro_SMG_darab<=9) {
				double Micro_SMG_Ar2=(Micro_SMG_Ar*0.93);
				Micro_SMG_Ar=((int)Micro_SMG_Ar2);
			}if(Micro_SMG_darab>9) {
				double Micro_SMG_Ar2=(Micro_SMG_Ar*0.83);
				Micro_SMG_Ar=((int)Micro_SMG_Ar2);
			}

		int Osszes_Fegyver_Ar=(Pisztoly_Ar+AP_Pisztoly_Ar+Tec9_Ar+Micro_SMG_Ar);
        // Összeg fozmázása a láthatóság végett
        
        String Osszes_Fegyver_Ar_Formazott = df.format(Osszes_Fegyver_Ar);
		Fegyver_Osszegzo_Armenny_Label.setText(Osszes_Fegyver_Ar_Formazott+" $");
		
		
		
		
		
		
		
		
		
		
		
		Osszes_Panel_Frissites();
		//Panel frissítése
		Fegyver_Osszegzo_Panel.setVisible(false);
		Menu_Osszesito_panel.setVisible(false);
		Menu_Osszesito_panel.setVisible(true);
		Fegyver_Osszegzo_Panel.setVisible(true);
		
	
}
	
	//Ha a fegyver kevesebb lenne mint 0 akkor korrigál
	private static void Fegyver_Mennyiseg_Figyeles() {
		if(Pistoly_Mennyiseg.getText().length()<1) {
			Pistoly_Mennyiseg.setText("0");
			Fegyver_Frissites();
			Osszes_Panel_Frissites();
			
		}
		if(AP_Pistoly_Mennyiseg.getText().length()<1) {
			AP_Pistoly_Mennyiseg.setText("0");
			Fegyver_Frissites();
			Osszes_Panel_Frissites();
		}
		if(Tec9_Mennyiseg.getText().length()<1) {
			Tec9_Mennyiseg.setText("0");
			Fegyver_Frissites();
			Osszes_Panel_Frissites();
			
		}
		if(Micro_SMG_Mennyiseg.getText().length()<1) {
			Micro_SMG_Mennyiseg.setText("0");
			Fegyver_Frissites();
			Osszes_Panel_Frissites();
			
		}
		
	}

	//Lőszer panel alap szöveggel feltötlése
	private static void Loszer_Osszegzo_Panel_Feltoltes() {

		
		
		Loszer_Osszegzo_Panel.add(Loszer_Osszegzo_Anyagok_Label);

		
		Loszer_Osszegzo_Anyagok_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Loszer_Osszegzo_Anyagok_Label.setForeground(Color.white);
		Loszer_Osszegzo_Anyagok_Label.setBounds(10,35,170,20);
		Loszer_Osszegzo_Anyagok_Label.setHorizontalAlignment(SwingConstants.LEFT);
		
		Loszer_Osszegzo_Acel_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Loszer_Osszegzo_Acel_Label.setForeground(Color.white);
		Loszer_Osszegzo_Acel_Label.setBounds(40,55,170,20);
		Loszer_Osszegzo_Acel_Label.setHorizontalAlignment(SwingConstants.LEFT);
		
		Loszer_Osszegzo_Aceldb_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Loszer_Osszegzo_Aceldb_Label.setForeground(Color.white);
		Loszer_Osszegzo_Aceldb_Label.setBounds(80,55,170,20);
		Loszer_Osszegzo_Aceldb_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Loszer_Osszegzo_Aceldb_Label.setText(Loszer_Osszegzo_Aceldb_Label.getText()+" db");
		Loszer_Osszegzo_Panel.add(Loszer_Osszegzo_Acel_Label);
		Loszer_Osszegzo_Panel.add(Loszer_Osszegzo_Aceldb_Label);
		

		

		
		
		Loszer_Osszegzo_Suly_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Loszer_Osszegzo_Suly_Label.setForeground(Color.white);
		Loszer_Osszegzo_Suly_Label.setBounds(10,90,170,20);
		Loszer_Osszegzo_Sulykg_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Loszer_Osszegzo_Sulykg_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Loszer_Osszegzo_Sulykg_Label.setForeground(Color.white);
		Loszer_Osszegzo_Sulykg_Label.setBounds(55,90,170,20);
		Loszer_Osszegzo_Sulykg_Label.setText(Loszer_Osszegzo_Sulykg_Label.getText()+" kg");
		Loszer_Osszegzo_Panel.add(Loszer_Osszegzo_Suly_Label);
		Loszer_Osszegzo_Panel.add(Loszer_Osszegzo_Sulykg_Label);
		
		Loszer_Osszegzo_Craft_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Loszer_Osszegzo_Craft_Label.setForeground(Color.white);
		Loszer_Osszegzo_Craft_Label.setBounds(50,130,170,20);
		
		Loszer_Osszegzo_Craft_ora_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Loszer_Osszegzo_Craft_ora_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Loszer_Osszegzo_Craft_ora_Label.setForeground(Color.white);
		Loszer_Osszegzo_Craft_ora_Label.setBounds(10,150,170,20);
		Loszer_Osszegzo_Craft_ora_Label.setText(Loszer_Osszegzo_Craft_ora_Label.getText()+" h");
		
		Loszer_Osszegzo_Craft_perc_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Loszer_Osszegzo_Craft_perc_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Loszer_Osszegzo_Craft_perc_Label.setForeground(Color.white);
		Loszer_Osszegzo_Craft_perc_Label.setBounds(50,150,170,20);
		Loszer_Osszegzo_Craft_perc_Label.setText(Loszer_Osszegzo_Craft_perc_Label.getText()+" min");
		
		Loszer_Osszegzo_Craft_masodperc_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Loszer_Osszegzo_Craft_masodperc_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Loszer_Osszegzo_Craft_masodperc_Label.setForeground(Color.white);
		Loszer_Osszegzo_Craft_masodperc_Label.setBounds(110,150,170,20);
		Loszer_Osszegzo_Craft_masodperc_Label.setText(Loszer_Osszegzo_Craft_masodperc_Label.getText()+" sec");
		
		Loszer_Osszegzo_Panel.add(Loszer_Osszegzo_Craft_Label);
		Loszer_Osszegzo_Panel.add(Loszer_Osszegzo_Craft_ora_Label);
		Loszer_Osszegzo_Panel.add(Loszer_Osszegzo_Craft_perc_Label);
		Loszer_Osszegzo_Panel.add(Loszer_Osszegzo_Craft_masodperc_Label);
		
		
		Loszer_Osszegzo_Ar_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Loszer_Osszegzo_Ar_Label.setForeground(Color.white);
		Loszer_Osszegzo_Ar_Label.setBounds(10,180,170,20);
		Loszer_Osszegzo_Armenny_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Loszer_Osszegzo_Armenny_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Loszer_Osszegzo_Armenny_Label.setForeground(Color.white);
		Loszer_Osszegzo_Armenny_Label.setBounds(40,180,170,20);
		Loszer_Osszegzo_Armenny_Label.setText(Loszer_Osszegzo_Armenny_Label.getText()+" $");
		Loszer_Osszegzo_Panel.add(Loszer_Osszegzo_Ar_Label);
		Loszer_Osszegzo_Panel.add(Loszer_Osszegzo_Armenny_Label);
		

	}

	//Lőszer panel mennyiség álltísa +kep
	private static void Pisztoly_Loszer_Megadas() {
		Pisztoly_Loszer_Panel.setBounds(20,250,Fegyver_szeles+17,Fegyver_magas+35);
		Pisztoly_Loszer_Panel.setLayout(null);
		Pisztoly_Loszer_Panel.setBackground(new Color(50,50,50,200));
		
		Pisztoly_Loszer_Kep.setBounds(11, 5, Fegyver_szeles, Fegyver_magas);
		Pisztoly_Loszer_Kep.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Pisztoly_Loszer.png")));
		Pisztoly_Loszer_Kep.setVisible(true);
		
		Pisztoly_Loszer_Szoveg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Pisztoly_Loszer_Szoveg.setHorizontalAlignment(SwingConstants.CENTER);
		Pisztoly_Loszer_Szoveg.setBounds(13, 97, 80, 25);
		Pisztoly_Loszer_Szoveg.setForeground(Color.white);
		
		
		
		Pisztoly_Loszer_Mennyiseg_panel.setBounds(18, 380, 110, 40);
		Pisztoly_Loszer_Mennyiseg_panel.setBackground(new Color(50,50,50,100));
		Pisztoly_Loszer_Mennyiseg_panel.setLayout(null);
		
		Pisztoly_Loszer_Minusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Minusz.png")));
		Pisztoly_Loszer_Minusz.setBounds(5, 9, 30, 20);
		Pisztoly_Loszer_Minusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Pisztoly loszer darabszam nott");
				Integer text=Integer.parseInt(Pisztoly_Loszer_Mennyiseg.getText());
				Integer Valtozott = text-1;
				if(Valtozott<0) {
					Valtozott=0;
				}
				Pisztoly_Loszer_Mennyiseg.setText(Valtozott.toString());
				Loszer_Frissites();
			}
		});
		

		Pisztoly_Loszer_Mennyiseg.setLocation(30, 10);
		Pisztoly_Loszer_Mennyiseg.setSize(50, 20);
		Pisztoly_Loszer_Mennyiseg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Pisztoly_Loszer_Mennyiseg.setHorizontalAlignment(SwingConstants.CENTER);
		Pisztoly_Loszer_Mennyiseg.setText("0");
		Pisztoly_Loszer_Mennyiseg.setEditable(true);
		Pisztoly_Loszer_Mennyiseg.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				}
			public void keyReleased(KeyEvent e) {
				if(Pisztoly_Loszer_Mennyiseg.getText().length()==0) {
					Pisztoly_Loszer_Mennyiseg.setText("");
				}
				Pisztoly_Loszer_Mennyiseg.setText(Pisztoly_Loszer_Mennyiseg.getText());
				if(Pisztoly_Loszer_Mennyiseg.getText().length()>0) {
					Loszer_Frissites();
				}}
			public void keyPressed(KeyEvent e) {
		}});
		Pisztoly_Loszer_Mennyiseg.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				Loszer_Mennyiseg_Figyeles();	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mouseExited(MouseEvent e) {

				
			}
		});
		
		
		
		Pisztoly_Loszer_Plusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Plusz.png")));
		Pisztoly_Loszer_Plusz.setBounds(85, 8, 30, 25);
		Pisztoly_Loszer_Plusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Pisztoly loszer darabszam nott");
				Integer text=Integer.parseInt(Pisztoly_Loszer_Mennyiseg.getText());
				Integer Valtozott = text+1;
				Pisztoly_Loszer_Mennyiseg.setText(Valtozott.toString());
				Loszer_Frissites();
			}
		});
		Pisztoly_Loszer_Panel.add(Pisztoly_Loszer_Kep);
		Pisztoly_Loszer_Panel.add(Pisztoly_Loszer_Szoveg);
		Pisztoly_Loszer_Mennyiseg_panel.add(Pisztoly_Loszer_Minusz);
		Pisztoly_Loszer_Mennyiseg_panel.add(Pisztoly_Loszer_Mennyiseg);
		Pisztoly_Loszer_Mennyiseg_panel.add(Pisztoly_Loszer_Plusz);
		
		
		

	}
	private static void SMG_Loszer_Megadas() {
		SMG_Loszer_Panel.setBounds((int)Pisztoly_Loszer_Panel.getLocation().getX()+Fegyver_szeles+Fegyver_Tavolsag,250,Fegyver_szeles+17,Fegyver_magas+35);
		SMG_Loszer_Panel.setLayout(null);
		SMG_Loszer_Panel.setBackground(new Color(50,50,50,200));
		
		SMG_Loszer_Kep.setBounds(8, 5, Fegyver_szeles, Fegyver_magas);
		SMG_Loszer_Kep.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/SMG_Loszer.png")));
		SMG_Loszer_Kep.setVisible(true);
		
		SMG_Loszer_Szoveg.setFont(new Font("Tahoma", Font.BOLD, 20));
		SMG_Loszer_Szoveg.setHorizontalAlignment(SwingConstants.CENTER);
		SMG_Loszer_Szoveg.setBounds(13, 97, 80, 25);
		SMG_Loszer_Szoveg.setForeground(Color.white);
		
		
		
		SMG_Loszer_Mennyiseg_panel.setBounds((int)SMG_Loszer_Panel.getLocation().getX()-2, 380, 110, 40);
		SMG_Loszer_Mennyiseg_panel.setBackground(new Color(50,50,50,100));
		SMG_Loszer_Mennyiseg_panel.setLayout(null);
		
		SMG_Loszer_Minusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Minusz.png")));
		SMG_Loszer_Minusz.setBounds(5, 9, 30, 20);
		SMG_Loszer_Minusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("SMG loszer darabszam nott");
				Integer text=Integer.parseInt(SMG_Loszer_Mennyiseg.getText());
				Integer Valtozott = text-1;
				if(Valtozott<0) {
					Valtozott=0;
				}
				SMG_Loszer_Mennyiseg.setText(Valtozott.toString());
				Loszer_Frissites();
			}
		});
		

		SMG_Loszer_Mennyiseg.setLocation(30, 10);
		SMG_Loszer_Mennyiseg.setSize(50, 20);
		SMG_Loszer_Mennyiseg.setFont(new Font("Tahoma", Font.BOLD, 20));
		SMG_Loszer_Mennyiseg.setHorizontalAlignment(SwingConstants.CENTER);
		SMG_Loszer_Mennyiseg.setText("0");
		SMG_Loszer_Mennyiseg.setEditable(true);
		SMG_Loszer_Mennyiseg.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				}
			public void keyReleased(KeyEvent e) {
				if(SMG_Loszer_Mennyiseg.getText().length()==0) {
					SMG_Loszer_Mennyiseg.setText("");
				}
				SMG_Loszer_Mennyiseg.setText(SMG_Loszer_Mennyiseg.getText());
				if(SMG_Loszer_Mennyiseg.getText().length()>0) {
					Loszer_Frissites();
				}}
			public void keyPressed(KeyEvent e) {
		}});
		SMG_Loszer_Mennyiseg.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				Loszer_Mennyiseg_Figyeles();	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mouseExited(MouseEvent e) {

				
			}
		});
		
		
		
		SMG_Loszer_Plusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Plusz.png")));
		SMG_Loszer_Plusz.setBounds(85, 8, 30, 25);
		SMG_Loszer_Plusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("SMG loszer darabszam nott");
				Integer text=Integer.parseInt(SMG_Loszer_Mennyiseg.getText());
				Integer Valtozott = text+1;
				SMG_Loszer_Mennyiseg.setText(Valtozott.toString());
				Loszer_Frissites();
			}
		});
		SMG_Loszer_Panel.add(SMG_Loszer_Kep);
		SMG_Loszer_Panel.add(SMG_Loszer_Szoveg);
		SMG_Loszer_Mennyiseg_panel.add(SMG_Loszer_Minusz);
		SMG_Loszer_Mennyiseg_panel.add(SMG_Loszer_Mennyiseg);
		SMG_Loszer_Mennyiseg_panel.add(SMG_Loszer_Plusz);
	}
	private static void MG_Loszer_Megadas() {
		MG_Loszer_Panel.setBounds((int)SMG_Loszer_Panel.getLocation().getX()+Fegyver_szeles+Fegyver_Tavolsag,250,Fegyver_szeles+17,Fegyver_magas+35);
		MG_Loszer_Panel.setLayout(null);
		MG_Loszer_Panel.setBackground(new Color(50,50,50,200));
		

		MG_Loszer_Kep.setBounds(16, 5, Fegyver_szeles, Fegyver_magas);
		MG_Loszer_Kep.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/MG_Loszer2.png")));
		MG_Loszer_Kep.setVisible(true);
		
		MG_Loszer_Szoveg.setFont(new Font("Tahoma", Font.BOLD, 20));
		MG_Loszer_Szoveg.setHorizontalAlignment(SwingConstants.CENTER);
		MG_Loszer_Szoveg.setBounds(13, 97, 80, 25);
		MG_Loszer_Szoveg.setForeground(Color.white);
		
		
		
		MG_Loszer_Mennyiseg_panel.setBounds((int)MG_Loszer_Panel.getLocation().getX()-2, 380, 110, 40);
		MG_Loszer_Mennyiseg_panel.setBackground(new Color(50,50,50,100));
		MG_Loszer_Mennyiseg_panel.setLayout(null);
		
		MG_Loszer_Minusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Minusz.png")));
		MG_Loszer_Minusz.setBounds(5, 9, 30, 20);
		MG_Loszer_Minusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("MG loszer darabszam nott");
				Integer text=Integer.parseInt(MG_Loszer_Mennyiseg.getText());
				Integer Valtozott = text-1;
				if(Valtozott<0) {
					Valtozott=0;
				}
				MG_Loszer_Mennyiseg.setText(Valtozott.toString());
				Loszer_Frissites();
			}
		});
		

		MG_Loszer_Mennyiseg.setLocation(30, 10);
		MG_Loszer_Mennyiseg.setSize(50, 20);
		MG_Loszer_Mennyiseg.setFont(new Font("Tahoma", Font.BOLD, 20));
		MG_Loszer_Mennyiseg.setHorizontalAlignment(SwingConstants.CENTER);
		MG_Loszer_Mennyiseg.setText("0");
		MG_Loszer_Mennyiseg.setEditable(true);
		MG_Loszer_Mennyiseg.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				}
			public void keyReleased(KeyEvent e) {
				if(MG_Loszer_Mennyiseg.getText().length()==0) {
					MG_Loszer_Mennyiseg.setText("");
				}
				MG_Loszer_Mennyiseg.setText(MG_Loszer_Mennyiseg.getText());
				if(MG_Loszer_Mennyiseg.getText().length()>0) {
					Loszer_Frissites();
				}}
			public void keyPressed(KeyEvent e) {
		}});
		MG_Loszer_Mennyiseg.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				Loszer_Mennyiseg_Figyeles();	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mouseExited(MouseEvent e) {

				
			}
		});
		
		
		
		MG_Loszer_Plusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Plusz.png")));
		MG_Loszer_Plusz.setBounds(85, 8, 30, 25);
		MG_Loszer_Plusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("MG loszer darabszam nott");
				Integer text=Integer.parseInt(MG_Loszer_Mennyiseg.getText());
				Integer Valtozott = text+1;
				MG_Loszer_Mennyiseg.setText(Valtozott.toString());
				Loszer_Frissites();
			}
		});
		MG_Loszer_Panel.add(MG_Loszer_Kep);
		MG_Loszer_Panel.add(MG_Loszer_Szoveg);
		MG_Loszer_Mennyiseg_panel.add(MG_Loszer_Minusz);
		MG_Loszer_Mennyiseg_panel.add(MG_Loszer_Mennyiseg);
		MG_Loszer_Mennyiseg_panel.add(MG_Loszer_Plusz);

	}
	private static void Rifle_Loszer_Megadas() {
		Rifle_Loszer_Panel.setBounds((int)MG_Loszer_Panel.getLocation().getX()+Fegyver_szeles+Fegyver_Tavolsag,250,Fegyver_szeles+17,Fegyver_magas+35);
		Rifle_Loszer_Panel.setLayout(null);
		Rifle_Loszer_Panel.setBackground(new Color(50,50,50,200));
		

		Rifle_Loszer_Kep.setBounds(1, 5, Fegyver_szeles+14, Fegyver_magas);
		Rifle_Loszer_Kep.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Rifle_Loszer.png")));
		Rifle_Loszer_Kep.setVisible(true);
		
		Rifle_Loszer_Szoveg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Rifle_Loszer_Szoveg.setHorizontalAlignment(SwingConstants.CENTER);
		Rifle_Loszer_Szoveg.setBounds(13, 97, 80, 25);
		Rifle_Loszer_Szoveg.setForeground(Color.white);
		
		
		
		Rifle_Loszer_Mennyiseg_panel.setBounds((int)Rifle_Loszer_Panel.getLocation().getX()-2, 380, 110, 40);
		Rifle_Loszer_Mennyiseg_panel.setBackground(new Color(50,50,50,100));
		Rifle_Loszer_Mennyiseg_panel.setLayout(null);
		
		Rifle_Loszer_Minusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Minusz.png")));
		Rifle_Loszer_Minusz.setBounds(5, 9, 30, 20);
		Rifle_Loszer_Minusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Rifle loszer darabszam nott");
				Integer text=Integer.parseInt(Rifle_Loszer_Mennyiseg.getText());
				Integer Valtozott = text-1;
				if(Valtozott<0) {
					Valtozott=0;
				}
				Rifle_Loszer_Mennyiseg.setText(Valtozott.toString());
				Loszer_Frissites();
			}
		});
		

		Rifle_Loszer_Mennyiseg.setLocation(30, 10);
		Rifle_Loszer_Mennyiseg.setSize(50, 20);
		Rifle_Loszer_Mennyiseg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Rifle_Loszer_Mennyiseg.setHorizontalAlignment(SwingConstants.CENTER);
		Rifle_Loszer_Mennyiseg.setText("0");
		Rifle_Loszer_Mennyiseg.setEditable(true);
		Rifle_Loszer_Mennyiseg.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				}
			public void keyReleased(KeyEvent e) {
				if(Rifle_Loszer_Mennyiseg.getText().length()==0) {
					Rifle_Loszer_Mennyiseg.setText("");
				}
				Rifle_Loszer_Mennyiseg.setText(Rifle_Loszer_Mennyiseg.getText());
				if(Rifle_Loszer_Mennyiseg.getText().length()>0) {
					Loszer_Frissites();
				}}
			public void keyPressed(KeyEvent e) {
		}});
		Rifle_Loszer_Mennyiseg.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				Loszer_Mennyiseg_Figyeles();	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mouseExited(MouseEvent e) {

				
			}
		});
		
		
		
		Rifle_Loszer_Plusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Plusz.png")));
		Rifle_Loszer_Plusz.setBounds(85, 8, 30, 25);
		Rifle_Loszer_Plusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Rifle loszer darabszam nott");
				Integer text=Integer.parseInt(Rifle_Loszer_Mennyiseg.getText());
				Integer Valtozott = text+1;
				Rifle_Loszer_Mennyiseg.setText(Valtozott.toString());
				Loszer_Frissites();
			}
		});
		Rifle_Loszer_Panel.add(Rifle_Loszer_Kep);
		Rifle_Loszer_Panel.add(Rifle_Loszer_Szoveg);
		Rifle_Loszer_Mennyiseg_panel.add(Rifle_Loszer_Minusz);
		Rifle_Loszer_Mennyiseg_panel.add(Rifle_Loszer_Mennyiseg);
		Rifle_Loszer_Mennyiseg_panel.add(Rifle_Loszer_Plusz);

	}
	private static void Shotgun_Loszer_Megadas() {
		Shotgun_Loszer_Panel.setBounds((int)Rifle_Loszer_Panel.getLocation().getX()+Fegyver_szeles+Fegyver_Tavolsag,250,Fegyver_szeles+17,Fegyver_magas+35);
		Shotgun_Loszer_Panel.setLayout(null);
		Shotgun_Loszer_Panel.setBackground(new Color(50,50,50,200));
		

		Shotgun_Loszer_Kep.setBounds(8, 5, Fegyver_szeles+20, Fegyver_magas);
		Shotgun_Loszer_Kep.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Shotgun_Loszer.png")));
		Shotgun_Loszer_Kep.setVisible(true);
		
		Shotgun_Loszer_Szoveg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Shotgun_Loszer_Szoveg.setHorizontalAlignment(SwingConstants.CENTER);
		Shotgun_Loszer_Szoveg.setBounds(5, 97,100, 25);
		Shotgun_Loszer_Szoveg.setForeground(Color.white);
		
		
		
		Shotgun_Loszer_Mennyiseg_panel.setBounds((int)Shotgun_Loszer_Panel.getLocation().getX()-2, 380, 110, 40);
		Shotgun_Loszer_Mennyiseg_panel.setBackground(new Color(50,50,50,100));
		Shotgun_Loszer_Mennyiseg_panel.setLayout(null);
		
		Shotgun_Loszer_Minusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Minusz.png")));
		Shotgun_Loszer_Minusz.setBounds(5, 9, 30, 20);
		Shotgun_Loszer_Minusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Shotgun loszer darabszam nott");
				Integer text=Integer.parseInt(Shotgun_Loszer_Mennyiseg.getText());
				Integer Valtozott = text-1;
				if(Valtozott<0) {
					Valtozott=0;
				}
				Shotgun_Loszer_Mennyiseg.setText(Valtozott.toString());
				Loszer_Frissites();
			}
		});
		

		Shotgun_Loszer_Mennyiseg.setLocation(30, 10);
		Shotgun_Loszer_Mennyiseg.setSize(50, 20);
		Shotgun_Loszer_Mennyiseg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Shotgun_Loszer_Mennyiseg.setHorizontalAlignment(SwingConstants.CENTER);
		Shotgun_Loszer_Mennyiseg.setText("0");
		Shotgun_Loszer_Mennyiseg.setEditable(true);
		Shotgun_Loszer_Mennyiseg.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				}
			public void keyReleased(KeyEvent e) {
				if(Shotgun_Loszer_Mennyiseg.getText().length()==0) {
					Shotgun_Loszer_Mennyiseg.setText("");
				}
				Shotgun_Loszer_Mennyiseg.setText(Shotgun_Loszer_Mennyiseg.getText());
				if(Shotgun_Loszer_Mennyiseg.getText().length()>0) {
					Loszer_Frissites();
				}}
			public void keyPressed(KeyEvent e) {
		}});
		Shotgun_Loszer_Mennyiseg.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				Loszer_Mennyiseg_Figyeles();	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mouseExited(MouseEvent e) {

				
			}
		});
		
		
		
		Shotgun_Loszer_Plusz.setIcon(new ImageIcon(Keret.class.getResource("/Bloods/Plusz.png")));
		Shotgun_Loszer_Plusz.setBounds(85, 8, 30, 25);
		Shotgun_Loszer_Plusz.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Shotgun loszer darabszam nott");
				Integer text=Integer.parseInt(Shotgun_Loszer_Mennyiseg.getText());
				Integer Valtozott = text+1;
				Shotgun_Loszer_Mennyiseg.setText(Valtozott.toString());
				Loszer_Frissites();
			}
		});
		Shotgun_Loszer_Panel.add(Shotgun_Loszer_Kep);
		Shotgun_Loszer_Panel.add(Shotgun_Loszer_Szoveg);
		Shotgun_Loszer_Mennyiseg_panel.add(Shotgun_Loszer_Minusz);
		Shotgun_Loszer_Mennyiseg_panel.add(Shotgun_Loszer_Mennyiseg);
		Shotgun_Loszer_Mennyiseg_panel.add(Shotgun_Loszer_Plusz);

	}

	//Szövegek olvashatóvá tétele illetve adatok ki írása
	private static void Loszer_Frissites() {
		DecimalFormat df = new DecimalFormat("#,###");
		DecimalFormat df2 = new DecimalFormat("#.###");
		int Pisztoly_Loszer_Nyersanyag=0;
		int SMG_Loszer_Nyersanyag=0;
		int MG_Loszer_Nyersanyag=0;
		int Rifle_Loszer_Nyersanyag=0;
		int Shotgun_Loszer_Nyersanyag=0;
		
		int Pisztoly_Loszer_darab=Integer.parseInt(Pisztoly_Loszer_Mennyiseg.getText());
		int SMG_Loszer_darab=Integer.parseInt(SMG_Loszer_Mennyiseg.getText());
		int MG_Loszer_darab=Integer.parseInt(MG_Loszer_Mennyiseg.getText());
		int Rifle_Loszer_darab=Integer.parseInt(Rifle_Loszer_Mennyiseg.getText());
		int Shotgun_Loszer_darab=Integer.parseInt(Shotgun_Loszer_Mennyiseg.getText());


		//Nyers anyagok
		
		//Pisztoly
		if(Pisztoly_Loszer_darab>0&Pisztoly_Loszer_darab<51) {
			Pisztoly_Loszer_Nyersanyag=(1*Pisztoly_Loszer_Acel);
			System.out.println("Pisztoly loszer nyersanyag kevesebb mint 50 ezert acel= "+Pisztoly_Loszer_Nyersanyag);
		}
		else if(Pisztoly_Loszer_darab>50) {
			int Osztas_Eredmeny=(Pisztoly_Loszer_darab-1)/50+1;
			Pisztoly_Loszer_Nyersanyag=Osztas_Eredmeny*Pisztoly_Loszer_Acel;
			System.out.println("Pisztoly loszer nyersanyag nagyobb mint 50 ezert acel= "+Pisztoly_Loszer_Nyersanyag);
		}
		//SMG
		if(SMG_Loszer_darab>0&SMG_Loszer_darab<51) {
			SMG_Loszer_Nyersanyag=(1*SMG_Loszer_Acel);
			System.out.println("SMG loszer nyersanyag kevesebb mint 50 ezert acel= "+SMG_Loszer_Nyersanyag);
		}
		else if(SMG_Loszer_darab>50) {
			int Osztas_Eredmeny=(SMG_Loszer_darab-1)/50+1;
			SMG_Loszer_Nyersanyag=Osztas_Eredmeny*SMG_Loszer_Acel;
			System.out.println("SMG loszer nyersanyag nagyobb mint 50 ezert acel= "+SMG_Loszer_Nyersanyag);
		}
		//Rifle
		if(Rifle_Loszer_darab>0&Rifle_Loszer_darab<51) {
			Rifle_Loszer_Nyersanyag=(1*Rifle_Loszer_Acel);
			System.out.println("Rifle loszer nyersanyag kevesebb mint 50 ezert acel= "+Rifle_Loszer_Nyersanyag);
		}
		else if(Rifle_Loszer_darab>50){
			int Osztas_Eredmeny=(Rifle_Loszer_darab-1)/50+1;
			Rifle_Loszer_Nyersanyag=Osztas_Eredmeny*Rifle_Loszer_Acel;
			System.out.println("Rifle loszer nyersanyag nagyobb mint 50 ezert acel= "+Rifle_Loszer_Nyersanyag);
		}

		
		
		int Osszes_Nyersanyag=(Pisztoly_Loszer_Nyersanyag+SMG_Loszer_Nyersanyag+Rifle_Loszer_Nyersanyag);
        String Osszes_Fegyver_Nyersanyag_Formazott = df.format(Osszes_Nyersanyag);
        Loszer_Osszegzo_Aceldb_Label.setText(Osszes_Fegyver_Nyersanyag_Formazott+" db");
        
        

		
		//Súly
        float Pisztoly_Loszer_Suly2=(Pisztoly_Loszer_darab*((float)Pisztoly_Loszer_Suly));
        float SMG_Loszer_Suly2=(SMG_Loszer_darab*((float)SMG_Loszer_Suly));
        float MG_Loszer_Suly2=(MG_Loszer_darab*((float)MG_Loszer_Suly));
        float Rifle_Loszer_Suly2=(Rifle_Loszer_darab*((float)Rifle_Loszer_Suly));
        float Shotgun_Loszer_Suly2=(Shotgun_Loszer_darab*((float)Shotgun_Loszer_Suly));
        
        
        float Osszes_Suly=(Pisztoly_Loszer_Suly2+SMG_Loszer_Suly2+MG_Loszer_Suly2+Rifle_Loszer_Suly2+Shotgun_Loszer_Suly2);
        String Osszes_Suly_Formazott = df2.format(Osszes_Suly);
        Loszer_Osszegzo_Sulykg_Label.setText(Osszes_Suly_Formazott+" kg");
        
        //Craftolási idő

        int Pisztoly_Loszer_Teljes_Craft_Ido=(Pisztoly_Loszer_darab*Alapanyag_craftolsai_ido);
        int SMG_Loszer_Teljes_Craft_Ido=(SMG_Loszer_darab*Alapanyag_craftolsai_ido);
        int Rifle_Loszer_Teljes_Craft_Ido=(Rifle_Loszer_darab*Alapanyag_craftolsai_ido);
        
        //Pisztoly része
		if(Pisztoly_Loszer_darab>0&Pisztoly_Loszer_darab<51) {
			Pisztoly_Loszer_Teljes_Craft_Ido=(1*Alapanyag_craftolsai_ido);
		}
		else if(Pisztoly_Loszer_darab>50){
			int Osztas_Eredmeny=(Pisztoly_Loszer_darab-1)/50+1;
			Pisztoly_Loszer_Teljes_Craft_Ido=Osztas_Eredmeny*Alapanyag_craftolsai_ido;
		}
		
        //SMG része
		if(SMG_Loszer_darab>0&SMG_Loszer_darab<51) {
			SMG_Loszer_Teljes_Craft_Ido=(1*Alapanyag_craftolsai_ido);
		}
		else if(SMG_Loszer_darab>50){
			int Osztas_Eredmeny=(SMG_Loszer_darab-1)/50+1;
			SMG_Loszer_Teljes_Craft_Ido=Osztas_Eredmeny*Alapanyag_craftolsai_ido;
		}
		
        //Rifle része
		if(Rifle_Loszer_darab>0&Rifle_Loszer_darab<51) {
			Rifle_Loszer_Teljes_Craft_Ido=(1*Alapanyag_craftolsai_ido);
		}
		else if (Rifle_Loszer_darab>50){
			int Osztas_Eredmeny=(Rifle_Loszer_darab-1)/50+1;
			Rifle_Loszer_Teljes_Craft_Ido=Osztas_Eredmeny*Alapanyag_craftolsai_ido;
		}

        
        int Fegyver_Teljes_Craft_Ido=(Pisztoly_Loszer_Teljes_Craft_Ido+SMG_Loszer_Teljes_Craft_Ido+Rifle_Loszer_Teljes_Craft_Ido);
        
        int Orak=Fegyver_Teljes_Craft_Ido/3600;
        int Percek=(Fegyver_Teljes_Craft_Ido%3600)/60;
        int Masodpercek=Fegyver_Teljes_Craft_Ido%60;

        
        if(Orak==0) {
        	 Loszer_Osszegzo_Craft_ora_Label.setText("0 h");
        }
        if(Percek==0) {
        	 Loszer_Osszegzo_Craft_perc_Label.setText("0 min");
        }
        if(Masodpercek==0) {
        	 Loszer_Osszegzo_Craft_masodperc_Label.setText("0 sec");
        }
        
        Loszer_Osszegzo_Craft_ora_Label.setText(Integer.toString(Orak)+" h");
        Loszer_Osszegzo_Craft_perc_Label.setText(Integer.toString(Percek)+" min");
        Loszer_Osszegzo_Craft_masodperc_Label.setText(Integer.toString(Masodpercek)+" sec");
		
		//Ár
		int Pisztoly_Loszer_Ar2=(Pisztoly_Loszer_darab*Pisztoly_Loszer_Ar);
		int SMG_Loszer_Ar2=(SMG_Loszer_darab*SMG_Loszer_Ar);
		int MG_Loszer_Ar2=(MG_Loszer_darab*MG_Loszer_Ar);
		int Rifle_Loszer_Ar2=(Rifle_Loszer_darab*Rifle_Loszer_Ar);
		int Shotgun_Loszer_Ar2=(Shotgun_Loszer_darab*Shotgun_Loszer_Ar);

			

		int Osszes_Fegyver_Ar=(Pisztoly_Loszer_Ar2+SMG_Loszer_Ar2+Rifle_Loszer_Ar2+Shotgun_Loszer_Ar2+MG_Loszer_Ar2);
        // Összeg fozmázása a láthatóság végett
        
        String Osszes_Fegyver_Ar_Formazott = df.format(Osszes_Fegyver_Ar);
        Loszer_Osszegzo_Armenny_Label.setText(Osszes_Fegyver_Ar_Formazott+" $");
        
        Osszes_Panel_Frissites();

		//Panel frissítése
        Loszer_Osszegzo_Panel.setVisible(false);
		Menu_Osszesito_panel.setVisible(false);
		Menu_Osszesito_panel.setVisible(true);
		 Loszer_Osszegzo_Panel.setVisible(true);
		
	
}
	
	//Ha a lőszer kevesebb lenne mint 0 akkor korrigál
	private static void Loszer_Mennyiseg_Figyeles() {
		if(Pisztoly_Loszer_Mennyiseg.getText().length()<1) {
			Pisztoly_Loszer_Mennyiseg.setText("0");
			Loszer_Frissites();
			
		}
		
		if(SMG_Loszer_Mennyiseg.getText().length()<1) {
			SMG_Loszer_Mennyiseg.setText("0");
			Loszer_Frissites();
			
		}
		if(MG_Loszer_Mennyiseg.getText().length()<1) {
			MG_Loszer_Mennyiseg.setText("0");
			Loszer_Frissites();
			
		}
		if(Rifle_Loszer_Mennyiseg.getText().length()<1) {
			Rifle_Loszer_Mennyiseg.setText("0");
			Loszer_Frissites();
			
		}
		if(Shotgun_Loszer_Mennyiseg.getText().length()<1) {
			Shotgun_Loszer_Mennyiseg.setText("0");
			Loszer_Frissites();
			
		}

		
	}
	
	//Összes ögszezés létrehozása
	private static void Osszes_Panel_Feltoltes() {

		//Anyagok kiírása
		Osszes_Osszegzo_Anyagok_Label.setBounds(5, 8, 200, 60);
		Osszes_Osszegzo_Anyagok_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Osszes_Osszegzo_Anyagok_Label.setForeground(Color.white);
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Anyagok_Label);
		//Acél kiírás és darabszám
		Osszes_Osszegzo_Acel_Label.setBounds(40, 30, 200, 60);
		Osszes_Osszegzo_Acel_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Osszes_Osszegzo_Acel_Label.setForeground(Color.white);
		Osszes_Osszegzo_Acel_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Acel_Label);
		
		Osszes_Osszegzo_Aceldb_Label.setBounds(80, 30, 200, 60);
		Osszes_Osszegzo_Aceldb_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Osszes_Osszegzo_Aceldb_Label.setForeground(Color.white);
		Osszes_Osszegzo_Aceldb_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Osszes_Osszegzo_Aceldb_Label.setText(Osszes_Osszegzo_Aceldb_Label.getText()+" db");
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Aceldb_Label);
		//Vas kiírás és darabszám
		Osszes_Osszegzo_Vas_Label.setBounds(40, 50, 200, 60);
		Osszes_Osszegzo_Vas_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Osszes_Osszegzo_Vas_Label.setForeground(Color.white);
		Osszes_Osszegzo_Vas_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Vas_Label);
		
		Osszes_Osszegzo_Vasdb_Label.setBounds(80, 50, 200, 60);
		Osszes_Osszegzo_Vasdb_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Osszes_Osszegzo_Vasdb_Label.setForeground(Color.white);
		Osszes_Osszegzo_Vasdb_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Osszes_Osszegzo_Vasdb_Label.setText(Osszes_Osszegzo_Vasdb_Label.getText()+" db");
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Vasdb_Label);
		//Réz kiírás és darabszám
		Osszes_Osszegzo_Rez_Label.setBounds(40, 70, 200, 60);
		Osszes_Osszegzo_Rez_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Osszes_Osszegzo_Rez_Label.setForeground(Color.white);
		Osszes_Osszegzo_Rez_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Rez_Label);
		
		Osszes_Osszegzo_Rezdb_Label.setBounds(80, 70, 200, 60);
		Osszes_Osszegzo_Rezdb_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Osszes_Osszegzo_Rezdb_Label.setForeground(Color.white);
		Osszes_Osszegzo_Rezdb_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Osszes_Osszegzo_Rezdb_Label.setText(Osszes_Osszegzo_Rezdb_Label.getText()+" db");
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Rezdb_Label);
		//Súly és darab
		Osszes_Osszegzo_Suly_Label.setBounds(5, 95, 200, 60);
		Osszes_Osszegzo_Suly_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Osszes_Osszegzo_Suly_Label.setForeground(Color.white);
		Osszes_Osszegzo_Suly_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Suly_Label);
		
		Osszes_Osszegzo_Sulykg_Label.setBounds(90, 95, 200, 60);
		Osszes_Osszegzo_Sulykg_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Osszes_Osszegzo_Sulykg_Label.setForeground(Color.white);
		Osszes_Osszegzo_Sulykg_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Osszes_Osszegzo_Sulykg_Label.setText(Osszes_Osszegzo_Sulykg_Label.getText()+" kg");
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Sulykg_Label);
		//Craftolási idő
		Osszes_Osszegzo_Craft_Label.setBounds(30, 120, 200, 60);
		Osszes_Osszegzo_Craft_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Osszes_Osszegzo_Craft_Label.setForeground(Color.white);
		Osszes_Osszegzo_Craft_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Craft_Label);
		
		Osszes_Osszegzo_Craft_ora_Label.setBounds(10, 140, 200, 60);
		Osszes_Osszegzo_Craft_ora_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Osszes_Osszegzo_Craft_ora_Label.setForeground(Color.white);
		Osszes_Osszegzo_Craft_ora_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Osszes_Osszegzo_Craft_ora_Label.setText(Osszes_Osszegzo_Craft_ora_Label.getText()+" h");
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Craft_ora_Label);
		
		Osszes_Osszegzo_Craft_perc_Label.setBounds(50, 140, 200, 60);
		Osszes_Osszegzo_Craft_perc_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Osszes_Osszegzo_Craft_perc_Label.setForeground(Color.white);
		Osszes_Osszegzo_Craft_perc_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Osszes_Osszegzo_Craft_perc_Label.setText(Osszes_Osszegzo_Craft_perc_Label.getText()+" min");
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Craft_perc_Label);
		
		Osszes_Osszegzo_Craft_masodperc_Label.setBounds(110, 140, 200, 60);
		Osszes_Osszegzo_Craft_masodperc_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Osszes_Osszegzo_Craft_masodperc_Label.setForeground(Color.white);
		Osszes_Osszegzo_Craft_masodperc_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Osszes_Osszegzo_Craft_masodperc_Label.setText(Osszes_Osszegzo_Craft_masodperc_Label.getText()+" sec");
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Craft_masodperc_Label);
		//Ár összes
		Osszes_Osszegzo_Ar_Label.setBounds(10, 165, 200, 60);
		Osszes_Osszegzo_Ar_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Osszes_Osszegzo_Ar_Label.setForeground(Color.white);
		Osszes_Osszegzo_Ar_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Ar_Label);
		
		Osszes_Osszegzo_Armenny_Label.setBounds(80, 165, 200, 60);
		Osszes_Osszegzo_Armenny_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		Osszes_Osszegzo_Armenny_Label.setForeground(Color.white);
		Osszes_Osszegzo_Armenny_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Osszes_Osszegzo_Armenny_Label.setText(Osszes_Osszegzo_Armenny_Label.getText()+" $");
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Armenny_Label);
		

	}
	private static void Osszes_Panel_Frissites() {
		DecimalFormat df = new DecimalFormat("#,###");
		DecimalFormat df2 = new DecimalFormat("#.###");
		
		//Nyers anyagok
		int Pisztoly_darab=Integer.parseInt(Pistoly_Mennyiseg.getText());
		int Ap_Pisztoly_darab=Integer.parseInt(AP_Pistoly_Mennyiseg.getText());
		int Tec9_darab=Integer.parseInt(Tec9_Mennyiseg.getText());
		int Micro_SMG_darab=Integer.parseInt(Micro_SMG_Mennyiseg.getText());
		

		int Pisztoly_Nyersanyag=(Pisztoly_darab*Pisztoly_osszerak_darab);
		int AP_Pisztoly_Nyersanyag=(Ap_Pisztoly_darab*Ap_pisztoly_osszerak_darab);
		int Tec9_Nyersanyag=(Tec9_darab*Tec_9_osszerak_darab);
		int Micro_SMG_Nyersanyag=(Micro_SMG_darab*Micro_SMG_osszerak_darab);
		int Osszes_Nyersanyag=(Pisztoly_Nyersanyag+AP_Pisztoly_Nyersanyag+Tec9_Nyersanyag+Micro_SMG_Nyersanyag);
        String Osszes_Fegyver_Nyersanyag_Formazott = df.format(Osszes_Nyersanyag);
        Osszes_Osszegzo_Aceldb_Label.setText(Osszes_Fegyver_Nyersanyag_Formazott+" db");
        Osszes_Osszegzo_Vasdb_Label.setText(Osszes_Fegyver_Nyersanyag_Formazott+" db");
        Osszes_Osszegzo_Rezdb_Label.setText(Osszes_Fegyver_Nyersanyag_Formazott+" db");
        
        int Pisztoly_Loszer_Nyersanyag=0;
		int SMG_Loszer_Nyersanyag=0;
		int MG_Loszer_Nyersanyag=0;
		int Rifle_Loszer_Nyersanyag=0;
		int Shotgun_Loszer_Nyersanyag=0;
		
		int Pisztoly_Loszer_darab=Integer.parseInt(Pisztoly_Loszer_Mennyiseg.getText());
		int SMG_Loszer_darab=Integer.parseInt(SMG_Loszer_Mennyiseg.getText());
		int MG_Loszer_darab=Integer.parseInt(MG_Loszer_Mennyiseg.getText());
		int Rifle_Loszer_darab=Integer.parseInt(Rifle_Loszer_Mennyiseg.getText());
		int Shotgun_Loszer_darab=Integer.parseInt(Shotgun_Loszer_Mennyiseg.getText());
		
		if(Pisztoly_Loszer_darab>0&Pisztoly_Loszer_darab<51) {
			Pisztoly_Loszer_Nyersanyag=(1*Pisztoly_Loszer_Acel);
			System.out.println("Pisztoly loszer nyersanyag kevesebb mint 50 ezert acel= "+Pisztoly_Loszer_Nyersanyag);
		}
		else if(Pisztoly_Loszer_darab>50) {
			int Osztas_Eredmeny=(Pisztoly_Loszer_darab-1)/50+1;
			Pisztoly_Loszer_Nyersanyag=Osztas_Eredmeny*Pisztoly_Loszer_Acel;
			System.out.println("Pisztoly loszer nyersanyag nagyobb mint 50 ezert acel= "+Pisztoly_Loszer_Nyersanyag);
		}
		//SMG
		if(SMG_Loszer_darab>0&SMG_Loszer_darab<51) {
			SMG_Loszer_Nyersanyag=(1*SMG_Loszer_Acel);
			System.out.println("SMG loszer nyersanyag kevesebb mint 50 ezert acel= "+SMG_Loszer_Nyersanyag);
		}
		else if(SMG_Loszer_darab>50) {
			int Osztas_Eredmeny=(SMG_Loszer_darab-1)/50+1;
			SMG_Loszer_Nyersanyag=Osztas_Eredmeny*SMG_Loszer_Acel;
			System.out.println("SMG loszer nyersanyag nagyobb mint 50 ezert acel= "+SMG_Loszer_Nyersanyag);
		}
		//Rifle
		if(Rifle_Loszer_darab>0&Rifle_Loszer_darab<51) {
			Rifle_Loszer_Nyersanyag=(1*Rifle_Loszer_Acel);
			System.out.println("Rifle loszer nyersanyag kevesebb mint 50 ezert acel= "+Rifle_Loszer_Nyersanyag);
		}
		else if(Rifle_Loszer_darab>50){
			int Osztas_Eredmeny=(Rifle_Loszer_darab-1)/50+1;
			Rifle_Loszer_Nyersanyag=Osztas_Eredmeny*Rifle_Loszer_Acel;
			System.out.println("Rifle loszer nyersanyag nagyobb mint 50 ezert acel= "+Rifle_Loszer_Nyersanyag);
		}

		int Osszes_Nyersanyag2=(Pisztoly_Loszer_Nyersanyag+SMG_Loszer_Nyersanyag+Rifle_Loszer_Nyersanyag+Osszes_Nyersanyag);
        String Osszes_Fegyver_Nyersanyag_Formazott2 = df.format(Osszes_Nyersanyag2);
        Osszes_Osszegzo_Aceldb_Label.setText(Osszes_Fegyver_Nyersanyag_Formazott2+" db");
		
		//Súly
        
        float Pisztoly_Suly=(Pisztoly_darab*((float)Pisztoly_suly));
        float AP_Pisztoly_Suly=(Ap_Pisztoly_darab*((float)AP_pisztoly_suly));
        float Tec9_Suly=(Tec9_darab*((float)Tec9_suly));
        float Micro_SMG_Suly=(Micro_SMG_darab*((float)Micro_SMG_suly));
		float Osszes_Suly=(Pisztoly_Suly+AP_Pisztoly_Suly+Tec9_Suly+Micro_SMG_Suly);
        String Osszes_Suly_Formazott = df2.format(Osszes_Suly);
        Osszes_Osszegzo_Sulykg_Label.setText(Osszes_Suly_Formazott+" kg");
        
        float Pisztoly_Loszer_Suly2=(Pisztoly_Loszer_darab*((float)Pisztoly_Loszer_Suly));
        float SMG_Loszer_Suly2=(SMG_Loszer_darab*((float)SMG_Loszer_Suly));
        float MG_Loszer_Suly2=(MG_Loszer_darab*((float)MG_Loszer_Suly));
        float Rifle_Loszer_Suly2=(Rifle_Loszer_darab*((float)Rifle_Loszer_Suly));
        float Shotgun_Loszer_Suly2=(Shotgun_Loszer_darab*((float)Shotgun_Loszer_Suly));
        
        
        float Osszes_Suly2=(Pisztoly_Loszer_Suly2+SMG_Loszer_Suly2+MG_Loszer_Suly2+Rifle_Loszer_Suly2+Shotgun_Loszer_Suly2+Osszes_Suly);
        String Osszes_Suly_Formazott2 = df2.format(Osszes_Suly2);
        Osszes_Osszegzo_Sulykg_Label.setText(Osszes_Suly_Formazott2+" kg");
        
        //Craftolási idő
        
        int Pisztoly_Teljes_Craft_Ido=(Pisztoly_darab*Alapanyag_craftolsai_ido*Pisztoly_osszerak_darab+Pisztoly_darab*Fegyver_craftolsai_ido);
        int AP_Pisztoly_Teljes_Craft_Ido=(Ap_Pisztoly_darab*Alapanyag_craftolsai_ido*Ap_pisztoly_osszerak_darab+Ap_Pisztoly_darab*Fegyver_craftolsai_ido);
        int Tec9_Teljes_Craft_Ido=(Tec9_darab*Alapanyag_craftolsai_ido*Tec_9_osszerak_darab+Tec9_darab*Fegyver_craftolsai_ido);
        int Micro_SMG_Teljes_Craft_Ido=(Micro_SMG_darab*Alapanyag_craftolsai_ido*Micro_SMG_osszerak_darab+Micro_SMG_darab*Fegyver_craftolsai_ido);
        
        int Fegyver_Teljes_Craft_Ido=(Pisztoly_Teljes_Craft_Ido+AP_Pisztoly_Teljes_Craft_Ido+Tec9_Teljes_Craft_Ido+Micro_SMG_Teljes_Craft_Ido);
        
        int Orak=Fegyver_Teljes_Craft_Ido/3600;
        int Percek=(Fegyver_Teljes_Craft_Ido%3600)/60;
        int Masodpercek=Fegyver_Teljes_Craft_Ido%60;
        Osszes_Osszegzo_Craft_ora_Label.setText(Integer.toString(Orak)+" h");
        Osszes_Osszegzo_Craft_perc_Label.setText(Integer.toString(Percek)+" min");
        Osszes_Osszegzo_Craft_masodperc_Label.setText(Integer.toString(Masodpercek)+" sec");
        
        if(Orak==0) {
        	Osszes_Osszegzo_Craft_ora_Label.setText("0 h");
        }
        if(Percek==0) {
        	Osszes_Osszegzo_Craft_perc_Label.setText("0 min");
        }
        if(Masodpercek==0) {
        	Osszes_Osszegzo_Craft_masodperc_Label.setText("0 sec");
        }
        

        int Pisztoly_Loszer_Teljes_Craft_Ido=(Pisztoly_Loszer_darab*Alapanyag_craftolsai_ido);
        int SMG_Loszer_Teljes_Craft_Ido=(SMG_Loszer_darab*Alapanyag_craftolsai_ido);
        int Rifle_Loszer_Teljes_Craft_Ido=(Rifle_Loszer_darab*Alapanyag_craftolsai_ido);
        
        //Pisztoly része
		if(Pisztoly_Loszer_darab>0&Pisztoly_Loszer_darab<51) {
			Pisztoly_Loszer_Teljes_Craft_Ido=(1*Alapanyag_craftolsai_ido);
		}
		else if(Pisztoly_Loszer_darab>50){
			int Osztas_Eredmeny=(Pisztoly_Loszer_darab-1)/50+1;
			Pisztoly_Loszer_Teljes_Craft_Ido=Osztas_Eredmeny*Alapanyag_craftolsai_ido;
		}
		
        //SMG része
		if(SMG_Loszer_darab>0&SMG_Loszer_darab<51) {
			SMG_Loszer_Teljes_Craft_Ido=(1*Alapanyag_craftolsai_ido);
		}
		else if(SMG_Loszer_darab>50){
			int Osztas_Eredmeny=(SMG_Loszer_darab-1)/50+1;
			SMG_Loszer_Teljes_Craft_Ido=Osztas_Eredmeny*Alapanyag_craftolsai_ido;
		}
		
        //Rifle része
		if(Rifle_Loszer_darab>0&Rifle_Loszer_darab<51) {
			Rifle_Loszer_Teljes_Craft_Ido=(1*Alapanyag_craftolsai_ido);
		}
		else if (Rifle_Loszer_darab>50){
			int Osztas_Eredmeny=(Rifle_Loszer_darab-1)/50+1;
			Rifle_Loszer_Teljes_Craft_Ido=Osztas_Eredmeny*Alapanyag_craftolsai_ido;
		}

        
        int Loszer_Teljes_Craft_Ido=(Pisztoly_Loszer_Teljes_Craft_Ido+SMG_Loszer_Teljes_Craft_Ido+Rifle_Loszer_Teljes_Craft_Ido+Fegyver_Teljes_Craft_Ido);
        
        int Orak2=Loszer_Teljes_Craft_Ido/3600;
        int Percek2=(Loszer_Teljes_Craft_Ido%3600)/60;
        int Masodpercek2=Loszer_Teljes_Craft_Ido%60;

        
        if(Orak2==0) {
        	 Osszes_Osszegzo_Craft_ora_Label.setText("0 h");
        }
        if(Percek2==0) {
        	Osszes_Osszegzo_Craft_perc_Label.setText("0 min");
        }
        if(Masodpercek2==0) {
        	Osszes_Osszegzo_Craft_masodperc_Label.setText("0 sec");
        }
        
        Osszes_Osszegzo_Craft_ora_Label.setText(Integer.toString(Orak2)+" h");
        Osszes_Osszegzo_Craft_perc_Label.setText(Integer.toString(Percek2)+" min");
        Osszes_Osszegzo_Craft_masodperc_Label.setText(Integer.toString(Masodpercek2)+" sec");
        
        //Árak összes
        int Pisztoly_Ar=(Pisztoly_darab*Pisztoly_ar);
		if(Pisztoly_darab>4&Pisztoly_darab<=9) {
			double Pisztoly_Ar2=(Pisztoly_Ar*0.9);
			Pisztoly_Ar=((int)Pisztoly_Ar2);
		}if(Pisztoly_darab>9) {
			double Pisztoly_Ar2=(Pisztoly_Ar*0.7);
			Pisztoly_Ar=((int)Pisztoly_Ar2);
		}
		
	int AP_Pisztoly_Ar=(Ap_Pisztoly_darab*Ap_Pisztoly_ar);
		if(Ap_Pisztoly_darab>4&Ap_Pisztoly_darab<=9) {
			double AP_Pisztoly_Ar2=(AP_Pisztoly_Ar*0.92);
			AP_Pisztoly_Ar=((int)AP_Pisztoly_Ar2);
		}if(Ap_Pisztoly_darab>9) {
			double AP_Pisztoly_Ar2=(AP_Pisztoly_Ar*0.84);
			AP_Pisztoly_Ar=((int)AP_Pisztoly_Ar2);
		}
		
	int Tec9_Ar=(Tec9_darab*Tec9_ar);
		if(Tec9_darab>4&Tec9_darab<=9) {
			double Tec9_Ar2=(Tec9_Ar*0.86);
			Tec9_Ar=((int)Tec9_Ar2);
		}if(Tec9_darab>9) {
			double Tec9_Ar2=(Tec9_Ar*0.73);
			Tec9_Ar=((int)Tec9_Ar2);
		}
		
	int Micro_SMG_Ar=(Micro_SMG_darab*Micro_SMG_ar);
		if(Micro_SMG_darab>4&Micro_SMG_darab<=9) {
			double Micro_SMG_Ar2=(Micro_SMG_Ar*0.93);
			Micro_SMG_Ar=((int)Micro_SMG_Ar2);
		}if(Micro_SMG_darab>9) {
			double Micro_SMG_Ar2=(Micro_SMG_Ar*0.83);
			Micro_SMG_Ar=((int)Micro_SMG_Ar2);
		}

	int Osszes_Fegyver_Ar=(Pisztoly_Ar+AP_Pisztoly_Ar+Tec9_Ar+Micro_SMG_Ar);
    // Összeg fozmázása a láthatóság végett
    
    String Osszes_Fegyver_Ar_Formazott = df2.format(Osszes_Fegyver_Ar);
    Osszes_Osszegzo_Armenny_Label.setText(Osszes_Fegyver_Ar_Formazott+" $");
        
        
		int Pisztoly_Loszer_Ar2=(Pisztoly_Loszer_darab*Pisztoly_Loszer_Ar);
		int SMG_Loszer_Ar2=(SMG_Loszer_darab*SMG_Loszer_Ar);
		int MG_Loszer_Ar2=(MG_Loszer_darab*Pisztoly_Loszer_Ar);
		int Rifle_Loszer_Ar2=(Rifle_Loszer_darab*Rifle_Loszer_Ar);
		int Shotgun_Loszer_Ar2=(Shotgun_Loszer_darab*Shotgun_Loszer_Ar);

			

		int Osszes_Fegyver_Ar2=(Pisztoly_Loszer_Ar2+SMG_Loszer_Ar2+Rifle_Loszer_Ar2+Shotgun_Loszer_Ar2+MG_Loszer_Ar2+Osszes_Fegyver_Ar);
        // Összeg fozmázása a láthatóság végett
        
        String Osszes_Fegyver_Ar_Formazott2 = df.format(Osszes_Fegyver_Ar2);
        Osszes_Osszegzo_Armenny_Label.setText(Osszes_Fegyver_Ar_Formazott2+" $");
        
        
		
        Loszer_Osszegzo_Panel.setVisible(false);
		Menu_Osszesito_panel.setVisible(false);
		Menu_Osszesito_panel.setVisible(true);
		Loszer_Osszegzo_Panel.setVisible(true);
	}
}
