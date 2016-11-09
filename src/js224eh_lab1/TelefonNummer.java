package js224eh_lab1;

import java.util.Random;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-11-09.
 *
 * Lektion 3 - Using Library Classes
 *
 * 14. Telefonnummer
 *     Skriv ett program TelefonNummer.java som genererar, och skriver ut, ett
 *     slumpmässigt telefonnummer på formen 0XXX-ZYYYYY. Riktnumret är alltså en
 *     nolla följt av 3 godtyckliga siffror (X). Lokalnumret får inte starta med
 *     en nolla (Z), övriga fem siffror (Y) är godtyckliga.
 *
 *     Ledtråd: Använd klassen java.util.Random.
 */
public class TelefonNummer
{
    public static void main(String[] args)
    {
        String riktNummer = "0" + getNRandomDigitsInRange(3, 0, 9);
        String lokalNummer = getNRandomDigitsInRange(1, 1, 9) +
                             getNRandomDigitsInRange(5, 0, 9);

        System.out.println(riktNummer + "-" + lokalNummer);
    }

    /**
     * Generates a specified number of random sequential digits within a
     * specified range.
     *
     * @param numberOfDigits The number of random digits to return. I.E.
     *                       length of the returned string.
     * @param min            The minimum possible value of any single digit.
     * @param max            The maximum possible value of any single digit.
     * @return A string of 'N' sequential digits with within [min, max].
     */
    private static String getNRandomDigitsInRange(int numberOfDigits,
                                                  int min, int max)
    {
        assert numberOfDigits > 0;
        Random        random        = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numberOfDigits; i++) {
            stringBuilder.append(random.nextInt((max - min) + 1) + min);
        }

        return stringBuilder.toString();
    }
}
