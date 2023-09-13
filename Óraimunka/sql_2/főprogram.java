package sql_2;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
public class főprogram {

   public static void main(String[] args) {
	   Scanner input= new Scanner(System.in);
       // TODO Auto-generated method stub
       nobel[] nobeldij=new nobel[1000];
       try {
           System.setProperty("File.encoding","UTF-8");
           BufferedReader br=new BufferedReader(new FileReader("bico.txt"));
           String sor=",";

           int index=0;
           while(sor!=null) {
               sor=br.readLine();
               if (sor!=null) {
                   
                   String[] darab=sor.split(",");
                   
                       nobeldij[index]=new nobel(darab[0],darab[1],Integer.parseInt(darab[2]),Integer.parseInt(darab[3]));
                   
             
                   
               }
               index++;
               
               
           }
           br.close();
       

   }catch (IOException e) {System.out.println("hiba");}
       for (int i=0;i<nobeldij.length;i++) {
           if (nobeldij[i]!=null) {
           
           //System.out.println(nobeldij[i].toString());
       }
       }
       
       System.out.println("Feldolgozas kesz");
       String versenyzo="";
       String orszag="";
       int orszag_darab=0;
       System.out.println("Keresett versenyzo neve:");
       boolean nev_talat =false;
       versenyzo=input.nextLine();
       System.out.println("Keresett orszag neve:");
       boolean orszag_talat =false;
       orszag=input.nextLine();
    	  
    	  
    	   for(int u=0;u<nobeldij.length;u++) {
    		   if (nobeldij[u]!=null) {
    		   if(orszag.equals(nobeldij[u].getOrszag())) {
    			   orszag_darab++;
    			   orszag_talat =true;
    		   }
    		   if (versenyzo.equals(nobeldij[u].getNev())) {
              
            	   System.out.print("A keresett versenyzo "+nobeldij[u].getNev()+" Eredmenye= "+nobeldij[u].getEredmeny());
            	   nev_talat=true;
               }
    	   }
    	   }
    	   

       
       if (nev_talat==false) {
    	   System.out.println("Nincs ilyen nevu versenyzo");
       }
       if (orszag_talat==false) {
    	   System.out.println("Nincs ilyen orszag a versenyen");
       }else {
    	   System.out.println(orszag+"-bol szarmazo versenyzo osszesen= "+orszag_darab+"db");
       }
       
       }
   }