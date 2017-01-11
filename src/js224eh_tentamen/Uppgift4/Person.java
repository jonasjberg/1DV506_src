package js224eh_tentamen.Uppgift4;

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
    final static int DEFAULT_AGE = -1;

    ArrayList<Person> parents;
    private int age;
    private String name;

    public Person(String name)
    {
        this(DEFAULT_AGE, name);
    }

    public Person(int age, String name)
    {
        parents = new ArrayList<>();
        this.age = age;
        this.name = name;
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
            private int nextChild;
            private ArrayList<Person> children;

            public PersonIterator(ArrayList<Person> children)
            {
                this.children = children;
                nextChild = 0;
            }

            @Override public boolean hasNext()
            {
                return nextChild <= children.size();
            }

            @Override public Person next()
            {
                return children.get(nextChild++);
            }
        }

        return new PersonIterator(parents);
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
        return name;
    }
}
