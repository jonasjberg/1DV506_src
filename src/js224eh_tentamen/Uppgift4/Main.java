package js224eh_tentamen.Uppgift4;

import java.util.Iterator;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-01-11.
 */

public class Main
{
    public static void main(String[] args)
    {
        Person olle = new Person("Olle");
        Person maja = new Person("Maja");
        Person stina = new Person("Stina");

        Person nisse = new Person("Nisse");
        Person kalle = new Person("Kalle");

        try {
            nisse.addParent(olle); // Lägg till Olle som förälder till Nisse
            kalle.addParent(olle); // Lägg till Olle som förälder till Kalle
            kalle.addParent(maja); // Lägg till Maja som förälder till Kalle

            // Hämta och skriv ut Olles barn
            Iterator<Person> iter = olle.getChildren();
            Person barn = null;
            while (iter.hasNext()) {
                barn = iter.next();
                System.out.println(barn.getName());
            }

            /*
            * Lägg till Stina som förälder till Kalle.
            * Detta ska generera ett undantag (eng. exception) då
            * han redan har två föräldrar (Olle & Maja).
            */
            kalle.addParent(stina);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
