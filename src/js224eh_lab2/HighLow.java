package js224eh_lab2;

import java.util.Random;

import static js224eh_lab2.UserInputUtils.promptForPositiveWholeNumber;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-24.
 *
 * Lektion 4 - Styrande satser
 * Uppgift 4
 * Skriv ett program HighLow.java som implementerar gissningsleken High and
 * Low. Datorn väljer ett slumptal mellan 1 och 100 och låter sedan spelaren
 * gissa dess värde. Efter varje gissning ges en ledtråd av typen "högre" eller
 * "lägre". En körning kan se ut enligt följande:
 *
 *     Gissning 1: 67
 *        Ledtråd: högre
 *     Gissning 2: 82
 *        Ledtråd: lägre
 *     Gissning 3: 77
 *        Rätt svar efter bara 3 gissningar - Strålande!
 *
 * Programmet avbryts efter 10 gissningar med en lämplig slutkommentar.
 */
public class HighLow
{
    public static void main(String[] args)
    {
        final int correctAnswer   = getRandomNumber(1, 100);
        int       guessCount = 1;

        int guess = promptForPositiveWholeNumber("Gissning " + guessCount + ": ");
        if (guess == correctAnswer) {
            System.out.printf("   Rätt svar efter bara %d gissningar - Strålande!", guessCount);
        }

        while (guess != correctAnswer) {
            guessCount++;
            System.out.println("   Ledtråd: " + (guess > correctAnswer ? "lägre" : "högre"));

            guess = promptForPositiveWholeNumber("Gissning " + guessCount + ": ");
            if (guess == correctAnswer) {
                System.out.printf("   Rätt svar efter bara %d gissningar - Strålande!", guessCount);
                break;
            }
            if (guessCount == 10) {
                System.out.println("   Max antal gissningar överskridet!");
                break;
            }
        }

        System.exit(0);
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
        Random random = new Random();
        return random.nextInt(((max - min) + 1) + min);
    }
}
