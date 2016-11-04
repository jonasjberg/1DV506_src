package js224eh_lab1;

import java.util.Scanner;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-04.
 *
 * Lektion 2 - (Input/Output, Operations on Primitive Types)
 *
 * 7. Antal sekunder
 *    Skriv ett program Sekunder.java som läser in tre heltal (timmar, minuter,
 *    sekunder) och sedan beräknar motsvarande tid i sekunder.
 *    Tex, 1 timme, 28 minuter och 42 sekunder är samma sak som 5322 sekunder.
 *    En exekvering kan se ut enligt följande:
 *
 *     Timmar: 1
 *     Minuter: 28
 *     Sekunder: 42
 *
 *     Totala antalet sekunder: 5322
 */
public class Sekunder
{
    public static void main(String[] args)
    {
        final String MSG_PROMPT_FOR_HMS = "Ange antal timmar, minuter och " +
                                          "sekunder på formen (timmar, " +
                                          "minuter, sekunder): ";
        final int NUMBER_OF_CSV = 3;

        int[] userInput = promptUserForNCommaSepValues(NUMBER_OF_CSV,
                                                       MSG_PROMPT_FOR_HMS);
        printUserInput(userInput);
        printSecondsTotal(userInput);

        System.exit(0);
    }

    /**
     * Prints number of seconds from an array of integers with length 3.
     *
     * @param userInput An array containing three integers representing
     *                  hours, minutes and seconds.
     */
    private static void printSecondsTotal(int[] userInput)
    {
        final int secondsTotal = convertHoursToSeconds(userInput[0]) +
                                 convertMinutesToSeconds(userInput[1]) +
                                 userInput[2];
        System.out.println("\nTotala antalet sekunder: " + secondsTotal + "\n");
    }

    /**
     * Prints the user input. Expects an array of integers with length 3.
     *
     * @param userInput An array containing three integers representing
     *                  hours, minutes and seconds.
     */
    private static void printUserInput(int[] userInput)
    {
        System.out.printf("\nTimmar: %d\nMinuter: %d\nSekunder: %d",
                          userInput[0], userInput[1], userInput[2]);
    }

    /**
     * Converts the specified number of hours to seconds.
     *
     * @param hours Number of hours to convert to seconds as an integer.
     * @return Specified number of hours expressed as seconds.
     */
    private static int convertHoursToSeconds(int hours)
    {
        return hours * 60 * 60;
    }

    /**
     * Converts the specified number of minutes to seconds.
     *
     * @param minutes Number of minutes to convert to seconds as an integer.
     * @return Specified number of minutes expressed as seconds.
     */
    private static int convertMinutesToSeconds(int minutes)
    {
        return minutes * 60;
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
     * Prompts the user for 'n' number of values, separated by commas.
     *
     * A message prompt is contiously shown until the user input matches the
     * conditions; array of 'numberOfValues' digits, separated by commas.
     * All whitespace is stripped. The array must contain ONLY digits.
     *
     * @param numberOfValues The number of comma separated values to get.
     * @param promptMessage The message to display when prompting the user.
     * @return An array of integers with length 'numberOfValues'.
     */
    private static int[] promptUserForNCommaSepValues(int numberOfValues,
                                                      String promptMessage)
    {
        String[] commaSepValues = null;
        Scanner  scan           = new Scanner(System.in);
        String   userInput      = null;

        do {
            queryUser(promptMessage);
            userInput = scan.nextLine().replaceAll("\\s+", "");
            commaSepValues = userInput.split(",", numberOfValues);
        } while (commaSepValues.length < numberOfValues ||
                 !stringArrayContainsOnlyDigits(commaSepValues));

        scan.close();
        return convertStringArrayToIntArray(commaSepValues);
    }

    /**
     * Converts an array of strings to an array of integers.
     *
     * @param arrayToConvert The array of strings to convert.
     * @return An array of integers.
     */
    private static int[] convertStringArrayToIntArray(String[] arrayToConvert)
    {
        int[] integerArray = new int[arrayToConvert.length];

        for (int i = 0; i < arrayToConvert.length; i++) {
            try {
                integerArray[i] = Integer.parseInt(arrayToConvert[i]);
            } catch (NumberFormatException e) {
                /* TODO: Handle illegal array contents properly .. */
                continue;
            }
        }

        return integerArray;
    }

    /**
     * Tests that an array of strings contains only digits.
     *
     * @param arrayToTest The array whose contents will be tested.
     * @return True if the array contains only digits, else False.
     */
    private static boolean stringArrayContainsOnlyDigits(String[] arrayToTest)
    {
        for (String arrayEntry : arrayToTest) {
            try {
                Integer.parseInt(arrayEntry);
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }
}
