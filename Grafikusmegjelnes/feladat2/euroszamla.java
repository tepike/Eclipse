package feladat2;

public class euroszamla extends forintszamla {
	private int Jelszo;
	private int Egyenleg=0;
	
	public void felvetel(int Jelszo,int Egyenleg) {
		this.Jelszo=Jelszo;
		this.Egyenleg=Egyenleg;
		
	}
	
	public void kifizetes(int mennyit) {
		int i=2;
		if(Euroszamal&mennyit>100) {
			System.out.println("Kerem adja meg a pinkodot");
			pinkodmegadott=input.nextInt();
			while(pinkodmegadott!=Jelszo) {
				System.out.println("Hibas pinkod");
				System.out.println("Probalkozasok szama: "+i);
				pinkodmegadott=input.nextInt();
				i--;
				if(i==0) {
					mennyit=0;
					letiltva=true;
					System.out.println("A szamlat letiltottuk a sok sikertelen proba miatt");
					break;
				}
			
		}
		System.out.println("Sikeresen kifizetett "+mennyit);
		Egyenleg=Egyenleg-mennyit;
		System.out.println(" Osszes elerheto: "+Egyenleg);
		return;
	}

}
}