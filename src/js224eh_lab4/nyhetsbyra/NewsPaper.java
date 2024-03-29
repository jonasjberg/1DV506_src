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
import java.util.Random;


public class NewsPaper implements NewsTransactor
{
    private static final Random random = new Random();
    private final String[] ADJECTIVES = {"Bleak-like", "Tall", "Beautiful",
                                         "Anemic", "Washed out white"};
    private final String[] NOUNS = {"Plastic Things", "Poisonous Flagpoles",
                                    "Death Metal Singers", "Gravy Contests"};
    private final String[] PRONOUNS = {"You", "I", "Your Cat", "This Cat",
                                       "This One Cat", "An Awesome Black Cat"};
    private final String[] VERBTENSE = {"Didn't Know about", "Must Read About",
                                        "Should Download as Audiobook"};
    private final String[] DUMMY_TEXT = {"Lorem ipsum bla bla bla bla",
                                         "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                                         "wow this is really interesting",
                                         "Nunc id urna a nisi gravida venenatis.",
                                         "Quisque porta neque id risus viverra, id luctus lorem volutpat.",
                                         "Duis eget est faucibus urna vestibulum ultricies.",
                                         "Maecenas ultricies nulla sit amet dolor dictum, " +
                                         "sed accumsan orci faucibus."};

    private ArrayList<News> newsItems;
    private String name;
    private ArrayList<NewsTransactor> subscribers;

    public NewsPaper(String name)
    {
        newsItems = new ArrayList<>();
        subscribers = new ArrayList<>();
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public ArrayList<News> getNewsArticles()
    {
        return newsItems;
    }

    /**
     * Get random entry from String array.
     * @param entries The String array to fetch from.
     * @return A random element from "entries".
     */
    private String getRandomEntry(String[] entries)
    {
        int index = random.nextInt(entries.length);
        return entries[index];
    }

    /**
     * Authors a specified number of new news items/articles.
     *
     * @param numberOfItems The number of news items to author.
     */
    public void authorNewsArticles(int numberOfItems)
    {
        if (numberOfItems < 1) {
            return;
        }

        ArrayList<News> newsToDistribute = new ArrayList<>();

        for (int i = 1; i <= numberOfItems; i++) {
            String title = String.format("%d %s %s %s %s",
                                         random.nextInt(21) + 1,
                                         getRandomEntry(ADJECTIVES),
                                         getRandomEntry(NOUNS),
                                         getRandomEntry(PRONOUNS),
                                         getRandomEntry(VERBTENSE));

            News freshNews = new News(title, DUMMY_TEXT, this);
            newsItems.add(freshNews);
            newsToDistribute.add(freshNews);
        }

        System.out.printf("%s has authored %d news articles.%n",
                          getName(), numberOfItems);
        distributeNewsToSubscribers(newsToDistribute);
    }

    private void distributeNewsToSubscribers(ArrayList<News> freshNews)
    {
        int agencyCount = 0;
        for (NewsTransactor t : subscribers) {
            // System.out.println("Sending to " + t);
            for (News news : freshNews) {
                t.receiveNews(news);
            }
            agencyCount++;
        }
        System.out.printf("%s has distributed news articles to %d agencies.%n",
                          getName(), agencyCount);
    }

    @Override
    public void receiveNews(News... freshNews)
    {
        ArrayList<News> newsToDistribute = new ArrayList<>();

        for (News news : freshNews) {
            if (!newsItems.contains(news)) {
                newsItems.add(news);
            }
            newsToDistribute.add(news);
        }

        if (!newsToDistribute.isEmpty()) {
            System.out.printf("%s has received %d news items of which %d will " +
                              "be distributed to %d agencies%n",
                              getName(), freshNews.length,
                              newsToDistribute.size(),
                              subscribers.size());
            distributeNewsToSubscribers(newsToDistribute);
        }
    }

    @Override
    public void sendNews(NewsTransactor receiver, News... freshNews)
    {
        receiver.receiveNews(freshNews);
    }

    /**
     * Register this newspaper to a NewsTransactor. This creates a subscription
     * link between them.
     *
     * @param other The NewsTransactor to subscribe to (register with).
     */
    @Override
    public void registerWith(NewsTransactor other)
    {
        subscribers.add(other);
        other.registerWith(this);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        } else if (!(o instanceof NewsPaper)) {
            return false;
        }

        NewsPaper newsPaper = (NewsPaper) o;
        return getName().equals(newsPaper.getName());
    }

    /**
     * @return Returns a human-readable string representation of the newspaper.
     */
    @Override
    public String toString()
    {
        String FORMAT = "  %-15.15s : %s%n";
        StringBuilder str = new StringBuilder("{\n  ");
        str.append(this.getClass().getName()).append("\n");


        // Inspired by the ToStringBuilder in "Apache Commons Lang".
        // https://git-wip-us.apache.org/repos/asf?p=commons-lang.git
        str.append(String.format(FORMAT, "instance ID",
                                 Integer.toHexString(
                                         System.identityHashCode(this))));

        str.append(String.format(FORMAT, "Name", getName()));
        str.append(String.format(FORMAT, "News articles #", newsItems.size()));

        if (newsItems.size() > 0) {
            StringBuilder sbItem = new StringBuilder();
            for (News n : newsItems) {
                sbItem.append(n);
            }

            str.append(sbItem.toString());
        }

        return str.append("}").toString();
    }
}
