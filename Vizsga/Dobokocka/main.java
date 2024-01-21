package Dobokocka;



import java.util.Random;

import java.util.Scanner;



public class main {



   

   public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
       Random random = new Random();
       String input = "";

       int generaltSzamok = 0;
       int osszesen = 0;
       int szamlalo = 0;
       
       int egy = 0;
       int ketto = 0;
       int harom = 0;
       int negy = 0;
       int ot = 0;
       int hat = 0;

       

       while (!input.equals("x")) {

           System.out.println("\nSzámok generálása (1-6)\r\nÚj szám generálásához nyomja meg bármelyik betűt.\r\nMegszakításhoz nyomja meg: x");

           input = scanner.nextLine();
           if(input.equals("x")){
        		   break;
           }

           generaltSzamok = (random.nextInt(5)+1);

           System.out.println("\nSzám sikeresen generálva");

           szamlalo++;
           
           System.out.println("\nA generált szám: "+generaltSzamok);             
           osszesen=osszesen+generaltSzamok;
           
         

               if (generaltSzamok == 1) {

                   egy++;

               }

               if (generaltSzamok == 2) {

                   ketto++;

               }

               if (generaltSzamok == 3) {

                   harom++;

               }

               if (generaltSzamok == 4) {

                   negy++;

               }

               if (generaltSzamok == 5) {

                   ot++;

               }

               if (generaltSzamok == 6) {

                   hat++;

               }

           }

       

       System.out.println("\nA generált számok összege: ");


       System.out.println(osszesen);

       System.out.println("\nA számok előfordulása: ");
       
       System.out.println("\n1: "+egy+"db");

       System.out.println("\n2: "+ketto+"db");

       System.out.println("\n3: "+harom+"db");

       System.out.println("\n4: "+negy+"db");

       System.out.println("\n5: "+ot+"db");

       System.out.println("\n6: "+hat+"db");

   }



}