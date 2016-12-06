package js224eh_lab3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-12-06.
 */
@RunWith(Parameterized.class)
public class ArraySortTest
{
    private int[] inputArray;
    private int[] expectedResult;

    /* Varje parameter placeras som argument här. När en runner körs så skickar
     * den argumenten från parametrar definierade i testData()-metoden. */
    public ArraySortTest(int[] inputArray, int[] expectedResult)
    {
        this.inputArray = inputArray;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return java.util.Arrays.asList(new Object[][] {
                { new int[] { 3, 4, 5, 6, 7 }, new int[] { 3, 4, 5, 6, 7 } },
                { new int[] { 7, 6, 5, 4, 3 }, new int[] { 3, 4, 5, 6, 7 } },
                { new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 } },
                { new int[] { 1, 1, 1 }, new int[] { 1, 1, 1 } },
                { new int[] { 1 }, new int[] { 1 } },
                { new int[] { 0 }, new int[] { 0 } },
                { new int[] {}, new int[] {} },
                });
    }

    @Test
    public void testArraysSort()
    {
        assertArrayEquals(expectedResult, Arrays.sort(inputArray));
    }
}