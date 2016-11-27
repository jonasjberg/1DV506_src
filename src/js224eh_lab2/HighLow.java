package js224eh_lab2;

import java.util.Random;
import java.util.Scanner;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-24.
 *
 * Lektion 4 - Styrande satser
 * Uppgift 4
 *
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
        final int MAX_NUMBER_OF_GUESSES = 10;

        final Random random        = new Random();
        final int    correctAnswer = random.nextInt(100) + 1;
        int          guessCount    = 1;

        int guess = promptForPositiveWholeNumber("Gissning " + guessCount + ": ");
        if (guess == correctAnswer) {
            System.out.printf("   Rätt svar efter bara %d gissningar" +
                              " - Strålande!", guessCount);
        }

        while (guess != correctAnswer && guessCount < MAX_NUMBER_OF_GUESSES) {
            guessCount++;

            System.out.println("   Ledtråd: " +
                               (guess > correctAnswer ? "lägre" : "högre"));

            guess = promptForPositiveWholeNumber("Gissning " + guessCount + ": ");
            if (guess == correctAnswer) {
                System.out.printf("   Rätt svar efter bara %d gissningar" +
                                  " - Strålande!", guessCount);
            } else if (guessCount == MAX_NUMBER_OF_GUESSES) {
                System.out.println("   Max antal gissningar överskridet!");
            }
        }

        System.exit(0);
    }

    /**
     * First created 2015-06-24 during the course DV017a at Högskolan i Gävle.
     * https://github.com/jonasjberg/DV017A_lab2/commit/057fc2e41f79b3458b09d5678176c9ae6423728e
     *
     * Prompts the user for a positive whole number.
     *
     * The message is shown continuously until the user has entered a valid
     * whole number. Any leading and trailing whitespace is removed.
     *
     * @param strPromptForLine The message to display when prompting for input.
     * @return The number entered by the user.
     */
    static int promptForPositiveWholeNumber(String strPromptForLine)
    {
        Scanner scan = new Scanner(System.in);
        int     number;

        do {
            System.out.print(strPromptForLine);

            while (!scan.hasNextInt()) {
                System.out.print(strPromptForLine);
                scan.next();
            }
            number = scan.nextInt();

        } while (number <= 0);

        return number;
    }
}
