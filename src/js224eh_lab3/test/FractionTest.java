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
    private Fraction f1, f2, f3, f4, f5;

    @Before
    public void setup()
    {
        f1 = new Fraction(3, 7);
        f2 = new Fraction(3, 1);
        f3 = new Fraction(1, 2);
        f4 = new Fraction(-1, 2);
        f5 = new Fraction(50, 100);
    }

    @Test
    public void testGetNumerator() throws Exception
    {
        assertEquals(3, f1.getNumerator());
        assertEquals(3, f2.getNumerator());
        assertEquals(1, f3.getNumerator());
        assertEquals(-1, f4.getNumerator());
        assertEquals(1, f5.getNumerator());
    }

    @Test
    public void testGetDenominator() throws Exception
    {
        assertEquals(7, f1.getDenominator());
        assertEquals(1, f2.getDenominator());
        assertEquals(2, f3.getDenominator());
        assertEquals(2, f4.getDenominator());
        assertEquals(2, f5.getDenominator());
    }

    @Test
    public void testIsNegative() throws Exception
    {
        assertFalse(f1.isNegative());
        assertFalse(f2.isNegative());
        assertFalse(f3.isNegative());
        assertTrue(f4.isNegative());
        assertFalse(f5.isNegative());
    }

    @Test
    public void testAdd() throws Exception
    {
        assertEquals(new Fraction(24, 7), f1.add(f2));
        assertEquals(new Fraction(0, 4), f3.add(f4));
    }

    @Test
    public void testSubtract() throws Exception
    {
        assertEquals(new Fraction(0, 7), f1.subtract(f1));
        assertEquals(new Fraction(-18, 7), f1.subtract(f2));
        assertEquals(new Fraction(-1, 14), f1.subtract(f3));
        assertEquals(new Fraction(13, 14), f1.subtract(f4));
        assertEquals(new Fraction(18, 7), f2.subtract(f1));
        assertEquals(new Fraction(0, 1), f2.subtract(f2));
        assertEquals(new Fraction(5, 2), f2.subtract(f3));
        assertEquals(new Fraction(7, 2), f2.subtract(f4));
        assertEquals(new Fraction(1, 1), f3.subtract(f4));
    }

    @Test
    public void testMultiply() throws Exception
    {
        assertEquals(new Fraction(9, 7), f1.multiply(f2));
        assertEquals(new Fraction(-1, 4), f3.multiply(f4));
    }

    @Test
    public void testIsEqualTo() throws Exception
    {
        assertTrue(f1.isEqualTo(f1));
        assertTrue(f1.isEqualTo(new Fraction(3, 7)));
        assertTrue(f2.isEqualTo(f2));
        assertTrue(f2.isEqualTo(new Fraction(3, 1)));
        assertFalse(f1.isEqualTo(f2));
        assertFalse(f2.isEqualTo(f1));
        assertFalse(f3.isEqualTo(f4));
        assertFalse(f4.isEqualTo(f3));
        assertTrue(f4.isEqualTo(new Fraction(-1, 2)));
    }

    @Test
    public void testToString() throws Exception
    {
        assertEquals("3/7", f1.toString());
        assertEquals("3/1", f2.toString());
        assertEquals("1/2", f3.toString());
        assertEquals("-1/2", f4.toString());
        assertEquals("1/2", f5.toString());
    }
}