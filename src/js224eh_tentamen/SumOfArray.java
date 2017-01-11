package js224eh_tentamen;

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
    final static int[] TEST_NUMBERS = {1, 2, 3, 4, 5};

    public static void main(String[] args)
    {
        int sum = getSumOfIntArray(TEST_NUMBERS);
        System.out.println(sum);
    }

    private static int getSumOfIntArray(int[] array)
    {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            int number = array[i];

            if (sum > 30) {
                number /= 2;
            }

            if (number > 3) {
                sum += number + 10;
            } else if (i % 2 != 0) {
                sum += (number * 2);
            } else {
                sum += number;
            }
        }

        return sum;
    }
}
