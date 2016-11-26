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
        /* Antal tal som skall matas in ändras med 'NUMBERS_TO_GET'. */
        final int NUMBERS_TO_GET = 10;

        /* Användning av klasskonstanter och annars liknande kod jag skrev
         * 2015-08-08 till kursen DV017a vid Högskolan i Gävle.
         * https://github.com/jonasjberg/DV017A_lab4/commits/master/src
         * /Lab4Uppg01.java
         */
        int numberCount      = 0;
        int biggestYet       = Integer.MIN_VALUE;
        int secondBiggestYet = Integer.MIN_VALUE;

        Scanner scan = new Scanner(System.in);
        System.out.print("Mata in 10 heltal: ");

        do {
            if (scan.hasNextInt()) {
                int input = scan.nextInt();

                if (input > biggestYet) {
                    secondBiggestYet = biggestYet;
                    biggestYet = input;
                } else if (input > secondBiggestYet) {
                    secondBiggestYet = input;
                }
            }

            numberCount++;
        } while (numberCount < NUMBERS_TO_GET);

        scan.close();
        System.out.println("Det näst största talet är: " + secondBiggestYet);
    }
}
