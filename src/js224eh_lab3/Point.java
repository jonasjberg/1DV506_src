package js224eh_lab3;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 6
 */
public class Point
{
    private int x, y;

    /**
     * Creates a new point at coordinates (0, 0).
     */
    public Point()
    {
        this(0, 0);
    }

    /**
     * Creates a new point at coordinates (x, y).
     * @param x The X-coordinate of the new point.
     * @param y The Y-coordinate of the new point.
     */
    public Point(int x, int y)
    {
        moveToXY(x, y);
    }

    /**
     * @return The X-position of this point.
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * @return The Y-position of this point.
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * Tests if a point has the same coordinates as another point.
     * @param another The second point to test against.
     * @return True if the coordinates of both points are equal.
     */
    public boolean isEqualTo(Point another)
    {
        return this.x == another.getX() && this.y == another.getY();
    }

    /**
     * Moves (translates) the point by the vector (x, y).
     * @param x Size of horizontal movement (translation)
     * @param y Size of vertical movement (translation)
     */
    public void move(int x, int y)
    {
        this.x += x;
        this.y += y;
    }

    /**
     * Moves the point to coordinates (x, y).
     * @param x The points new X-position.
     * @param y The points new Y-position.
     */
    public void moveToXY(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the distance between this Point and another Point.
     * Uses the formula:   distance = Sqrt( (x1-x2)^2 + (y1-y2)^2 )
     *
     * @param another Distance is calculated between this specified
     *                Point ('another') and the calling object.
     * @return The distance between this object and the given Point.
     */
    public double distanceTo(Point another)
    {
        return Math.sqrt(Math.pow(this.x - another.x, 2) +
                         Math.pow(this.y - another.y, 2));
    }

    /**
     * @return A string representation of this Point.
     */
    @Override
    public String toString()
    {
        return String.format("(%d,%d)", this.x, this.y);
    }
}
