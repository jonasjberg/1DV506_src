package js224eh_lab1;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-11-09.
 *
 * Lektion 3 - Using Library Classes
 *
 * 15. Avstånd mellan två koordinater
 * Skriv ett program Avstand.java som läser in två koordinater på formen
 * (x,y) och sedan beräknar avståndet mellan dem mha formeln
 *
 * avstand = Sqrt( (x1-x2)^2 + (y1-y2)^2 )
 *
 * Här står Sqrt() för "kvadratroten ur" och ^ betyder "upphöjt till".
 * Svaret skall presenteras med 3 siffrors noggranhet.
 *
 * Ledtråd: Använd klassen java.lang.Math för beräkning.
 */
public class Avstand
{
    public static void main(String[] args)
    {
        double coordX1 = 3.1415;
        double coordY1 = 33;
        double coordX2 = -10;
        double coordY2 = -1.3;

        SimpleVector coordFirst  = new SimpleVector(coordX1, coordY1);
        SimpleVector coordSecond = new SimpleVector(coordX2, coordY2);

        double distance = getCoordinateDistance(coordFirst, coordSecond);

        System.out.printf("Avstånd mellan koordinater %s och %s: %.2f",
                          coordFirst.toString(), coordSecond.toString(),
                          distance);
    }

    private static double getCoordinateDistance(SimpleVector coordFirst,
                                                SimpleVector coordSecond)
    {
        double x1 = coordFirst.x;
        double y1 = coordFirst.y;
        double x2 = coordSecond.x;
        double y2 = coordSecond.y;
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
}

class SimpleVector
{
    double x, y;

    public SimpleVector(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return "(" + this.x + ", " + this.y + ")";
    }
}
