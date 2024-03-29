package js224eh_lab3;

/**
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

    /**
     * Returns the first part (last 4 digits) of the personal.
     * @param personal The personal to get the first part of.
     * @return The first part of the personal.
     */
    public static String getFirstPart(String personal) {
        if (personal.isEmpty() || !personal.contains("-")) {
            return "";
        }
        return personal.split("-")[0];
    }

    /**
     * Returns the second part (last 4 digits) of the personal.
     * @param personal The personal to get the second part of.
     * @return The second part of the personal.
     */
    public static String getSecondPart(String personal) {
        if (personal.isEmpty() || !personal.contains("-")) {
            return "";
        }
        return personal.split("-")[1];
    }

    /**
     * Returns whether the personal belongs to a female person.
     *
     * "De tre första siffrorna efter skiljetecknet är personnumrets
     *  födelsenummer, som består av ett löpnummer där tredje siffran anger
     *  personens kön -- jämn siffra för kvinnor och udda för män."
     *  https://sv.wikipedia.org/wiki/Personnummer_i_Sverige
     *
     * @param personal The personal to test.
     * @return True if the personal belongs to a female person, else False.
     */
    public static boolean isFemaleNumber(String personal) {
        String secondPart = getSecondPart(personal);
        if (secondPart.length() == 4) {
            int thirdDigit = Character.getNumericValue(secondPart.charAt(2));
            return (thirdDigit % 2 == 0);
        }
        return false;
    }

    /**
     * Returns whether the personal belongs to a male person.
     * @param personal The personal to test.
     * @return True if the personal belongs to a male person, else False.
     */
    public static boolean isMaleNumber(String personal) {
        String secondPart = getSecondPart(personal);
        if (secondPart.length() == 4) {
            int thirdDigit = Character.getNumericValue(secondPart.charAt(2));
            return (thirdDigit % 2 != 0);
        }
        return false;
    }

    /**
     * Tests if two personals are equal.
     * @param personalOne The first personal to compare.
     * @param personalTwo The second personal to compare.
     * @return True if the personals are equal, else False.
     */
    public static boolean areEqual(String personalOne, String personalTwo)
    {
        return personalOne.equals(personalTwo);
    }

    /**
     * Validates the personal.
     *
     * Checks that the date is a valid date and tests the control digit for validity.
     * Uses validation technique from  https://sv.wikipedia.org/wiki/Luhn-algoritmen
     *
     * @param personal The personal to validate.
     * @return True if the personal is correct, otherwise false.
     */
    public static boolean isCorrect(String personal) {
        String firstPart = getFirstPart(personal);
        String secondPart = getSecondPart(personal);

        if (firstPart.length() != 6 || secondPart.length() != 4) {
            return false;
        }

        /* Check for valid date. */
        int year = Integer.parseInt(firstPart.substring(0, 2));
        int month = Integer.parseInt(firstPart.substring(2, 4));
        int day = Integer.parseInt(firstPart.substring(4, 6));
        if (!((year >= 0 && year <= 99) &&
            (month > 0 && month <= 12) &&
            (day > 1 && day <= 31))) {
            return false;
        }

        /* Validate control digit. */
        int sum = 0;
        boolean multiplyByTwoBistable = true;
        for (char c : personal.toCharArray()) {
            if (!Character.isDigit(c)) {
                continue;
            }

            /* Multiply every other digit by 2. */
            int digit = Character.getNumericValue(c);
            if (multiplyByTwoBistable) {
                digit *= 2;
            }

            /* Split numbers into digits and add to running sum. */
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
        return controlDigit % 10 == 0;
    }
}
