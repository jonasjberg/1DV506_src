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
    final static String             FILE_PATH       =
            "/home/jonas/Dropbox/LNU/1DV506_Problemlosning/src/1DV506/src" +
            "/js224eh_lab4/histogram_data.txt";
    final static int[] BUCKETS = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    static       int[]              numberFrequency = new int[101];
    static       ArrayList<Integer> numbers         = new ArrayList<>();



    public static void main(String[] args)
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
            String digits;
            digits = scan.findInLine("-?\\d+");
            if (digits != null) {
                try {
                    int number = Integer.parseInt(digits);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    continue;
                }
            }

            scan.nextLine();
        }

        int numbersInRange = 0;
        for (int number : numbers) {
            if (number >= 1 && number <= 100) {
                numberFrequency[number]++;
                numbersInRange++;
            }
        }

        System.out.printf("Antal i intervallet [1,100]: %s%n", numbersInRange);
        System.out.printf("Övriga: %s%n", numbers.size());
        System.out.printf("Histogram%n", numbers.size());

        int b = 0;
        for (int i = 0; i < numberFrequency.length; i++) {
            for (int j = 0; j < numberFrequency[i]; j++) {
            }
            if (i % 10 == 0) {
                b++;
            }
        }
        //  1  - 10  | ******
        //  91 - 100 | ***

        int bucketLimitLow = 1;
        int bucketLimitHigh = 10;
/*        for (int i = 1; i < numberFrequency.length; i++) {
            System.out.printf("numberFrequency[%03d] = %d%n", i, numberFrequency[i]);
            if (numberFrequency)
        }*/
    }

/*    private Scanner getScannerForFile(String path)
    {
        Scanner scan = null;
        try {
            File file = new File(path);
            scan = new Scanner(file);
        }  catch (FileNotFoundException e) {
            System.out.printf("ERROR: %s%n", e.toString());
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        return scan;
    }*/
}
