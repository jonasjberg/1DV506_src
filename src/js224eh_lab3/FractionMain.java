package js224eh_lab3;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 7
 */
public class FractionMain
{
    public static void main(String[] args)
    {
        Fraction f1 = new Fraction(1, 2);
        printFractionInfo("f1", f1);


        Fraction f2 = new Fraction(1, -2);
        printFractionInfo("f2", f2);

        // try {
        //     Fraction f3 = new Fraction(1, 0);
        //     printFractionInfo(f3);
        // } catch (IllegalArgumentException e) {
        //     System.out.println("----------------------------------------");
        //     e.printStackTrace();
        // }

        Fraction sumOfF1F2 = f1.add(f2);
        printFractionInfo("sumOfF1F2", sumOfF1F2);

        Fraction f3 = new Fraction(3, 7);
        printFractionInfo("f3", f3);
        Fraction f4 = new Fraction(3, 1);
        printFractionInfo("f4", f4);

        Fraction sumOfF3F4 = f3.add(f4);
        printFractionInfo("sumOfF3F4", sumOfF3F4);

        /* Demonstrates reduce(), called internally. */
        Fraction f5 = new Fraction(50, 100);
        printFractionInfo("f5", f5);

        Fraction f6 = new Fraction(-50, 100);
        printFractionInfo("f6", f6);
    }

    private static void printFractionInfo(String fName, Fraction f)
    {
        System.out.println("----------------------------------------");
        System.out.println(fName);
        System.out.println(f);
        System.out.println("Numerator: " + f.getNumerator());
        System.out.println("Denominator: " + f.getDenominator());
        System.out.println("Negative: " + (f.isNegative() ? "true" : "false"));
    }
}
