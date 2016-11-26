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
        final int NUMBER_OF_DICE_THROWS = 3;
        int[]     frequencyDistribution = new int[6];
        System.out.println(frequencyDistribution.length);

        System.out.printf("Frequencies when rolling a dice %d times.%n",
                          NUMBER_OF_DICE_THROWS);

        /* Kasta tärningen. */
        for (int i = 0; i < NUMBER_OF_DICE_THROWS; i++) {
            int rolledNumber = getRandomNumber(1, 6);
            System.out.println("RULLADE: " + rolledNumber);
            frequencyDistribution[rolledNumber - 1]++;
        }

        /* Skriv ut resultatet. */
        for (int i = 1; i < frequencyDistribution.length; i++) {
            System.out.printf("%d: %d%n", i, frequencyDistribution[i - 1]);
        }
    }

    /**
     * Generates a random number within specified range.
     *
     * @param min The minimum possible value of any single digit.
     * @param max The maximum possible value of any single digit.
     * @return A random number within the range [min:max].
     */
    private static int getRandomNumber(int min, int max)
    {
        final Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
