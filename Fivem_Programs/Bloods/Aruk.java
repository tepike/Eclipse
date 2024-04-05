package Bloods;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	
	//Lőszer árak
	static int Pisztoly_Loszer=250;
	static int SMG_Loszer=350;
	static int Rifle_Loszer=550;
	static int Shotgun_Loszer=550;
	
	//Craftolási plusszok
	static int Alapanyag_craftolsai_ido=13;
	static int Fegyver_craftolsai_ido=20;
	
	//Fegyver súlyok
	static double Pisztoly_suly=0.97;
	static double Tec9_suly=1.4;
	static double Micro_SMG_suly=4;
	static double AP_pisztoly_suly=1.22;
	
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
	
	//Lőszer_Mennyiseg panel
	
	
	
	
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
	static JLabel Loszer_Osszegzo_Sulykg_Label= new JLabel("kg");
	static JLabel Loszer_Osszegzo_Anyagok_Label = new JLabel("Szükséges anyagok:");
	static JLabel Loszer_Osszegzo_Ar_Label = new JLabel("Ár:");
	static JLabel Loszer_Osszegzo_Armenny_Label = new JLabel("100_000_000");
	static JLabel Loszer_Osszegzo_Acel_Label= new JLabel("Acél:");
	static JLabel Loszer_Osszegzo_Vas_Label= new JLabel("Vas:");
	static JLabel Loszer_Osszegzo_Rez_Label= new JLabel("Réz:");
	static JLabel Loszer_Osszegzo_Aceldb_Label= new JLabel("10_000");
	static JLabel Loszer_Osszegzo_Vasdb_Label= new JLabel("10_000");
	static JLabel Loszer_Osszegzo_Rezdb_Label= new JLabel("10_000");
	static JLabel Loszer_Osszegzo_Craft_Label= new JLabel("Craftolás:");
	
	static JPanel Osszes_Osszegzo_Panel= new JPanel();
	static JLabel Osszes_Osszegzo_Label = new JLabel("Teljes adat");
	static JLabel Osszes_Osszegzo_Suly_Label= new JLabel("Súly össz:");
	static JLabel Osszes_Osszegzo_Sulykg_Label= new JLabel("kg");
	static JLabel Osszes_Osszegzo_Anyagok_Label = new JLabel("Szükséges anyagok össz:");
	static JLabel Osszes_Osszegzo_Ar_Label = new JLabel("Ár össz:");
	static JLabel Osszes_Osszegzo_Armenny_Label = new JLabel("100_000_000");
	static JLabel Osszes_Osszegzo_Acel_Label= new JLabel("Acél:");
	static JLabel Osszes_Osszegzo_Vas_Label= new JLabel("Vas:");
	static JLabel Osszes_Osszegzo_Rez_Label= new JLabel("Réz:");
	static JLabel Osszes_Osszegzo_Aceldb_Label= new JLabel("10_000");
	static JLabel Osszes_Osszegzo_Vasdb_Label= new JLabel("10_000");
	static JLabel Osszes_Osszegzo_Rezdb_Label= new JLabel("10_000");
	static JLabel Osszes_Osszegzo_Craft_Label= new JLabel("Craftolás:");
	
	static JButton Reset_gomb=new JButton("Reset");
	
	
	
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
		
		Reset_gomb.setBounds(900, 530, 80, 30);
		Reset_gomb.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Reset");

		}});
		
		
		
		//Mennyiség 
		kiegeszitok_hozzadasa();
		
		

		
		Menu_panel.add(Pisztoly_panel);
		Menu_panel.add(AP_Pisztoly_panel);
		Menu_panel.add(Tec_9_panel);
		Menu_panel.add(Micro_SMG_panel);
		Menu_panel.add(Pistoly_Mennyiseg_panel);
		Menu_panel.add(AP_Pistoly_Mennyiseg_panel);
		Menu_panel.add(Tec9_Mennyiseg_panel);
		Menu_panel.add(Micro_SMG_Mennyiseg_panel);
		Menu_panel.add(Reset_gomb);
		
		

		
		
		
		
	}
	
	//Átláthatóságot segítő részek
	
	private static void kiegeszitok_hozzadasa() {
		Pisztoly_Megadas();
		AP_Pisztoly_Megadas();
		Tec9_Megadas();
		Micro_SMG_Megadas();

		Osszegzo_Panel_Letrehozas();
		Osszegzo_Panel_Feltoltes();
		
	}
	
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
		Pistoly_Mennyiseg.setEditable(false);
		
		
		
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
		AP_Pistoly_Mennyiseg.setEditable(false);
		
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
		Tec9_Mennyiseg.setEditable(false);
		
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
		Micro_SMG_Mennyiseg.setEditable(false);
		
		Micro_SMG_Mennyiseg_panel.add(Micro_SMG_Minusz);
		Micro_SMG_Mennyiseg_panel.add(Micro_SMG_Mennyiseg);
		Micro_SMG_Mennyiseg_panel.add(Micro_SMG_Plusz);
		
	}	
	private static void Osszegzo_Panel_Letrehozas() {
		//Összegző panel kitöltés
		Fegyver_Osszegzo_Panel.setBackground(new Color(50,50,50,150));
		Fegyver_Osszegzo_Panel.setBounds(5,10,190,215);
		Fegyver_Osszegzo_Panel.setLayout(null);
		
		Fegyver_Osszegzo_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		Fegyver_Osszegzo_Label.setForeground(Color.white);
		Fegyver_Osszegzo_Label.setBounds(5, 3, 190, 30);
		Fegyver_Osszegzo_Panel.add(Fegyver_Osszegzo_Label);
		
		
		Loszer_Osszegzo_Panel.setBackground(new Color(50,50,50,150));
		Loszer_Osszegzo_Panel.setBounds(5,230,190,215);
		Loszer_Osszegzo_Panel.setLayout(null);
		
		Loszer_Osszegzo_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		Loszer_Osszegzo_Label.setForeground(Color.white);
		Loszer_Osszegzo_Label.setBounds(10, 3, 190, 30);
		Loszer_Osszegzo_Panel.add(Loszer_Osszegzo_Label);
		
		Osszes_Osszegzo_Panel.setBackground(new Color(50,50,50,150));
		Osszes_Osszegzo_Panel.setBounds(5,450,190,210);
		Osszes_Osszegzo_Panel.setLayout(null);
		
		Osszes_Osszegzo_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		Osszes_Osszegzo_Label.setForeground(Color.white);
		Osszes_Osszegzo_Label.setBounds(45, 3, 190, 30);
		Osszes_Osszegzo_Panel.add(Osszes_Osszegzo_Label);
		
		Menu_Osszesito_panel.add(Fegyver_Osszegzo_Panel);
		Menu_Osszesito_panel.add(Loszer_Osszegzo_Panel);
		Menu_Osszesito_panel.add(Osszes_Osszegzo_Panel);
	}
	private static void Osszegzo_Panel_Feltoltes() {
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

	private static void Fegyver_Frissites() {
		
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
		//Súly
		int Pisztoly_Suly=(Pisztoly_darab*((int)Pisztoly_suly));
		int AP_Pisztoly_Suly=(Ap_Pisztoly_darab*((int)AP_pisztoly_suly));
		int Tec9_Suly=(Tec9_darab*((int)Tec9_suly));
		int Micro_SMG_Suly=(Micro_SMG_darab*((int)Micro_SMG_suly));
		int Osszes_Suly=(Pisztoly_Suly+AP_Pisztoly_Suly+Tec9_Suly+Micro_SMG_Suly);
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
        DecimalFormat df = new DecimalFormat("#,###");
        String Osszes_Fegyver_Ar_Formazott = df.format(Osszes_Fegyver_Ar);
		Fegyver_Osszegzo_Armenny_Label.setText(Osszes_Fegyver_Ar_Formazott);
		
		
		
		
		
		
		
		
		
		
		
		
		
		Fegyver_Osszegzo_Panel.setVisible(false);
		Menu_Osszesito_panel.setVisible(false);
		Menu_Osszesito_panel.setVisible(true);
		Fegyver_Osszegzo_Panel.setVisible(true);
		
	
}

}
