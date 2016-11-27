package js224eh_lab2;

import java.util.Scanner;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-26.
 *
 * Lektion 4 - Styrande satser
 * Uppgift 5
 *
 * Skriv ett program Triangle.java som för ett godtyckligt positivt udda heltal
 * N (läses in från tangentbordet) skriver ut två olika trianglar.
 * Först en rätvinklig sedan en likbent. Exempel på körning:
 *
 *     Mata in ett udda heltal: 7
 *     Rätvinklig triangel:
 *           *
 *          **
 *         ***
 *        ****
 *       *****
 *      ******
 *     *******
 *
 *     Likbent triangel:
 *        *
 *       ***
 *      *****
 *     *******
 *
 * Notera, heltalet N bestämmer hur lång basen på varje triangel är.
 * Programmet skall avslutas med ett felmeddelande om det inmatade talet
 * inte är ett positivt udda heltal.
 */
public class Triangle
{
    public static void main(String[] args)
    {
        final String MSG_QUERY = "Mata in ett udda heltal: ";

        /* Hämta inmatning från användaren. */
        Scanner scan = new Scanner(System.in);

        int triangleBase;
        do {
            System.out.print(MSG_QUERY);

            while (!scan.hasNextInt()) {
                System.out.print(MSG_QUERY);
                scan.next();
            }
            triangleBase = scan.nextInt();

        } while (triangleBase <= 0 || triangleBase % 2 == 0);

        scan.close();

        /* Skriv ut trianglar. */
        System.out.println("Rätvinklig triangel:");
        for (int i = 0; i < triangleBase; i++) {
            String asterisks = repeatString("*", i + 1);

            String format = "%" + triangleBase + "s" + "\n";
            System.out.printf(format, asterisks);
        }

        System.out.println("\n" + "Likbent triangel:");
        int asteriskCount = 1;
        while (asteriskCount < (triangleBase + 2)) {
            int spaceCount = (triangleBase - asteriskCount) / 2;

            System.out.printf(repeatString(" ", spaceCount));
            System.out.printf(repeatString("*", asteriskCount));
            System.out.printf(repeatString(" ", spaceCount));
            System.out.printf("\n");

            asteriskCount += 2;
        }

        System.exit(0);
    }

    /**
     * Repeats a given string a specified number of times.
     *
     * @param string  The string to repeat.
     * @param repeats The number of concatenations of the string.
     * @return 'string' repeated 'repeats' times.
     */
    private static String repeatString(String string, int repeats)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < repeats; i++) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
