package js224eh_lab1;

import java.text.DecimalFormat;

import static js224eh_lab1.UserInputUtils.promptForNumber;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-10.
 *
 * Lektion 3 - Using Library Classes
 *
 * 16. Vindavkylning, effektiv temperatur (VG-uppgift)
 *     Du upplever säkert en lägre temperatur än vad termometern visar då det
 *     blåser. Men vilken temperatur är det du upplever? Ett sätt att beräkna
 *     den upplevda (eller effektiva) temperaturen är med hjälp av Siple's
 *     formula.
 *
 *     Skriv ett program VindAvkylning.java där användaren genom att ange
 *     temperaturen och vindhastigheten kan få reda på den effektiva
 *     temperaturen, avrundad till närmsta heltal.
 *
 *         Ange temperatur: -7.8
 *         Ange vindhastigheten: 8.4
 *         Effektiv temperatur: -24 grader Celsius
 */
public class VindAvkylning
{
    public static void main(String[] args)
    {
        final String MSG_PROMPT_FOR_TEMPERATURE  = "Ange temperatur: ";
        final String MSG_PROMPT_FOR_WIND_SPEED   = "Ange vindhastigheten: ";
        final String MSG_CALCULATION_RESULT      = "Effektiv temperatur: ";
        final String MSG_CALCULATION_RESULT_UNIT = " grader Celsius";

        double temperature = promptForNumber(MSG_PROMPT_FOR_TEMPERATURE);
        double windSpeed   = promptForNumber(MSG_PROMPT_FOR_WIND_SPEED);

        double apparentTemperature = calculateApparentTemperature(temperature,
                                                                  windSpeed);

        DecimalFormat df = new DecimalFormat("0.#");
        System.out.println(MSG_CALCULATION_RESULT +
                           df.format(Math.round(apparentTemperature)) +
                           MSG_CALCULATION_RESULT_UNIT);
    }

    /**
     * Calculates the apparent temperature using Siples formula.
     *
     * For degrees Celsius and m/s with baseline conditions 33C and 1.8m/s:
     *
     *      Twc = 33 + (T - 33)*(0.474 + 0.454 sqrt(S) - 0.0454*S)
     *
     *      With:   S >= 1.79 m/s       T < 33 degrees C
     *
     * Source:  https://www.eol.ucar.edu/homes/rilling/wc_formula.html
     *
     * @param temperature The temperate in degrees Celsius
     * @param windSpeed   The wind speed in meters per second.
     * @return The apparent temperature in degrees Celsius.
     */
    private static double calculateApparentTemperature(double temperature,
                                                      double windSpeed)
    {
        double windChillTemp = 33 + (temperature - 33) *
                                    (0.474 + (0.454 * Math.sqrt(windSpeed)) -
                                     (0.0454 * windSpeed));
        return windChillTemp;
    }
}
