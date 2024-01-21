package Lista;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Lista implements Comparable<Lista>{
	static Scanner bevitel = new Scanner(System.in);
	
	public String Nap;
	public String Napszak;
	public int Hofok;
	
	public Lista(String Nap, String Napszak, int Hofok) {
		this.Nap=Nap;
		this.Napszak=Napszak;
		this.Hofok=Hofok;
	}

public String toString() {
	return "\nNap = "+Nap+", Napszak = "+Napszak+", Hofok = "+Hofok;
}
	
	static int Legkissebb=0;
	static int Legnagyobb=0;
public static void main(String[] args) {
	List<Lista> myLista= new ArrayList<Lista>();
	System.out.print("Kerlek add meg a napot: ");
	for (int i =0;i!=5;i++) {
		
		String Nap="";
		String Napszak="";
		int Hofok=0;
		
		
		Nap=bevitel.next();
		
		System.out.print("Kerlek add meg a napszakot: ");
		Napszak=bevitel.next();
		
		System.out.print("Kerlek add meg a hofokot: ");
		Hofok=bevitel.nextInt();
		if(Hofok<Legkissebb) {
			Legkissebb=Hofok;
		}
		if(Hofok>Legnagyobb) {
			Legnagyobb=Hofok;
		}
		
		myLista.add(new Lista(Nap,Napszak, Hofok));
		
		Collections.sort(myLista);
	
	for(Lista element:myLista) {
			System.out.print(element);
	
	
	}
	}
	System.out.print("\nA legkisebb hofok = "+Legkissebb);
	System.out.print("\nA legnagyobb hofok = "+Legnagyobb);
}


@Override
public int compareTo(Lista o) {
	// TODO Auto-generated method stub
	return 0;
}
}
