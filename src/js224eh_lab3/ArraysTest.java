package js224eh_lab3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-12-06.
 */
public class ArraysTest
{
    @Test
    public void main() throws Exception
    {
        int[] input1   =   {3, 4, 5, 6, 7};
        int[] expect1   = {3, 4, 5, 6, 7};

        int[] input2   =   {7, 4, 5, 6, 3};
        int[] expect2   = {3, 4, 5, 6, 7};

        int[] input3   =   {7, 6, 4, 5, 3};
        int[] expect3   = {3, 4, 5, 6, 7};

        int[] input4   =   {7, 0, 6, 4, 5, 3, -1};
        int[] expect4   =  {-1, 0, 3, 4, 5, 6, 7};

        assertArrayEquals(Arrays.sort(input1), expect1);
        assertArrayEquals(Arrays.sort(input2), expect2);
        assertArrayEquals(Arrays.sort(input3), expect3);
        assertArrayEquals(Arrays.sort(input4), expect4);
    }

}