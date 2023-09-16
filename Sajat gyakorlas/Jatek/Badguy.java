package Jatek;

public class Badguy {
	
	private static String Nev="Gonoszka";
	private static int Elet=100;
	private static int Mana=10;
	private static int Mergezes=5;
	
	
	public static int getElet() {
		return Elet;
	}
	public void setElet(int elet) {
		Elet = elet;
	}
	public static int getMana() {
		return Mana;
	}
	public void setMana(int mana) {
		Mana = mana;
	}
	public static int getMergezes() {
		return Mergezes;
	}
	public void setMergezes(int mergezes) {
		Mergezes = mergezes;
	}
	public static String getNev() {
		return Nev;
	}

}
