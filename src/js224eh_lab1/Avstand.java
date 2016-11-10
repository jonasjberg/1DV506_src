package js224eh_lab1;

import java.util.Scanner;

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
        double[] coords1 = promptUserForCoordinates();
        double[] coords2 = promptUserForCoordinates();

        SimpleVector firstCoordinate = createSimpleVector(coords1);
        SimpleVector secondCoordinate = createSimpleVector(coords2);

        double distance = firstCoordinate.getDistanceTo(secondCoordinate);

        System.out.printf("Avståndet mellan koordinaterna %s och %s är %.3f",
                          firstCoordinate.toString(),
                          secondCoordinate.toString(), distance);
    }

    /**
     * Prompts the user for 'n' number of values, separated by commas.
     *
     * A message prompt is repeatedly displayed until the user input matches the
     * conditions: User entered 'NUMBER_OF_VALUES' valid doubles, separated
     * by commas. Everything but commas, periods, dashes and digits is removed
     * prior to parsing the numbers.
     *
     * @return An array of integers with length 'NUMBER_OF_VALUES'.
     */
    private static double[] promptUserForCoordinates()
    {
        final int NUMBER_OF_VALUES = 2;
        Scanner   scan             = new Scanner(System.in);
        String[]  commaSepValues   = null;
        String    userInput        = null;
        boolean   inputValidated   = false;

        do {
            UserInputUtils.queryUser(MSG_QUERY_COORDINATE);
            userInput = scan.nextLine();
            userInput = cleanupString(userInput);
            commaSepValues = userInput.split(",", NUMBER_OF_VALUES);

            if (commaSepValues.length == NUMBER_OF_VALUES &&
                stringArrayContainsOnlyValidDoubles(commaSepValues)) {
                inputValidated = true;
            }
        } while (!inputValidated);

        return convertStringArrayToDoubleArray(commaSepValues);
    }

    /**
     * Converts an array of strings to an array of doubles.
     *
     * @param arrayToConvert The array of strings to convert.
     * @return The resulting array of doubles.
     */
    private static double[] convertStringArrayToDoubleArray(String[] arrayToConvert)
    {
        double[] doubleArray = new double[arrayToConvert.length];

        for (int i = 0; i < arrayToConvert.length; i++) {
            try {
                doubleArray[i] = Double.parseDouble(arrayToConvert[i]);
            } catch (NumberFormatException e) {
                /* TODO: Handle illegal array contents properly .. */
            }
        }

        return doubleArray;
    }

    /**
     * Tests that an array of strings contains only valid doubles. That is,
     * strings that could be converted to doubles without throwing an exception.
     *
     * @param arrayToTest The array whose contents will be tested.
     * @return True if the array contains only valid doubles, else False.
     */
    private static boolean stringArrayContainsOnlyValidDoubles(
            String[] arrayToTest)
    {
        for (String arrayEntry : arrayToTest) {
            try {
                double number = Double.parseDouble(arrayEntry);
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    private static String cleanupString(String string)
    {
        // Remove whitespace. Then remove everything that is not
        // digits, dashes, commas or periods.
        string = string.replaceAll("\\s+", "").replaceAll("[^0-9,.-]", "");

        // // Hacky workaround for locale-dependant decimal separator ..
        // string = string.replaceAll(",", ".");

        // // Remove any leading and trailing periods.
        // string = string.replaceAll("^\\.+", "").replaceAll("\\.+$", "");
        return string;
    }

    private static SimpleVector createSimpleVector(double[] values)
    {
        return new SimpleVector(values[0], values[1]);
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
    double getDistanceTo(SimpleVector another)
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
