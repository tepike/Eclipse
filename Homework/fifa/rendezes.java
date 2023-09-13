package fifa;

public class rendezes {

   private String Csapat;
   private int Helyezes;
   private int Valtozas;
   private int Pontszam;
   
   








public  rendezes(String Csapat, int Helyezes, int Valtozas, int Pontszam) {
       
       this.Csapat = Csapat;
       this.Helyezes = Helyezes;
       this.Valtozas = Valtozas;
       this.Pontszam = Pontszam;
   }



   public String getCsapat() {
       return Csapat;
   }




   public int getHelyezes() {
       return Helyezes;
   }




   public int getValtozas() {
       return Valtozas;
   }




   public int getPontszam() {
       return Pontszam;
   }




   public void setCsapat(String Csapat) {
       this.Csapat = Csapat;
   }




   public void setHelyezes(int tipus) {
       this.Helyezes = Helyezes;
   }




   public void setValtozas(int Valtozas) {
       this.Valtozas = Valtozas;
   }




   public void setVezeteknev(int Pontszam) {
       this.Pontszam = Pontszam;
   }



   @Override
   public String toString() {
       return "Fifa [Csapat=" + Csapat + ", Helyezes=" + Helyezes + ", Valtozas=" + Valtozas + ", Pontszam=" + Pontszam
               + "]";
   }
}