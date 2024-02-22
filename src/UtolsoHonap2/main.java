package UtolsoHonap2;

public class main {

	public static void main(String[] args) {
		adatok KovacsAdatok;
		KovacsAdatok = new adatok();
		
		
		KovacsAdatok.setNev("Kovacs Istvan");
		KovacsAdatok.setE_amil("kovacs.istvan@gmail.com");
		
		KovacsAdatok.kiirSima();
		KovacsAdatok.kiirKereskedelmi();
		KovacsAdatok.KereskedelmiVasarlo();
		KovacsAdatok.vasarlasnoveles(50001);

	}

}
