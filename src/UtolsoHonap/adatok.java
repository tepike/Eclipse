package UtolsoHonap;

import java.time.LocalDate;

public class adatok {
	private String Tipus="";
	private int Darab=0;
	private int Osszeg=main.TermekAr;
	LocalDate currentDate = LocalDate.now();
	
  

    
    LocalDate futureDate = currentDate.plusMonths(1);
    //System.out.println("Date after adding 1 month: " + futureDate);

	
	
	public adatok(String Tipus,int Darab, int Osszeg,LocalDate currentDate) {
		this.Tipus=Tipus;
		this.Darab=Darab;
		this.Osszeg=Osszeg;
		this.currentDate=currentDate;
		
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
		System.out.println("A "+Tipus+" tipusu berletbol "+Darab+"/db-ot fizettek "+" melnyek ara= "+Osszeg+ "\n ervenyesseg kezdete: "+currentDate+"\n ervenyesseg vege: "+futureDate+"\n");
	}

	public int getOsszeg() {
		return Osszeg;
	}

	public void setOsszeg(int osszeg) {
		Osszeg = osszeg;
	}

}
