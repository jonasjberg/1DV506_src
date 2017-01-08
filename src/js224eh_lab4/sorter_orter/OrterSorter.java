package js224eh_lab4.sorter_orter;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Created by Jonas Sjöberg (js224eh) on 2017-01-08.
 *
 * 1DV506 -- Problemlösning och Programmering, HT2016
 * Laboration 4: Exceptions, IO och interface
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * Uppgift 4
 * =========
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class OrterSorter
{
    private ArrayList<Ort> orter;
    private String filePath;

    public OrterSorter(String filePath)
    {
        this.filePath = filePath;
        orter = new ArrayList<>();

        run();
    }

    private void run()
    {
        String[] lines = readTextLinesFromFile(this.filePath);

        for (String line : lines) {
            orter.add(parseLineAndCreateOrt(line));
        }

        Collections.sort(orter);
    }

    private Ort parseLineAndCreateOrt(String line)
    {
        String postal = line.split(":")[0];
        String city = line.split(":")[1];

        int postalNumber = 0;
        try {
            postalNumber = Integer.parseInt(postal);
        } catch (NumberFormatException e) {
            System.out.printf("ERROR: %s%n", e.toString());
        }

        return new Ort(city, postalNumber);
    }

    public void printResults()
    {
        if (orter.isEmpty()) {
            System.out.println("There are no results to print.");
            return;
        }

        for (Ort o : orter) {
            System.out.println(o);
        }
    }

    private static String[] readTextLinesFromFile(String filePath)
    {
        ArrayList<String> lines = new ArrayList<>();

        Scanner scan = null;
        try {
            File file = new File(filePath);
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: %s%n", e.toString());
            System.exit(1);
        }

        while (scan.hasNextLine()) {
            String line = null;
            line = scan.nextLine();
            if (line != null && !line.isEmpty()) {
                lines.add(line);
            }
        }

        scan.close();

        return lines.toArray(new String[0]);
    }
}
