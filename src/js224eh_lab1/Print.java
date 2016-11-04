package js224eh_lab1;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-11-04.
 */
public class Print {
    public static final String STR_KNOWLEDGE_POWER = "Kunskap är makt!";

    public static void main(String[] args) {
        printStringOnOneLine(STR_KNOWLEDGE_POWER);
        printSplitStringOnThreeLines(STR_KNOWLEDGE_POWER);
        printSplitStringOnThreeLines("Kunskap är makt!");
        printSplitStringOnThreeLines("Kunskap är makt! Test");
        printSplitStringOnThreeLines("Kunskap är makt! Test mjao");
    }

    private static void printStringOnOneLine(String stringToPrint) {
        System.out.println(stringToPrint);
    }

    /**
     * Prints a string on three lines with one word per line.
     *
     * The string is split on whitespace with a maximum of three splits. If the
     * string can be split into more than three parts, the third parts will
     * contain more than one whitespace-separated word.
     *
     * @param stringToPrint The string to split and print.
     */
    private static void printSplitStringOnThreeLines(String stringToPrint) {
        /* Reference for String method 'split':
         * http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#split(java.lang.String,%20int)
         *
         * Reference for regular expression pattern:
         * https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
         *
         * Regex pattern used:    \s    A whitespace character: [ \t\n\x0B\f\r]
         *                        X+    X, one or more times
         */

        String[] subStrings = stringToPrint.split("\\s+", 3);
        for (int i = 0; i < subStrings.length; i++) {
            if (subStrings[i] == null) {
                continue;
            }
            System.out.println(subStrings[i]);
        }
    }
}
