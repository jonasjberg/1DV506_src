package js224eh_lab1;

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
        final String MSG_PROMPT_FOR_TEMPERATURE = "Ange temperatur: ";
        final String MSG_PROMPT_FOR_WIND_SPEED = "Ange vindhastigheten: ";

        double temperature = promptForNumber(MSG_PROMPT_FOR_TEMPERATURE);
        double windSpeed = promptForNumber(MSG_PROMPT_FOR_WIND_SPEED);

        double apparentTemperature = calculateApparentTemperature(temperature,
                                                                  windSpeed);
    }

    private static double calculateApparentTemperature(double temperature,
                                                       double windSpeed)
    {
        // Tapparent(°C) = 33 + (Tair- 33)*(0.474 + 0.454√(v)-0.0454.v)

        double result = 33 + (temperature - 33) *
                             (0.474 + (0.454 * Math.sqrt(windSpeed)));
    }
}
