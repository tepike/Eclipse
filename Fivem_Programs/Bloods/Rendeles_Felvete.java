package Bloods;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.sql.Date;
import java.sql.Time;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Rendeles_Felvete extends Aruk {
	ArrayList<String> lsita= new ArrayList<String>();
	public static int Tetel_darab;
	public static boolean Pisztoly_megadva=false;
	public static boolean AP_Pisztoly_megadva=false;
	public static boolean Tec_9_megadva=false;
	public static boolean SMG_megadva=false;
	public static boolean Pisztoly_Loszer_megadva=false;
	public static boolean SMG_Loszer_megadva=false;
	public static boolean MG_Loszer_megadva=false;
	public static boolean Riffle_Loszer_megadva=false;
	public static boolean Shotgun_Loszer_megadva=false;
	
	
	
	
	
	
	public static void Rendeles_Felvetel_Betoltes() {
		
		Aruk.Rendeles_Osszesito.setAutoscrolls(true);
		String ev=Integer.toString(LocalDateTime.now().getYear());
		String honap=Integer.toString(LocalDateTime.now().getMonthValue());
		String nap=Integer.toString(LocalDateTime.now().getDayOfMonth());
		String ora=Integer.toString(LocalDateTime.now().getHour());
		String perc=Integer.toString(LocalDateTime.now().getMinute());
		String masodperc=Integer.toString(LocalDateTime.now().getSecond());
		if(Integer.parseInt(honap)<10) {
			honap=("0"+honap);
		}
		if(Integer.parseInt(nap)<10) {
			nap=("0"+nap);
		}
		if(Integer.parseInt(ora)<10) {
			ora=("0"+ora);
		}
		if(Integer.parseInt(perc)<10) {
			perc=("0"+perc);
		}
		if(Integer.parseInt(masodperc)<10) {
			masodperc=("0"+masodperc);
		}
		String Felvetel_Ideje=(ev+"."+honap+"."+nap+" "+ora+":"+perc+":"+masodperc);
		System.out.println("Kosrarba rakott tetlek darabszama: "+Tetel_darab);
		String Teszt_Szoveg="Teszt_Szoveg";
		JLabel teszt = new JLabel(Teszt_Szoveg);
		teszt.setForeground(Color.white);
		teszt.setFont(new Font("Tahoma", Font.BOLD, 24));
		teszt.setLayout(null);
		teszt.setBackground(Color.white);
		teszt.setBounds(30, 30,(((Teszt_Szoveg.length()*28))/2), 50);
		System.out.println("test".length());
		Aruk.Rendeles_Osszesito.add(teszt);
		System.out.println(Felvetel_Ideje);
		Aruk.Rendeles_Osszesito.addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				System.out.println("Gorgo megnyomva: "+e.getWheelRotation());
				
			}
		});

		
	}

	public static void Reset_gomb_Boolean() {
		   Pisztoly_megadva=false;
		   AP_Pisztoly_megadva=false;
		   Tec_9_megadva=false;
		   SMG_megadva=false;
		   Pisztoly_Loszer_megadva=false;
		   SMG_Loszer_megadva=false;
		   MG_Loszer_megadva=false;
		   Riffle_Loszer_megadva=false;
		   Shotgun_Loszer_megadva=false;
		
	}
	
	


	
	


}