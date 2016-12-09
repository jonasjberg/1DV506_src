package js224eh_lab3.test;

import js224eh_lab3.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-12-06.
 */
@RunWith(Parameterized.class)
public class ArrayHasSubsequenceTest
{
    private int[] inputArray;
    private int[] inputSubArray;
    private boolean expectedResult;

    /* Varje parameter placeras som argument här. När en runner körs så skickar
     * den argumenten från parametrar definierade i testData()-metoden. */
    public ArrayHasSubsequenceTest(int[] inputArray, int[] inputSubArray,
                                   boolean expectedResult)
    {
        this.inputArray = inputArray;
        this.inputSubArray = inputSubArray;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return java.util.Arrays.asList(new Object[][] {
                { new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5 }, true },
                { new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 2, 1 }, false },
                { new int[] { 1, 2, 3, 4, 5 }, new int[] { 2, 1 }, false },
                { new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2 }, true },
                { new int[] { 1, 2, 3, 4, 5 }, new int[] { 2, 3 }, true },
                { new int[] { 1, 2, 3, 4, 5 }, new int[] { 0 }, false },
                { new int[] { 1, 2, 3, 4, 5 }, new int[] {}, false },
                { new int[] { 1 }, new int[] { 2 }, false },
                { new int[] {}, new int[] {}, false }
                });
    }

    @Test
    public void testArraysHasSubsequence()
    {
        Assert.assertEquals(expectedResult, Arrays
                .hasSubsequence(inputArray, inputSubArray));
    }
}