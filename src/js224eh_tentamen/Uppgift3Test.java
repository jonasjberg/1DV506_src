package js224eh_tentamen;

/**
 * Created by Jonas Sjöberg (js224eh) on 2017-01-11.
 */
public class Uppgift3Test
{
    public static void main(String[] args)
    {
        printNumber(42);         // Anropar printNumber(int number)
        printNumber(4.2f);       // Anropar printNumber(float number)
        printNumber(42, 4.20);   // Anropar printNumber(int number1, int number2)
        printNumber(42, 1337);   // Anropar printNumber(int number1, int number2)
    }

    private static void printNumber(float v)
    {
        System.out.println(v);
    }


    private static void printNumber(int i, int i1)
    {
        System.out.println(i + " " + i1);
    }

    private static void printNumber(int i, double i1)
    {
        System.out.println(i + " " + i1);
    }

    private static void printNumber(int i)
    {
        System.out.println(i);
    }
}
