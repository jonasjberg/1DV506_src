package js224eh_lab3.test;

import js224eh_lab3.Arrays;

/**
 * Created by spock on 2016-12-09.
 */
public class ArrayHasSubsequenceMain {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] subTrue = {1, 2};
        int[] subFalse = {2, 1};
        System.out.println(Arrays.hasSubsequence(array, subTrue));
        System.out.println(Arrays.hasSubsequence(array, subFalse));
    }
}
