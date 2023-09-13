package sql_2;

public class nobel {
   private String nev;
   private String orszag;
   private int eletkor;
   private int eredmeny;
   
   

   public nobel(String nev, String orszag, int eletkor, int eredmeny) {
       
       this.nev = nev;
       this.orszag = orszag;
       this.eletkor = eletkor;
       this.eredmeny = eredmeny;
   }



   public String getNev() {
       return nev;
   }




   public String getOrszag() {
       return orszag;
   }




   public int getEletkor() {
       return eletkor;
   }




   public int getEredmeny() {
       return eredmeny;
   }




   public void setNev() {
       this.nev = nev;
   }




   public void setOrszag(String orszag) {
       this.orszag = orszag;
   }




   public void setEletkor(int eletkor) {
       this.eletkor = eletkor;
   }




   public void setEredmeny(int eredmeny) {
       this.eredmeny = eredmeny;
   }



   @Override
   public String toString() {
       return "Nev =" + nev + ", Orszag=" + orszag + ", Kor=" + eletkor + ", Eredmeny=" + eredmeny
               ;
   }
}