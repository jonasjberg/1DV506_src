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


public interface NewsTransactor
{
    void registerWith(NewsTransactor other);

    void sendNews(NewsTransactor receiver, News... freshNews);

    void receiveNews(News... freshNews);

    String getName();
}
