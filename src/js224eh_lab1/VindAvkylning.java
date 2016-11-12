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

        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println(
                MSG_CALCULATION_RESULT + df.format(apparentTemperature) +
                MSG_CALCULATION_RESULT_UNIT);
    }

    private static double calculateApparentTemperature(double temperature,
                                                       double windSpeed)
    {
        // Using formula:
        // Tchill = 13.12 + 0.6215 ∗ Ta − 11.37 ∗ V^{0.16} + 0.3965 ∗ Ta ∗
        // V^{0.16}
        //
        // With:    Tchill   wind chill in celsius
        //          Ta       actual temperature
        //          V        wind velocity in km/h
        //
        // Source: http://www.freemathhelp.com/wind-chill.html

        double Ta = temperature;
        double V  = windSpeed;
        double Tchill = 13.12 + 0.6215 * Ta - 11.37 * Math.pow(V, 0.16) +
                        0.3965 * Ta * Math.pow(V, 0.16);
        return Tchill;
    }
}
