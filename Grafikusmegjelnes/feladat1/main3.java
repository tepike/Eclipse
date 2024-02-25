package feladat1;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;

//Figyeli az adatok helyességét és hibás adatnál újra kéri az adatot, valamint ellenőrzi a kártya adatokat és 3 hibás próbánál leáll.

public class main3 {


	public static int TermekAr;

	public static void main(String[] args) {
		String lejaratidatum1="24";
		int kartyaszam1=123;
		int pinkod1=456;
		
		String lejaratidatum2="";
		int kartyaszam2=0;
		int pinkod2=0;
		
		boolean Kartyadatokhelyes=false;
		int kartyaproba=3;
		
		
		Scanner input = new Scanner(System.in);
		int VasarlasiMennyiseg=2;
		int segedindex=0;
		boolean Fizetek=false;
		int FizetekOsszes=0;
		String fizetesopcio = "";
		adatok [] Berletek=new adatok[VasarlasiMennyiseg];
		LocalDate currentDate = LocalDate.now();
		
		
		while (!Fizetek) {
			
			
	        String berlettipus = "";
	        int darabszam = 0;
	                
	        String Ujadat="";
	        System.out.print("Felnott vagy diak berletet szeretne? ");
	        berlettipus = input.next();
	        while (!berlettipus.toLowerCase().equals("felnott")&!berlettipus.toLowerCase().equals("diak")) {
				System.out.println("Helytelen adat kerlek valaszd ujra (Felnott | Diak)");
				berlettipus = input.next();
				
			}
	        
	        System.out.print("Hány darab berletet szeretne venni? ");
	        darabszam=input.nextInt();
	        while(darabszam<1) {
	        	System.out.println("Helytelen mennyiseg: "+darabszam+ "Add meg ujra a darabszamot");
	        	darabszam=input.nextInt();
	        }
	        
	        // Árazás számítása típus megadása után
	        if(berlettipus.toLowerCase().equals("felnott")) {
	        	TermekAr=18900*darabszam;
	        	FizetekOsszes=FizetekOsszes+TermekAr;
	        }else if(berlettipus.toLowerCase().equals("diak")) {
	        	TermekAr=1890*darabszam;
	        	FizetekOsszes=FizetekOsszes+TermekAr;
	        	
	        }
			
			System.out.println("Szeretne ujabb berletet venni? (igen | nem)");
			Ujadat=input.next();
			while(!Ujadat.equals("igen")&!Ujadat.equals("nem")) {
				System.out.println("Helytelen valasz. Add meg ujra (igen | nem)");
				Ujadat=input.next();
			}
			
			
			if (Ujadat.toLowerCase().equals("igen")) {
				Fizetek=false;
				
			}else if(Ujadat.toLowerCase().equals("nem")) {
				Fizetek=true;
				System.out.println("Mivel szeretne fizetni? (Keszpenz | Bankartya)");
				fizetesopcio=input.next();
				while(!fizetesopcio.toLowerCase().equals("keszpenz")&!fizetesopcio.toLowerCase().equals("bankartya")) {
					System.out.println("Helytelen fizetesimod valasztas. (Keszpenz | Bankartya)");
					fizetesopcio=input.next();
				}
				if(fizetesopcio.toLowerCase().equals("bankartya")) {
					System.out.println("Kerem adja meg a kartya adatait.");
					System.out.println("Kartyaszam: ");
					kartyaszam2=input.nextInt();
					System.out.println("Lejaratidatum: ");
					lejaratidatum2=input.next();
					System.out.println("Pinkod: ");
					pinkod2=input.nextInt();
					System.out.println("A megadott adatok a kovetkezok: "+kartyaszam2+" "+lejaratidatum2+" "+pinkod2);
				}
				
				while(!Kartyadatokhelyes) {
					System.out.println("Helytelen adatot adott meg. Kérem ismételje meg újra");
					System.out.println("Kartyaszam: ");
					kartyaszam2=input.nextInt();
					System.out.println("Lejaratidatum: ");
					lejaratidatum2=input.next();
					System.out.println("Pinkod: ");
					pinkod2=input.nextInt();
					System.out.println("A megadott adatok a kovetkezok: "+kartyaszam2+" "+lejaratidatum2+" "+pinkod2);
					kartyaproba--;
					System.out.println("Hatralevo probalkozasok szama: "+kartyaproba);
					if (kartyaproba==0) {
						System.out.println("Tobsszori sikertelen probalkozas miatt a tranzakciot megszakitjuk");
						break;
					}
					
				}
				
				
			}
			
			VasarlasiMennyiseg=VasarlasiMennyiseg++;
			Berletek[segedindex] =new adatok(berlettipus, darabszam, TermekAr,currentDate);
			segedindex++;
			
			
		}
		for(int i=0;i!=segedindex;) {
			
			
			Berletek[i].kiir();
			i++;
			
		}
		System.out.print("Osszesen fizetendo: "+FizetekOsszes +" \nFizetesmodja: "+fizetesopcio);
		

	}

}
