package js224eh_lab2;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-26.
 *
 * Lektion 5 - Arrayer och ArrayList
 * Uppgift 10
 *
 * Gör klart programmet BytaPlats.java nedan så att:
 * 1. Först skrivs innehållet i arrayen text ut.
 * 2. Ändra sedan innehållet i arrayen text, så att det första elementet byter
 *    plats med det sista, det andra byter plats med det näst sista o.s.v.
 * 3. Sedan skrivs innehållet i arrayen text ut igen.
 *
 *     public class BytaPlats {
 *         public static void main(String[] args) {
 *             char[] text = { 't', 't', 'ä', 'l', ' ', 'r', 'a', 'v',
 *                             ' ', 'a', 't', 't', 'e', 'D' };
 *
 *             // Fortsätt här ...
 *         }
 *     }
 *
 * Observera att du inte bara ska skriva ut tecknen baklänges utan verkligen
 * byta plats på dem!
 */
public class BytaPlats
{
    public static void main(String[] args)
    {
        char[] text = {'t', 't', 'ä', 'l', ' ', 'r', 'a', 'v', ' ', 'a',
                       't', 't', 'e', 'D'};

        System.out.println(text);

        for (int charOnePos = 0; charOnePos < (text.length / 2); charOnePos++) {
            int  charTwoPos = text.length - charOnePos - 1;
            char temp       = text[charOnePos];
            text[charOnePos] = text[charTwoPos];
            text[charTwoPos] = temp;
        }

        System.out.println(text);
    }
}
