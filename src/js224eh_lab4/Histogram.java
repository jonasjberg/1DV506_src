package js224eh_lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jonas Sjöberg (js224eh) on 2017-01-06.
 *
 * 1DV506 -- Problemlösning och Programmering, HT2016
 * Laboration 4: Exceptions, IO och interface
 * ---------------------------------------------------------------------------
 *
 * Uppgift 1
 * =========
 * Skriv ett program Histogram.java som läser ett godtyckligt antal heltal från
 * en fil och sedan ritar upp ett histogram (stapeldiagram) för de av talen som
 * är mellan 1 och 100. Notera: Alla talen i filen behöver ej vara inom
 * intervallet [1,100]. En körning kan se ut enligt följande:
 *
 *     Läser heltal från filen: C:\Temp\heltal.dat
 *     Antal i intervallet [1,100]: 46
 *     Övriga: 16
 *     Histogram
 *     1  - 10  | ******
 *     11 - 20  | ****
 *     21 - 30  | **
 *     31 - 40  | ***
 *     41 - 50  | *******
 *     51 - 60  | ****
 *     61 - 70  | ***
 *     71 - 80  | *********
 *     81 - 90  | *****
 *     91 - 100 | ***
 *
 * Notera 1: Du måste skapa din egen datafil. Vi förväntar oss en vanlig
 *           textfil med ett heltal per rad.
 * Notera 2: Datafilens sökväg (tex C:\Temp\heltal.dat) skall vara indata till
 *           programmet (via String[] args).
 */
public class Histogram
{
    final static String FILE_PATH = "/home/jonas/Dropbox/LNU/1DV506_Problemlosning/src/1DV506/src/js224eh_lab4/histogram_data.txt";

    static int[]              buckets               = new int[10];
    static int[]              numberFrequency       = new int[101];
    static ArrayList<Integer> numbers               = new ArrayList<>();
    static int                numbersInRange        = 0;
    static int                numbersOutsideOfRange = 0;

    public static void main(String[] args)
    {
        // TODO: Get file path from args!
        showFileStatistics(FILE_PATH);
    }

    private static void showFileStatistics(String path)
    {
        Scanner scan = null;
        try {
            File file = new File(FILE_PATH);
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: %s%n", e.toString());
            System.exit(1);
        }

        System.out.printf("Läser heltal från filen: \"%s\"%n", FILE_PATH);
        while (scan.hasNextLine()) {
            String digits = scan.findInLine("-?\\d+");
            if (digits != null && !digits.isEmpty()) {
                try {
                    int number = Integer.parseInt(digits);
                    if (number >= 1 && number <= 100) {
                        numberFrequency[number]++;
                        numbersInRange++;
                    } else {
                        numbersOutsideOfRange++;
                    }
                } catch (NumberFormatException e) {
                    continue;
                }
            }

            scan.nextLine();
        }

        System.out.printf("Antal i intervallet [1,100]: %s%n", numbersInRange);
        System.out.printf("Övriga: %s%n", numbersOutsideOfRange);
        System.out.printf("Histogram%n");

        int b = 0;
        for (int i = 0; i < numberFrequency.length; i++) {
            buckets[b] += numberFrequency[i];

            if (i > 0 && i % 10 == 0) {
                if (b < buckets.length - 1) {
                    b++;
                }
            }
        }
        //  1  - 10  | ******
        //  91 - 100 | ***

        int bucketLow = 1;
        int bucketHigh = 10;
        for (int i = 0; i < buckets.length; i++) {
            String bar = repeatString("*", buckets[i]);
            System.out.printf("%2d - %3d | %s%n", bucketLow, bucketHigh, bar);

            bucketLow += 10;
            bucketHigh += 10;
        }

    }

    /**
     * Repeats a given string a specified number of times.
     *
     * @param string  The string to repeat.
     * @param repeats The number of concatenations of the string.
     * @return 'string' repeated 'repeats' times.
     */
    private static String repeatString(String string, int repeats)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < repeats; i++) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
