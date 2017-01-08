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

    public News(String headline, String[] contents)
    {
        this.headline = headline;
        this.contents = contents;
    }

    public String getHeadline()
    {
        return headline;
    }

    public String[] getContents()
    {
        return contents;
    }
}
