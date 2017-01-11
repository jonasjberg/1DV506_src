package js224eh_tentamen;

import java.util.Iterator;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-01-11.
 *
 * Uppgift 4
 * I uppgiften skall du använda och utöka klassen Person nedan med tillhörande
 * iterator:
 */
public class Person
{
    // Lägg till kod här

    /*
    * Lägger till en förälder till en person.
    * En person kan bara ha två föräldrar, om det redan finns två skall
    * ett undantag kastas.
    */
    public void addParent(Person p) throws Exception
    {
        // Lägg till kod här
    }

    /*
    * Hämtar en iterator som itererar över personens barn.
    * Notera att du måste skapa en separat iteratorklass som
    * vet hur man itererar över alla barnen!
    */
    public Iterator<Person> getChildren()
    {
        // Lägg till kod här
    }

    /*
    * Hämta personens ålder.
    */
    public int getAge()
    {
        // Lägg till kod här
    }

    /*
    * Hämta personens namn.
    */
    public String getName()
    {
        // Lägg till kod här
        return name;
    }
}
