package js224eh_tentamen;

import java.util.Arrays;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-01-11.
 *
 * Skriv ett program, SumOfArray.java, som innehåller en metod som tar en
 * int-array som inparameter och som returnerar summan enligt nedan.
 *
 * Array’en gås igenom från första heltalet till det sista och för varje heltal
 * gäller följande regler vid summeringen:
 *
 * 1. Om heltalet är större än 3 så ska heltalet+10 adderas till summan.
 * 2. Om heltalet är på en jämn plats i array’en adderas heltalet*2 till summan.
 * 3. Om 1. eller 2. ovan ej uppfylls, adderas heltalet som det är till summan.
 *
 * Notera att om en regel uppfyllts för det aktuella heltalet skall eventuella
 * nästföljande kontroller inte utföras, t ex om 1. uppfylls så hoppar man över
 * 2. samt 3. och går vidare till nästa heltal i array’en.
 * Dessutom, om summan överstiger 30 så halveras alla heltalen medelst
 * heltalsdivision i array’en efter att detta inträffat (heltalen, inte
 * beräkningarna!).
 */
public class SumOfArray
{
    final static int[] TEST_ARRAY_1 = {1, 2, 3, 4, 5};
    final static int[] TEST_ARRAY_2 = {10, 20, 21, 300, 4000};

    public static void main(String[] args)
    {
        // int sum1 = calculateSumOfIntArray(TEST_ARRAY_1);
        // System.out.printf("Summan av %s = %d%n", Arrays.toString(TEST_ARRAY_1), sum1);
        printDemoCalculation(TEST_ARRAY_1);
        printDemoCalculation(TEST_ARRAY_2);

        // int sum2 = calculateSumOfIntArray(TEST_ARRAY_2);
        // System.out.printf("Summan av %s = %d%n", Arrays.toString(TEST_ARRAY_2), sum2);
    }

    private static void printDemoCalculation(int[] array)
    {
        int sum = calculateSumOfIntArray(array);
        System.out.printf("calculateSumOfIntArray(%s) = %d%n", Arrays.toString(array), sum);
    }

    private static int calculateSumOfIntArray(int[] array)
    {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            int number = array[i];

            if (sum > 30) {
                number /= 2;
            }

            if (number > 3) {
                sum += number + 10;
            } else if (i % 2 == 0) {
                sum += (number * 2);
            } else {
                sum += number;
            }
        }

        return sum;
    }
}
