package js224eh_lab1;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-11-09.
 *
 * Lektion 3 - Using Library Classes
 *
 * 15. Avstånd mellan två koordinater
       Skriv ett program Avstand.java som läser in två koordinater på formen
       (x,y) och sedan beräknar avståndet mellan dem mha formeln

           avstand = Sqrt( (x1-x2)^2 + (y1-y2)^2 )

       Här står Sqrt() för "kvadratroten ur" och ^ betyder "upphöjt till".
       Svaret skall presenteras med 3 siffrors noggranhet.

       Ledtråd: Använd klassen java.lang.Math för beräkning.
 */
public class Avstand
{
    public static void main(String[] args)
    {
        double coordX = 3.1415;
        double coordY = 33;

        String inputCoordinates = "(" + coordX + "," + coordY + ")";

        System.out.println(inputCoordinates);

    }
}
