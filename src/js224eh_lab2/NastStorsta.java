package js224eh_lab2;

import java.util.Scanner;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-26.
 *
 * Lektion 4 - Styrande satser
 * Uppgift 6
 * Skriv ett program NastStorsta.java som läser in tio heltal och hittar det
 * näst största talet av dem och därefter skriver ut det.
 * En körning kan se ut enligt följande:
 *
 *     Mata in 10 heltal: 67 -468 36 1345 -7778 0 34 7654 45 -666
 *     Det näst största talet är: 1345
 *
 * Försök att göra programmet så att det är lätt att ändra antalet inmatade
 * heltal.
 *
 * Rekommendation: Använd mindre än 10 heltal under tiden ni utvecklar
 *                 programmet.
 * Notera: Du får inte använda arrayer (eller andra datastrukturer) för att
 *         temporärt lagra alla de inlästa heltalen innan du börjar leta efter
 *         det näst största heltalet.
 */
public class NastStorsta
{
    public static void main(String[] args)
    {
        final String MSG_QUERY = "Mata in 10 heltal: ";
        final String MSG_RESULT = "Det näst största talet är: ";

        /* Antal tal som skall matas in ändras med 'NUMBERS_TO_GET'. */
        final int NUMBERS_TO_GET = 3;

        int numberCount = 0;
        int biggestYet = Integer.MIN_VALUE;
        int secondBiggestYet;
        Scanner scan = new Scanner(System.in);

        do {
            int input;
            while (scan.hasNextInt()) {
                input = scan.nextInt();
                if (input > biggestYet) {
                    biggestYet = input;
                }
            }

        } while (numberCount < NUMBERS_TO_GET);


    }

}
