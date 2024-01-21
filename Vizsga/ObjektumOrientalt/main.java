package ObjektumOrientalt;
/*
 * 1. Hozza létre a következő objektumorientált programot:
osztály: házak (nm, ár, város)
alosztály: emeletes (emelet, közösköltség)
                  kertes (kertnm)
Metódus: set, get, kiír négyzetméter ár, 4 felett van lift, 10% fásítás

példán 2 ház példány létrehozása és a metódusok futtatása
 */

public class main {


	public static void main(String[] args) {
		Emeletes Elsohaz;
		Hazak MasodikHazak;
		Elsohaz=new Emeletes();
		MasodikHazak=new Hazak();
		
		Elsohaz.setAr(50000000);
		Elsohaz.setNm(50);
		Elsohaz.Varos="Szeged";
		Elsohaz.Emelet=4;
		Elsohaz.Nm=50;
		Elsohaz.setKozoskoltseg(15000);
		Elsohaz.kiir();
		
		
		
		MasodikHazak.setAr(160000000);
		MasodikHazak.setNm(150);
		MasodikHazak.Varos="Sopron";
		
		

	}

}
