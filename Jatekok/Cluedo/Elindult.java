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
					
					if(Aktiv_Karakter_Id==0) {
						Kivalasztott_Karakterek.Karakterek.get(Osszesen_Jatszik-1).setForeground(Color.white);
					}
					if(Aktiv_Karakter_Id>0) {
						Kivalasztott_Karakterek.Karakterek.get(Aktiv_Karakter_Id-1).setForeground(Color.white);
					}
					if(KarakterValasztas.Osszesen_Jatszik==Aktiv_Karakter_Id) {
						Aktiv_Karakter_Id=0;
					}
					System.out.println("Karakter megszinez mert uj lep");
					Kivalasztott_Karakterek.Karakterek.get(Aktiv_Karakter_Id).setForeground(Color.green);
					kovetkezo=false;
					Kocka_Dobas.setVisible(true);
					

					
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
