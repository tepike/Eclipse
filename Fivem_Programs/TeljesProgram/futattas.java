package TeljesProgram;

import java.util.Scanner;

import javax.swing.JFrame;

public class futattas {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main metodus elindul");
		Grafikus ablak = new Grafikus();
		MenuPanel loginPanel=new MenuPanel();
		ablak.Ablakletrehoz();
		ablak.kiir();
		ablak.meretezesTiltas();
		//loginPanel.Bejelentkezo_Menu();
		
		//System.out.println("Add meg az erteket");
		//String valami=ablak.bevitel.nextLine();
		//System.out.println("A megadott ertek: "+valami);
		
	}

}
