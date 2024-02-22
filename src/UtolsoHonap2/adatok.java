package UtolsoHonap2;

public class adatok{
	
	private String nev;
	private String E_amil;
	private String Tipus="Normal";
	private double kedvezmeny=0.0;
	private double VasarlasAktulais=0;
	private int OsszesenVasarolt=140_300;
	
	
	public double vasarlasnoveles(double mennyit) {
		//Pozitív érték figyelése
		if(mennyit<1&getTipus().toLowerCase().equals("normal")) {
			System.out.println("\nAz ertek nem lehet kevesebb mint 1ft");
			VasarlasAktulais=VasarlasAktulais+0;
		}
		else if(mennyit>0&getTipus().toLowerCase().equals("normal")){
			System.out.println("\nFizetendo osszeg novelve: "+mennyit);
		VasarlasAktulais=VasarlasAktulais+mennyit;
		}
		else if(mennyit>50_000&getTipus().toLowerCase().equals("kedvezmenyes")){
			System.out.println("\nFizetendo kedvezmenyes osszeg : "+(int)(mennyit*getKedvezmeny()));
			VasarlasAktulais=VasarlasAktulais+(int)(mennyit*getKedvezmeny());
		}
		else if(mennyit<50_000&getTipus().toLowerCase().equals("kedvezmenyes")){
			System.out.println("\nAz osszeg nem eri el az 50.000 Forintot");
			VasarlasAktulais=VasarlasAktulais+0;
		}
		else if(mennyit<1&getTipus().toLowerCase().equals("kedvezmenyes")){
			System.out.println("\nAz ertek nem lehet kevesebb mint 1ft");
			VasarlasAktulais=VasarlasAktulais+0;
		}
		return VasarlasAktulais;
	}
	
	public void KereskedelmiVasarlo() {
		setKedvezmeny(0.7);
		setTipus("Kedvezmenyes");
		
	}
	
	public void NormalVasarlos() {
		setKedvezmeny(0.0);
		setTipus("Normal");
		
	}
	
	public void OsszesenVasarolt() {
		System.out.println("Vasarolt termekek aktualis ara: "+getOsszesenVasarolt());
	}
	
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		this.nev = nev;
	}
	public String getE_amil() {
		return E_amil;
	}
	public void setE_amil(String e_amil) {
		E_amil = e_amil;
	}
	public String getTipus() {
		return Tipus;
	}
	public void setTipus(String tipus) {
		Tipus = tipus;
	}
	
	public double getKedvezmeny() {
		return kedvezmeny;
	}
	public void setKedvezmeny(double kedvezmeny) {
		this.kedvezmeny = kedvezmeny;
	}
	

	public double getVasarlasAktulais() {
		return VasarlasAktulais;
	}
	public void setVasarlasAktulais(int vasarlasAktulais) {
		VasarlasAktulais = vasarlasAktulais;
	}
	public int getOsszesenVasarolt() {
		return OsszesenVasarolt;
	}
	public void setOsszesenVasarolt(int osszesenVasarolt) {
		OsszesenVasarolt = osszesenVasarolt;
	}
	
	public void kiirSima() {
		System.out.println("Nev: "+getNev()+"\nE-mail cim: "+getE_amil()+"\nFiok tipusa: "+getTipus()+"\n");
		
	}
	
	public void kiirKereskedelmi() {
		System.out.println("Nev: "+getNev()+"\nE-mail cim: "+getE_amil()+"\nFiok tipusa: "+getTipus()+"\nKedvezmeny merteke: "+(getKedvezmeny()*100)+"%");
		
	}

}
