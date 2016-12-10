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
        assertTrue(Pnr.isFemaleNumber("850212-9029"));
        assertFalse(Pnr.isFemaleNumber("850212-7614"));
        assertTrue(Pnr.isFemaleNumber("820712-7567"));
    }

    @Test
    public void testIsMaleNumber() throws Exception
    {
        assertFalse(Pnr.isMaleNumber("850212-9029"));
        assertTrue(Pnr.isMaleNumber("860224-7614"));
        assertFalse(Pnr.isMaleNumber("820712-7567"));
    }

    @Test
    public void testAreEqual() throws Exception
    {
        assertFalse(Pnr.areEqual("850212-9029", "860224-7614"));
        assertTrue(Pnr.areEqual("860224-7614", "860224-7614"));
    }

    @Test
    public void testIsCorrect() throws Exception
    {
        assertFalse(Pnr.isCorrect(""));
        assertFalse(Pnr.isCorrect(" "));
        assertFalse(Pnr.isCorrect("abc"));
        assertFalse(Pnr.isCorrect("-1"));
        assertFalse(Pnr.isCorrect("198602247614"));
        assertFalse(Pnr.isCorrect("19860224 7614"));
        assertFalse(Pnr.isCorrect("1986022417614"));
        assertFalse(Pnr.isCorrect("8602247614"));
        assertFalse(Pnr.isCorrect("860224 7614"));
        assertFalse(Pnr.isCorrect("86022417614"));
        assertFalse(Pnr.isCorrect("860224-7612"));
        assertFalse(Pnr.isCorrect("860224-7613"));
        assertFalse(Pnr.isCorrect("860224-7615"));
        assertTrue(Pnr.isCorrect("860224-7614"));
        assertTrue(Pnr.isCorrect("820712-7567"));
    }
}