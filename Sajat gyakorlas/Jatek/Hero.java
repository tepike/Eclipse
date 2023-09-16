package Jatek;

public class Hero {
	
	private static String Nev="Pista";
	private static int Elet=100;
	private static int Mana=10;
	private static int Damage=10;

	
	public static int getElet() {
		return Elet;
	}

	public static void setElet(int elet) {
		Elet = elet;
	}

	public static int getMana() {
		return Mana;
	}

	public void setMana(int mana) {
		Mana = mana;
	}

	public static int getDamage() {
		return Damage;
	}

	public void setDamage(int damage) {
		Damage = damage;
	}

	public static String getNev() {
		return Nev;
	}

}
