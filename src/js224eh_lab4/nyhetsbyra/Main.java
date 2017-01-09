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
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main
{
    public static final ConsoleHandler logHandler = new ConsoleHandler();
    public static Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args)
    {
        logHandler.setLevel(Level.ALL);
        logger.setLevel(Level.ALL);
        logger.addHandler(logHandler);

        // generateFauxNewsHeadlines(100);

        // Create news agencies
        NewsAgency reuters = createNewsAgencyInstance("Reuters");
        NewsAgency tt = createNewsAgencyInstance("TT");

        // Create newspapers and setup connections
        NewsPaper dn = createNewsPaperInstance("Dagens Nyheter");
        dn.registerWith(reuters);
        dn.registerWith(tt);

        NewsPaper wp = createNewsPaperInstance("Washington Post");
        wp.registerWith(tt);

        // Author some news articles
        dn.authorNewsArticles(1);

        // Add another newspaper
        NewsPaper ex = createNewsPaperInstance("Expressen");
        ex.registerWith(reuters);

        // Author some news articles
        // ex.authorNewsArticles(1);
        // dn.authorNewsArticles(2);

        logger.finest("------------------------------------------");
        logger.fine(dn.toString());
        logger.finest("------------------------------------------");
        logger.fine(ex.toString());
        logger.finest("------------------------------------------");
        logger.fine(wp.toString());
        logger.finest("------------------------------------------");
        logger.finest("------------------------------------------");
        logger.fine(reuters.toString());
        logger.finest("------------------------------------------");
        logger.fine(tt.toString());
        logger.finest("------------------------------------------");

        // ex.registerWithNewsAgency(reuters);
        // ex.authorNewsArticles(1);
        // System.out.println(dn);
        // System.out.println(ex);
        // System.out.println(wp);

        // wp.registerWithNewsAgency(tt);
        // wp.authorNewsArticles(2);
        // System.out.println(dn);
        // System.out.println(ex);
        // System.out.println(wp);
    }

    private static NewsPaper createNewsPaperInstance(String name)
    {
        if (name.isEmpty()) {
            name = "Unnamed Newspaper";
        }

        NewsPaper instance = new NewsPaper(name);
        logger.fine("Created a new NewsPaper " + instance.getName() + " ..");

        return instance;
    }

    private static NewsAgency createNewsAgencyInstance(String name)
    {
        if (name.isEmpty()) {
            name = "Unnamed Newsagency";
        }

        NewsAgency instance = new NewsAgency(name);
        logger.fine("Created a new NewsAgency " + instance.getName() + " ..");

        return instance;
    }

    private static void generateFauxNewsHeadlines(int amount)
    {
        if (amount <= 0) {
            return;
        }

        NewsPaper np = new NewsPaper("");
        np.authorNewsArticles(amount);

        ArrayList<News> news = np.getNewsArticles();
        for (News n : news) {
            System.out.println(n.getHeadline());
        }
    }
}
