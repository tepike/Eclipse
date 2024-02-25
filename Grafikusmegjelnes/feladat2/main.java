package feladat2;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		
		euroszamla bankszamla2=new euroszamla();
		forintszamla bankszamla = new forintszamla();
		
		bankszamla.setForintszamal(true);
		bankszamla.setNev("Andras");
		bankszamla.setJelszo(456);
		bankszamla.setEgyenleg(5000);
		bankszamla.befizetes(5000);
		bankszamla.kifizetes(500);

		bankszamla.getEgyenleg();
		
		bankszamla2.setNev("Peter");
		bankszamla2.setJelszo(123);
		bankszamla2.setEuroszamal(true);
		bankszamla2.setEgyenleg(6000);
		bankszamla2.getEgyenleg();
		bankszamla2.kifizetes(105);
		
		
	}

}
