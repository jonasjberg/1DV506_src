package js224eh_lab2;

import java.util.Scanner;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-24.
 *
 * Lektion 4 - Styrande satser
 * Uppgift 3
 *
 * Skriv ett program StorstaK.java som för ett godtyckligt positivt heltal N
 * (läses in från tangentbordet) beräknar det största värdet K sådant att
 * 0+2+4+6+8+...+K < N. En körning kan se ut enligt följande:
 *
 *     Mata in ett positivt heltal: 25
 *     Största tal K sådant att 0+2+4+6+...+K < 25 => K=8
 */
public class StorstaK {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int     n;

        do {
            System.out.print("Mata in ett positivt heltal: ");

            while (!scan.hasNextInt()) {
                System.out.print("Mata in ett positivt heltal: ");
                scan.next();
            }
            n = scan.nextInt();

        } while (n <= 0);

        int k = 0;
        int sum = 0;
        while (sum + k < n) {
            k += 2;
            sum += k;
        }

        System.out.println("Största tal K sådant att 0+2+4+6+...+K < 25 => K=" + k);
        System.exit(0);
    }
}
