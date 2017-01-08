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
    private String name;
    private ArrayList<NewsTransactor> subscribers;
    private ArrayList<News> newsItems;

    public NewsAgency(String name)
    {
        subscribers = new ArrayList<>();
        newsItems = new ArrayList<>();
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public void receiveNews(News... freshNews)
    {
        Collections.addAll(newsItems, freshNews);

        for (NewsTransactor t : subscribers) {
            t.receiveNews(freshNews);
        }
    }

    @Override
    public void sendNews(NewsTransactor receiver, News... freshNews)
    {
        receiver.receiveNews(freshNews);
    }

    @Override
    public String toString()
    {
        String FORMAT = "  %-15.15s : %s%n";
        StringBuilder str = new StringBuilder("{\n  ");
        str.append(this.getClass().getName()).append("\n");


        // Inspired by the ToStringBuilder in "Apache Commons Lang".
        // https://git-wip-us.apache.org/repos/asf?p=commons-lang.git
        str.append(String.format(FORMAT, "instance ID",
                                 Integer.toHexString(System.identityHashCode(this))));

        str.append(String.format(FORMAT, "Name", getName()));
        str.append(String.format(FORMAT, "Number of subscribers:", subscribers.size()));

        if (newsItems.size() > 0) {
            StringBuilder sbItem = new StringBuilder();
            for (News n : newsItems) {
                sbItem.append(n).append("\n");
            }

            //str.append(String.format(FORMAT, "News", sbItem.toString()));
        }

        return str.append("}").toString();
    }
}
