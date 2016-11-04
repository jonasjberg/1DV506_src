package js224eh_lab1;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-04.
 *
 * Lektion 2 - (Input/Output, Operations on Primitive Types)
 *
 * 8. BMI
 *    Skriv ett program BMI.java som räknar ut BMI (Body Mass Index) för en
 *    person. Programmet skall läsa in data (längd och vikt) från tangentbordet
 *    och sedan presentera svaret. BMI räknas ut som vikt/(längd)^2 där längden
 *    ges i meter och vikten ges i kilogram. En exekvering kan se ut som följer:
 *
 *        Ange din längd i meter: 1,83
 *        Ange din vikt i kilogram: 83
 *        Ditt BMI är: 25
 *
 *    Notera: BMI är alltid ett heltal.
 */

import java.util.Scanner;

public class BMI
{
    public static void main(String[] args)
    {
        final String MSG_PROMPT_FOR_HEIGHT = "Ange din längd i meter: ";
        final String MSG_PROMPT_FOR_WEIGHT = "Ange din vikt i kilogram: ";
        final String MSG_BMI_RESULT        = "Ditt BMI är: ";

        final double height = promptUserForNumber(MSG_PROMPT_FOR_HEIGHT);
        final double weight = promptUserForNumber(MSG_PROMPT_FOR_WEIGHT);
        final double bmi    = calculateBmi(weight, height);

        System.out.println(MSG_BMI_RESULT + bmi);
    }

    /**
     * Calculates the BMI from a weight and a height.
     *
     * @param weight Weight in kilograms.
     * @param height Height in meters.
     * @return BMI calculated from the weight and height.
     */
    private static double calculateBmi(double weight, double height)
    {
        return weight / Math.pow(height, 2);
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
     * @param strPromptForLine The message to display when prompting for input.
     * @return The number entered by the user.
     */
    private static double promptUserForNumber(String strPromptForLine)
    {
        Scanner scan      = new Scanner(System.in);
        String  userInput = null;
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
}
