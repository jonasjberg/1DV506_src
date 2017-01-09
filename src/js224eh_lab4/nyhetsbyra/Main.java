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
        /* Make sure to use this VM option for a saner logger output format
         * with single-line entries and less cruft:
         *
         * -Djava.util.logging.SimpleFormatter.format="%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %4$s %5$s%6$s%n"
         */
        logHandler.setLevel(Level.ALL);
        logger.setLevel(Level.ALL);
        logger.addHandler(logHandler);

        // generateFauxNewsHeadlines(100);

        /* Create news agencies */
        NewsAgency reuters = createNewsAgencyInstance("Reuters");
        NewsAgency tt = createNewsAgencyInstance("TT");

        /* Create newspapers and setup connections */
        NewsPaper dn = createNewsPaperInstance("Dagens Nyheter");
        dn.registerWith(reuters);
        dn.registerWith(tt);

        NewsPaper wp = createNewsPaperInstance("Washington Post");
        wp.registerWith(tt);

        /* Author some news articles */
        dn.authorNewsArticles(1);
        wp.authorNewsArticles(1);

        /* Add another newspaper */
        NewsPaper ex = createNewsPaperInstance("Expressen");
        ex.registerWith(reuters);

        /* Author some news articles */
        ex.authorNewsArticles(1);
        dn.authorNewsArticles(2);

        //logger.info(dn.toString());
        //logger.info(ex.toString());
        //logger.info(wp.toString());
        //logger.finest("==========================================");
        //logger.info(reuters.toString());
        //logger.info(tt.toString());
        System.out.println(dn.toString());
        System.out.println(ex.toString());
        System.out.println(wp.toString());
        System.out.println("==========================================");
        System.out.println(reuters.toString());
        System.out.println(tt.toString());

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
        logger.info("Created a new NewsPaper " + instance.getName() + " ..");
        System.out.println("Created a new NewsPaper " + instance.getName() + " ..");

        return instance;
    }

    private static NewsAgency createNewsAgencyInstance(String name)
    {
        if (name.isEmpty()) {
            name = "Unnamed Newsagency";
        }

        NewsAgency instance = new NewsAgency(name);
        logger.info("Created a new NewsAgency " + instance.getName() + " ..");
        System.out.println("Created a new NewsAgency " + instance.getName() + " ..");

        return instance;
    }

    private static void generateFauxNewsHeadlines(int amount)
    {
        if (amount <= 0) {
            return;
        }

        NewsPaper np = new NewsPaper("");
        np.authorNewsArticles(amount);
        for (News n : np.getNewsArticles()) {
            System.out.println(n.getHeadline());
        }
    }
}
