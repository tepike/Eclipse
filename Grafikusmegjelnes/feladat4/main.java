package feladat4;

import java.util.*;

public class main {

    public static void main(String[] args) {
        // Halmaz példa
        Set<Integer> halmaz = new HashSet<>();
        halmaz.add(5);
        halmaz.add(3);
        halmaz.add(8);
        System.out.println("Halmaz: " + halmaz);

        // Lista  példa
        List<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(3);
        lista.add(8);
        System.out.println("Lista: " + lista);

        // Összetett lista  példa
        List<List<Integer>> osszetettLista = new ArrayList<>();
        osszetettLista.add(Arrays.asList(1, 2, 3));
        osszetettLista.add(Arrays.asList(4, 5, 6));
        System.out.println("Osszetett lista: " + osszetettLista);

        // Tömb példa
        int[] tomb = {1, 2, 3, 4, 5};
        System.out.println("Tomb: " + Arrays.toString(tomb));

        // Műveleti példák
        System.out.println("TOmb masodik eleme: " + tomb[1]);
        System.out.println("Halmaz merete: " + halmaz.size());
        System.out.println("Lista masodik eleme: " + lista.get(1));
        System.out.println("Osszetett lista masodik eleme: " + osszetettLista.get(1).get(1));
    }
}