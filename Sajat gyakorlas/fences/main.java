package fences;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
public class main {

	   public static void main(String[] args) {
		   Scanner bevitel = new Scanner(System.in);
		   kerites[] kerites=new kerites[1000];
		   int index=0;
		   int osszesadat=0;
		   int utolso_telek=0;
		   int utolso_hazszam=0;
		   String paros_paratlan="";   
		   int hazszam_index=0;
		   int bekert_hazszam=0; //Vizsgálja, hogy páros vagy páratlan
		   System.out.print("Add meg a lekerni kivant hazszamot:");
		   int megadot_hazszam= bevitel.nextInt();
		   if (megadot_hazszam % 2 == 0) {
			    System.out.println("A megadott hazszam paros.");
			    bekert_hazszam=0;
			} else {
			    System.out.println("A megadott hazszam paratlan.");
			    bekert_hazszam=1;
			}
		   
		   //Feladat 5 index létrehozás
		   if(megadot_hazszam==1) {
			   hazszam_index=0;
		   }else if(megadot_hazszam==2) {
			   hazszam_index=0;
		   }else if(megadot_hazszam%2==0) {
			   hazszam_index=(megadot_hazszam%2);
		   }else if(megadot_hazszam%2!=0) {
			   int i=(megadot_hazszam+1)%2;
			   hazszam_index=i;
		   }
		   System.out.println("Hazszam idex lefutott es az eredmenye = "+hazszam_index);
		   
		   
		   System.out.println("A bekert hazszam = "+bekert_hazszam);
		   

		try {
	           System.setProperty("File.encoding","UTF-8");
	           BufferedReader br=new BufferedReader(new FileReader("kerites.txt"));
	           String sor="";
	           
	           while(sor!=null) {
	               sor=br.readLine();
	               if (sor!=null) {
	            	   
	                   String[] darab=sor.split(" ");
	                   if (darab.length==3) {
	                	   kerites[index]=new kerites(Integer.parseInt(darab[0]),Integer.parseInt(darab[1]),darab[2]);	                       
	                   }
	                   else {
	                	   kerites[index]=new kerites(Integer.parseInt(darab[0]),Integer.parseInt(darab[1]),darab[2]);
	                   }	                   
	                   if(Integer.parseInt(darab[0])==0) {
	                	   utolso_hazszam=utolso_hazszam+2;	                	   
	                   }
	                   
		               utolso_telek=Integer.parseInt(darab[0]);		               //utolso_hazszam=Integer.parseInt(darab[1]);
		    		   if(utolso_telek==0) {
		    			   paros_paratlan="Paros";
		    		   }else if(utolso_telek==1){
		    			   paros_paratlan="Paratlan";
		    		   }	
		    		   
		    		   
		    		   //Feladat 5:
		    		   
		    		   if(Integer.parseInt(darab[0])==bekert_hazszam&&kerites[index].getmilyen()==megadot_hazszam) {
		    			   System.out.println("A hazhoz tartozo szin= "+darab[2]);
		    			   
		    		   }
		    		   
		    		   
		    		   /*
		    		    * 	a. Írja ki a házszámhoz tartozó kerítés színét, ha már elkészült és befestették,
								egyébként az állapotát a „#” vagy „:” karakter jelöli!
						
							b. A házszámhoz tartozó kerítést szeretné tulajdonosa be- vagy átfesteni. Olyan
								színt akar választani, amely különbözik a mellette lévő szomszéd(ok)tól és a
								jelenlegi színtől is. Adjon meg egy lehetséges színt! A színt a teljes palettából
								(A–Z) szabadon választhatja meg.
								
								Csak a 0-ra igaz darab[0]-t nézze
								a páratlanhoz hozzá kell rendelni az indexhez +1-et, hogy ha azt osztom egész számot kapjak.
								Ha a házszám 1 akkor index =0, Ha 2 akkor szintén (Ne 1-re legyen az osztás, mert akkor a dara[0]-nak a 0. eleme sose fog jönni.
								
		    		    */
		    		   
		    		   
	               }
	               index++;	               
	           }

	           System.out.println("Sikeres osszehasonlitas\n");

		       
	           br.close();

	           System.out.println("1. Feladat");

	   }
		
		
		catch (IOException e) {System.out.println("hiba");}
	       for (int i=0;i<kerites.length;i++) {
	           if (kerites[i]!=null) {
	        	   osszesadat++;
	        
	        System.out.println(kerites[i].toString()); //Ellenőrzás az adatok beolvasására
	       }
	       }
	       

	       System.out.println("\n2. Feladat: "+" \nOsszes eladott telek= "+osszesadat); //Valamiért 99-et hoz, de lehet azért mert volt egy plusz sor txt.
	       
	       System.out.println("\n3. Feladat: "+" \nAz utolso telek a "+paros_paratlan+" oldalon talalt gazdara es hazszama= "+utolso_hazszam);
	       
	       System.out.println("\n4. Feladat:\t");
	       //Feladat 4
	       int kerites_a=0;
	       int kerites_b=1;
	       boolean talalt = false;
	       int feladat_hazszam=1;
	       
	       
	       while (!(kerites[kerites_a].getmilyen() == 1 && kerites[kerites_b].getmilyen() == 1 && kerites[kerites_a].getszin().equals(kerites[kerites_b].getszin()))) {
	    	    kerites_a++;
	    	    if (kerites_a > 97) {
	    	        kerites_a = 97;
	    	    }
	    	    kerites_b++;
	    	    if (kerites_b > 98) {
	    	        kerites_b = 98;
	    	    }
	    	    feladat_hazszam=feladat_hazszam+2;
	    	}
	       
	       if (kerites[kerites_a].getmilyen() == 1 && kerites[kerites_b].getmilyen() == 1 && kerites[kerites_a].getszin().equals(kerites[kerites_b].getszin())) {
	    	    System.out.println(kerites[kerites_a].getmilyen() + " || " + kerites[kerites_b].getmilyen()); //Páratlan szám vizsgálat
	    	    System.out.println("Haz hasonlitasa= " + kerites[kerites_a].getszin() + " Ehez a hazhoz= " + kerites[kerites_b].getszin()+"\tMegtalalhato hazszam= "+feladat_hazszam); // Festés színének vizsgálata + házszám
	    	    talalt = true;
	    	}

	    	if (!talalt) { //Ha a talat=false akkor nem talált egyezést
	    	    System.out.println("Nem talalhato olyan kerites, amelynek az azonos hazszam melletti keritese azonos szinu.");
	    	}

	       
	       
	       
	       
	       //System.out.println("\nMinta a bekereshez"+"\tKerites paros/paratlan:\t"+kerites[2].getmilyen()+" Kerites hossza:"+kerites[2].gethossz()+" Kerites szine:"+kerites[2].getszin());
	       //System.out.println("");
} 
	   // kerites[index]=new kerites(Integer.parseInt(darab[0]),Integer.parseInt(darab[1]),darab[2]);
}

/*
 
1. Olvassa be és tárolja el a kerites.txt fájl tartalmát!

2. Írja a képernyőre, hogy hány telket adtak el az utcában!

3. Jelenítse meg a képernyőn, hogy az utolsó eladott telek
a. melyik (páros / páratlan) oldalon talált gazdára!
b. milyen házszámot kapott!

4. Írjon a képernyőre egy házszámot a páratlan oldalról, amely melletti telken ugyanolyan
színű a kerítés! (A hiányzó és a festetlen kerítésnek nincs színe.) Feltételezheti, hogy van
ilyen telek, a több ilyen közül elég az egyik ház számát megjeleníteni.

5. Kérje be a felhasználótól egy eladott telek házszámát, majd azt felhasználva oldja meg a
következő feladatokat!

	a. Írja ki a házszámhoz tartozó kerítés színét, ha már elkészült és befestették,
		egyébként az állapotát a „#” vagy „:” karakter jelöli!

	b. A házszámhoz tartozó kerítést szeretné tulajdonosa be- vagy átfesteni. Olyan
		színt akar választani, amely különbözik a mellette lévő szomszéd(ok)tól és a
		jelenlegi színtől is. Adjon meg egy lehetséges színt! A színt a teljes palettából
		(A–Z) szabadon választhatja meg.

6. Jelenítse meg az utcakep.txt fájlban a páratlan oldal utcaképét az alábbi mintának
megfelelően!
KKKKKKKK::::::::::SSSSSSSSSBBBBBBBBFFFFFFFFFKKKKKKKKKKIIIIIIII
1 3 5 7 9 11 13
Az első sorban a páratlan oldal jelenjen meg, a megfelelő méternyi szakasz kerítésszínét
(vagy állapotát) jelző karakterrel! A második sorban a telek első karaktere alatt kezdődően
a házszám álljon! 
 

 * */
