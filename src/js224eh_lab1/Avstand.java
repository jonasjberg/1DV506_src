package js224eh_lab1;

import static js224eh_lab1.UserInputUtils.promptForTextLine;

/*
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

    public static final String MSG_QUERY_COORDINATE = "Ange en koordinat på " +
                                                      "formen (x,y): ";

    public static void main(String[] args)
    {
        String input1 = promptForTextLine(MSG_QUERY_COORDINATE);
        //String       input2      = promptForTextLine(MSG_QUERY_COORDINATE);

        System.out.println("raw input: " + input1);
        String cleanInput1 = cleanupString(input1);
        System.out.println("cleaned input: " + cleanInput1);

        SimpleVector firstCoordinate = createCoordinateFromString(cleanupString(input1));

        double       coordX2          = 1;
        double       coordY2          = 1;
        SimpleVector secondCoordinate = new SimpleVector(coordX2, coordY2);

        double distance = firstCoordinate.getDistance(secondCoordinate);

        System.out.printf("Avståndet mellan koordinaterna %s och %s är %.3f",
                          firstCoordinate.toString(),
                          secondCoordinate.toString(), distance);
    }

    private static String cleanupString(String string)
    {
        // Remove everything except digits, commas and periods.
        string = string.replaceAll("[^0-9,.]", "");

        // Hacky workaround for locale-dependant decimal separator ..
        string = string.replaceAll(",", ".");

        // Remove any leading and trailing periods.
        string = string.replaceAll("^\\.+", "").replaceAll("\\.+$", "");
        return string;
    }

    private static SimpleVector createCoordinateFromString(String string)
    {
        double x = string.

        return new SimpleVector(1, 2);
    }

}


class SimpleVector
{
    // Getters and setters left out for brevity ..
    double x, y;

    /**
     * A simple wrapper for two values representing a vector or 2D coordinate.
     *
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
