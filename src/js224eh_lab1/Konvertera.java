package js224eh_lab1;

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

    }

    private static double convertFahrenheitToCelsius(double fahrenheit)
    {
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        return celsius;
    }
}
