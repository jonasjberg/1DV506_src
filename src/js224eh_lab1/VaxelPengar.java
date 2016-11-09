package js224eh_lab1;

import static js224eh_lab1.UserInputUtils.promptUserForPositiveNumber;

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

        final double purchaseCost   = promptUserForPositiveNumber(MSG_PROMPT_FOR_COST);
        final double amountReceived = promptUserForPositiveNumber(MSG_PROMPT_FOR_AMOUNT_RECEIVED);

        double changeToReturn = amountReceived - purchaseCost;

        int thousands = (int) changeToReturn / 1000;
        changeToReturn = changeToReturn % 1000;
        int fiveHundreds = (int) changeToReturn / 500;
        changeToReturn = changeToReturn % 500;
        int hundreds = (int) changeToReturn / 100;
        changeToReturn = changeToReturn % 100;
        int fifties = (int) changeToReturn / 50;
        changeToReturn = changeToReturn % 50;
        int twenties = (int) changeToReturn / 20;
        changeToReturn = changeToReturn % 20;
        int tens = (int) changeToReturn / 10;
        changeToReturn = changeToReturn % 10;
        int fives = (int) changeToReturn / 5;
        changeToReturn = changeToReturn % 5;
        int ones = (int) Math.round(changeToReturn);

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
}
