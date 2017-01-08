package js224eh_lab4;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Created by Jonas Sjöberg (js224eh) on 2017-01-08.
 *
 * 1DV506 -- Problemlösning och Programmering, HT2016
 * Laboration 4: Exceptions, IO och interface
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * Uppgift 5
 * =========
 * Simulering
 * Skapa en klass DrunkenWalk som simulerar onyktra personers vandring på en
 * plattform i en sjö. Programmet ska fråga användaren efter storleken på
 * plattformen (planet), det maximala antalet steg och antalet onyktra personer
 * som sätts på plattformen. En person i taget ska sättas på plattformen och
 * utföra sin vandring. Ditt program ska räkna hur många av dem som ramlar i
 * sjön. Testa ditt program med några olika värden på storleken och antalet
 * steg. Exempel på körning:
 *
 *     Ange storlek: 10
 *     Ange max antal steg: 50
 *     Ange antal slumpvandringar: 150
 *     Av 150 onyktra personer, föll 14 (9.34%) i vattnet.
 */

import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class DrunkenWalk
{
    static int iterations, areaSize, maxNumberSteps;
    static final boolean DRAW_ASCII_GRAPHICS = true;

    public static void main(String[] args)
    {
        //areaSize = getPositiveIntegerFromUser("Ange storlek");
        //maxNumberSteps = getPositiveIntegerFromUser("Ange max antal steg");
        //iterations = getPositiveIntegerFromUser("Ange antal slumpvandringar");
        areaSize = 5;
        maxNumberSteps = 25;
        iterations = 10;

        int deadDrunks = 0;
        for (int i = 1; i <= iterations; i++) {
            RandomWalk walk = new RandomWalk(maxNumberSteps, areaSize);

            while (walk.moreSteps()) {
                if (DRAW_ASCII_GRAPHICS) {
                    clearAndResetAnsiTerminal();
                    System.out.printf("Running simulation #-%3d/%-3d%n", i, iterations);
                    double p = (double) deadDrunks / iterations * 100;
                    System.out.printf("Dead: %-5d (%.2f%%)   Lucky: %-5d%n", deadDrunks, p, i - deadDrunks);
                    System.out.println("------------------------------\n");
                    walk.drawAsString();
                    System.out.printf("%n%s%n", walk);
                    sleep(50);
                }

                walk.takeStep();
                if (!walk.inBounds()) {
                    deadDrunks++;
                    break;
                }
            }
        }

        double probability = (double) deadDrunks / iterations * 100;
        String result = String.format("Av %d onyktra personer, föll %d (%.2f%%) i vattnet.%n",
                                      iterations, deadDrunks, probability);
    }

    private static int getPositiveIntegerFromUser(String message)
    {
        Scanner scan = new Scanner(System.in);
        String msg = message + ": ";
        int     number;

        do {
            System.out.print(msg);

            while (!scan.hasNextInt()) {
                System.out.print(msg);
                scan.next();
            }
            number = scan.nextInt();

        } while (number <= 0);

        return number;
    }

    /**
     * Used when drawing the ASCII "graphics".
     * Clears and resets a ANSI compatible terminal emulator.
     */
    private static void clearAndResetAnsiTerminal()
    {
        /* Method #1 */
        // final String ANSI_CLS = "\u001b[2J";
        // final String ANSI_HOME = "\u001b[H";
        // System.out.print(ANSI_CLS + ANSI_HOME);
        // System.out.flush();

        /* Method #2 */
        final String ESC = "\033[";
        System.out.print(ESC + "2J");
    }

    /**
     * Used when drawing the ASCII "graphics".
     * Pauses execution -- "sleeps" for a given duration.
     *
     * @param milliseconds Milliseconds to sleep, approximately.
     */
    private static void sleep(int milliseconds)
    {
        if (milliseconds > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(milliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
