package valasztas;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
public class főprogram {

   public static void main(String[] args) {
       // TODO Auto-generated method stub
       választás[] választás=new választás[1000];
       Scanner bevitel = new Scanner(System.in);
       int szavazatok=0;
       int jelolt_szavazatok=0;
       int jeloltek=0;
       double lakossag=12345;
       double kapott_szavazat=0;
       String Vezeteknev=bevitel.next();
       
       try {
           System.setProperty("File.encoding","UTF-8");
           BufferedReader br=new BufferedReader(new FileReader("szavazatok.txt"));
           String sor="";
           
           int index=0;
           
           while(sor!=null) {
               sor=br.readLine();
               if (sor!=null) {
                   String[] darab=sor.split(" ");
                   szavazatok+=Integer.parseInt(darab[1]);
                   
                   	
                   
                   
                   
{
                	 
                       választás[index]=new választás(Integer.parseInt(darab[0]),(Integer.parseInt(darab[1])),darab[2],darab[3],darab[4]);
                       
                       if(Vezeteknev.equals(darab[2])) {
                       	jelolt_szavazatok=Integer.parseInt(darab[1]);
                       	System.out.println(darab[2]);
                   }
					}
				
     
               }
               index++;
               
               
           }
           
           jeloltek+=index;
           br.close();
           
           
       

   }catch (IOException e) {System.out.println("hiba");}
       for (int i=0;i<választás.length;i++) {
           if (választás[i]!=null) {
           
           System.out.println(választás[i].toString());
           
       }
       }
       double arany=szavazatok/lakossag*100;
       System.out.println("Osszesen leadott szavazatok szama= "+szavazatok+", Reszveteli arany= "+arany+"%");
       System.out.println("Osszes jelolt= "+jeloltek);
       System.out.println(Vezeteknev+" "+jelolt_szavazatok);

       }
   }