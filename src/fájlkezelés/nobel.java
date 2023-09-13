package fájlkezelés;

public class nobel {
   private int ev;
   private String tipus;
   private String keresztnev;
   private String vezeteknev;
   
   

   public nobel(int ev, String tipus, String keresztnev, String vezeteknev) {
       
       this.ev = ev;
       this.tipus = tipus;
       this.keresztnev = keresztnev;
       this.vezeteknev = vezeteknev;
   }



   public int getEv() {
       return ev;
   }




   public String getTipus() {
       return tipus;
   }




   public String getKeresztnev() {
       return keresztnev;
   }




   public String getVezeteknev() {
       return vezeteknev;
   }




   public void setEv(int ev) {
       this.ev = ev;
   }




   public void setTipus(String tipus) {
       this.tipus = tipus;
   }




   public void setKeresztnev(String keresztnev) {
       this.keresztnev = keresztnev;
   }




   public void setVezeteknev(String vezeteknev) {
       this.vezeteknev = vezeteknev;
   }



   @Override
   public String toString() {
       return "nobel [ev=" + ev + ", tipus=" + tipus + ", keresztnev=" + keresztnev + ", vezeteknev=" + vezeteknev
               + "]";
   }
}