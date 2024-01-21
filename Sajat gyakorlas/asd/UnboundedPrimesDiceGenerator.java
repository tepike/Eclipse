package asd;
import java.util.Random;

public class UnboundedPrimesDiceGenerator {

    public static void main(String[] args) {
        int result = rollPrimesDice();
        System.out.println("A dobás eredménye: " + result);
    }

    public static int rollPrimesDice() {
        // Prímszámok
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        // Véletlenszám generátor
        Random random = new Random();

        // Véletlenszám kiválasztása a prímszámok közül
        int randomIndex = random.nextInt(primes.length);

        // A kiválasztott prímszám visszaadása
        return primes[randomIndex];
    }
}
