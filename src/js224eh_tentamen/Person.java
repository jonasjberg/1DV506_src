package js224eh_tentamen;

import java.util.ArrayList;
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
    ArrayList<Person> parents = new ArrayList<>();
    private int age;
    private String name;

    public Person(int age, String name)
    {
        this.name = name;
        this.age = age;
    }

    /*
    * Lägger till en förälder till en person.
    * En person kan bara ha två föräldrar, om det redan finns två skall
    * ett undantag kastas.
    */
    public void addParent(Person p) throws Exception
    {
        if (parents.size() == 2) {
            throw new IllegalArgumentException("A person can not have more " +
                                               "than two parents.");
        }

        parents.add(p);
    }

    /*
    * Hämtar en iterator som itererar över personens barn.
    * Notera att du måste skapa en separat iteratorklass som
    * vet hur man itererar över alla barnen!
    */
    public Iterator<Person> getChildren()
    {
        class PersonIterator implements Iterator<Person>
        {

            @Override public boolean hasNext()
            {
                return false;
            }

            @Override public Person next()
            {
                return null;
            }
        }
    }


    /*
    * Hämta personens ålder.
    */
    public int getAge()
    {
        return age;
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
