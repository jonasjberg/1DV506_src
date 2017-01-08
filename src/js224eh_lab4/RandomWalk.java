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
