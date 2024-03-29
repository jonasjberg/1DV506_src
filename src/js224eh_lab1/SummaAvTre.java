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

        int   threeDigitNumber = promptUserForThreeDigitInt(MSG_PROMPT_THREE_DIGITS);
        int[] numberArray      = splitIntIntoIntArray(threeDigitNumber);

        int sum = 0;
        for (int number : numberArray) {
            sum += number;
        }

        System.out.printf("Summan av siffrorna i heltalet är: %d\n", sum);
        System.exit(0);
    }

    /**
     * Splits an integer into an array of integers with one number per index.
     *
     * @param number The number to split into an array.
     * @return An array of integers with one number in each array position.
     */
    private static int[] splitIntIntoIntArray(int number)
    {
        final String numberString   = String.valueOf(number);
        final int    numberOfDigits = numberString.length();
        int[]        numberArray    = new int[numberOfDigits];

        for (int i = 0; i < numberOfDigits; i++) {
            numberArray[i] = Integer
                    .parseInt(String.valueOf(numberString.charAt(i)));
        }

        return numberArray;
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
            UserInputUtils.queryUser(message);

            while (!scan.hasNextInt()) {
                UserInputUtils.queryUser(message);
                scan.next();
            }
            userInput = scan.nextInt();

            hasThreeDigits = String.valueOf(userInput).length() == 3;

        } while (userInput <= 0 || !hasThreeDigits);

        return userInput;
    }
}
