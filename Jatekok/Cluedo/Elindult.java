package Cluedo;

import java.awt.Color;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class Elindult extends KarakterValasztas{
	public static Timer ELindult_A_Jatek= new Timer();
	public static int Karakter_Nev_Figyeles=0;
	public static int Aktiv_Karakter_Id=1;
	public static boolean kovetkezo=false;
	
	public static void Elindit() {
		
		System.out.println("A jatek elkezdodik");
		TimerTask Fut= new TimerTask() {
			
			@Override
			public void run() {
				
				if(kovetkezo) {
					

					
					//Újra töltésnél az első karakter fehérre szinezése
					if(Aktiv_Karakter_Id==0) {
						Kivalasztott_Karakterek.Karakterek.get(Osszesen_Jatszik-1).setForeground(Color.white);
						if(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()>52) {
							System.out.println("Ezen allt ez modosit: "+Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all());
							Mezok.Mezok[Kivalasztott_Karakterek.Jatszo_Karakterek.get(Aktiv_Karakter_Id-1).getMezon_all()].setBackground(new Color(255,255,255,50));
							
						}
						else {
							Mezok.Mezok[Kivalasztott_Karakterek.Jatszo_Karakterek.get(Aktiv_Karakter_Id-1).getMezon_all()].setBackground(new Color(255,255,255,200));
						}
						
					}
					//Továbblépésnél a karakter vissza szinezése
					if(Aktiv_Karakter_Id>0) {
						Kivalasztott_Karakterek.Karakterek.get(Aktiv_Karakter_Id-1).setForeground(Color.white);
						if(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all()>52) {
							System.out.println("Ezen allt ez modosit: "+Kivalasztott_Karakterek.Jatszo_Karakterek.get(Elindult.Aktiv_Karakter_Id-1).getMezon_all());
							Mezok.Mezok[Kivalasztott_Karakterek.Jatszo_Karakterek.get(Aktiv_Karakter_Id-1).getMezon_all()].setBackground(new Color(255,255,255,50));
							
						}
						else {
							Mezok.Mezok[Kivalasztott_Karakterek.Jatszo_Karakterek.get(Aktiv_Karakter_Id-1).getMezon_all()].setBackground(new Color(255,255,255,200));
						}
						
						
					}
					
					//Ha elerte az utolsó karaktert akkor kezdi újra az elsővel
					if(KarakterValasztas.Osszesen_Jatszik==Aktiv_Karakter_Id) {
						Aktiv_Karakter_Id=0;
					}
					System.out.println("Karakter megszinez mert uj lep");
					Kivalasztott_Karakterek.Karakterek.get(Aktiv_Karakter_Id).setForeground(Color.green);
					System.out.println("\tMezo szinezes: "+Kivalasztott_Karakterek.Jatszo_Karakterek.get(Aktiv_Karakter_Id).getMezon_all());
					kovetkezo=false;
					Kocka_Dobas.setVisible(true);
					if(Kivalasztott_Karakterek.Jatszo_Karakterek.get(Aktiv_Karakter_Id).getMezon_all()<65) {
						System.out.println("\tMezo szinezes: "+Kivalasztott_Karakterek.Jatszo_Karakterek.get(Aktiv_Karakter_Id).getMezon_all());
						Mezok.Mezok[Kivalasztott_Karakterek.Jatszo_Karakterek.get(Aktiv_Karakter_Id).getMezon_all()].setBackground(new Color(0,255,0,150));
					}
						
					

					
					keret.repaint();
					Karakter_Jelzo.repaint();
					Jatek_Hatterkep.repaint();
					Jatek_Alap_Hatterkep.repaint();
					Aktiv_Karakter_Id++;
					
				}
				
			}
		};
		ELindult_A_Jatek.schedule(Fut, 1,100);
		
	}

}
