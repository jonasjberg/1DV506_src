package js224eh_lab1;

import java.util.Scanner;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-11-09.
 *
 * Various utility method for getting specific input from a user through stdin.
 * Methods that were indentical and repeated in more than one file have been
 * moved here.
 */
class UserInputUtils
{
    /**
     * Prints a message to the user.
     *
     * @param message The message to print. Must not be empty.
     */
    static void queryUser(String message)
    {
        if (message != null && message.length() > 0) {
            System.out.print(message);
        }
    }

    /**
     * Prompts the user for a positive number.
     *
     * The message is shown continuously until the user has entered a valid
     * number. Any leading and trailing whitespace is removed.
     *
     * @param strPromptForLine The message to display when prompting for input.
     * @return The number entered by the user.
     */
    static double promptForPositiveNumber(String strPromptForLine)
    {
        Scanner scan = new Scanner(System.in);
        double  number;

        do {
            queryUser(strPromptForLine);

            while (!scan.hasNextDouble()) {
                queryUser(strPromptForLine);
                scan.next();
            }
            number = scan.nextDouble();

        } while (number <= 0);

        return number;
    }

    /**
     * Prompts the user for a decimal number.
     *
     * The message is shown continuously until the user has entered a valid
     * number. Any leading and trailing whitespace is removed.
     *
     * @param strPromptForLine The message to display when prompting for input.
     * @return The number entered by the user.
     */
    static double promptForNumber(String strPromptForLine)
    {
        Scanner scan = new Scanner(System.in);

        while (!scan.hasNextDouble()) {
            queryUser(strPromptForLine);
            scan.next();
        }

        return scan.nextDouble();
    }

    /**
     * Prompts the user for a line of input from stdin.
     *
     * The message is shown continuously until the input has one or more
     * characters. Any leading and trailing whitespace is removed.
     *
     * @param strPromptForLine The message to display when prompting for input.
     * @return The line of input entered by the user.
     */
    static String promptForTextLine(String strPromptForLine)
    {
        Scanner scan      = new Scanner(System.in);
        String  userInput = null;

        do {
            queryUser(strPromptForLine);
            userInput = scan.nextLine().trim();
        } while (userInput == null || userInput.isEmpty());

        return userInput;
    }
}
