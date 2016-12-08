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

    public Fraction(int numerator, int denominator)
    {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator must be non-zero");
        }

        if (denominator < 0) {
            this.numerator =  numerator * -1;
            this.denominator = denominator * -1;
        }

        // if (numerator == 0) {
        //     this.denominator = 0;
        //     this.numerator = 0;
        // } else {
            this.denominator = denominator;
            this.numerator = numerator;
        // }

        if (this.denominator == this.numerator) {
            this.denominator = 1;
            this.numerator = 1;
        }
    }

    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public boolean isNegative()
    {
        return this.numerator < 0;
    }

    /**
     * Adds two fractions using the formula:
     *
     *     T1/N1 + T2/N2 = (T1*N2 + N1*T2)/(N1*N2)
     *
     * @param fraction The fraction to add to this fraction.
     * @return The sum of this fraction and operand as a new Fraction.
     */
    public Fraction add(Fraction fraction)
    {
        int t1 = numerator;
        int n1 = denominator;
        int t2 = fraction.getNumerator();
        int n2 = fraction.getDenominator();
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
     * @param fraction
     * @return
     */
    public Fraction subtract(Fraction fraction)
    {
        if (denominator == fraction.getDenominator()) {
            return new Fraction(numerator - fraction.getNumerator(), denominator);
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
     *     (T1/N1)*(T2/N2) = (T1*T2)/(N1*N2)
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

    public boolean isEqualTo(Fraction fraction)
    {
        return equals(fraction);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) {
            return true;
        }

        else if(!(o instanceof Fraction)) {
            return false;
        }

        Fraction fraction = (Fraction)o;
        return numerator == fraction.getNumerator() &&
               denominator == fraction.getDenominator();
    }

    @Override
    public String toString()
    {
        return String.format("%d/%d", this.numerator, this.denominator);
    }
}
