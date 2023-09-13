package Jatek
import java.util.Scanner;
import java.util.Random;
public class körök {
   static int  Körszámláló=1;

    public static void getKöröm(){
        Körszámláló=Körszámláló;
    }
    public static void Rounds(){
        
        hero Főhős;
        badguy Badguy;
        Főhős = new hero();
        Badguy = new badguy();
        Scanner bevitel = new Scanner(System.in);
        int Körszámláló=1;
        System.out.println("\t\s\sMegkezdődött az 1. kör\n");
/* Hős lépési interakció */
        do{
            if(hero.getÉlet()<1){
                System.out.println("\nA játék végetért, mert "+Főhős.getHős_neve()+"-t elpusztították"+"\s|\s"+"Összes játszott kör száma: "+Körszámláló);
                break;
            }
            System.out.println("\t\t"+Főhős.getHős_neve()+ " lép ");
            System.out.println("Hős léphető opciói"+"\s|\sSaját élet = "+hero.getÉlet()+"\s|\s Mana = "+Főhős.Mana+"\nA = Támadás, H = Healelás (5 Mana), D = Damage Boost támadás (6 Mana), E = Játék befejezése"+"\s |\s"+Badguy.getBadguy_neve()+"Életereje = "+Badguy.getÉlet()+"");
            String Hős_válasz = bevitel.next().toUpperCase();
            String Hős_Választott_lépés="AHD";
            String Hős_Választott_Manamentes_Lépés="A";
            if(Hős_válasz.contains("E")){
                System.out.println("Játék bezárva");
                break;
            }

            while (!Hős_Választott_lépés.contains(Hős_válasz)) {
                System.out.println("Helytelen lépés. | A = Támadás, H = Healelás, D = Damage Boost támadás, E = Játék befejezése");
                Hős_válasz = bevitel.next().toUpperCase();
            }





            switch(Hős_válasz){
                case "A":
                    Badguy.getÉlet();
                    Badguy.setÉlet(Badguy.getÉlet()-Főhős.getDamage());
                    System.out.println("Sikeres támadás bevitel");

                    break;
                case "H":
                    if(Főhős.Mana>=5){
                        System.out.println(""+Főhős.getHős_neve()+" Healelt");
                        Főhős.Healelés();
                        System.out.println("Így az élete "+hero.getÉlet()+" re nőtt");
                        Főhős.setFőhős_Heal_Használt();
                        break;
                    }
                    else{
                        while (!Hős_válasz.contains(Hős_Választott_Manamentes_Lépés)) {
                            System.out.println("Nincs elég Manád! "+"| Elérhető Mana:"+Főhős.Mana+ " | A = Támadás, E = Játék befejezése");
                            Hős_válasz = bevitel.next().toUpperCase();
                        }
                    }

                case "D":
                    if(Főhős.Mana>=5){
                        Főhős.Boost_damagebe();
                        Főhős.getDamage();
                        Badguy.setÉlet(Badguy.getÉlet()-Főhős.getDamage());
                        Főhős.setFőhős_Mana_Használt();
                        break;
                    }
                    else{
                        while (!Hős_válasz.contains(Hős_Választott_Manamentes_Lépés)) {
                            System.out.println("Nincs elég Manád! "+"| Elérhető Mana:"+Főhős.Mana+ " | A = Támadás, E = Játék befejezése");
                            Hős_válasz = bevitel.next().toUpperCase();
                        }
                    }


                default:
                    Badguy.getÉlet();
                    Badguy.setÉlet(Badguy.getÉlet()-Főhős.getDamage());
                    System.out.println("Sikeres támadás bevitel "+Főhős.Damage);

                    break;
            }
            /*Gonosz lépési interakció */


            if(badguy.getÉlet()<1){
                System.out.println("\nA játék végetért, mert "+Badguy.getBadguy_neve()+"-t elpusztítottad "+"\s|\s"+"Összes játszott kör száma: "+Körszámláló);
                break;
            }
            try {
                Thread.sleep(2000); // 2 másodperc várakozás
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                System.out.println("\n");

                System.out.println("\t"+Badguy.getBadguy_neve()+ " lép "+"\s\s|\s\s élete =" +Badguy.getÉlet() );

    
                /*System.out.println("Támadás = 1-6 ig, Mérgezés = 7-10 ig"+"\s\s|"+"\s\s"+Főhős.getHős_neve()+"Életereje = "+Főhős.getÉlet());*/
                /*try {
                    Thread.sleep(2000); // 2 másodperc várakozás
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }*/
                Random random = new Random();
                int Badguy_válasz = random.nextInt(9) + 1;
                /*System.out.println(Badguy_válasz);*/

                try {
                    Thread.sleep(2000); // 2 másodperc várakozás
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
                switch (Badguy_válasz){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        Főhős.getÉlet();
                        Főhős.setÉlet(Főhős.getÉlet()-Badguy.getDamage());
                        System.out.println("\tSikeres támadás bevitel "+"("+Badguy.Damage+")");
                        break;

                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        if(Badguy.Mana>=5){
                            System.out.println("\tMéregezés nagysága = "+Badguy.Poison);
                            Badguy.Mérgezés();
                            break;
                        }
                        else{
                             while (Badguy_válasz>6) {
                                /*System.out.print("Újrapórálbkozás Mana hiányában");*/
                                Badguy_válasz = random.nextInt(2) + 1;
                            }
                        }

                    default:
                        Főhős.getÉlet();
                        Főhős.setÉlet(Főhős.getÉlet()-Badguy.getDamage());
                        System.out.println("\tSikeres támadás bevitel "+"("+Badguy.Damage+")");
                        break;
                    
    
                }


                Körszámláló++;
                Főhős.setFőhős_Mana();
                Badguy.setBadguy_Mana();
                try {
                    Thread.sleep(3000); // 2 másodperc várakozás
               } catch (InterruptedException e) {
                        e.printStackTrace();
               }
                System.out.println("=====================================================================");
                System.out.println("\n\t\sJelenlegi kör száma = "+Körszámláló+"| Mana változás: +2\n");
            try {
                 Thread.sleep(1000); // 2 másodperc várakozás
            } catch (InterruptedException e) {
                     e.printStackTrace();
            }


        }
        while (Badguy.getÉlet()>1|Főhős.getÉlet()>1);


    
    


}
}

