package js224eh_lab2;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-26.
 *
 * Lektion 4 - Styrande satser
 * Uppgift 8 (VG-uppgift)
 *
 * Skriv ett program TartLjus.java som beräknar hur många askar tårtljus en
 * person behöver köpa varje år fram till hundraårsfirandet. Ni kan anta att
 * antalet ljus i tårtan är samma som det år man fyller, att man sparar
 * överblivna ljus från ett år till ett annat, och att varje ask innehåller 24
 * ljus. I slutet av programet skall ni också skriva ut det totala antalet askar
 * man måste köpa och hur många ljus som finns kvar efter man firat sin 100:e
 * födelsedag. En körning kan se ut enligt följande:
 *
 *     Before birthday 1, buy 1 box(es)
 *     Before birthday 7, buy 1 box(es)
 *     Before birthday 10, buy 1 box(es)
 *     Before birthday 12, buy 1 box(es)
 *     Before birthday 14, buy 1 box(es)
 *
 *     ...
 *
 *     Before birthday 95, buy 3 box(es)
 *     Before birthday 96, buy 4 box(es)
 *     Before birthday 97, buy 5 box(es)
 *     Before birthday 98, buy 4 box(es)
 *     Before birthday 99, buy 4 box(es)
 *     Before birthday 100, buy 4 box(es)
 *
 *     Total number of boxes: 211, Remaining candels: 14
 *
 * Notera: I utskriften ovan redovisar vi bara de år då man måste köpa nya
 *         askar. De år som inte skrivs ut (tex 2-6, 8-9) klarar man sig utan
 *         att köpa några nya ljus.
 */
public class TartLjus
{
    public static void main(String[] args)
    {
        final int YEAR_FIRST      = 1;
        final int YEAR_LAST       = 100;
        final int CANDLES_PER_BOX = 24;

        int boxes      = 0;
        int candles    = 0;
        int boxesTotal = 0;

        for (int age = YEAR_FIRST; age <= YEAR_LAST; age++) {
            /* Köp fler om det saknas för nästkommande födelsedagstårta. */
            while (candles < age) {
                boxes++;
                boxesTotal++;
                candles += CANDLES_PER_BOX;
            }

            System.out.printf("Before birthday %d, buy %d box(es)%n", age, boxes);
            boxes = 0;

            /* Förbruka lika många ljus som antal år man fyller. */
            candles -= age;
        }

        System.out.printf("\nTotal number of boxes: %d, Remaining candles: %d",
                          boxesTotal, candles);
        System.exit(0);
    }
}
