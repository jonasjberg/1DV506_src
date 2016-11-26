package js224eh_lab2;

import java.util.Scanner;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-26.
 *
 * Lektion 4 - Styrande satser
 * Uppgift 9 (VG-uppgift)
 *
 * Skriv ett program Palindrom.java som testar om en textrad (läses in från
 * tangentbordet) är ett palindrom. Dvs, att textraden har samma sekvens av
 * bokstäver vare sig man läser den framifrån eller bakifrån. Ni skall bortse
 * från stora och små bokstäver, siffror och andra tecken som inte är bokstäver.
 * Exempel på palindrom
 *
 *     "Anna"  "x"  "Ff"   "A1 n2%3na"  "Ni talar bra latin."
 *
 * Ledtråd: De två statiska metoderna Character.isLetter(char c) och
 *          Character.toLowerCase(char c) kan här komma till nytta!
 */
public class Palindrom
{
    public static void main(String[] args)
    {
        /* Hämta text från användaren. */
        Scanner scan = new Scanner(System.in);
        String  text;

        do {
            System.out.println("Mata in en textrad att palindromtesta: ");
            text = scan.nextLine().trim();
        } while (text.isEmpty());

        scan.close();

        /* Rensa upp den inmatade texten. */
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                builder.append(Character.toLowerCase(c));
            }
        }
        String textNormalized = builder.toString();


        /* Testa om palindrom -- "pekare" mot positioner för bokstäver som skall
         * jämföras; 'i' och 'j', börjar på varsin ände av texten och rör sig
         * mot mitten. Pekar de på olika bokstäver är ordet inte ett palindrom.
         */
        boolean isPalindrome = false;
        if (textNormalized.length() > 0) {
            isPalindrome = true;

            int j = textNormalized.length() - 1;
            for (int i = 0; i < textNormalized.length(); i++) {
                if (textNormalized.charAt(i) != textNormalized.charAt(j)) {
                    isPalindrome = false;
                }
                j--;
            }
        }

        if (isPalindrome) {
            System.out.println("Den inmatade texten \"" + text + "\" (" +
                               textNormalized + ") är ett palindrom.");
        } else {
            System.out.println("Den inmatade texten är inte ett palindrom.");
        }
        System.exit(0);
    }
}
