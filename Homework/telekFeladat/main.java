/*
1. Egy telek oldalhosszúságait kérje be a felhasználótól és határozza meg a telek területét.

2. Amennyiben a telek 20%-a építhető be, úgy határozza meg ennek a területét.

3. Amennyiben gyümölcsöst kívánnak telepíteni és 2 négyzetméterenként kívánnak egy fát ültetni,
úgy hány fa ültethető az adott telekre(Nem kell figyelembe venni a telekhatárt és egyéb paramétereket).
*/
package telekFeladat;

import java.util.Scanner;

public class main {

	static Scanner bevitel= new Scanner(System.in);
	public static void main(String[] args) {
		int Telekhoszz=0;
		int Telekszel=0;
		int TelekTerulet=0;
		System.out.println("1. feladat");
		System.out.print("\nKerem adja meg a telek szelesseget");
		Telekszel=bevitel.nextInt();
		System.out.print("Kerem adja meg a telek hosszusagat");
		Telekhoszz=bevitel.nextInt();
		TelekTerulet=Telekhoszz*Telekszel;
		System.out.println("A telek terulete : "+TelekTerulet+" negyzetmeter");
		System.out.println("\n2. feladat \nBeepitheto terulet nagysaga: "+TelekTerulet*0.2+" negyzetmeter");
		System.out.println("\n3. feladat \n Osszesen "+TelekTerulet/2+" fat lehet ultetni a telekre");
		
		

	}

}
