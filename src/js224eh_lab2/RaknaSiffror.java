package js224eh_lab2;

import java.util.Scanner;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-26.
 *
 * Lektion 4 - Styrande satser
 * Uppgift 7 (VG-uppgift)
 * Skriv ett program RaknaSiffror.java som för ett godtyckligt positivt heltal N
 * (läses in från tangentbordet) skriver ut antalet nollor, antalet udda siffror
 * och antalet jämna siffror. En körning kan se ut enligt följande:
 *
 *     Mata in ett heltal: 6789500
 *     Nollor: 2
 *     Udda: 3
 *     Jämna: 2
 *
 * Notera: Noll är (i denna uppgift) varken udda eller jämnt.
 */
public class RaknaSiffror
{
    public static void main(String[] args)
    {
        boolean inputValidated = false;
        Scanner scan           = new Scanner(System.in);
        int     number         = 0;

        do {
            System.out.print("Mata in ett heltal: ");

            while (!scan.hasNextInt()) {
                scan.next();
            }
            if (scan.hasNextInt()) {
                number = scan.nextInt();
                inputValidated = true;
            }

        } while (!inputValidated);

        scan.close();

        int countZeros = 0;
        int countOdd   = 0;
        int countEven  = 0;

        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length(); i++) {
            char c = numberString.charAt(i);
            if (Character.isDigit(c)) {
                if (c == '0') {
                    countZeros++;
                } else {
                    if (Character.getNumericValue(c) % 2 == 0) {
                        countEven++;
                    } else {
                        countOdd++;
                    }
                }
            }
        }

        System.out.println("Nollor: " + countZeros);
        System.out.println("Udda: " + countOdd);
        System.out.println("Jämna: " + countEven);
        System.exit(0);
    }
}
