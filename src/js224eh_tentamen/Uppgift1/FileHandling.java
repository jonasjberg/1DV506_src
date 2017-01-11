package js224eh_tentamen.Uppgift1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-01-11.
 *
 * Uppgift 1
 * Skriv ett program, FileHandling.java, som öppnar en textfil innehållande ord
 * separerade med antingen mellanslag eller radslut. Skriv ut alla ord baklänges
 * som uppfyller följande villkor:
 * Kontrollsumman för det aktuella ordet skall vara större än 3000 och det
 * föregående ordet får inte ha en kontrollsumma som överstiger 3000.
 * där kontrollsumman för ett ord beräknas enligt
 *
 *     kontrollsumma =        SUM        (index + ) * ASCIIvärde
 *                      för varje tecken
 *
 */
public class FileHandling
{
    static final String DEFAULT_PATH = "/home/jonas/today/FileHandling_test.txt";

    public static void main(String[] args)
    {
        ArrayList<String> words;

        if (args == null || args.length == 0) {
            words = readWordsFromFile(DEFAULT_PATH);
        } else {
            words = readWordsFromFile(args[0]);
        }

        words = filterWordsByChecksum(words);
        reverseArrayList(words);
        for (String word : words) {
            System.out.println(word);
        }
    }

    private static void reverseArrayList(ArrayList<String> words)
    {
        int firstPos = words.size() - 1;
        for (int secondPos = 0; secondPos < firstPos; secondPos++) {
            words.add(secondPos, words.remove(firstPos));
        }
    }

    private static ArrayList<String> filterWordsByChecksum(
            ArrayList<String> words)
    {
        ArrayList<String> filteredWords = new ArrayList<>();

        int previousChecksum = 0;
        for (String word : words) {
            int thisChecksum = calculateWordChecksum(word);

            if (thisChecksum > 3000 && previousChecksum < 3000) {
                filteredWords.add(word);
            }

            previousChecksum = thisChecksum;
        }

        return filteredWords;
    }

    /**
     * Assumes ASCII encoded text which might not always be the case.
     * Does conversion by casting characters to integers.
     */
    private static int calculateWordChecksum(String word)
    {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            sum += (i + 1) * (int) c;
        }
        return sum;
    }

    private static ArrayList<String> readWordsFromFile(String path)
    {
        ArrayList<String> words = new ArrayList<>();

        Scanner scan = null;
        try {
            File file = new File(path);
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: %s%n", e.toString());
            System.exit(1);
        }

        while (scan.hasNext()) {
            words.add(scan.next());
        }

        scan.close();
        return words;
    }
}
