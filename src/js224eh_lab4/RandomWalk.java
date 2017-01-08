package js224eh_lab4;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Created by Jonas Sjöberg (js224eh) on 2017-01-08.
 *
 * 1DV506 -- Problemlösning och Programmering, HT2016
 * Laboration 4: Exceptions, IO och interface
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * Uppgift 5
 * =========
 * Skapa en klass RandomWalk.java som simulerar en slumpvandring. En
 * slumpvandring utförs på ett begränsat plan och varje steg består av en
 * förflyttning i en slumpmässig riktning. Vandringen upphör när ett maximalt
 * antal steg har tagits eller när ett steg tas ut från det givna planet.
 * Antag att planet är givet av ett rutnät, där punkt (0, 0) ligger i mitten.
 * Storleken på planet bestäms av ett heltal; om värdet på heltalet är k så kan
 * x- och y-koordinaterna för punkter på planet variera från –k till k.
 *
 * I varje steg sker en förflyttning ett steg upp, ett steg ner, ett steg till
 * höger eller ett steg till vänster (inga diagonala steg).
 *
 * Klassen RandomWalk behöver följande fält:
 *   - X-koordinaten för nuvarande position
 *   - Y-koordinaten för nuvarande position
 *   - Det maximala antalet steg en vandring får ha
 *   - Antalet steg tagna hittills i vandringen
 *   - Storleken på planet (enligt ovan)
 *
 * Övriga medlemmar:
 *   - RandomWalk(int max, int size):
 *     Det maximala antalet steg skall vara max och size är storleken på planet.
 *     Startpositionen sätts till (0, 0).
 *   - String toString():
 *     Returnerar en sträng bestående av antalet steg tagna hittills och den
 *     nuvarande positionen.
 *   - void takeStep():
 *     Simulerar ett steg i vandringen. Slumpa ett heltal som kan anta 4 olika
 *     värden och låt dessa representera att steget tas uppåt, nedåt, till höger
 *     eller till vänster. Metoden ska också öka antalet tagna steg.
 *   - boolean moreSteps():
 *     Returnerar true om antalet tagna steg är mindre än maxantalet, annars
 *     returneras false.
 *   - boolean inBounds():
 *     Returnerar true om nuvarande position är innanför planets område, annars
 *     returneras false.
 *   - void walk():
 *     Simulerar en slumpvandring, dvs ett antal steg utförs tills det maximala
 *     antalet har uppnåtts eller tills vi vandrar ut från planets område.
 */

import java.util.Random;


public class RandomWalk
{
    private static final Random random = new Random();

    private int x, y;
    private int maxSteps;
    private int stepsTaken;
    private int absAreaMax;

    /**
     * Creates a new instance of the "RandomWalk" class.
     *
     * @param max The maximum number of steps to take.
     * @param size The size of the area.
     */
    public RandomWalk(int max, int size)
    {
        maxSteps = max;
        absAreaMax = size;
        x = 0;
        y = 0;
        stepsTaken = 0;
    }

    /**
     * @return The number of steps taken and the current position as a String.
     */
    public String toString()
    {
        String fmt = "steps: %-6d  position: (%3d, %3d)";
        return String.format(fmt, stepsTaken, x, y);
    }

    public void printAsciiArtStateToStdout()
    {
        for (int y = -absAreaMax; y <= absAreaMax; y++) {
            for (int x = -absAreaMax; x <= absAreaMax; x++) {
                String s = (this.x == x && this.y == y) ? "@" : ".";
                System.out.print(s + " ");
            }
            System.out.printf("%n");
        }
    }

    /**
     * Simulates a step in the walk.
     *
     * The direction is randomized.
     */
    public void takeStep()
    {
        int direction = random.nextInt(4) + 1;
        switch (direction) {
            case 0:
                /* Up */
                y += 1;
                break;
            case 1:
                /* Down */
                y -= 1;
                break;
            case 2:
                /* Right */
                x += 1;
                break;
            case 3:
                /* Left */
                x -= 1;
                break;
        }

        stepsTaken++;
    }

    /**
     * @return True if the number of steps taken is less than the maximum
     * number of steps allowed, otherwise False.
     */
    public boolean moreSteps()
    {
        return stepsTaken < maxSteps;
    }

    /**
     * @return True if the current position is inside the allowed area, else False.
     */
    public boolean inBounds()
    {
        return (Math.abs(x) <= absAreaMax) && (Math.abs(y) <= absAreaMax);
    }
}
