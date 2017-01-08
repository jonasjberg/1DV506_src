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
    private int x, y;
    private int maxSteps;
    private int stepsTaken;
    private int absAreaMax;

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
        String fmt = "steps: %-6d  position: (%3d, %3d)%n";
        return String.format(fmt, x, y, stepsTaken);
    }

    /**
     * Simulates a step in the walk.
     *
     * The direction is randomized.
     */
    public void takeStep()
    {
        Random random = new Random();

        /* 0 - up
         * 1 - down
         * 2 - right
         * 3 - left
         */
        int direction = random.nextInt(4) + 1;
        switch (direction) {
            case 0:
                /* Up */
                break;
            case 1:
                /* Down */
                break;
            case 2:
                /* Right */
                break;
            case 3:
                /* Left */
                break;
        }
    }

    /**
     * @return True if the number of steps taken is less than the maximum
     * number of steps allowed, otherwise False.
     */
    public boolean moreSteps()
    {

    }

    /**
     * @return True if the current position is inside the allowed area, else False.
     */
    public boolean inBounds()
    {

    }
}
