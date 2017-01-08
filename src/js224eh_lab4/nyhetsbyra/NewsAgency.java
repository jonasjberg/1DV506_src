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
import java.util.Collections;


public class NewsAgency implements NewsTransactor
{
    private ArrayList<NewsPaper> newsPapers;
    private ArrayList<News> newsItems;
    private boolean hasUndistributedNewsItems = false;
    private String name;

    public NewsAgency(String name)
    {
        newsPapers = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void receiveNews(News... freshNews)
    {
        Collections.addAll(newsItems, freshNews);

        for (NewsTransactor t : newsPapers) {
            t.receiveNews(freshNews);
        }

    }

    @Override
    public void sendNews(NewsTransactor receiver, News... newsItem)
    {

    }
}
