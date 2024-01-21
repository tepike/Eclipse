package hegyek;


import java.io.BufferedReader;
import java.io.IOException;



import java.io.FileReader;
public class mohegyek {

   public static void main(String[] args) {

	   int osszes_hegy=0;
	   double atlagmagassag=0;
	   double osszes_magassag=0;

       // TODO Auto-generated method stub
	   beolvasas[] beolvasas=new beolvasas[1000];

     
	   
	   
       System.out.println("Feladat 1 adatok beolvasasa kesz\n");
	   //Feladat 1
       try {
           System.setProperty("File.encoding","UTF-8");
           BufferedReader br=new BufferedReader(new FileReader("hegyekMo.txt"));
           String sor=";";
           br.readLine();
           int index=0;
      
           while(sor!=null) {
               sor=br.readLine();
               if (sor!=null) {
                   
                   String[] darab=sor.split(";");
                   if (darab.length==3) {
                	   beolvasas[index]=new beolvasas(darab[0],darab[1],(Integer.parseInt(darab[2])));

                	   
                       
                   }
                   else {
                	   beolvasas[index]=new beolvasas(darab[0],darab[1],(Integer.parseInt(darab[2])));


                   }


                   
                   
                   osszes_magassag=osszes_magassag+Integer.parseInt(darab[2]);
                   
                   osszes_hegy++;
               }
               index++;
               
               
               
           }

           br.close();
           

           
        //Feladat 2
           System.out.println("Feladat 2 adatok kiirasa: ");
   }catch (IOException e) {System.out.println("hiba");}
       for (int i=0;i<beolvasas.length;i++) {
           if (beolvasas[i]!=null) {
           
           System.out.println(beolvasas[i].toString());
           
       }
       }
       atlagmagassag=osszes_magassag/osszes_hegy;
       System.out.println("\nFeladat3  Osszes hegy = "+osszes_hegy+"db");
       System.out.println("\nFeladat4  Az atlag magassag = "+atlagmagassag+"m");
       //Feladat 5 Határozza meg és írja ki a képernyőre a minta szerint a legmagasabb hegy adatait! | Feltételezheti, hogy nem alakult ki holtverseny.
       int index_f5=0;
	   int legmagasabb=0;
	   int seged_index=0;
       while(index_f5!=osszes_hegy) {

    	   beolvasas[index_f5].getmagassag();
    	   	if(legmagasabb< beolvasas[index_f5].getmagassag()) {;
    	   		legmagasabb=beolvasas[index_f5].getmagassag();
    	   		seged_index=index_f5;
    	   		//System.out.println("Feladat 5 legmagasabb = "+legmagasabb);
    	   		//System.out.println("Feladat 5 beolvasott magassag= "+beolvasas[index_f5].getmagassag());
    	   		
    	   	}
    	    //System.out.println("Feladat 5 index nőtt = "+index_f5);
    	   
    	   
    	   index_f5++;
    	   
       }
       
       System.out.println("\nFeladat 5 lefutott"+"\n\tLegmagasabb hegy = "+legmagasabb+"m"+" \n\tHegyseg neve= "+beolvasas[seged_index].gethegycsucsneve()+"\n\tHegyseg= "+beolvasas[seged_index].gethegyseg());
       
       

       }
   }

