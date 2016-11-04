package js224eh_lab1;

import java.util.Scanner;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-04.
 *
 * Lektion 2 - (Input/Output, Operations on Primitive Types)
 *
 * 9. Tiden
 *    Skriv ett program Tid.java som läser in ett antal sekunder (ett heltal)
 *    och sedan skriver ut samma tid i termer av timmar, minuter och sekunder.
 *    En exekvering kan se ut som följer:
 *
 *        Ange antal sekunder: 9999
 *        Detta motsvarar: 2 timmar, 46 minuter och 39 sekunder.
 */
public class Tid
{
    public static void main(String[] args)
    {
        final String MSG_PROMPT_FOR_SECONDS = "Ange antal sekunder: ";

        int secondsTotal = promptUserForPositiveInt(MSG_PROMPT_FOR_SECONDS);

        int hours   = secondsTotal / 3600;
        int minutes = (secondsTotal % 3600) / 60;
        int seconds = secondsTotal % 60;

        String hoursString   = hours   == 1 ? "timme"  : "timmar";
        String minutesString = minutes == 1 ? "minut"  : "minuter";
        String secondsString = seconds == 1 ? "sekund" : "sekunder";

        System.out.printf("Detta motsvarar: %d %s, %d %s och %d %s.\n",
                          hours, hoursString, minutes, minutesString,
                          seconds, secondsString);
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
    private static int promptUserForPositiveInt(String message)
    {
        Scanner scan      = new Scanner(System.in);
        int     userInput = 0;

        do {
            queryUser(message);

            while (!scan.hasNextInt()) {
                queryUser(message);
                scan.next();
            }
            userInput = scan.nextInt();

        } while (userInput <= 0);

        return userInput;
    }
}
