package js224eh_lab2;

import java.util.Scanner;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-26.
 *
 * Lektion 4 - Styrande satser
 * Uppgift 5
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
 * Notera, heltalet N bestämmer hur lång basen på varje triangel är. Programmet
 * skall avslutas med ett felmeddelande om det inmatade talet inte är ett
 * positivt udda heltal.
 */
public class Triangle
{
    public static void main(String[] args)
    {
        final String MSG_QUERY = "Mata in ett udda heltal: ";
        int          triangleBase = 2;

        while (isEven(triangleBase)) {
            triangleBase = UserInputUtils.promptForPositiveWholeNumber(MSG_QUERY);
        }

        // // Enklare och bräckligare lösning:
        // Scanner scan = new Scanner(System.in);
        //
        // while (isEven(triangleBase)) {
        //     System.out.print(MSG_QUERY);
        //     triangleBase = scan.nextInt();
        // }
        //
        // scan.close();


        System.out.println("Rätvinklig triangel:");
        for (int i = 0; i < triangleBase; i++) {
            String asterisks = repeatString("*", i + 1);

            String format = "%" + triangleBase + "s" + "\n";
            System.out.printf(format, asterisks);
        }

        System.out.println("\n" + "Likbent triangel:");
        int numberAsterisksThisRow = 1;
        while (numberAsterisksThisRow < triangleBase) {
            int numberOfSpaces = (triangleBase - numberAsterisksThisRow) / 2;

            System.out.printf(repeatString(" ", numberOfSpaces));
            System.out.printf(repeatString("*", numberAsterisksThisRow));
            System.out.printf(repeatString(" ", numberOfSpaces));
            System.out.printf("\n");

            numberAsterisksThisRow += 2;
        }
        System.out.printf(repeatString("*", triangleBase));
    }

    /**
     * Tests if a number is even.
     *
     * @param number The number to test.
     * @return True if the number is even, otherwise False.
     */
    private static boolean isEven(int number)
    {
        return number % 2 == 0;
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
