package js224eh_lab1;

import java.util.Scanner;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-04.
 *
 * Lektion 2 - (Input/Output, Operations on Primitive Types)
 *
 * 10. Summa av tre siffror
 *
 *     Skriv ett program SummaAvTre.java där användaren ombeds mata in ett
 *     tresiffrigt tal. Programmet ska sedan bilda summan av de siffrorna
 *     heltalet utgörs av, samt skriva ut summan. Det tresiffriga talet måste
 *     läsas in i sin helhet vid ett och samma tillfälle.
 *
 *         Ange ett tresiffrigt heltal: 483
 *         Summan av siffrorna i heltalet är: 15
 *
 *     Ledtråd: Använd modulus (%10) och heltalsdivision (/10) för att plocka
 *              ut siffrorna en åt gången.
 */
public class SummaAvTre
{
    public static void main(String[] args)
    {
        final String MSG_PROMPT_THREE_DIGITS = "Ange ett tresiffrigt heltal: ";

        int threeDigitNumber = promptUserForThreeDigitInt(MSG_PROMPT_THREE_DIGITS);

        System.out.println(threeDigitNumber);
    }

    /**
     * Prints a message to the user.
     *
     * @param message The message to print. Must not be empty.
     */
    private static void queryUser(String message)
    {
        if (message != null && message.length() > 0) {
            System.out.print(message);
        }
    }

    /**
     * Prompts the user for a number.
     *
     * The message is shown continuously until the user has entered a valid
     * number. Any leading and trailing whitespace is removed.
     *
     * @param message The message to display when prompting for input.
     * @return The number entered by the user.
     */
    private static int promptUserForThreeDigitInt(String message)
    {
        Scanner scan           = new Scanner(System.in);
        int     userInput      = 0;
        boolean hasThreeDigits = false;

        do {
            queryUser(message);

            while (!scan.hasNextInt()) {
                queryUser(message);
                scan.next();
            }
            userInput = scan.nextInt();

            hasThreeDigits = String.valueOf(userInput).length() == 3;

        } while (userInput <= 0 || !hasThreeDigits);

        return userInput;
    }
}
