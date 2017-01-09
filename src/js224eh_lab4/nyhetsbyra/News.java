package js224eh_lab4.nyhetsbyra;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Created by Jonas Sjöberg (js224eh) on 2017-01-08.
 *
 * 1DV506 -- Problemlösning och Programmering, HT2016
 * Laboration 4: Exceptions, IO och interface
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * Uppgift 6
 * =========
 */


public class News
{
    private String headline;
    private String[] contents;
    private NewsPaper author;

    public News(String headline, String[] contents, NewsPaper author)
    {
        this.headline = headline;
        this.contents = contents;
        this.author = author;
    }

    public String getHeadline()
    {
        return headline;
    }

    public String[] getContents()
    {
        return contents;
    }

    public NewsPaper getAuthor()
    {
        return author;
    }

    @Override
    public String toString()
    {
        String FORMAT = "    %-13.13s : %s%n";
        StringBuilder str = new StringBuilder("  {\n");


        // Inspired by the ToStringBuilder in "Apache Commons Lang".
        // https://git-wip-us.apache.org/repos/asf?p=commons-lang.git
        str.append(String.format(FORMAT, "instance ID",
                                 Integer.toHexString(System.identityHashCode(this))));

        str.append(String.format(FORMAT, "Author", getAuthor().getName()));
        str.append(String.format(FORMAT, "Headline", getHeadline()));

        return str.append("  }\n").toString();
    }
}
