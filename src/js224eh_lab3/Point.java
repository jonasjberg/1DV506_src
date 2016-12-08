package js224eh_lab3;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 6
 */
public class Point
{
    private int x, y;

    public Point()
    {
        this(0, 0);
    }

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public boolean isEqualTo(Point another)
    {
        return this.x == another.getX() && this.y == another.getY();
    }

    public void move(int x, int y)
    {
        this.x += x;
        this.y += y;
    }

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
