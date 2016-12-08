package js224eh_lab3;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 5
 */
public class TextAnalyzerMain
{
    public static void main(String[] args)
    {
        String       text = "My name is Anakin Skywalker. My age is 42.";
        TextAnalyzer ta   = new TextAnalyzer(text);

        System.out.println("Char Count: " + ta.charCount());
        System.out.println("Upper Case Count: " + ta.upperCaseCount());
        System.out.println("Whitespace Count: " + ta.whitespaceCount());
        System.out.println("Digit Count: " + ta.digitCount());

        if (ta.containsChar('x'))
            System.out.println("The text contains char \'x\'");

        if (ta.containsString("nakin"))
            System.out.println("The text contains substring \"nakin\"");


        System.out.println("-------------------------------------------------");

        TextAnalyzer ta2   = new TextAnalyzer(" ");

        System.out.println("Char Count: " + ta2.charCount());
        System.out.println("Upper Case Count: " + ta2.upperCaseCount());
        System.out.println("Whitespace Count: " + ta2.whitespaceCount());
        System.out.println("Digit Count: " + ta2.digitCount());

        if (ta2.containsChar(' '))
            System.out.println("The text contains char \' \'");

        if (ta2.containsString(""))
            System.out.println("The text contains substring \"\"");
    }
}
