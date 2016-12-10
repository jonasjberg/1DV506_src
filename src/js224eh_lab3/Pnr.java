package js224eh_lab3;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 2
 */
public class Pnr {
    public static void main(String[] args) {
        String personNummer = "860224-7614";
        String personNummer2 = "860220-7614";
        String FORMAT = "%-38.38s: %s%n";
        System.out.printf(FORMAT, "personNummer", personNummer);
        System.out.printf(FORMAT, "getFirstPart(personNummer)", getFirstPart(personNummer));
        System.out.printf(FORMAT, "getSecondPart(personNummer)", getSecondPart(personNummer));
        System.out.printf(FORMAT, "isFemaleNumber(personNummer)", isFemaleNumber(personNummer));
        System.out.printf(FORMAT, "isMaleNumber(personNummer)", isMaleNumber(personNummer));
        System.out.printf(FORMAT, "personNummer2", personNummer2);
        System.out.printf(FORMAT, "areEqual(personNummer, personNummer2)", areEqual(personNummer, personNummer2));
        System.out.printf(FORMAT, "isCorrect(personNummer)", isCorrect(personNummer));
        System.out.printf(FORMAT, "isCorrect(personNummer2)", isCorrect(personNummer2));
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

    public static boolean areEqual(String personalOne, String personalTwo)
    {
        return personalOne.equals(personalTwo);
    }

    /**
     * Validates the personal.
     *
     * @param personal The personal to validate.
     * @return True if the personal is correct, otherwise false.
     */
    public static boolean isCorrect(String personal)
    {
        String  firstPart       = getFirstPart(personal);
        String  secondPart      = getSecondPart(personal);
        boolean firstPartValid  = false;
        boolean secondPartValid = false;

        if (firstPart.length() != 6 || secondPart.length() != 4) {
            return false;
        }

        int year  = Integer.parseInt(firstPart.substring(0, 2));
        int month = Integer.parseInt(firstPart.substring(2, 4));
        int day   = Integer.parseInt(firstPart.substring(4, 6));
        if ((year >= 0 && year <= 99) &&
            (month > 0 && month <= 12) &&
            (day > 1 && day <= 31)) {
            firstPartValid = true;
        }

        int sum = 0;
        boolean multiplyByTwoBistable = true;
        for (char c : personal.toCharArray()) {
            if (!Character.isDigit(c)) {
                continue;
            }

            int digit = Character.getNumericValue(c);
            if (multiplyByTwoBistable) {
                digit *= 2;
            }
            while (digit > 0) {
                sum = sum + digit % 10;
                digit = digit / 10;
            }

            multiplyByTwoBistable = !multiplyByTwoBistable;
        }

        int nextPowerOfTen = 0;
        while (sum >= nextPowerOfTen) {
            nextPowerOfTen += 10;
        }

        int controlDigit = nextPowerOfTen - sum;

        if (controlDigit % 10 == 0) {
            secondPartValid = true;
        }

        return firstPartValid && secondPartValid;
    }
}
