package js224eh_lab3.test;

import js224eh_lab3.MultiDisplay;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 3
 */
public class MultiDisplayMain
{
    public static void main(String[] args)
    {
        MultiDisplay md = new MultiDisplay();

        md.setDisplayMessage("Hello World!");
        md.setDisplayCount(3);
        md.display();                           // ==> print-out

        md.display("Goodbye cruel world!", 2);  // ==> print-out
        md.display("I LIVE AGAIN", 1);          // ==> print-out
        md.setDisplayMessage("Hello World!");
        md.display();                           // ==> print-out
        md.setDisplayCount(0);
        md.display();                           // ==> print-out
        md.display("Goodbye cruel world!", 1);  // ==> print-out

        System.out.println("Current Message: " + md.getDisplayMessage());
    }
}
