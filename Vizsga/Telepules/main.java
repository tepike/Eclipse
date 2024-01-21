package Telepules;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner bevitelScanner = new Scanner(System.in);
		System.out.println("Kerlek add meg az iranyitoszamot");
		int iranyitoszam=bevitelScanner.nextInt();
		System.out.println("Bekeres sikeres");
		
		switch (iranyitoszam) {
		case 3535: {			
			System.out.println("Megadott szamhoz tartozo telepules = Miskolc ");
			break;
		}
		
		case 7737: {			
			System.out.println("Megadott szamhoz tartozo telepules = Székelyszabar   ");
			break;
		}
		
		case 1141: {			
			System.out.println("Megadott szamhoz tartozo telepules = Budapest, XIV. kerület ");
			break;
		}
		
		case 9554: {			
			System.out.println("Megadott szamhoz tartozo telepules = Borgáta   ");
			break;
		}
		
		case 3985: {			
			System.out.println("Megadott szamhoz tartozo telepules = Alsóberecki ");
			break;
		}
		
		default:
			System.out.println("Ismeretlen iranyitoszam: " + iranyitoszam);
		}

	}

}
