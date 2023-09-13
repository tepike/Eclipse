package fifa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int csapatok = 0;
        double csapatok_pontszama = 0;
        int legtobb_javitas = 0;
        int legtobb_javitas_index=0;
        boolean Magyarorszag=false;
        String Feladat6="Magyarorszag";
        
        

        rendezes[] Fifatomb = new rendezes[1000];
        try {
            System.setProperty("File.encoding", "UTF-8");
            BufferedReader br = new BufferedReader(new FileReader("fifa.txt"));
            String sor = "";
            br.readLine();
            int index = 0;
            while ((sor = br.readLine()) != null && !sor.isEmpty()) {
                String[] darab = sor.split(";");
                if (darab.length == 4) {
                    Fifatomb[index] = new rendezes(darab[0], Integer.parseInt(darab[1]), Integer.parseInt(darab[2]), Integer.parseInt(darab[3]));
                    csapatok++;
                    csapatok_pontszama += Integer.parseInt(darab[3]);
                } else {
                    Fifatomb[index] = new rendezes(darab[0], Integer.parseInt(darab[1]), Integer.parseInt(darab[2]), Integer.parseInt(darab[3]));
                }
                index++;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("hiba");
        }

        for (int i = 0; i < Fifatomb.length; i++) {
            if (Fifatomb[i] != null) {
                System.out.println(Fifatomb[i].toString());
            }
        }

        for (int i = 0; i < Fifatomb.length; i++) {
            if (Fifatomb[i] != null) {
                if (Fifatomb[i].getValtozas() > legtobb_javitas) {
                    legtobb_javitas = Fifatomb[i].getValtozas();
                    legtobb_javitas_index=i;
                }
                if(Fifatomb[i].getCsapat().equals(Feladat6)) {
                	Magyarorszag=true;
                }
                
            }
        }
        //  System.out.println();
        System.out.println("\nFeladat 3: Osszes csapat az allomanyban = " + csapatok);
        System.out.println("Feladat 4: A csapatok atlagos pontszama = " + (csapatok_pontszama / csapatok) + " pont");
        System.out.println("Feladat 5:  A legtobbet javito csapat:"
        		+ "\n Helyezes: "+Fifatomb[legtobb_javitas_index].getHelyezes()+"\n Csapat: "+Fifatomb[legtobb_javitas_index].getCsapat()+"\n Pontszam: "+Fifatomb[legtobb_javitas_index].getPontszam());
        if(Magyarorszag==false) {
        	System.out.println("Feladat 6: A csapatok kozott nincs Magyarorszag");
        
        }else {
        	System.out.println("Feladat 6: A csapatok megtalalhato Magyarorszag");
        }
        
        /*
            7. Készítsen statisztikát a helyezések változása (Va1tozas) alapján csoportosítva a
			csapatok számárő| a minta szerint! Csak azok a helyezésváltozások jelenjenek meg a
			képemyőn, amelyek esetében a csapatok szána több mint egy volt! A megjelenő
			csopor1ok sorrendj e tetszőleges.
         */
        
        String[] feladat7=new String[csapatok];
        feladat7[0]="alma";
        feladat7[1]="alma2";
        System.out.println(Arrays.toString(feladat7));
        
        
    }
}
