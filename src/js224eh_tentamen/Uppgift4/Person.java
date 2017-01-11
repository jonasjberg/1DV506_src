package js224eh_tentamen.Uppgift4;

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
    final static int MAX_PERSONS = 100;

    private static int[][] childLookup = new int[MAX_PERSONS][MAX_PERSONS];
    private static int personCount = 0;
    private static Person[] persons = new Person[MAX_PERSONS];

    private Person[] parents = new Person[2];
    private int age;
    private String name;
    public int id;
    private int numberChildren = 0;

    public Person(String name)
    {
        this(DEFAULT_AGE, name);
    }

    public Person(int age, String name)
    {
        this.age = age;
        this.name = name;
        persons[personCount] = this;
        this.id = personCount++;
    }

    /*
    * Lägger till en förälder till en person.
    * En person kan bara ha två föräldrar, om det redan finns två skall
    * ett undantag kastas.
    */
    public void addParent(Person p) throws Exception
    {
        int numberParents = parents.length;

        if (numberParents == 2) {
            throw new IllegalArgumentException("A person can not have more " +
                                               "than two parents.");
        }

        parents[numberParents - 1] = p;
        childLookup[p.id][numberChildren++] = this.id;
    }

    /*
    * Hämtar en iterator som itererar över personens barn.
    * Notera att du måste skapa en separat iteratorklass som
    * vet hur man itererar över alla barnen!
    */
    Iterator<Person> getChildren()
    {
        class PersonIterator implements Iterator<Person>
        {
            private int nextChild;
            private Person parent;
            private int[][] childLookup;

            public PersonIterator(Person parent, int[][] childLookup)
            {
                this.parent = parent;
                this.childLookup = childLookup;
                nextChild = 0;
            }

            @Override
            public boolean hasNext()
            {
                return nextChild <= childLookup[parent.id].length;
            }

            @Override
            public Person next()
            {
                int index = childLookup[parent.id][nextChild++];
                return persons[index];
            }
        }

        return new PersonIterator(this, childLookup);
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
