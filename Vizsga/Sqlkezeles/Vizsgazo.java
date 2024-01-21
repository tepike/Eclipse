package Sqlkezeles;




public class Vizsgazo {



   private String vizsgazo;

   private int pontszam;

   public Vizsgazo(String vizsgazo, int pontszam) {

       super();

       this.vizsgazo = vizsgazo;

       this.pontszam = pontszam;

   }

   public String getVizsgazo() {

       return vizsgazo;

   }

   public void setVizsgazo(String vizsgazo) {

       this.vizsgazo = vizsgazo;

   }

   public int getPontszam() {

       return pontszam;

   }

   public void setPontszam(int pontszam) {

       this.pontszam = pontszam;

   }

   @Override

   public String toString() {

       return "Vizsgázó neve: " + vizsgazo + ", pontszám: " + pontszam;

   }

}