package js224eh_lab3.test;

import js224eh_lab3.Pnr;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 */
public class PnrTest
{
    @Test
    public void testGetFirstPart() throws Exception
    {
        assertEquals("860212", Pnr.getFirstPart("860212-1224"));
        assertEquals("", Pnr.getFirstPart(":"));
        assertEquals("", Pnr.getFirstPart(" "));
        assertEquals("", Pnr.getFirstPart(""));
    }

    @Test
    public void testGetSecondPart() throws Exception
    {
        assertEquals("1224", Pnr.getSecondPart("860212-1224"));
        assertEquals("", Pnr.getSecondPart(":"));
        assertEquals("", Pnr.getSecondPart(" "));
        assertEquals("", Pnr.getSecondPart(""));
    }

    @Test
    public void testIsFemaleNumber() throws Exception
    {
        assertEquals(true, Pnr.isFemaleNumber("19850212-9029"));
        assertEquals(false, Pnr.isFemaleNumber("19850212-7614"));
    }

    @Test
    public void testIsMaleNumber() throws Exception
    {
        assertEquals(false, Pnr.isMaleNumber("19850212-9029"));
        assertEquals(true, Pnr.isMaleNumber("19860224-7614"));
    }

    @Test
    public void testAreEqual() throws Exception
    {
        assertEquals(false, Pnr.areEqual("19850212-9029", "19860224-7614"));
        assertEquals(true, Pnr.areEqual("19860224-7614", "19860224-7614"));
    }

    @Test
    public void testIsCorrect() throws Exception
    {
        assertEquals(false, Pnr.isMaleNumber(""));
        assertEquals(false, Pnr.isMaleNumber(" "));
        assertEquals(false, Pnr.isMaleNumber("198602247614"));
        assertEquals(false, Pnr.isMaleNumber("19860224 7614"));
        assertEquals(false, Pnr.isMaleNumber("1986022417614"));
        assertEquals(false, Pnr.isMaleNumber("1986022417614"));
        assertEquals(true, Pnr.isMaleNumber("19860224-7614"));
    }
}