package Alapok;

import java.util.Scanner;



public class main {
	
	public static void main(String[] args) {
		
		int Osszes=0;
		int bekertszam=0;
		int hatar=0;
		System.out.println("Add meg a határt");
		Scanner bevitel = new Scanner(System.in);
		hatar=bevitel.nextInt();
		System.out.println("Bekért határérték "+hatar);
		
	
		//System.out.print("Adat bekérés lefutott");
		//int bekerttest=bevitel.nextInt();
		//System.out.print(bekerttest);
		
		for(int i =0;i<hatar;i++) {
			System.out.println("Add meg a számodat");
			bekertszam=bevitel.nextInt();
			System.out.println("A megadott szám= "+bekertszam);
			
			
			if (bekertszam>0) {
				Osszes=Osszes+bekertszam;
			}
		}
		System.out.println("Összesen megadott számok összege= "+Osszes);
	}

}
