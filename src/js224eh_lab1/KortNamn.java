package js224eh_lab1;

import static js224eh_lab1.UserInputUtils.promptForTextLine;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-09.
 *
 * Lektion 3 - Using Library Classes
 *
 * 13. Ditt kortnamn
 *     Skriv ett program KortNamn.java som läser in ett för- och ett efternamn
 *     (två strängar) och sedan skriver ut första bokstaven i förnamnet, följt
 *     av punkt och mellanslag, och sedan de fyra första bokstäverna i
 *     efternamnet.  En exekvering kan se ut som följer:
 *
 *         Förnamn: Anakin
 *         Efternamn: Skywalker
 *         Kort namn: A. Skyw
 *
 *     Ledtråd: Använd metoder från String-klassen.
 *              Hur hanterar ni namnet Bo Ahl?
 */
public class KortNamn
{
    private static final int LASTNAME_MAX_LENGTH = 4;

    public static void main(String[] args)
    {
        final String MSG_QUERY_FIRST_NAME = "Förnamn: ";
        final String MSG_QUERY_LAST_NAME = "Efternamn: ";
        final String MSG_NAME_SHORTENED = "Kort namn: ";

        String firstName = promptForTextLine(MSG_QUERY_FIRST_NAME);
        String lastName = promptForTextLine(MSG_QUERY_LAST_NAME);

        String shortenedName = generateShortFormName(lastName, firstName);
        System.out.println(MSG_NAME_SHORTENED + shortenedName);

        System.exit(0);
    }

    private static String generateShortFormName(String lastName,
                                                String firstName)
    {
        assert firstName != null;
        assert lastName != null;

        String shortFirstName = firstName.substring(0, 1);

        int subStringEndIndex = Math.min(lastName.length(), LASTNAME_MAX_LENGTH);
        String shortLastName = lastName.substring(0, subStringEndIndex);

        return shortFirstName + ". " + shortLastName;
    }
}
