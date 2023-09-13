package valasztas;

public class választás {
   private int kerulet;
   private int szavazat;
   private String Vezeteknev;
   private String Keresztnev;
   private String tamogato;

   
   

   public választás(int kerulet, int szavazat, String Vezeteknev, String Keresztnev,String tamogato) {
       
       this.kerulet = kerulet;
       this.szavazat = szavazat;
       this.Vezeteknev = Vezeteknev;
       this.Keresztnev = Keresztnev;
       this.tamogato = tamogato;
   }



   public int getkerulet() {
       return kerulet;
   }




   public int getszavazat() {
       return szavazat;
   }


   

   public String gettamogato() {
       return tamogato;
   }





   public String getVezeteknev() {
       return Vezeteknev;
   }




   public String getKeresztnev() {
       return Keresztnev;
   }




   public void setkerulet(int kerulet) {
       this.kerulet = kerulet;
   }




   public void setszavazat(int szavazat) {
       this.szavazat = szavazat;
       
   }

   public void settamogato(String tamogato) {
       this.tamogato = tamogato;
   }



   public void setVezeteknev(String Vezeteknev) {
       this.Vezeteknev = Vezeteknev;
   }




   public void setKeresztnev(String Keresztnev) {
       this.Keresztnev = Keresztnev;
   }



   @Override
   public String toString() {
       return "valasztas [kerulet= " + kerulet + ", szavazat= " + szavazat + ", Vezeteknev= " + Vezeteknev + ", Keresztnev= " + Keresztnev+", tamogato= "+tamogato
               +"]";
   }
}