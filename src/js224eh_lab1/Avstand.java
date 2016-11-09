package js224eh_lab1;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-11-09.
 *
 * Lektion 3 - Using Library Classes
 *
 * 15. Avstånd mellan två koordinater
 *     Skriv ett program Avstand.java som läser in två koordinater på formen
 *     (x,y) och sedan beräknar avståndet mellan dem mha formeln
 *
 *         avstand = Sqrt( (x1-x2)^2 + (y1-y2)^2 )
 *
 *     Här står Sqrt() för "kvadratroten ur" och ^ betyder "upphöjt till".
 *     Svaret skall presenteras med 3 siffrors noggranhet.
 *
 *     Ledtråd: Använd klassen java.lang.Math för beräkning.
 */
public class Avstand
{
    public static void main(String[] args)
    {
        double coordX1 = -3.1415;
        double coordY1 = -33;
        double coordX2 = -10;
        double coordY2 = -1.3;

        SimpleVector coordFirst  = new SimpleVector(coordX1, coordY1);
        SimpleVector coordSecond = new SimpleVector(coordX2, coordY2);

        double distance = coordFirst.getDistance(coordSecond);

        System.out.printf("Avståndet mellan koordinaterna %s och %s är %.3f",
                          coordFirst.toString(), coordSecond.toString(),
                          distance);
    }
}

class SimpleVector
{
    // Getters and setters left out for brevity ..
    double x, y;

    /**
     * A simple wrapper for two values representing a vector or 2D coordinate.
     * @param x The X position of this vector/coordinate.
     * @param y The Y position of this vector/coordinate.
     */
    SimpleVector(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the distance between this vector (coordinate) and another
     * vector (coordinate).
     * Uses the formula:   distance = Sqrt( (x1-x2)^2 + (y1-y2)^2 )
     *
     * @param another Distance is calculated between this vector/coordinate
     *                and the calling object.
     * @return The distance between this object and the given SimpleVector.
     */
    double getDistance(SimpleVector another)
    {
        return Math.sqrt(Math.pow(this.x - another.x, 2) +
                         Math.pow(this.y - another.y, 2));
    }

    /**
     * @return A string representation of this object.
     */
    @Override
    public String toString()
    {
        return "(" + this.x + ", " + this.y + ")";
    }
}
