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

    /**
     * Adds a subscription to this news agency if it is not currently in the
     * list of subscribers.
     *
     * @param subscriber The subscriber to to add to the list of subscribers.
     */
    public void addSubscriber(NewsTransactor subscriber)
    {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    private void distributeNewsToSubs(ArrayList<News> freshNews)
    {
        for (NewsTransactor sub : subscribers) {
            for (News news : freshNews) {
                if (!sub.equals(news.getAuthor())) {
                    sendNews(sub, news);
                } else {
                    // System.out.println("Skipping " + sub + " ...");
                    NewsPaper n = (NewsPaper) sub;
                    System.out.println("Skipping " + n.getName() + " ...");
                }
            }
        }
    }

    @Override
    public void receiveNews(News... freshNews)
    {
        for (News news : freshNews) {
            receiveNews(news);
        }
    }

    public void receiveNews(News freshNews)
    {
        ArrayList<News> newsToDistribute = new ArrayList<>();

        if (!newsItems.contains(freshNews)) {
            newsItems.add(freshNews);
            newsToDistribute.add(freshNews);
        }

        if (!newsToDistribute.isEmpty()) {
            distributeNewsToSubs(newsToDistribute);
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
        str.append(String.format(FORMAT, "Subscribers #", subscribers.size()));
        str.append(String.format(FORMAT, "News articles #", newsItems.size()));

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
