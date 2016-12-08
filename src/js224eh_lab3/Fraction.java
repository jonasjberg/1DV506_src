package js224eh_lab3;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 7
 */
public class Fraction
{
    private int numerator;
    private int denominator = 1;

    /**
     * Creates a new fraction from the given numerator and denominator.
     *
     * @param numerator The numerator of this new fraction.
     * @param denominator The denominator of this new fraction.
     *                    Throws an IllegalArgumentException if 0.
     */
    public Fraction(int numerator, int denominator)
    {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator must be non-zero");
        }

        if (denominator < 0) {
            this.numerator = numerator * -1;
            this.denominator = denominator * -1;
        }

        this.denominator = denominator;
        this.numerator = numerator;

        reduce();
    }

    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    /**
     * Tests if this fraction is negative.
     * @return True if this fraction is negative.
     */
    public boolean isNegative()
    {
        return this.numerator < 0;
    }

    /**
     * Adds two fractions using the formula:
     *
     * T1/N1 + T2/N2 = (T1*N2 + N1*T2)/(N1*N2)
     *
     * @param fraction The fraction to add to this fraction.
     * @return The sum of this fraction and operand as a new Fraction.
     */
    public Fraction add(Fraction fraction)
    {
        int t1      = numerator;
        int n1      = denominator;
        int t2      = fraction.getNumerator();
        int n2      = fraction.getDenominator();
        int resultT = (t1 * n2) + (n1 * t2);
        int resultN = n1 * n2;
        //int resultT = (numerator * fraction.getDenominator()) +
        //              (denominator * fraction.getNumerator());
        //int resultN = denominator * fraction.getDenominator();
        return new Fraction(resultT, resultN);
    }

    /**
     * Subtracts a fraction from this fraction.
     * Uses the formula:   T1/N1 - T2/N2 = (T1*N2 - N1*T2)/(N1*N2)
     *
     * @param fraction
     * @return
     */
    public Fraction subtract(Fraction fraction)
    {
        if (denominator == fraction.getDenominator()) {
            return new Fraction(numerator - fraction.getNumerator(),
                                denominator);
        } else {
            int resultT = (numerator * fraction.getDenominator()) -
                          (denominator * fraction.getNumerator());
            int resultN = denominator * fraction.getDenominator();
            return new Fraction(resultT, resultN);
        }
    }

    /**
     * Multiplies two fractions using the formula:
     *
     * (T1/N1)*(T2/N2) = (T1*T2)/(N1*N2)
     *
     * @param fraction
     * @return
     */
    public Fraction multiply(Fraction fraction)
    {
        int resultT = numerator * fraction.getNumerator();
        int resultN = denominator * fraction.getDenominator();
        return new Fraction(resultT, resultN);
    }

    /**
     * Calculates the greatest common divisor of this fractions numerator and
     * denominator.
     *
     * @return The greatest common divisor for the numerator and denominator of
     *         this fraction.
     */
    private int getGreatestCommonDivisor()
    {
        int tmp;
        int t = Math.abs(numerator);
        int n = Math.abs(denominator);

        while (t > 0) {
            tmp = t;
            t = n % t;
            n = tmp;
        }

        return n;
    }

    /**
     * Reduces this fraction to the smallest equivalent fraction.
     * Modifies the fraction in place, does not return a new instance.
     */
    public void reduce()
    {
        int scalar = getGreatestCommonDivisor();
        this.numerator /= scalar;
        this.denominator /= scalar;
    }

    /**
     * Tests if this fraction is equal to another fraction.
     * @param fraction The fraction to compare this fraction with.
     * @return True if this fraction is equivalent to the specified fraction.
     */
    public boolean isEqualTo(Fraction fraction)
    {
        return equals(fraction);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        } else if (!(o instanceof Fraction)) {
            return false;
        }

        Fraction fraction = (Fraction) o;
        return numerator == fraction.getNumerator() &&
               denominator == fraction.getDenominator();
    }

    @Override
    public String toString()
    {
        return String.format("%d/%d", this.numerator, this.denominator);
    }
}
