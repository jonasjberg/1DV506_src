package js224eh_lab3.test;

import js224eh_lab3.Fraction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 */
public class FractionTest
{
    private Fraction f1, f2, f3, f4;
    @Before
    public void setup()
    {
        System.out.println("BEFORE TESTS");
        f1 = new Fraction(3, 7);
        f2 = new Fraction(3, 1);
        f3 = new Fraction(1, 2);
        f4 = new Fraction(-1, 2);
    }

    @Test
    public void testGetNumerator() throws Exception
    {
        assertEquals(3, f1.getNumerator());
        assertEquals(3, f2.getNumerator());
    }

    @Test
    public void testGetDenominator() throws Exception
    {
        assertEquals(7, f1.getDenominator());
        assertEquals(1, f2.getDenominator());
    }

    @Test
    public void testIsNegative() throws Exception
    {

    }

    @Test
    public void testAdd() throws Exception
    {
        assertEquals(new Fraction(24, 7), f1.add(f2));
        assertEquals(new Fraction(0, 1), f3.add(f4));
    }

    @Test
    public void testMultiply() throws Exception
    {

    }

    @Test
    public void testToString() throws Exception
    {
        assertEquals("", "");
    }

}