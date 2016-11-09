package js224eh_lab1;

import static js224eh_lab1.UserInputUtils.promptUserForPositiveNumber;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-09.
 *
 * Lektion 3 - Using Library Classes
 *
 * 12. Konvertera Fahrenheit till Celsius
 *     Ibland händer det att temperaturer anges i Fahrenheit. Men hur många
 *     grader Celsius är en temperatur som anges i Fahrenheit, t.ex. 83,7 F?
 *     Du kan konvertera F till C enligt:
 *
 *         C = (F - 32) * 5 / 9
 *
 *     Skriv ett program Konvertera.java som omvandlar en inmatad temperatur i
 *     Fahrenheit till Celsius. Programmet ska be användaren ange en temperatur
 *     i F, som sedan omvandlas till C och skrivs ut med en decimals
 *     noggrannhet.
 */
public class Konvertera
{
    public static void main(String[] args)
    {
        final String MSG_ENTER_TEMP = "Mata in en temperatur i grader (F): ";

        double tempFahr = promptUserForPositiveNumber(MSG_ENTER_TEMP);
        double tempCels = convertFahrenheitToCelsius(tempFahr);

        printTemperatureConversionResult(tempFahr, tempCels);
    }

    /**
     * Prints temperatures in Fahrenheit and Celsius.
     *
     * @param tempFahr The temperature in Fahrenheit.
     * @param tempCels The temperature in Celsius.
     */
    private static void printTemperatureConversionResult(double tempFahr,
                                                         double tempCels)
    {
        System.out.printf("\n  Fahrenheit: %.1f" +
                          "\n     Celsius: %.1f\n",
                          tempFahr, tempCels);
    }

    /**
     * Converts a temperature in degrees Fahrenheit to degrees Celsius.
     *
     * @param fahrenheit The temperature to convert in degrees Fahrenheit.
     * @return The given temperature in degrees Celsius.
     */
    private static double convertFahrenheitToCelsius(double fahrenheit)
    {
        return ((fahrenheit - 32) * 5.0) / 9.0;
    }
}
