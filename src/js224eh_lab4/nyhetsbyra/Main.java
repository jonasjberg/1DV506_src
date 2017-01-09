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


public class Main
{
    public static void main(String[] args)
    {
        // generateFauxNewsHeadlines(100);

        NewsPaper dn = new NewsPaper("Dagens Nyheter");
        NewsPaper ex = new NewsPaper("Expressen");
        NewsPaper wp = new NewsPaper("Washington Post");

        NewsAgency reuters = new NewsAgency("Reuters");
        NewsAgency tt      = new NewsAgency("TT");

        dn.registerWithNewsAgency(reuters);
        dn.registerWithNewsAgency(tt);
        dn.authorNewsArticles(3);
        System.out.println(dn);
        System.out.println(ex);
        System.out.println(wp);

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

    private static void generateFauxNewsHeadlines(int amount)
    {
        if (amount <= 0) { return; }

        NewsPaper np = new NewsPaper("");
        np.authorNewsArticles(amount);

        ArrayList<News> news = np.getNewsArticles();
        for (News n : news) {
            System.out.println(n.getHeadline());
        }
    }
}
