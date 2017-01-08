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
    private ArrayList<News> newsItems;
    private String name;

    public NewsPaper(String name)
    {
        newsItems = new ArrayList<>();
        this.name = name;
    }

    /**
     * Register this newspaper to a news agency. This creates a subscription
     * link between them.
     *
     * @param agency The news agency to subscribe to (register with)
     */
    public void registerWithNewsAgency(NewsAgency agency)
    {
        if (agency == null) {
            return;
        }
    }

    private String getRandomEntry(String[] entries)
    {
        int index = random.nextInt(entries.length);
        return entries[index];
    }

    public void authorNewsArticles(int numberOfItems)
    {
        String title = String.format("%d %s %s %s %s", random.nextInt(21) + 1,
                                     getRandomEntry(ADJECTIVES),
                                     getRandomEntry(NOUNS),
                                     getRandomEntry(PRONOUNS),
                                     getRandomEntry(VERBTENSE));
        String[] text = {"Lorem ipsum bla bla bla bla", "bla bla bla",
                         "wow this is really interesting", "bla bla"};

        News freshNews = new News(title, text);
        newsItems.add(freshNews);
    }

    @Override
    public void sendNews(NewsTransactor recipient, News newsItem)
    {

    }

    @Override
    public void receiveNews(NewsTransactor sender, News newsItem)
    {

    }
}
