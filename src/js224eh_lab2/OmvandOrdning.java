package js224eh_lab2;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-26.
 *
 * Lektion 5 - Arrayer och ArrayList
 * Uppgift 11
 *
 * Skriv ett program OmvandOrding.java som läser ett godtyckligt antal positiva
 * heltal från tangentbordet och sedan skriver ut dem baklänges. Inmatningen
 * sker fram tills det att användaren matar in ett negativt tal.
 * En körning kan se ut enligt följande:
 *
 *     Mata in positiva heltal. Avsluta med ett negativt.
 *     tal 1: 5
 *     tal 2: 10
 *     tal 3: 15
 *     tal 4: 20
 *     tal 5: -7
 *
 *     Antal positiva: 4
 *     Baklänges: 20, 15, 10, 5
 *
 * Notera: Man skall inte behöva ange hur många tal man ämnar mata in.
 */
public class OmvandOrdning
{
    public static void main(String[] args)
    {
        System.out.println("Mata in positiva heltal. Avsluta med ett negativt.");

        /* Hämta text från användaren. */
        Scanner            scan                = new Scanner(System.in);
        ArrayList<Integer> numbers             = new ArrayList<Integer>();
        boolean            shouldGetMoreNumbers = true;

        do {
            System.out.printf("tal %d: ", numbers.size() + 1);

            while (!scan.hasNextInt()) {
                scan.next();
            }

            int number = scan.nextInt();
            if (number >= 0) {
                numbers.add(number);
            } else {
                shouldGetMoreNumbers = false;
            }

        } while (shouldGetMoreNumbers);

        scan.close();

        /* Lägg elementen i omvänd ordning och skriv ut resultat. */
        int firstPos = numbers.size() - 1;
        for(int secondPos = 0; secondPos < firstPos; secondPos++) {
            numbers.add(secondPos, numbers.remove(firstPos));
        }

        System.out.printf("Antal positiva: %d%n", numbers.size());
        if (!numbers.isEmpty()) {
            System.out.printf("Baklänges: %s%n", numbers.toString());
        }

        System.exit(0);
    }
}
