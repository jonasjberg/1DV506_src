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
        int[] n = {3,4,5,6,7};
        String str = Arrays.toString(n);
        System.out.println("n = " + str);
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
}
