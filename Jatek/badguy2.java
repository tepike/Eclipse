package Jatek
import java.util.Random;
public class badguy2 {


    Random random = new Random();
    int randomNumber = random.nextInt(10) + 1;


    /*static kellet a név elé, hogy tudja kezelni  hero.Név/badguy.Név formában másik programkód */
    static String Név="Diablo";
    private static int Élet=100;
    String Heal;
    int Poison=10;
    int Damage=5;
    int Mana=10;



    public String getBadguy_neve(){
        return Név;
    }

    public static int getÉlet(){
        return Élet;
    }
    public void setÉlet(int Életmegadása){
        Élet=Életmegadása;
    }

    public void setBadguy_Mana(){
        Mana=Mana+2;
        if(Mana>10){
            Mana=10;
        }

    }



    public void Mérgezés(){
        /*getKöröm még nem működik. Cél, hogy 2 körig mérgezzen és ne lehessen csak 3-4 körönként használni */
        if (Mana>=5){
            int Hős_élet= hero.getÉlet();
            int sebzett_élet= Hős_élet-Poison;
            hero.setÉlet(sebzett_élet);
            System.out.println("A hős életéből levett a méreg: "+Poison+"-et, így a fennmaradó mennyiség = "+sebzett_élet);
        }
           
    }

    public void Mérgezés_nagysága(){
    System.out.println("\nA hősünk ("+hero.Név+")"+" mérgezett sebzése: "+Poison);
    }

    public int getDamage(){
        return Damage;
    }




}