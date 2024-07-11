package Bloods;

import java.util.ArrayList;

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
		System.out.println("Kosrarba rakott tetlek darabszama: "+Tetel_darab);
		
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