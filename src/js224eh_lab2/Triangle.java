package js224eh_lab2;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-26.
 *
 * Lektion 4 - Styrande satser
 * Uppgift 5
 * Skriv ett program Triangle.java som för ett godtyckligt positivt udda heltal
 * N (läses in från tangentbordet) skriver ut två olika trianglar.
 * Först en rätvinklig sedan en likbent. Exempel på körning:
 *
 *     Mata in ett udda heltal: 7
 *     Rätvinklig triangel:
 *           *
 *          **
 *         ***
 *        ****
 *       *****
 *      ******
 *     *******
 *
 *     Likbent triangel:
 *        *
 *       ***
 *      *****
 *     *******
 *
 * Notera, heltalet N bestämmer hur lång basen på varje triangel är. Programmet
 * skall avslutas med ett felmeddelande om det inmatade talet inte är ett
 * positivt udda heltal.
 */
public class Triangle
{
    public static void main(String[] args)
    {
        final String MSG_QUERY = "Mata in ett udda heltal: ";

        //int triangleHeight = UserInputUtils.promptForPositiveWholeNumber(MSG_QUERY);
        int triangleHeight = 7;
        while (isEven(triangleHeight)) {
            triangleHeight = UserInputUtils.promptForPositiveWholeNumber(MSG_QUERY);
        }

        System.out.println("Rätvinklig triangel:");
        for (int i = 0; i < triangleHeight; i++) {
            System.out.printf("%-" + triangleHeight + "s\n", "*");

            int n = 4;
            System.out.println(String.format("%"+n+"s", " "));
        }


    }

    /**
     * Tests if a number is even.
     * @param number The number to test.
     * @return True if the number is even, otherwise False.
     */
    private static boolean isEven(int number)
    {
        return number % 2 == 0;
    }
}
