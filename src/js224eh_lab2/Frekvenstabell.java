package js224eh_lab2;

import java.util.Random;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-26.
 *
 * Lektion 5 - Arrayer och ArrayList
 * Uppgift 12
 *
 * Skriv ett program Frekvenstabell.java som simulerar 6000 tärningskast. För
 * att visa att sannolikheten att få en etta, tvåa, trea, fyra, femma eller sexa
 * är ungefär lika stor, skall man skapa en frekvenstabell som lagrar hur många
 * ettor, tvåor, o.s.v. som slumpats fram. (Använd en array för att lagra hur
 * många ettor, tvåor, o.s.v. som slumpats fram.)
 * En körning kan se ut enligt följande:
 *
 *     Frequencies when rolling a dice 6000 times.
 *     1: 1025
 *     2: 996
 *     3: 980
 *     4: 1006
 *     5: 1035
 *     6: 958
 */
public class Frekvenstabell
{
    public static void main(String[] args)
    {
        final int NUMBER_OF_DICE_THROWS = 6000;
        int[]     frequencyDistribution = new int[7];  // (index 0 används inte)

        /* Simulera tärningskast. */
        final Random random = new Random();
        for (int i = 0; i < NUMBER_OF_DICE_THROWS; i++) {
            int score = random.nextInt(6) + 1;
            frequencyDistribution[score]++;
        }

        /* Skriv ut resultatet. */
        System.out.printf("Frequencies when rolling a dice %d times.%n",
                          NUMBER_OF_DICE_THROWS);
        for (int i = 1; i < frequencyDistribution.length; i++) {
            System.out.printf("%d: %d%n", i, frequencyDistribution[i]);
        }

        System.exit(0);
    }
}
