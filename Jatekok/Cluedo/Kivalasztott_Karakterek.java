package Cluedo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Kivalasztott_Karakterek extends KarakterValasztas{
	private String Nev="";
	private int Elet=0;
	private int DobottSzam=0;
	private boolean Kimarad=false;
	private boolean Talat_Fegyver=false;
	private boolean Talat_Gyilkos=false;
	private boolean Talat_Szoba=false;
	private int Mezon_all;
	static int index1=0;
	public static int Sorsoltszam;
	
	static ArrayList<Kivalasztott_Karakterek>Jatszo_Karakterek =new ArrayList<>();
	
	public static ArrayList<JLabel> Karakterek=new ArrayList<JLabel>();
	public static ArrayList<JLabel> Eletek=new ArrayList<JLabel>();
	public static ArrayList<JLabel> Kimaradas=new ArrayList<JLabel>();
	public static ArrayList<JLabel> Megtalalt_Fegyver=new ArrayList<JLabel>();
	public static ArrayList<JLabel> Megtalalt_Gyilkos=new ArrayList<JLabel>();
	public static ArrayList<JLabel> Megtalalt_Szoba=new ArrayList<JLabel>();
	static int Szeles=5;
	static int Magas=10;
	
	public static ArrayList<JLabel> Jatek_Szoveg= new ArrayList<JLabel>();
	public static JPanel Action_Text= new JPanel();
	
	public static ImageIcon Gyilkos = new ImageIcon();
	public static ImageIcon Szoba = new ImageIcon();
	public static ImageIcon Fegyver = new ImageIcon();
	
	public static int Szoveg_magas_tav = 30; // Sorok közötti távolság
	
	
	public static void Jatek_Kezdodik() {
		System.err.println("\t Osszesen jatszo karakter: "+KarakterValasztas.Osszesen_Jatszik);
		
		//System.out.println("\nTombok merete: "+Jatszo_Karakterek.length);
		//Jatszo_Karakterek.add(new Kivalasztott_Karakterek("Ádám",100,3,false,false,false,false));
		for(int i =0;i!=KarakterValasztas.Osszesen_Jatszik;i++) {
			System.out.println("Feltoltes megindul: "+i);
			Jatszo_Karakterek.add(new Kivalasztott_Karakterek(KarakterValasztas.Megadott_Nevek.get(i),100,0,false,true,true,false,100));
			
			
		}
		//System.out.println("Ádám talált fegyvert: "+Jatszo_Karakterek.get(0).isTalat_Fegyver());
		//System.out.println("Barbara talált fegyvert: "+Jatszo_Karakterek.get(1).isTalat_Fegyver());
		for(Kivalasztott_Karakterek darab: Jatszo_Karakterek) {
			System.out.println(darab);
		}
		System.out.println(Jatszo_Karakterek.get(0).getNev());
		
		Elindult.Elindit();
	}
	

	public Kivalasztott_Karakterek (String Nev, int Elet, int DobottSzam, boolean Kimarad, boolean Talat_Fegyver,boolean Talat_Gyilkos, boolean Talat_Szoba, int Mezon_all) {
		this.Nev=Nev;
		this.Elet=Elet;
		this.DobottSzam=DobottSzam;
		this.Kimarad=Kimarad;
		this.Talat_Fegyver=Talat_Fegyver;
		this.Talat_Gyilkos=Talat_Gyilkos;
		this.Talat_Szoba=Talat_Szoba;
		this.Mezon_all =Mezon_all;
		
	}
	public String getNev() {
		return Nev;
	}
	public void setNev(String nev) {
		Nev = nev;
	}
	public int getElet() {
		return Elet;
	}
	public void setElet(int elet) {
		Elet = elet;
	}
	public int getDobottSzam() {
		return DobottSzam;
	}
	public void setDobottSzam(int dobottSzam) {
		DobottSzam = dobottSzam;
	}
	public boolean isKimarad() {
		return Kimarad;
	}
	public void setKimarad(boolean kimarad) {
		Kimarad = kimarad;
	}
	public boolean isTalat_Fegyver() {
		return Talat_Fegyver;
	}
	public void setTalat_Fegyver(boolean talat_Fegyver) {
		Talat_Fegyver = talat_Fegyver;
	}
	public boolean isTalat_Gyilkos() {
		return Talat_Gyilkos;
	}
	public void setTalat_Gyilkos(boolean talat_Gyilkos) {
		Talat_Gyilkos = talat_Gyilkos;
	}
	public boolean isTalat_Szoba() {
		return Talat_Szoba;
	}
	public void setTalat_Szoba(boolean talat_Szoba) {
		Talat_Szoba = talat_Szoba;
	}
	
	public String toString() {
		return "A karakter adatai. Nev: "+Nev+" Elet: "+Elet+" Dobott szam: "+DobottSzam+" Kimarad: "+Kimarad+" Fegyver: "+Talat_Fegyver+" Gyilkos: "+Talat_Gyilkos+" Szoba: "+Talat_Szoba;
	}
	
	public static void Karakter_Felvelte_Jatekkepbe() {
		//	Karakterek=new ArrayList<JLabel>();
		//	Eletek=new ArrayList<JLabel>();
		//	Kimaradas=new ArrayList<JLabel>();
		//	Megtalalt_Fegyver=new ArrayList<JLabel>();
		//	Megtalalt_Gyilkos=new ArrayList<JLabel>();
		//	Megtalalt_Szoba=new ArrayList<JLabel>();
		ImageIcon Keres = new ImageIcon(Kivalasztott_Karakterek.class.getResource("/Cluedo/Kepek/Nyomkere.png"));
		Image Keres_Alakit=Keres.getImage();
		Image Keres_Formazott=Keres_Alakit.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
		Keres = new ImageIcon(Keres_Formazott);
		
		ImageIcon Kimarad_Kep = new ImageIcon(Kivalasztott_Karakterek.class.getResource("/Cluedo/Kepek/kimarad.png"));
		Image Kimarad_Beker=Kimarad_Kep.getImage();
		Image Kimarad_Megformaz=Kimarad_Beker.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
		Kimarad_Kep = new ImageIcon(Kimarad_Megformaz);
		
		Fegyver = new ImageIcon(Kivalasztott_Karakterek.class.getResource("/Cluedo/Kepek/Fegyver_Megvan.png"));
		Image Fegyver_Alakit=Fegyver.getImage();
		Image Fegyver_Formazott=Fegyver_Alakit.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
		Fegyver = new ImageIcon(Fegyver_Formazott);
		
		Gyilkos = new ImageIcon(Kivalasztott_Karakterek.class.getResource("/Cluedo/Kepek/Gyilkos_Megvan.png"));
		Image Gyilkos_Alakit=Gyilkos.getImage();
		Image Gyilkos_Formazott=Gyilkos_Alakit.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
		Gyilkos = new ImageIcon(Gyilkos_Formazott);
		
		Szoba = new ImageIcon(Kivalasztott_Karakterek.class.getResource("/Cluedo/Kepek/Gyilkos_Szoba.png"));
		Image Szoba_Alakit=Szoba.getImage();
		Image Szoba_Formazott=Szoba_Alakit.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
		Szoba = new ImageIcon(Szoba_Formazott);
		
		
		
		for(int i =0;i!=KarakterValasztas.Osszesen_Jatszik;i++) {
			JLabel nev= new JLabel();
			JLabel elet= new JLabel();
			JLabel kimarad= new JLabel();
			JLabel fegyver= new JLabel();
			JLabel gyilkos= new JLabel();
			JLabel szoba= new JLabel();
			
			nev.setText(Jatszo_Karakterek.get(i).getNev());
			elet.setText(Integer.toString(Jatszo_Karakterek.get(i).getElet()));
			kimarad.setIcon(Kimarad_Kep);
			fegyver.setIcon(Keres);
			gyilkos.setIcon(Keres);
			szoba.setIcon(Keres);
			
			//fegyver.setIcon(Fegyver);
			//gyilkos.setIcon(Gyilkos);
			//szoba.setIcon(Szoba);
			
			kimarad.setVisible(false);
			
			
			nev.setFont(new Font("Arial", 1, 18));
			elet.setFont(new Font("Arial", 1, 18));

			
			nev.setForeground(Color.white);
			elet.setForeground(Color.white);

			
			//nev.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			//elet.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			//kimarad.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			//fegyver.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			//gyilkos.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			//szoba.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			

			
			Karakterek.add(nev);
			Eletek.add(elet);
			Kimaradas.add(kimarad);
			Megtalalt_Fegyver.add(fegyver);
			Megtalalt_Gyilkos.add(gyilkos);
			Megtalalt_Szoba.add(szoba);
			
			Karakterek.get(i).setBounds(Szeles, Magas, 100, 30); Szeles=Szeles+Karakterek.get(i).getText().length()*2+70;
			Eletek.get(i).setBounds(Szeles, Magas, 100, 30); Szeles=Szeles+45;
			Kimaradas.get(i).setBounds(Szeles, Magas, 35, 35); Szeles=Szeles+40;
			Megtalalt_Fegyver.get(i).setBounds(Szeles, Magas, 35, 35); Szeles=Szeles+45;
			Megtalalt_Gyilkos.get(i).setBounds(Szeles, Magas, 35, 35); Szeles=Szeles+45;
			Megtalalt_Szoba.get(i).setBounds(Szeles, Magas, 35, 35); Szeles=Szeles+45;
			
			Alapkep.Karakter_Jelzo.add(Karakterek.get(i)); 
			Alapkep.Karakter_Jelzo.add(Eletek.get(i)); 
			Alapkep.Karakter_Jelzo.add(Kimaradas.get(i)); 
			Alapkep.Karakter_Jelzo.add(Megtalalt_Fegyver.get(i)); 
			Alapkep.Karakter_Jelzo.add(Megtalalt_Gyilkos.get(i)); 
			Alapkep.Karakter_Jelzo.add(Megtalalt_Szoba.get(i)); 
			
			Alapkep.Karakter_Jelzo.add(Karakter_Valasztas1);
			Karakter_Valasztas1.setLocation(10, Karakterek.get(i).getHeight()+10);
			if(i==1) {
				System.out.println("Kep helyez 1");
				Alapkep.Karakter_Jelzo.add(Karakter_Valasztas.get(i));
				Karakter_Valasztas.get(i).setLocation(10, 150);
			}
			if(i==2) {
				System.out.println("Kep helyez 2");
				Alapkep.Karakter_Jelzo.add(Karakter_Valasztas.get(i));
				Karakter_Valasztas.get(i).setLocation(10, 260);
			}
			if(i==3) {
				System.out.println("Kep helyez 3");
				Alapkep.Karakter_Jelzo.add(Karakter_Valasztas.get(i));
				Karakter_Valasztas.get(i).setLocation(10, 370);
			}
			if(i==4) {
				System.out.println("Kep helyez 4");
				Alapkep.Karakter_Jelzo.add(Karakter_Valasztas.get(i));
				Karakter_Valasztas.get(i).setLocation(10, 480);
			}
			if(i==5) {
				System.out.println("Kep helyez 5");
				Alapkep.Karakter_Jelzo.add(Karakter_Valasztas.get(i));
				Karakter_Valasztas.get(i).setLocation(10, 590);
			}
			if(i==6) {
				System.out.println("Kep helyez 6");
				Alapkep.Karakter_Jelzo.add(Karakter_Valasztas.get(i));
				Karakter_Valasztas.get(i).setLocation(10, 700);
			}
			

			//Karakter_Valasztas1
			Magas=Magas+110;
			Szeles=5;
			
			
			
			
			
			
		}
		Kivalasztott_Karakterek.Karakterek.get(0).setForeground(Color.green);
		
		
	}


	public int getMezon_all() {
		return Mezon_all;
	}


	public void setMezon_all(int mezon_all) {
		Mezon_all = mezon_all;
	}
	
	public static void Jatek_Szoveg_Gorget() {
	    if (Jatek_Szoveg.size() > 3) {
	        // Alapértelmezett kezdő Y pozíció
	        int alapY = -20; 
	        int offset = Szoveg_magas_tav;

	        for (int i = 0; i < Jatek_Szoveg.size(); i++) {
	            JLabel darab = Jatek_Szoveg.get(i);
	            int ujY = alapY + i * offset; // Új Y pozíció kiszámítása
	            darab.setLocation(darab.getX(), ujY);
	        }

	        // Panel újrarajzolása
	        Jatek_Szoveg.get(0).getParent().repaint();
	    }
	}
	
	public static void Bizonyitek_Check() {
		System.out.println("\nMegtalalt bizonyitekok atvizsgalasa");
		boolean fegyver=false;
		boolean szoba=false;
		boolean gyilkos=false;
		
		if(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).isTalat_Fegyver()) {
			System.err.println("Fegyver csekkolás sikeresen lefutott es talat");
			fegyver=true;
		};
		if(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).isTalat_Szoba()) {
			System.err.println("Szoba csekkolás sikeresen lefutott es talat");
			szoba=true;
		};
		if(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).isTalat_Gyilkos()) {
			System.err.println("Gyilkos csekkolás sikeresen lefutott es talat");
			gyilkos=true;
		};
		
		if(fegyver&&szoba&&gyilkos) {
			System.out.println("\t A jatek vegetert mert meglett az osszes bizonyitek");
			Mezok.Vege_Szoveg.setText("Eredmeny: "+Mezok.Generalt_Gyilkos+" megolte "+Mezok.Generalt_Halott+" "+Mezok.Generalt_Gyilkos_Szoba+". A gyilkosságot pedig  "+Mezok.Generalt_Gyilkos_Fegyver+" követte el.");
			Mezok.Jatek_Vege();

			
		}else {
			gyilkos=false;
			fegyver=false;
			szoba=false;
		}
		
	}
	

	
	
	
}
