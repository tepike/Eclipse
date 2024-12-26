package Cluedo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

public class Mezok extends Alapkep{
	static boolean Mezo_Szam_Lathato=true;
	static int Mezo_X;
	static int Mezo_Y;
	static boolean Eger_belepett=false;
	static boolean Eger_kilepett=true;
	static boolean Mezo_Mehet=true;
	static int a=0;
	static int Mezo_Eger=0;
	static JPanel[] Mezok=new JPanel[300];
	static JLabel [] Mezo_Szamok= new JLabel[300];
	public static Timer kocka_timer=new Timer();
	static Random random= new Random();
	static boolean lepehet=false;
	static ArrayList<Boolean> Gyilkos_Szoba_Tarolas= new ArrayList<Boolean>();
	static ArrayList<Boolean> Gyilkos_Tarolas= new ArrayList<Boolean>();
	static ArrayList<Boolean> Gyilkos_Fegyver_Tarolas= new ArrayList<Boolean>();
	public static int Gyilkos_Mezo_index_Megadas;
	public static int Gyilkos_Fegyver_Mezo_index_Megadas;
	public static int Gyilkos_Szoba_Mezo_index_Megadas;
	
	public static String Generalt_Gyilkos;
	public static String Generalt_Gyilkos_Fegyver;
	public static String Generalt_Gyilkos_Szoba;
	public static String Generalt_Halott;;
	
	static void Mezo_Betoltes() {

		for(int i=0;i<300;i++) {
			//System.out.println("Mezo letrehoz: "+i);
			
			Mezok[i]=new JPanel();
			Mezok[i].setLayout(new GridBagLayout());
			Mezo_Szamok[i] =new JLabel(Integer.toString(i+1));
			Mezok[i].add(Mezo_Szamok[i]);
			Jatek_Hatterkep.add(Mezok[i]);
			Mezok[i].setVisible(false);
			Mezo_Szamok[i].setVisible(Mezo_Szam_Lathato);
		}
		
		Mezok[0].setBounds(150, Jatek_Hatterkep.getHeight()/2-100, 45, 45);
		Mezok[0].setBackground(new Color(255,255,255,200));
		Mezok[0].setVisible(true);
		//Elso oszlop letrehozas
		for(int i =1;i<7;i++) {
			if(i==1){
			Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+55, (int)Mezok[0].getLocation().getY(), 45, 45);
			Mezok[i].setBackground(new Color(255,255,255,200));
			Mezok[i].setVisible(true);
		}
			if(i==2) {
				Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+55, (int)Mezok[0].getLocation().getY()-55, 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
			}
			if(i>2) {
			Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+55, (int)Mezok[i-1].getLocation().getY()+55, 45, 45);
				if(i==3) {
					Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+55, (int)Mezok[i].getLocation().getY()+55, 45, 45);
				}
			Mezok[i].setBackground(new Color(255,255,255,200));
			Mezok[i].setVisible(true);
			}
		}
		
		//Masodik oszlop letrehozas
		for(int i =7;i<13;i++) {
			if(i==7){
			Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+110, (int)Mezok[0].getLocation().getY(), 45, 45);
			Mezok[i].setBackground(new Color(255,255,255,200));
			Mezok[i].setVisible(true);
		}
			if(i==8) {
				Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+110, (int)Mezok[0].getLocation().getY()-55, 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
			}
			if(i>8) {
			Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+110, (int)Mezok[i-1].getLocation().getY()+55, 45, 45);
				if(i==9) {
					Mezok[i].setBounds((int)Mezok[0].getLocation().getX()+110, (int)Mezok[i].getLocation().getY()+55, 45, 45);
				}
			Mezok[i].setBackground(new Color(255,255,255,200));
			Mezok[i].setVisible(true);
			}
		}
		
		Mezok[14]=new JPanel();
		Mezok[14].setLayout(new GridBagLayout());
		Mezok[14].setBounds((int)Mezok[9].getLocation().getX()+55, (int)Mezok[9].getLocation().getY(), 45, 45);
		Mezo_Szamok[14] =new JLabel("15");
		Mezok[14].add(Mezo_Szamok[14]);
		Mezok[14].setBackground(new Color(255,255,255,200));
		Jatek_Hatterkep.add(Mezok[14]);
		Mezo_Szamok[14].setVisible(Mezo_Szam_Lathato);
		Mezok[14].setVisible(true);
		
		Mezok[15]=new JPanel();
		Mezok[15].setLayout(new GridBagLayout());
		Mezok[15].setBounds((int)Mezok[14].getLocation().getX()+55, (int)Mezok[14].getLocation().getY(), 45, 45);
		Mezo_Szamok[15] =new JLabel("16");
		Mezok[15].add(Mezo_Szamok[15]);
		Mezok[15].setBackground(new Color(255,255,255,200));
		Jatek_Hatterkep.add(Mezok[15]);
		Mezo_Szamok[15].setVisible(Mezo_Szam_Lathato);
		Mezok[15].setVisible(true);
		

		Mezok[16]=new JPanel();
		Mezok[16].setLayout(new GridBagLayout());
		Mezok[16].setBounds((int)Mezok[15].getLocation().getX()+55, (int)Mezok[15].getLocation().getY(), 45, 45);
		Mezo_Szamok[16] =new JLabel("17");
		Mezok[16].add(Mezo_Szamok[16]);
		Mezok[16].setBackground(new Color(255,255,255,200));
		Jatek_Hatterkep.add(Mezok[16]);
		Mezo_Szamok[16].setVisible(Mezo_Szam_Lathato);
		Mezok[16].setVisible(true);
		
		
		//Belépési mezők: 
		
		Mezok[13]=new JPanel();
		Mezok[13].setBounds((int)Mezok[0].getLocation().getX()+110, (int)Mezok[0].getLocation().getY()-110, 45, 45);
		Mezok[13].setLayout(new GridBagLayout());
		Mezo_Szamok[13] =new JLabel("14");
		Mezok[13].add(Mezo_Szamok[13]);
		Jatek_Hatterkep.add(Mezok[13]);
		Mezo_Szamok[13].setVisible(Mezo_Szam_Lathato);
		Mezok[13].setVisible(true);
		Mezok[13].setBackground(new Color(255,255,255,200));
		Mezok[12].setBackground(new Color(255,255,255,200));
		 
		 

		Kozepso_Mezok();
		Mezo_Szobak();
		
		System.out.println("Mezo betoltve");
	}
	static void Kozepso_Mezok() {
		Mezo_eger();
		System.out.println("Belso mezok betoltese");
		for(int i =17;i<38;i++) {
			//Belső tér
			if(i==17){
			Mezok[i].setBounds((int)Mezok[16].getLocation().getX()+55, (int)Mezok[8].getLocation().getY()-55, 45, 45);
			Mezok[i].setBackground(new Color(255,255,255,200));
			Mezok[i].setVisible(true);
			
		}
			if(i>17){
				Mezok[i].setBounds((int)Mezok[17].getLocation().getX(), (int)Mezok[17].getLocation().getY()+a, 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
			}

			System.out.println(i);
			if(i==24) {
				a=0;
				System.err.println("A reset");
				Mezok[i].setBounds((int)Mezok[16].getLocation().getX()+238, (int)Mezok[17].getLocation().getY()+a, 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
			}
			if(i>24) {
				Mezok[i].setBounds((int)Mezok[24].getLocation().getX(), (int)Mezok[17].getLocation().getY()+a, 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
				
			}
			
			if(i==31) {
				a=0;
				System.err.println("A reset");
				Mezok[i].setBounds((int)Mezok[16].getLocation().getX()+470, (int)Mezok[17].getLocation().getY()+a, 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
			}
			if(i>31) {
				Mezok[i].setBounds((int)Mezok[31].getLocation().getX(), (int)Mezok[17].getLocation().getY()+a, 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
				
			}
			a=a+55;
			
		}
		a=60;
		
		//Belsőtér vizszintes sor kitoltes
		for(int i= 38;i<53;i++) {
			//felso sor
			Mezok[i].setBounds((int)Mezok[17].getLocation().getX()+a, (int)Mezok[17].getLocation().getY(), 45, 45);
			Mezok[i].setBackground(new Color(255,255,255,200));
			Mezok[i].setVisible(true);
			if(i==40) {
				Mezok[i].setBounds((int)Mezok[17].getLocation().getX()+a+65, (int)Mezok[17].getLocation().getY(), 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
				a=a+60;
			}
			
			//Kozepso sor
			if(i==42) {
				a=0;
			}
			if(i>42) {
				Mezok[i].setBounds((int)Mezok[20].getLocation().getX()+a, (int)Mezok[20].getLocation().getY(), 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
			}
			if(i==45) {
				Mezok[i].setBounds((int)Mezok[20].getLocation().getX()+a+65, (int)Mezok[20].getLocation().getY(), 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
				a=a+60;
			}
			
			//Also sor
			
			if(i==47) {
				a=0;
			}
			if(i>47) {
				Mezok[i].setBounds((int)Mezok[23].getLocation().getX()+a, (int)Mezok[23].getLocation().getY(), 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
			}
			if(i==50) {
				Mezok[i].setBounds((int)Mezok[23].getLocation().getX()+a+65, (int)Mezok[23].getLocation().getY(), 45, 45);
				Mezok[i].setBackground(new Color(255,255,255,200));
				Mezok[i].setVisible(true);
				a=a+60;
			}
			
			a=a+60;
			
		}
	}
	static void Mezo_Szobak() {
		//Számozás kezdődik 53-tól
		Mezok[53].setBounds(90, 80, 280, 180);
		Mezok[53].setBackground(new Color(255,255,255,50));
		Mezok[53].add(Mezo_Szamok[53]);
		Jatek_Hatterkep.add(Mezok[53]);
		Mezok[53].setVisible(true);
		Mezo_Szamok[53].setVisible(true);

		
		Mezok[54].setBounds(400, 80, 250, 180);
		Mezok[54].setBackground(new Color(255,255,255,50));
		Mezok[54].add(Mezo_Szamok[54]);
		Jatek_Hatterkep.add(Mezok[54]);
		Mezok[54].setVisible(true);
		Mezo_Szamok[54].setVisible(true);
		
		Mezok[55].setBounds(670, 80, 190, 180);
		Mezok[55].setBackground(new Color(255,255,255,50));
		Mezok[55].add(Mezo_Szamok[55]);
		Jatek_Hatterkep.add(Mezok[55]);
		Mezok[55].setVisible(true);
		Mezo_Szamok[55].setVisible(true);
		
		Mezok[56].setBounds(890, 80, 100, 180);
		Mezok[56].setBackground(new Color(255,255,255,50));
		Mezok[56].add(Mezo_Szamok[56]);
		Jatek_Hatterkep.add(Mezok[56]);
		Mezok[56].setVisible(true);
		Mezo_Szamok[56].setVisible(true);
		
		Mezok[57].setBounds(1020, 80, 230, 180);
		Mezok[57].setBackground(new Color(255,255,255,50));
		Mezok[57].add(Mezo_Szamok[57]);
		Jatek_Hatterkep.add(Mezok[57]);
		Mezok[57].setVisible(true);
		Mezo_Szamok[57].setVisible(true);
		
		Mezok[58].setBounds(1020, 280, 230, 160);
		Mezok[58].setBackground(new Color(255,255,255,50));
		Mezok[58].add(Mezo_Szamok[58]);
		Jatek_Hatterkep.add(Mezok[58]);
		Mezok[58].setVisible(true);
		Mezo_Szamok[58].setVisible(true);
		
		Mezok[59].setBounds(1040, 460, 210, 210);
		Mezok[59].setBackground(new Color(255,255,255,50));
		Mezok[59].add(Mezo_Szamok[59]);
		Jatek_Hatterkep.add(Mezok[59]);
		Mezok[59].setVisible(true);
		Mezo_Szamok[59].setVisible(true);
		
		Mezok[60].setBounds(1020, 690, 210, 300);
		Mezok[60].setBackground(new Color(255,255,255,50));
		Mezok[60].add(Mezo_Szamok[60]);
		Jatek_Hatterkep.add(Mezok[60]);
		Mezok[60].setVisible(true);
		Mezo_Szamok[60].setVisible(true);
		
		Mezok[61].setBounds(570, 750, 250, 240);
		Mezok[61].setBackground(new Color(255,255,255,50));
		Mezok[61].add(Mezo_Szamok[61]);
		Jatek_Hatterkep.add(Mezok[61]);
		Mezok[61].setVisible(true);
		Mezo_Szamok[61].setVisible(true);
		
		Mezok[62].setBounds(90, 750, 290, 240);
		Mezok[62].setBackground(new Color(255,255,255,50));
		Mezok[62].add(Mezo_Szamok[62]);
		Jatek_Hatterkep.add(Mezok[62]);
		Mezok[62].setVisible(true);
		Mezo_Szamok[62].setVisible(true);
		
		Mezok[63].setBounds(50, 525, 110, 200);
		Mezok[63].setBackground(new Color(255,255,255,50));
		Mezok[63].add(Mezo_Szamok[63]);
		Jatek_Hatterkep.add(Mezok[63]);
		Mezok[63].setVisible(true);
		Mezo_Szamok[63].setVisible(true);
		
		for(int i =1;i<12;i++) {
			Gyilkos_Szoba_Tarolas.add(false);
			Gyilkos_Tarolas.add(false);
			Gyilkos_Fegyver_Tarolas.add(false);
		}
		Gyilkos_Dolgok_Betoltese();

		
	}
	
	public static void Szoba_eger() {
		for(int i=53;i<65;i++) {
			 final int Mezo_Eger=i;
			 Mezok[i].addMouseListener(new MouseInputAdapter() {
				 public void mouseExited(MouseEvent e) {
						if(Eger_belepett&&Eger_kilepett&&lepehet) {
						//System.out.println("Eger kilepett");
						Eger_belepett=false;
						Eger_kilepett=true;
						Mezok[Mezo_Eger].setBorder(BorderFactory.createEmptyBorder());
						Jatek_Hatterkep.repaint();
						Jatek_Alap_Hatterkep.repaint();
						}
						
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						if(!Eger_belepett&&lepehet) {
						//System.out.println("Eger belepett");
						Mezo_X=((int)Mezok[Mezo_Eger].getLocation().getX());
						Mezo_Y=((int)Mezok[Mezo_Eger].getLocation().getY());
						Eger_belepett=true;
						Mezok[Mezo_Eger].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
						Jatek_Hatterkep.repaint();
						Jatek_Alap_Hatterkep.repaint();
						
						}
					}
				 
				 
				 public void mouseReleased(MouseEvent e) {
						if(lepehet) {
						//System.err.println("Mezo megnyomva");
						if(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()<65&&Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()>52) {
							Mezok[Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()].setBackground(new Color(255,255,255,50));
						}
						if(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()<53) {
							Mezok[Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()].setBackground(new Color(255,255,255,200));
						}
						Elindult.kovetkezo=true;
						lepehet=false;
						//eger kilepes javitas 				

						Eger_belepett=false;
						Eger_kilepett=true;
						Mezok[Mezo_Eger].setBorder(BorderFactory.createEmptyBorder());
						Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).setMezon_all(Integer.parseInt(Mezo_Szamok[Mezo_Eger].getText())-1);
						
						
							//Gyilkos megtalálás
						if(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()==Gyilkos_Mezo_index_Megadas) {
						System.err.println("Gyilkos megtalalva");
						Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).setTalat_Gyilkos(Boolean.TRUE);
						Kivalasztott_Karakterek.Megtalalt_Gyilkos.get(Elindult.Aktiv_Karakter_Id-1).setIcon(Kivalasztott_Karakterek.Gyilkos);
						
						JLabel szoveg= new JLabel(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getNev()+" megtalálta a gyilkost!");
						Kivalasztott_Karakterek.Jatek_Szoveg.add(szoveg);
						Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setBounds(5, 5, 240, 16);
						Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setForeground(Color.white);
						Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setFont(new Font("Arial", 1, 13));
						Kivalasztott_Karakterek.Action_Text.add(Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1));
						if(Kivalasztott_Karakterek.Jatek_Szoveg.size()>1) {
							Kivalasztott_Karakterek.Jatek_Szoveg_Gorget();
							int magas=((int)Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).getLocation().getY()+30);
							Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setBounds(5, magas, 240, 16);
						}
						
						
						}
							//Gyilkos Fegyver megtalálás
						if(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()==Gyilkos_Fegyver_Mezo_index_Megadas) {
						System.err.println("Gyilkos fegyver megtalalva");
						Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).setTalat_Fegyver(Boolean.TRUE);
						Kivalasztott_Karakterek.Megtalalt_Fegyver.get(Elindult.Aktiv_Karakter_Id-1).setIcon(Kivalasztott_Karakterek.Fegyver);
						
						JLabel szoveg= new JLabel(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getNev()+" megtalálta a gyilkos fegyvert");
						Kivalasztott_Karakterek.Jatek_Szoveg.add(szoveg);
						Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setBounds(5, 5, 240, 16);
						Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setForeground(Color.white);
						Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setFont(new Font("Arial", 1, 13));
						Kivalasztott_Karakterek.Action_Text.add(Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1));
						if(Kivalasztott_Karakterek.Jatek_Szoveg.size()>1) {
							Kivalasztott_Karakterek.Jatek_Szoveg_Gorget();
							int magas=((int)Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).getLocation().getY()+Kivalasztott_Karakterek.Szoveg_magas_tav);
							Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setBounds(5, magas, 240, 16);
						}
						
						
						}
							//Gyilkos szoba megtalálás
						if(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()==Gyilkos_Szoba_Mezo_index_Megadas) {
						System.err.println("Gyilkos fegyver megtalalva");
						Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).setTalat_Szoba(Boolean.TRUE);
						Kivalasztott_Karakterek.Megtalalt_Szoba.get(Elindult.Aktiv_Karakter_Id-1).setIcon(Kivalasztott_Karakterek.Szoba);
						
						JLabel szoveg= new JLabel(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getNev()+" megtalálta a gyilkos szobát ");
						Kivalasztott_Karakterek.Jatek_Szoveg.add(szoveg);
						Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setBounds(5, 5, 240, 16);
						Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setForeground(Color.white);
						Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setFont(new Font("Arial", 1, 13));
						Kivalasztott_Karakterek.Action_Text.add(Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1));
						if(Kivalasztott_Karakterek.Jatek_Szoveg.size()>1) {
							Kivalasztott_Karakterek.Jatek_Szoveg_Gorget();
							int magas=((int)Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).getLocation().getY()+(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1)*23);
							Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setBounds(5, magas, 240, 16);
						}
						
						

						}
						
						Kivalasztott_Karakterek.Bizonyitek_Check();
						keret.repaint();
						Karakter_Jelzo.repaint();
						Jatek_Hatterkep.repaint();
						Jatek_Alap_Hatterkep.repaint();
						System.out.println("Gyilkos fegyver: "+(Gyilkos_Fegyver_Mezo_index_Megadas+1)+" Gyilkos: "+(Gyilkos_Mezo_index_Megadas+1)+" Gyilkos szoba: "+(Gyilkos_Szoba_Mezo_index_Megadas+1));
						}
						
					}
			});
			 
		}
		
		
	}
	
	public static void Mezo_eger() {
		for(int i=0;i<53;i++) {
			 final int Mezo_Eger=i;
		Mezok[i].addMouseListener(new MouseInputListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(lepehet) {
				System.err.println("Mezo megnyomva");
				if(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()<53) {
					Mezok[Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()].setBackground(new Color(255,255,255,200));
				}
				if(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()<65&&Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()>52) {
					Mezok[Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()].setBackground(new Color(255,255,255,50));
				}
				
				Elindult.kovetkezo=true;
				lepehet=false;
				//eger kilepes javitas 				
				Mezok[Mezo_Eger].setSize(45,45);
				Mezok[Mezo_Eger].setLocation(Mezo_X,Mezo_Y);
				Eger_belepett=false;
				Eger_kilepett=true;
				Mezo_Szamok[Mezo_Eger].setHorizontalTextPosition(JLabel.CENTER);
				Mezo_Szamok[Mezo_Eger].setVerticalTextPosition(JLabel.CENTER);
				Mezok[Mezo_Eger].setBorder(BorderFactory.createEmptyBorder());
				Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).setMezon_all(Integer.parseInt(Mezo_Szamok[Mezo_Eger].getText())-1);
				
				
				
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(Eger_belepett&&Eger_kilepett&&lepehet) {
				//System.out.println("Eger kilepett");
				Mezok[Mezo_Eger].setSize(45,45);
				Mezok[Mezo_Eger].setLocation(Mezo_X,Mezo_Y);
				Eger_belepett=false;
				Eger_kilepett=true;
				Mezo_Szamok[Mezo_Eger].setHorizontalTextPosition(JLabel.CENTER);
				Mezo_Szamok[Mezo_Eger].setVerticalTextPosition(JLabel.CENTER);
				Mezok[Mezo_Eger].setBorder(BorderFactory.createEmptyBorder());
				}
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!Eger_belepett&&lepehet) {
				//System.out.println("Eger belepett");
				Mezo_X=((int)Mezok[Mezo_Eger].getLocation().getX());
				Mezo_Y=((int)Mezok[Mezo_Eger].getLocation().getY());
				Mezok[Mezo_Eger].setSize(55,55);
				Mezok[Mezo_Eger].setLocation((int)Mezok[Mezo_Eger].getLocation().getX()-5,(int)Mezok[Mezo_Eger].getLocation().getY()-5);
				Eger_belepett=true;
				Mezok[Mezo_Eger].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
				Mezo_Szamok[Mezo_Eger].setHorizontalTextPosition(JLabel.CENTER);
				Mezo_Szamok[Mezo_Eger].setVerticalTextPosition(JLabel.CENTER);
				
				}
				
				


				
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
		
	}
	
	public static void Kocka_Dobas_Inudl() {
		Kocka_Dobas.setVisible(false);
			//System.out.println("Kocka gif elindult");
			TimerTask task=new TimerTask() {
				int i=1;
				public void run() {
					Kocka_gif.setVisible(true);
					i++;
					if(i==6) {
						
						//System.err.println("Elerte a vegsot");
						kocka_timer.cancel();
						Kocka_gif.setVisible(false);
						kocka_timer=new Timer();
						Kivalasztott_Karakterek.Sorsoltszam=random.nextInt(6)+1;
						//System.out.println("A random generalt dobas: "+Kivalasztott_Karakterek.Sorsoltszam);
						lepehet=true;
						
						
						//Dobással össze kötött text ki írás.
						JLabel szoveg= new JLabel(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getNev()+" dobott száma: "+Kivalasztott_Karakterek.Sorsoltszam);
						Kivalasztott_Karakterek.Jatek_Szoveg.add(szoveg);
						Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setBounds(5, 5, 240, 16);
						Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setForeground(Color.white);
						Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setFont(new Font("Arial", 1, 13));
						Kivalasztott_Karakterek.Action_Text.add(Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1));
						if(Kivalasztott_Karakterek.Jatek_Szoveg.size()>1) {
							Kivalasztott_Karakterek.Jatek_Szoveg_Gorget();
							int magas=((int)Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).getLocation().getY()+(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1)*23);
							Kivalasztott_Karakterek.Jatek_Szoveg.get(Kivalasztott_Karakterek.Jatek_Szoveg.size()-1).setBounds(5, magas, 240, 16);
						}
						
						
						Elindult.Karakter_Nev_Figyeles++;
						//Utololsó legyen a frissites
						Kivalasztott_Karakterek.Action_Text.repaint();
						keret.repaint();
					}
				}		
			};
			kocka_timer.scheduleAtFixedRate(task, 1000, 1000);
			

		}
	static void Gyilkos_Dolgok_Betoltese() {
		System.out.println("Gyilkosok megnevezése");
		int Random_Gyilkos_Fegyver=random.nextInt(12)+1;
		int Random_Gyilkos=random.nextInt(6)+1;
		int Random_Halott=random.nextInt(10)+1;
		
		System.out.println("Gyilkos targyak betoltese");
		int Gyilkos_Fegyver=random.nextInt(11)+1;
		int Gyilkos=random.nextInt(11)+1;
		int Gyilkos_Szoba=random.nextInt(11)+1;
		
		while(Gyilkos==Gyilkos_Fegyver) {
			Gyilkos=random.nextInt(11)+1;
		}
		while(Gyilkos_Szoba==Gyilkos||Gyilkos_Szoba==Gyilkos_Fegyver) {
			Gyilkos_Szoba=random.nextInt(11)+1;
		}
		
		switch (Gyilkos_Fegyver) {
		case 1: {
			Gyilkos_Fegyver_Tarolas.set(0, Boolean.TRUE);
			Gyilkos_Fegyver_Mezo_index_Megadas=53;
			break;
		}
		case 2: {
			Gyilkos_Fegyver_Tarolas.set(1, Boolean.TRUE);
			Gyilkos_Fegyver_Mezo_index_Megadas=54;
			break;
		}
		case 3: {
			Gyilkos_Fegyver_Tarolas.set(2, Boolean.TRUE);
			Gyilkos_Fegyver_Mezo_index_Megadas=55;
			break;
		}
		case 4: {
			Gyilkos_Fegyver_Tarolas.set(3, Boolean.TRUE);
			Gyilkos_Fegyver_Mezo_index_Megadas=56;
			break;
		}
		case 5: {
			Gyilkos_Fegyver_Tarolas.set(4, Boolean.TRUE);
			Gyilkos_Fegyver_Mezo_index_Megadas=57;
			break;
		}
		case 6: {
			Gyilkos_Fegyver_Tarolas.set(5, Boolean.TRUE);
			Gyilkos_Fegyver_Mezo_index_Megadas=58;
			break;
		}
		case 7: {
			Gyilkos_Fegyver_Tarolas.set(6, Boolean.TRUE);
			Gyilkos_Fegyver_Mezo_index_Megadas=59;
			break;
		}
		case 8: {
			Gyilkos_Fegyver_Tarolas.set(7, Boolean.TRUE);
			Gyilkos_Fegyver_Mezo_index_Megadas=60;
			break;
		}
		case 9: {
			Gyilkos_Fegyver_Tarolas.set(8, Boolean.TRUE);
			Gyilkos_Fegyver_Mezo_index_Megadas=61;
			break;
		}
		case 10: {
			Gyilkos_Fegyver_Tarolas.set(9, Boolean.TRUE);
			Gyilkos_Fegyver_Mezo_index_Megadas=62;
			break;
		}
		case 11: {
			Gyilkos_Fegyver_Tarolas.set(10, Boolean.TRUE);
			Gyilkos_Fegyver_Mezo_index_Megadas=63;
			break;
		}
		default:
			break;
		}
		
		switch (Gyilkos) {
		case 1: {
			Gyilkos_Tarolas.set(0, Boolean.TRUE);
			Gyilkos_Mezo_index_Megadas=53;
			break;
		}
		case 2: {
			Gyilkos_Tarolas.set(1, Boolean.TRUE);
			Gyilkos_Mezo_index_Megadas=54;
			break;
		}
		case 3: {
			Gyilkos_Tarolas.set(2, Boolean.TRUE);
			Gyilkos_Mezo_index_Megadas=55;
			break;
		}
		case 4: {
			Gyilkos_Tarolas.set(3, Boolean.TRUE);
			Gyilkos_Mezo_index_Megadas=56;
			break;
		}
		case 5: {
			Gyilkos_Tarolas.set(4, Boolean.TRUE);
			Gyilkos_Mezo_index_Megadas=57;
			break;
		}
		case 6: {
			Gyilkos_Tarolas.set(5, Boolean.TRUE);
			Gyilkos_Mezo_index_Megadas=58;
			break;
		}
		case 7: {
			Gyilkos_Tarolas.set(6, Boolean.TRUE);
			Gyilkos_Mezo_index_Megadas=59;
			break;
		}
		case 8: {
			Gyilkos_Tarolas.set(7, Boolean.TRUE);
			Gyilkos_Mezo_index_Megadas=60;
			break;
		}
		case 9: {
			Gyilkos_Tarolas.set(8, Boolean.TRUE);
			Gyilkos_Mezo_index_Megadas=61;
			break;
		}
		case 10: {
			Gyilkos_Tarolas.set(9, Boolean.TRUE);
			Gyilkos_Mezo_index_Megadas=62;
			break;
		}
		case 11: {
			Gyilkos_Tarolas.set(10, Boolean.TRUE);
			Gyilkos_Mezo_index_Megadas=63;
			break;
		}
		default:
			break;
		}
		switch (Gyilkos_Szoba) {
		case 1: {
			Gyilkos_Szoba_Tarolas.set(0, Boolean.TRUE);
			Gyilkos_Szoba_Mezo_index_Megadas=53;
			//Ezt fogja ki írni a végén amikor valaki mindent megtalál
			Generalt_Gyilkos_Szoba="Dolgozó szobában";
			break;
		}
		case 2: {
			Gyilkos_Szoba_Tarolas.set(1, Boolean.TRUE);
			Gyilkos_Szoba_Mezo_index_Megadas=54;
			Generalt_Gyilkos_Szoba="a Vendég szobában";
			break;
		}
		case 3: {
			Gyilkos_Szoba_Tarolas.set(2, Boolean.TRUE);
			Gyilkos_Szoba_Mezo_index_Megadas=55;
			Generalt_Gyilkos_Szoba="a Mosókonyhában";
			break;
		}
		case 4: {
			Gyilkos_Szoba_Tarolas.set(3, Boolean.TRUE);
			Gyilkos_Szoba_Mezo_index_Megadas=56;
			Generalt_Gyilkos_Szoba="a Spájzban";
			break;
		}
		case 5: {
			Gyilkos_Szoba_Tarolas.set(4, Boolean.TRUE);
			Gyilkos_Szoba_Mezo_index_Megadas=57;
			Generalt_Gyilkos_Szoba="a Fürdőszobában";
			break;
		}
		case 6: {
			Gyilkos_Szoba_Tarolas.set(5, Boolean.TRUE);
			Gyilkos_Szoba_Mezo_index_Megadas=58;
			Generalt_Gyilkos_Szoba="a Gyerekszobában";
			break;
		}
		case 7: {
			Gyilkos_Szoba_Tarolas.set(6, Boolean.TRUE);
			Gyilkos_Szoba_Mezo_index_Megadas=59;
			Generalt_Gyilkos_Szoba="a Takarítószertárban";
			break;
		}
		case 8: {
			Gyilkos_Szoba_Tarolas.set(7, Boolean.TRUE);
			Gyilkos_Szoba_Mezo_index_Megadas=60;
			Generalt_Gyilkos_Szoba="a Hálószobában";
			break;
		}
		case 9: {
			Gyilkos_Szoba_Tarolas.set(8, Boolean.TRUE);
			Gyilkos_Szoba_Mezo_index_Megadas=61;
			Generalt_Gyilkos_Szoba="a Konyhában";
			break;
		}
		case 10: {
			Gyilkos_Szoba_Tarolas.set(9, Boolean.TRUE);
			Gyilkos_Szoba_Mezo_index_Megadas=62;
			Generalt_Gyilkos_Szoba="a Társalgóban";
			break;
		}
		case 11: {
			Gyilkos_Szoba_Tarolas.set(10, Boolean.TRUE);
			Gyilkos_Szoba_Mezo_index_Megadas=63;
			Generalt_Gyilkos_Szoba="a Pincében";
			break;
		}
		default:
			break;
		}
		

		
		switch (Random_Gyilkos) {
		case 1: {
			Generalt_Gyilkos="Szecskóné Rimán Eszter";
			break;
		}
		case 2: {
			Generalt_Gyilkos="Szecskó Ádám";
			break;
		}
		case 3: {
			Generalt_Gyilkos="Bakos Barbara";
			break;
		}
		case 4: {
			Generalt_Gyilkos="Sulyok Vivien";
			break;
		}
		case 5: {
			Generalt_Gyilkos="Tepliczi Ádám";
			break;
		}
		case 6: {
			Generalt_Gyilkos="Visegrádi Mónika";
			break;
		}
		default:
			break;
		}
		
		switch (Random_Gyilkos_Fegyver) {
		case 1: {
			Generalt_Gyilkos_Fegyver="egy Voodoo babával";
			break;
		}
		
		case 2: {
			Generalt_Gyilkos_Fegyver="egy Rózsaszín vibrátorral";
			break;
		}
		
		case 3: {
			Generalt_Gyilkos_Fegyver="egy Lézerkarddal";
			break;
		}
		
		case 4: {
			Generalt_Gyilkos_Fegyver="egy Főbenjáró átokkal";
			break;
		}
		
		case 5: {
			Generalt_Gyilkos_Fegyver="sok Agresszív Csincsillákkal";
			break;
		}
		
		case 6: {
			Generalt_Gyilkos_Fegyver="egy Tavalyi bejglivel";
			break;
		}
		
		case 7: {
			Generalt_Gyilkos_Fegyver="George Clooney-val";
			break;
		}
		
		case 8: {
			Generalt_Gyilkos_Fegyver="egy átkozott pakli Tarott kártyával";
			break;
		}
		
		case 9: {
			Generalt_Gyilkos_Fegyver="egy Proton ágyúval";
			break;
		}
		
		case 10: {
			Generalt_Gyilkos_Fegyver="Rasengannal";
			break;
		}
		
		case 11: {
			Generalt_Gyilkos_Fegyver="a Vajákkal";
			break;
		}
		
		case 12: {
			Generalt_Gyilkos_Fegyver="a Hatalom Gyűrűivel";
			break;
		}
		
		
		default:
			break;
		}
		
		
		switch (Random_Halott) {
		case 1: {
			Generalt_Halott="Frederick-et";
			break;
		}
		case 2: {
			Generalt_Halott="A Télapót";
			break;
		}
		case 3: {
			Generalt_Halott="Hamupipőkét";
			break;
		}
		case 4: {
			Generalt_Halott="Törpapát";
			break;
		}
		case 5: {
			Generalt_Halott="Frodót";
			break;
		}
		case 6: {
			Generalt_Halott="Dolores Umbridge ot";
			break;
		}
		case 7: {
			Generalt_Halott="Super Mariot";
			break;
		}
		case 8: {
			Generalt_Halott="Samut";
			break;
		}
		case 9: {
			Generalt_Halott="Taylor Swiftet";
			break;
		}
		case 10: {
			Generalt_Halott="Willy Wonkát";
			break;
		}
		
		default:
			break;
		}


		System.out.println("Gyilkos fegyver: "+(Gyilkos_Fegyver_Mezo_index_Megadas+1)+" Gyilkos: "+(Gyilkos_Mezo_index_Megadas+1)+" Gyilkos szoba: "+(Gyilkos_Szoba_Mezo_index_Megadas+1));
		
	}
		
	}
	
	

