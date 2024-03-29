package js224eh_lab2;

import java.util.Scanner;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-24.
 *
 * Lektion 4 - Styrande satser
 * Uppgift 1
 *
 * Skriv ett program RaknaA.java som läser in en textrad från tangentbordet och
 * sedan skriver hur ut många 'a' och 'A' det finns i raden.
 * En körning kan se ut enligt följande:
 *
 *     Mata in en textrad: Alla barn fick högsta betyget A.
 *     Antal a: 3
 *     Antal A: 2
 */
public class RaknaA
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String  text = null;

        do {
            System.out.print("Mata in en textrad: ");
            text = scan.nextLine().trim();
        } while (text.isEmpty());

        scan.close();


        int countLowerA = 0;
        int countUpperA = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'a') {
                countLowerA++;
            } else if (text.charAt(i) == 'A') {
                countUpperA++;
            }
        }

        System.out.println("Antal a: " + countLowerA);
        System.out.println("Antal A: " + countUpperA);
        System.exit(0);
    }
}
