package js224eh_lab3;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 5
 */
public class TextAnalyzer
{
    private String text;
    private int charCount = 0;
    private int upperCaseCount = 0;
    private int whitespaceCount = 0;
    private int digitCount = 0;

    public TextAnalyzer(String text)
    {
        this.text = text;
        runAnalysis();
    }

    /* Run the analysis just once at object instantiation. */
    private void runAnalysis()
    {
        for (int i = 0; i < this.text.length(); i++) {
            char c = this.text.charAt(i);

            charCount++;
            if (Character.isUpperCase(c)) {
                upperCaseCount++;
            }
            else if (Character.isWhitespace(c)) {
                whitespaceCount++;
            }
            else if (Character.isDigit(c)) {
                digitCount++;
            }
        }
    }

    public int charCount()
    {
        return charCount;
    }

    public int upperCaseCount()
    {
        return upperCaseCount;
    }

    public int whitespaceCount()
    {
        return whitespaceCount;
    }

    public int digitCount()
    {
        return digitCount;
    }

    public boolean containsChar(char c)
    {
        /* ".. if no such character occurs in this string, then -1 is returned."
         *  http://docs.oracle.com/javase/8/docs/api/java/lang/String.html#indexOf-int-
         */
        return text.indexOf(c) != -1;
    }

    public boolean containsString(String s)
    {
        if (s.isEmpty()) {
            return false;
        }
        return text.contains(s);
    }
}
