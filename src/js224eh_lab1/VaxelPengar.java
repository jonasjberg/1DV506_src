package js224eh_lab1;

import java.util.Scanner;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-07.
 *
 * Lektion 2 - (Input/Output, Operations on Primitive Types)
 *
 * 11. Växelpengar (VG-uppgift)
 *     Då du handlar i en affär och betalar kontant får du kanske växel
 *     tillbaka. I regel får affärsbiträdet hjälp av kassaapparaten med att
 *     beräkna summan man ska få tillbaka. Vilka sedlar och mynt som ska lämnas
 *     tillbaka får affärsbiträdet själv räkna ut i huvudet. Kan ett program
 *     göra samma sak?
 *
 *     Skriv ett program VaxelPengar.java som beräknar den växel du får tillbaka
 *     i samband med ett köp. Programmet ska, förutom att presentera beloppet
 *     kunden får tillbaka avrundat till närmaste hela krona, även bestämma
 *     vilka, och antalet, sedlar och mynt som kunden ska få tillbaka så att så
 *     få sedlar och mynt används som möjligt. Programmet ska kunna ge växel
 *     tillbaka med sedlar av valörerna 1000, 500, 100, 50 och 20 samt mynten
 *     10, 5 och 1 krona. Du kan anta att det alltid finns tillräckligt antal av
 *     de sedlar och mynt som krävs.
 *
 *         Ange kostnaden: 372,38
 *         Ange erhållet belopp: 1000
 *         Tillbaka: 628 kronor
 *         1000-lappar: 0
 *         500-lappar: 1
 *         100-lappar: 1
 *         50-lappar: 0
 *         20-lappar: 1
 *         10-kronor: 0
 *         5-kronor: 1
 *         1-kronor: 3
 *
 */
public class VaxelPengar
{
    public static void main(String[] args)
    {
        final String MSG_PROMPT_FOR_COST            = "Ange kostnaden: ";
        final String MSG_PROMPT_FOR_AMOUNT_RECEIVED = "Ange erhållet belopp: ";

        final double purchaseCost   = promptUserForNumber(MSG_PROMPT_FOR_COST);
        final double amountReceived = promptUserForNumber(MSG_PROMPT_FOR_AMOUNT_RECEIVED);

        double changeToPay = amountReceived - purchaseCost;

        int thousands = (int) changeToPay / 1000;
        changeToPay = changeToPay % 1000;
        int fiveHundreds = (int) changeToPay / 500;
        changeToPay = changeToPay % 500;
        int hundreds = (int) changeToPay / 100;
        changeToPay = changeToPay % 100;
        int fifties = (int) changeToPay / 50;
        changeToPay = changeToPay % 50;
        int twenties = (int) changeToPay / 20;
        changeToPay = changeToPay % 20;
        int tens = (int) changeToPay / 10;
        changeToPay = changeToPay % 10;
        int fives = (int) changeToPay / 5;
        changeToPay = changeToPay % 5;
        int ones = (int) Math.round(changeToPay);

        System.out.printf("1000-lappar: %d\n" +
                          " 500-lappar: %d\n" +
                          " 100-lappar: %d\n" +
                          "  50-lappar: %d\n" +
                          "  20-lappar: %d\n" +
                          "  10-kronor: %d\n" +
                          "   5-kronor: %d\n" +
                          "   1-kronor: %d\n",
                          thousands, fiveHundreds, hundreds, fifties,
                          twenties, tens, fives, ones);
    }

    /**
     * Prints a message to the user.
     *
     * @param message The message to print. Must not be empty.
     */
    private static void queryUser(String message)
    {
        if (message != null && message.length() > 0) {
            System.out.print(message);
        }
    }

    /**
     * Prompts the user for a number.
     *
     * The message is shown continuously until the user has entered a valid
     * number. Any leading and trailing whitespace is removed.
     *
     * @param strPromptForLine The message to display when prompting for input.
     * @return The number entered by the user.
     */
    private static double promptUserForNumber(String strPromptForLine)
    {
        Scanner scan      = new Scanner(System.in);
        String  userInput = null;
        double  number;

        do {
            queryUser(strPromptForLine);

            while (!scan.hasNextDouble()) {
                queryUser(strPromptForLine);
                scan.next();
            }
            number = scan.nextDouble();

        } while (number <= 0);

        return number;
    }
}
