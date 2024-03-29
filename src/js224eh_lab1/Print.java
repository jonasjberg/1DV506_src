package js224eh_lab1;
/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-04.
 *
 * Lektion 2 - (Input/Output, Operations on Primitive Types)
 *
 * 5. Utskrifter
 *    Skriv ett program Print.java som skriver ut frasen _Kunskap är makt!_
 *    - på en rad
 *    - på tre rader. Ett ord på varje rad
 *    - inuti en rektangel gjord av tecknen = och |.
 */

public class Print {
    private static final String STR_KNOWLEDGE_POWER = "Kunskap är makt!";

    public static void main(String[] args) {
        printStringOnOneLine(STR_KNOWLEDGE_POWER);
        printSplitStringOnThreeLines(STR_KNOWLEDGE_POWER);
        printStringSurroundedByRectangle(STR_KNOWLEDGE_POWER);
    }

    /**
     * Prints a string on one line.
     *
     * @param stringToPrint The string to print. Must be non-empty.
     */
    private static void printStringOnOneLine(String stringToPrint) {
        if (stringToPrint == null || stringToPrint.isEmpty()) {
            return;
        }

        System.out.println(stringToPrint);
    }

    /**
     * Prints a string on three lines with one word per line.
     *
     * The string is split on whitespace with a maximum of three splits.
     * If the string can be split into more than three parts, the third
     * part will contain more than one whitespace-separated word.
     *
     * @param stringToPrint The string to split and print.
     */
    private static void printSplitStringOnThreeLines(String stringToPrint) {
        /* Reference for String method 'split':
         * http://docs.oracle.com/javase/7/docs/api/java/lang/String
         * .html#split(java.lang.String,%20int)
         *
         * Reference for regular expression pattern:
         * https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern
         * .html
         *
         * Regex pattern used:    \s    A whitespace character: [ \t\n\x0B\f\r]
         *                        X+    X, one or more times
         */

        if (stringToPrint == null || stringToPrint.isEmpty()) {
            return;
        }

        String[] subStrings = stringToPrint.split("\\s+", 3);
        for (String subString : subStrings) {
            System.out.println(subString);
        }
    }

    /**
     * Prints a string surrounded by a rectangle made up by '=' and * '|'.
     *
     * @param stringToPrint The string to print.
     */
    private static void printStringSurroundedByRectangle(String stringToPrint) {
        if (stringToPrint == null || stringToPrint.isEmpty() ||
            stringToPrint.length() < 1) {
            return;
        }

        final String CHAR_HORIZ = "=";
        final String CHAR_VERTI = "|";
        final String CHAR_PAD   = " ";

        int rectangleWidth = stringToPrint.length() + CHAR_HORIZ.length() +
                             CHAR_VERTI.length() + (CHAR_PAD.length() * 2);

        printStringNtimes(CHAR_HORIZ, rectangleWidth);
        System.out.println("\n" + CHAR_VERTI + CHAR_PAD + stringToPrint +
                           CHAR_PAD + CHAR_VERTI);
        printStringNtimes(CHAR_HORIZ, rectangleWidth);
        System.out.println();
    }

    /**
     * Prints a string n times, without adding whitespace or line breaks.
     *
     * @param stringToPrint The string to print.
     * @param n             Number of times the string is printed. Must be a
     *                      positive integer.
     */
    private static void printStringNtimes(String stringToPrint, int n) {
        if (n < 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(stringToPrint);
        }
    }
}
