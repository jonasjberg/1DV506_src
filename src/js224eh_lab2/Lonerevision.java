package js224eh_lab2;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-26.
 *
 * Lektion 5 - Arrayer och ArrayList
 * Uppgift 13 (VG-uppgift)
 *
 * Då en del fackförbund informerar om utfallet av löneförhandlingar redovisar
 * de medianlönen (d.v.s. den mittersta lönen), genomsnittslönen och
 * lönespridningen (d.v.s. skillnaden mellan den högsta och lägsta lönen).
 * Skriv ett program Lonerevision.java som kan läsa in ett godtyckligt antal
 * löner och sedan beräkna medianlön, medellön och lönespridning.
 *
 * Medianlönen är den mittersta av de angivna lönerna och för att kunna bestämma
 * den måste lönerna sorteras. Enklaste sättet att sortera en ArrayList är att
 * använda sig av den statiska metoden sort som finns i klassen Collections (i
 * Javabiblioteket java.util). Är det ett jämt antal löner så bestäms
 * medianlönen genom att medelvärdet av de två mittersta lönerna beräknas.
 * Två körningar kan se ut enligt följande:
 *
 *     Mata in löner (och avsluta med 'X'): 21700 28200 26300 25100 22600
 *     22800 19900 X
 *     Medianlön: 22800
 *     Medellön: 23800
 *     Lönespridning: 8300
 *
 *     Mata in löner (och avsluta med 'X'): 22100 29800 27300 25400 23100
 *     22300 X
 *     Medianlön: 24250
 *     Medellön: 25000
 *     Lönespridning: 7700
 */
public class Lonerevision
{
    public static void main(String[] args)
    {
        System.out.print("Mata in löner (och avsluta med 'X'): ");

        /* Hämta text från användaren. */
        Scanner            scan                 = new Scanner(System.in);
        ArrayList<Integer> salaries             = new ArrayList<Integer>();
        boolean            shouldGetMoreNumbers = true;

        do {
            if (scan.hasNextInt()) {
                int number = scan.nextInt();
                if (number >= 0) {
                    salaries.add(number);
                }
            } else {
                String input = scan.next();
                if (input.toLowerCase().matches("x")) {
                    shouldGetMoreNumbers = false;
                }
            }
        } while (shouldGetMoreNumbers);

        scan.close();
        System.out.println(salaries);
    }
}
