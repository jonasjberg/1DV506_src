package js224eh_lab3;

import java.util.ArrayList;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 2
 */
public class Pnr
{
    public static void main(String[] args)
    {

    }

    public static String getFirstPart(String personal)
    {
        if (personal.isEmpty() || !personal.contains("-")) {
            return "";
        }
        return personal.split("-")[0];
    }


    public static String getSecondPart(String personal)
    {
        if (personal.isEmpty() || !personal.contains("-")) {
            return "";
        }
        return personal.split("-")[1];
    }

    /*
     * De tre första siffrorna efter skiljetecknet är personnumrets
     * födelsenummer, som består av ett löpnummer där tredje siffran anger
     * personens kön -- jämn siffra för kvinnor och udda för män.
     * https://sv.wikipedia.org/wiki/Personnummer_i_Sverige
     */
    public static boolean isFemaleNumber(String personal)
    {
        String secondPart = getSecondPart(personal);
        if (secondPart.length() == 4) {
            return secondPart.charAt(2) % 2 == 0;
        }
        return false;
    }

    public static boolean isMaleNumber(String personal)
    {
        String secondPart = getSecondPart(personal);
        if (secondPart.length() == 4) {
            return secondPart.charAt(2) % 2 != 0;
        }
        return false;
    }

    public static boolean isCorrect(String personal)
    {
        String  firstPart       = getFirstPart(personal);
        String  secondPart      = getSecondPart(personal);
        boolean firstPartValid  = false;
        boolean secondPartValid = false;

        if (!(firstPart.length() == 6 && secondPart.length() == 4)) {
            return false;
        }

        int year  = Integer.parseInt(firstPart.substring(0, 1));
        int month = Integer.parseInt(firstPart.substring(2, 3));
        int day   = Integer.parseInt(firstPart.substring(4, 5));
        if ((year >= 0 && year <= 99) &&
            (month > 0 && month <= 12) &&
            (day > 1 && day <= 31)) {
            firstPartValid = true;
        }

        int[] doubledDigits = new int[9];
        ArrayList<Integer> splitProducts = new ArrayList<>();

        for (int i = 0; i < secondPart.length(); i++) {
            if (Character.isDigit(secondPart.charAt(i))) {
                int digit = Integer.parseInt(String.valueOf(secondPart.charAt(i)));

                char[] digits = Character.toChars(digit);
                splitProducts.add(Integer.parseInt(String.valueOf(digit)))
            }
        }

        for (int i = 0; i < doubledDigits.length; i++) {

        }

        return firstPartValid && secondPartValid;
    }
}
