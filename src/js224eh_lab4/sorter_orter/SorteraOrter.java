package js224eh_lab4.sorter_orter;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Created by Jonas Sjöberg (js224eh) on 2017-01-07.
 *
 * 1DV506 -- Problemlösning och Programmering, HT2016
 * Laboration 4: Exceptions, IO och interface
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * Uppgift 4
 * =========
 * Skriv ett program SorteraOrter som läser ett godtyckligt antal ortsnamn med
 * dess postkod från en textfil. Ni kan anta att varje ort (sträng) och postkod
 * (heltal) finns på en separat rad i textfilen och att de är separerade av ett
 * semikolon(;). Skapa en klass Ort som representerar en inläst ort. Klassen Ort
 * skall implementera interfacet Comparable. Efter inläsningen skall alla orter
 * skrivas ut på skärmen sorterade efter deras postkoder.
 * En körning kan se ut enligt följande:
 *
 *     Läser orter från filen: C:\Temp\orter.dat
 *     Antal funna orter: 7
 *     23642 Höllviken
 *     35243 Växjö
 *     51000 Jönköping
 *     72211 Västerås
 *     75242 Uppsala
 *     90325 Umeå
 *     96133 Boden
 */


public class SorteraOrter
{
    public static void main(String[] args)
    {
        if (args == null || args[0].isEmpty()) {
            System.out.println("Usage: $(basename ${0}) [FILE]");
            System.exit(0);
        }

        OrterSorter sorter = new OrterSorter(args[0]);
        sorter.printResults();
    }
}
