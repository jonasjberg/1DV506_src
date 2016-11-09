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

import static js224eh_lab1.UserInputUtils.promptUserForPositiveNumber;

public class BMI
{
    public static void main(String[] args)
    {
        final String MSG_PROMPT_FOR_HEIGHT = "Ange din längd i meter: ";
        final String MSG_PROMPT_FOR_WEIGHT = "Ange din vikt i kilogram: ";
        final String MSG_BMI_RESULT        = "Ditt BMI är: ";

        final double height = promptUserForPositiveNumber(MSG_PROMPT_FOR_HEIGHT);
        final double weight = promptUserForPositiveNumber(MSG_PROMPT_FOR_WEIGHT);
        final double bmi    = calculateBmi(weight, height);

        System.out.println(MSG_BMI_RESULT + Math.round(bmi));
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
}
