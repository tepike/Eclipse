package Jatek
public class hero {
    static String Név="Herkules";
    private static int Élet=100;
    String Heal;
    int  Healmennyiség=5;
    int Damage=10;
    int Damage_boost=5;
    int Mana=0;

    
    public String getHős_neve(){
        return Név;
    }

    public static int getÉlet(){
        return  Élet;
    }
    public static void setÉlet(int Életmegadása){
        Élet=Életmegadása;
    }

    public  void Healelés(){
        hero.getÉlet();
        Élet=(Élet+Healmennyiség);
    }
    
    public void Hero_élet(){
    System.out.println("\nA hősünk ("+Név+")"+" Élet ereje: "+Élet);
    }

    public int getDamage(){
        return Damage;
    }
    
    public void  setDamage(int a){
        a=10;
        Damage=a;
    }

    public void setFőhős_Mana(){
        Mana=Mana+2;
        if(Mana>10){
            Mana=10;
        }

    }

    public void setFőhős_Mana_Használt(){
        Mana=Mana-6;
    }
    public void setFőhős_Heal_Használt(){
        Mana=Mana-5;
    }


    public void Boost_damagebe(){
        if(Mana>=6){
        setDamage(Damage);
        Damage=Damage+Damage_boost;
        System.out.println("\nA hősünk ("+Név+")"+" növelt támadási ereje: "+Damage+"-öt sebzett "+badguy.Név+"-n");
        }

    }

    public void Boost_damageki(){
        getDamage();
        Damage=Damage-Damage_boost;
        System.out.println("\nA hősünk ("+Név+")"+" alap sebzési ereje: "+Damage);

    }


}
