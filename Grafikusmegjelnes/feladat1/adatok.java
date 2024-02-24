package feladat1;

import java.time.LocalDate;

public class adatok {
	private String Tipus="";
	private int Darab=0;
	private int Osszeg=main.TermekAr;
	LocalDate jelenlegidatum = LocalDate.now();
    LocalDate Kovetkezohonap = jelenlegidatum.plusMonths(1);

	
	
	public adatok(String Tipus,int Darab, int Osszeg,LocalDate jelenlegidatum) {
		this.Tipus=Tipus;
		this.Darab=Darab;
		this.Osszeg=Osszeg;
		this.jelenlegidatum=jelenlegidatum;
		
	}
	
	public String getTipus() {
		return Tipus;
	}
	public void setTipus(String tipus) {
		Tipus = tipus;
	}


	public int getDarab() {
		return Darab;
	}
	public void setDarab(int darab) {
		Darab = darab;
	}
	
	public void kiir() {
		System.out.println("A "+Tipus+" tipusu berletbol "+Darab+"/db fizetendo "+" melnyek ara= "+Osszeg+ "\n ervenyesseg kezdete: "+jelenlegidatum+"\n ervenyesseg vege: "+Kovetkezohonap+"\n");
	}

	public int getOsszeg() {
		return Osszeg;
	}

	public void setOsszeg(int osszeg) {
		Osszeg = osszeg;
	}

}
