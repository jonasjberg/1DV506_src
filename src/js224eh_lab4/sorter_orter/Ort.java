package js224eh_lab4.sorter_orter;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Created by Jonas Sjöberg (js224eh) on 2017-01-07.
 *
 * 1DV506 -- Problemlösning och Programmering, HT2016
 * Laboration 4: Exceptions, IO och interface
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * Uppgift 4
 * =========
 */

public class Ort implements Comparable<Ort>
{
    private String name;
    private int postal;

    public Ort(String name, int postal)
    {
        this.name = name;
        this.postal = postal;
    }

    public String getName()
    {
        return name;
    }

    public int getPostal()
    {
        return postal;
    }

    @Override
    public int compareTo(Ort o)
    {
        return getPostal() - o.getPostal();
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(postal).append(":").append(name);
        return sb.toString();
    }
}
