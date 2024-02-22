package UtolsoHonap4;

public class main {

	public static void main(String[] args) {
		
		/*
		 Készítsen
	programot,amely a tömb adatszerkezet működését
	mutatja be. Tároljon filmcímeket az egyes adatszerkezetekben, majd mutassa be,
	hogy milyen lehetőségei vannak például egy halmaz szerkezetnek!
		 */
		
		adatok[] Filmeim=new adatok[10];
		Filmeim[1]=new adatok("Az apaca", "18+");		
		Filmeim[2]=new adatok("Nagyfiuk", "12");
		System.out.println("Film cim: "+Filmeim[1].filmcim);
		System.out.println("korosztaly: "+Filmeim[1].korhatar);
		System.out.println("\nFilm cim: "+Filmeim[2].filmcim);
		System.out.println("korosztaly: "+Filmeim[2].korhatar);
		

	}

}
