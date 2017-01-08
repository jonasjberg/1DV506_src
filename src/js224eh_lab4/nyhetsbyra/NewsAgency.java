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

import java.util.ArrayList;


public class NewsAgency
{
    private ArrayList<NewsPaper> newsPapers;
    private boolean hasUndistributedNewsItems = false;
    private String name;

    public NewsAgency(String name)
    {
        newsPapers = new ArrayList<>();
        this.name = name;
    }
}
