package js224eh_tentamen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-01-11.
 */
public class FileHandling
{
    static final String DEFAULT_PATH = "./FileHandling_test.txt";

    public static void main(String[] args)
    {
        String path;
        if (args == null || args.length == 0) {
            path = DEFAULT_PATH;
        } else {
            path = args[0];
        }

        ArrayList<String> words = readWordsFromFile(path);
        System.out.println(words);

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

        return words;
    }
}
