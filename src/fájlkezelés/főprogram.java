package fájlkezelés;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
public class főprogram {

   public static void main(String[] args) {
       // TODO Auto-generated method stub
       nobel[] nobeldij=new nobel[1000];
       try {
           System.setProperty("File.encoding","UTF-8");
           BufferedReader br=new BufferedReader(new FileReader("nobel.csv"));
           String sor="";
           br.readLine();
           int index=0;
           while(sor!=null) {
               sor=br.readLine();
               if (sor!=null) {
                   
                   String[] darab=sor.split(";");
                   if (darab.length==3) {
                       nobeldij[index]=new nobel(Integer.parseInt(darab[0]),darab[1],darab[2],"");
                       
                   }
                   else {
                       nobeldij[index]=new nobel(Integer.parseInt(darab[0]),darab[1],darab[2],darab[3]);
                   }
                   
                   
                   
                   
               }
               index++;
               
               
           }
           br.close();
       

   }catch (IOException e) {System.out.println("hiba");}
       for (int i=0;i<nobeldij.length;i++) {
           if (nobeldij[i]!=null) {
           
           System.out.println(nobeldij[i].toString());
       }
       }
       }
   }