package UtolsoHonap;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;

public class main {

	public static int TermekAr=0;

	public static void main(String[] args) {
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
