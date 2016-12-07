package js224eh_lab3;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-12-06.
 *
 * Laboration 3  --  Uppgift 1
* */
public class Arrays
{
    public static void main(String[] args)
    {
        int[]  n   = {3, 4, 5, 6, 7};
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

        System.out.println(Arrays.hasSubsequence(new int[] {1, 2, 3, 4, 5},
                                                 new int[] {3, 4, 5}));

    }

    private static int sum(int[] arr)
    {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }

    private static String toString(int[] arr)
    {
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

    private static int[] addN(int[] arr, int n)
    {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] + n;
        }

        return result;
    }

    private static int[] reverse(int[] arr)
    {
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] = arr[arr.length - 1 - i];
        }

        return result;
    }

    private static boolean hasN(int[] arr, int n)
    {
        for (int i : arr) {
            if (i == n) {
                return true;
            }
        }

        return false;
    }

    private static void replaceAll(int[] arr, int old, int nw)
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == old) {
                arr[i] = nw;
            }
        }
    }

    public static int[] sort(int[] arr)
    {
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

    public static boolean hasSubsequence(int[] arr, int[] sub)
    {
        if (sub.length > arr.length) {
            return false;
        } else if (arr.length == 0 || sub.length == 0) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < sub.length; j++) {
                if (!(sub[j] == arr[j + i])) {
                    System.out.println("Testing if " + sub[j] + " == " + arr[j + i]);
                    break;
                }

                return true;
            }
        }

        return false;
    }
}
