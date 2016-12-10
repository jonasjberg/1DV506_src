package js224eh_lab3;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-12-06.
 *
 * Laboration 3  --  Uppgift 1
* */
public class Arrays {
    public static void main(String[] args) {
        int[] n = {3, 4, 5, 6, 7};
        String str = Arrays.toString(n);
        System.out.println("n = " + str);

        System.out.println("nSum = " + Arrays.sum(n));

        int[] nAdded = Arrays.addN(n, 6);
        System.out.println("nAdded = " + Arrays.toString(nAdded));

        int[] nReversed = Arrays.reverse(n);
        System.out.println("nReversed = " + Arrays.toString(nReversed));

        System.out.println("hasN (N=6) = " + Arrays.hasN(n, 6));

        Arrays.replaceAll(n, 6, 667);
        System.out.println("nReplacedAll = " + Arrays.toString(n));

        int[] nSorted = Arrays.sort(n);
        System.out.println("nSorted = " + Arrays.toString(nSorted));

        System.out.println(Arrays.hasSubsequence(new int[]{1, 2, 3, 4, 5},
                new int[]{3, 4, 5}));

    }

    /**
     * Returns the sum of all elements in the array "arr".
     * @param arr The array to calculate sum from.
     * @return The sum of all elements in the array "arr".
     */
    private static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }

    /**
     * Returns a human readable string representation of the array.
     * @param arr The array to get a string representation of.
     * @return A string representation of the array "arr" as a String.
     */
    private static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(arr[i]);
        }

        sb.append("]");
        return sb.toString();
    }

    /**
     * Adds a integer "n" to all elements of the array "arr".
     * @param arr The array to which the integers are added.
     * @param n The integer to add to the array.
     * @return A new array with the "n" added to all elements of "arr".
     */
    private static int[] addN(int[] arr, int n) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] + n;
        }

        return result;
    }

    /**
     * Reverses the order of array "arr".
     * @param arr The array to reverse.
     * @return A new array with the elements of "arr" in reverse order.
     */
    private static int[] reverse(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] = arr[arr.length - 1 - i];
        }

        return result;
    }

    /**
     * Tests if the array "arr" contains the element "n".
     * @param arr The array to test.
     * @param n The element to test.
     * @return True if the array "arr" contains the element "n", else False.
     */
    private static boolean hasN(int[] arr, int n) {
        for (int i : arr) {
            if (i == n) {
                return true;
            }
        }

        return false;
    }

    /**
     * Replaces all instances of "old" with "nw" in the array "arr".
     * @param arr The array to replace elements in.
     * @param old The element to replace.
     * @param nw The element that "old" is substituted with.
     */
    private static void replaceAll(int[] arr, int old, int nw) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == old) {
                arr[i] = nw;
            }
        }
    }

    /**
     * Sorts the array using a variant of the "bubble sort" algorithm.
     * @param arr The array to sort.
     * @return A new sorted version of "arr".
     */
    public static int[] sort(int[] arr) {
        int[] result = arr.clone();

        /* Gå parvis och byt plats inom paret så att det mindre talet hamnar
         * före det större. Fortsätt tills inget av paren behövs korrigeras.
         * Det är alltså någon variant av "bubble sort".
         * https://en.wikipedia.org/wiki/Bubble_sort
         */
        boolean doAnotherPass;
        do {
            doAnotherPass = false;

            for (int i = 0; i < arr.length - 1; i++) {
                int elemOne = result[i];
                int elemTwo = result[i + 1];

                if (elemOne > elemTwo) {
                    /* Byt plats på talen i det aktuella paret. */
                    result[i] = elemTwo;
                    result[i + 1] = elemOne;
                    doAnotherPass = true;
                } else {
                    result[i] = elemOne;
                    result[i + 1] = elemTwo;
                }
            }

        } while (doAnotherPass);

        return result;
    }

    /**
     * Test if the array "arr" contains the array "sub" as a subarray,
     * all elements must be sequential.
     * @param arr The array to test for subarray.
     * @param sub The subarray to test.
     * @return True if the array "arr" contains the subsequence "sub", else False.
     */
    public static boolean hasSubsequence(int[] arr, int[] sub) {
        if (sub.length > arr.length) {
            return false;
        } else if (arr.length == 0 || sub.length == 0) {
            return false;
        }

        int offset = 0;
        boolean foundMatch;
        while (offset < arr.length) {

            foundMatch = true;
            for (int i = 0; i < sub.length; i++) {
                if (offset > arr.length - sub.length) {
                    return false;
                }
                if (arr[i + offset] != sub[i]) {
                    foundMatch = false;
                }
            }

            if (foundMatch) {
                return true;
            }
            offset++;
        }

        return false;
    }
}
