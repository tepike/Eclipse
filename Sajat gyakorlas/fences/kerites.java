package fences;

public class kerites {
	   private int milyen;
	   private int hossz;
	   private String szin;
	   private int hazszamok;
	   private int hazszamok2;

	   
	   








	public  kerites(int milyen, int hossz, String szin) {
	       
	       this.milyen = milyen;
	       this.hossz = hossz;
	       this.szin = szin;
	       this.hazszamok = hazszamok;
	       this.hazszamok2 = hazszamok2;

	   }



	   public int getmilyen() {
	       return milyen;
	   }




	   public int gethossz() {
	       return hossz;
	   }




	   public String getszin() {
	       return szin;
	   }



	   public int gethazszamok() {
	       return hazszamok;
	   }
	   
	   public int gethazszamok2() {
	       return hazszamok2;
	   }




	   public void setmilyen(int milyen) {
	       this.milyen = milyen;
	   }




	   public void sethossz(int hossz) {
	       this.hossz = hossz;
	   }




	   public void setszin(String szin) {
	       this.szin = szin;
	   }


	   public void sethazszamok(int hazszamok) {
	       this.hazszamok = hazszamok;
	   }
	   
	   public void sethazszamok2(int hazszamok2) {
	       this.hazszamok2 = hazszamok2;
	   }




	   @Override
	   public String toString() {
	       return ""+milyen +" "+ hossz +" "+ szin;
	               
	   }
}
