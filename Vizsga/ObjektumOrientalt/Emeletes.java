package ObjektumOrientalt;

public class Emeletes extends Hazak{
	public int Emelet=0;
	private int Kozoskoltseg=0;
	public int Nm=0;
	public int getKozoskoltseg() {
		return Kozoskoltseg;
	}
	public void setKozoskoltseg(int kozoskoltseg) {
		Kozoskoltseg = kozoskoltseg;
	}
	
public void kiir() {
	System.out.print("A lakas az "+Emelet+". emeleten talalhato. A tarsashazban lift ");
	if(Emelet>4) {
		System.out.print("talalhato");
	}else {
		System.out.print("nem talalhato");
	}
	System.out.print(". A kozoskoltseg osszege = "+Kozoskoltseg+" Ft"+"\n A lakás nm2-e : "+Nm+" Ára = ");
}
}
