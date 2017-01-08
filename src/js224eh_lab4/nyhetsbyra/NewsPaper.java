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
    private ArrayList<NewsTransactor> registeredAgencies;

    public NewsPaper(String name)
    {
        newsItems = new ArrayList<>();
        registeredAgencies = new ArrayList<>();
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    /**
     * Register this newspaper to a news agency. This creates a subscription
     * link between them.
     *
     * @param agency The news agency to subscribe to (register with)
     */
    public void registerWithNewsAgency(NewsAgency agency)
    {
        registeredAgencies.add(agency);
        for (News item : newsItems) {
            sendNews(agency, item);
        }
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

        for (int i = 1; i <= numberOfItems; i++) {
            String title = String.format("%d %s %s %s %s",
                                         random.nextInt(21) + 1,
                                         getRandomEntry(ADJECTIVES),
                                         getRandomEntry(NOUNS),
                                         getRandomEntry(PRONOUNS),
                                         getRandomEntry(VERBTENSE));

            News freshNews = new News(title, DUMMY_TEXT, this);
            newsItems.add(freshNews);
            for (NewsTransactor agency : registeredAgencies) {
                agency.receiveNews(freshNews);
            }
        }
    }

    @Override
    public void receiveNews(News... freshNews)
    {
        for (News news : freshNews) {
            if (news.getAuthor() != this) {
                newsItems.add(news);
            }
        }
    }

    @Override
    public void sendNews(NewsTransactor receiver, News... newsItem)
    {

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
}
