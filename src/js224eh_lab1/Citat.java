package js224eh_lab1;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-04.
 *
 * Lektion 2 - (Input/Output, Operations on Primitive Types)
 *
 * 6. Citat
 *    Skriv ett program Citat.java som läser in en godtycklig textrad och sedan
 *    skriver ut samma rad som ett citat (dvs inneslutet i " ").
 *    En exekvering kan se ut enligt följande:
 *
 *    Skriv in en rad text:  I wish I was a punk rocker with flowers in my hair.
 *    Citat: "I wish I was a punk rocker with flowers in my hair."
 */

import static js224eh_lab1.UserInputUtils.promptForTextLine;

public class Citat
{
    private static final String MSG_PROMPT_FOR_LINE = "Skriv in en rad text: ";
    private static final String MSG_PRE_QUOTE       = "Citat: ";

    public static void main(String[] args)
    {
        final String text = promptForTextLine(MSG_PROMPT_FOR_LINE);
        System.out.println(MSG_PRE_QUOTE + surroundWithQuoteMarks(text));
        System.exit(0);
    }

    /**
     * Surrounds a string with quote marks, I.E. makes it a quotation.
     *
     * @param text The text string to surround with quote marks.
     * @return The specified text with a prepended " and an appended ".
     */
    private static String surroundWithQuoteMarks(String text)
    {
        return "\"" + text + "\"";
    }
}
