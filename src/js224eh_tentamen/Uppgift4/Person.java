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
    // Handle age field unreachable through mutators.
    final static int DEFAULT_AGE = -1;

    // Keep track of all persons. Hardcoded array sizes for brevity.
    final static int MAX_PERSONS = 100;
    private static Person[] persons = new Person[MAX_PERSONS];
    private static int personCount = 0;
    private static int[][] childLookup = new int[MAX_PERSONS][MAX_PERSONS];

    // Public fields for fetching children from "persons" using parent ids.
    public int id;
    public int numberChildren;

    // Fields
    private Person[] parents = new Person[2];
    private int parentsIndex;
    private int age;
    private String name;

    /**
     * Creates a new DEFAULT_AGE years old instance of the Person class.
     * @param name The name of the person.
     */
    public Person(String name)
    {
        this(DEFAULT_AGE, name);
    }

    /**
     * Creates a new instance of the Person class.
     * @param age The age of the person.
     * @param name The name of the person.
     */
    public Person(int age, String name)
    {
        this.age = age;
        this.name = name;
        parentsIndex = 0;
        numberChildren = 0;
        persons[personCount] = this;
        id = personCount++;
    }

    /*
    * Lägger till en förälder till en person.
    * En person kan bara ha två föräldrar, om det redan finns två skall
    * ett undantag kastas.
    */
    public void addParent(Person p) throws Exception
    {
        if (parentsIndex > 1) {
            throw new IllegalArgumentException("A person can not have more " +
                                               "than two parents.");
        }

        parents[parentsIndex++] = p;
        childLookup[p.id][p.numberChildren++] = this.id;
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
            private Person parent;
            private int[][] childLookup;
            private int nextChild;

            public PersonIterator(Person parent, int[][] childLookup)
            {
                this.parent = parent;
                this.childLookup = childLookup;
                nextChild = 0;
            }

            @Override
            public boolean hasNext()
            {
                return nextChild < parent.numberChildren;
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
