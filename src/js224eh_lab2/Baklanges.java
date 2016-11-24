package js224eh_lab2;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-11-24.
 *
 * Skriv ett program Baklanges.java som läser in en textrad från tangent bordet
 * och sedan skriver ut den baklänges. En körning kan se ut enligt följande:
 * 
 *     Mata in en textrad: Anakin Skywalker 
 *     Baklänges: reklawykS nikanA 
 *
 * Notera: Du förväntas lösa denna uppgift genom att iterera över den inlästa
 *         strängen baklänges.
 */
public class Baklanges {
    public static void main(String[] args) {
        String text = UserInputUtils.promptForTextLine("Mata in en textrad: ");

        System.out.print("Baklänges: ");
        for (int i = text.length() - 1; i >= 0; i--) {
            System.out.print(text.charAt(i));
        }

        System.exit(0);
    }
}
