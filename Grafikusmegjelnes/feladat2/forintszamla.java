package feladat2;

import java.util.Scanner;

public class forintszamla {
/*
 * Nev
 * jelszo
 * egyenleg
 * egyenleg lekerdezes
 * kivétel, befizetés
 * új ügyfél rögzítése
 * 
 */
	Scanner input = new Scanner(System.in);
	String Bekertnev;
	int BekertPin;
	private String Nev;
	private int Jelszo;
	private int Egyenleg=0;
	private boolean Forintszamal=false;
	protected boolean Euroszamal=false;
	protected int pinkodmegadott;
	protected boolean letiltva;
	
	public void felvetel(String Nev,int Jelszo,int Egyenleg) {
		this.Nev=Nev;
		this.Jelszo=Jelszo;
		this.Egyenleg=Egyenleg;
	}
	
	public void befizetes(int mennyit) {
		System.out.println("Sikeresen befizetett "+mennyit+" Ft-ot");
		Egyenleg=Egyenleg+mennyit;
		return;
	}
	
	public void kifizetes(int mennyit) {
		System.out.println("Sikeres kifizetes "+mennyit+" Ft");
		Egyenleg=Egyenleg-mennyit;

		return;
		}
	

	
	
	public String getNev() {
		return Nev;
	}
	public void setNev(String nev) {
		Nev = nev;
	}
	public int getJelszo() {
		return Jelszo;
	}
	public void setJelszo(int jelszo) {
		Jelszo = jelszo;
	}
	public int getEgyenleg() {
		if(Forintszamal) {
		System.out.println("Adja meg a nevet es a pinkodot");
		System.out.println("Nev: ");
		Bekertnev=input.next();
		System.out.println("Pinkod: ");
		BekertPin=input.nextInt();
		if(Bekertnev.toLowerCase().equals(getNev().toLowerCase())&BekertPin==getJelszo()) {
			System.out.println("Elerheto egyenleg = "+Egyenleg);
			return Egyenleg;
		}else {
			System.out.println("Helytelen bejelentkezes");
			return Egyenleg;
		}
		}if(Euroszamal) {System.out.println("Elerheto Euro egyenleg = "+Egyenleg);}
		return Egyenleg;
		
		

	}
	public void setEgyenleg(int egyenleg) {
		if (egyenleg<1) {
			System.out.println("Helytelen osszeg: "+egyenleg);
			
			
		}else {
			System.out.println("Sikeres egyenleg allitas: "+egyenleg);
			Egyenleg = egyenleg;
		}
		
	}

	public boolean isForintszamal() {
		return Forintszamal;
	}

	public void setForintszamal(boolean forintszamal) {
		Forintszamal = forintszamal;
	}

	public boolean isEuroszamal() {
		return Euroszamal;
	}

	public void setEuroszamal(boolean euroszamal) {
		Euroszamal = euroszamal;
	}

	public int getPinkodmegadott() {
		return pinkodmegadott;
	}

	public void setPinkodmegadott(int pinkodmegadott) {
		this.pinkodmegadott = pinkodmegadott;
	}

	public boolean isLetiltva() {
		return letiltva;
	}

	public void setLetiltva(boolean letiltva) {
		this.letiltva = letiltva;
	}
	
}
