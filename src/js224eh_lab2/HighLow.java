package js224eh_lab2;

import java.util.Random;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-24.
 *
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
public class HighLow {
    public static void main(String[] args) {
        final int correctAnswer = getRandomNumber(1, 100);
        int numberGuesses = 1;
        int guessedNumber = UserInputUtils.promptForPositiveWholeNumber("Gissning " + numberGuesses + ": ");

        if (guessedNumber == correctAnswer) {
            System.out.println("   Rätt svar efter bara " + numberGuesses + " gissningar - Strålande!");
        }

        while (guessedNumber != correctAnswer) {
            numberGuesses++;
            System.out.println("   Ledtråd: " + (guessedNumber > correctAnswer ? "lägre" : "högre"));
            guessedNumber = UserInputUtils.promptForPositiveWholeNumber("Gissning " + numberGuesses + ": ");

            if (guessedNumber == correctAnswer) {
                System.out.println("   Rätt svar efter bara " + numberGuesses + " gissningar - Strålande!");
                break;
            }

            if (numberGuesses == 10) {
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
    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        //return random.nextInt((max - min) + 1) + min)
        int randomNumber = random.nextInt(((max - min) + 1) + min);
        return randomNumber;
    }
}
