/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Created by Jonas Sjöberg (js224eh) on 2017-01-07.
 *
 * 1DV506 -- Problemlösning och Programmering, HT2016
 * Laboration 4: Exceptions, IO och interface
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * Uppgift 3
 * =========
 */

package js224eh_lab4.stack;

public class StackMain
{
    public static void main(String[] args)
    {
        Stack stack = new StackImplementation();

        System.out.println("\nCreated a new empty stack");
        System.out.println(stack);

        stack.push("element1");
        stack.push("element2");
        System.out.println("\nPushed two elements to the stack");
        System.out.println(stack);

        System.out.println(String.format("\nPeeking the stack: [%s]", stack.peek()));

        stack.pop();
        System.out.println("\nPopped the stack");
        System.out.println(stack);

        System.out.println(String.format("\nPeeking the stack: [%s]", stack.peek()));

        stack.pop();
        System.out.println("\nPopped the stack");
        System.out.println(stack);

        System.out.println("\nPeeking the stack, expecting an exception to be thrown:");
        try {
            System.out.println(String.format("[%s]", stack.peek()));
        } catch (RuntimeException e) {
            System.out.printf("ERROR: %s%n", e.toString());
        }

        stack.push("element4");
        stack.push("prrrrrrr");
        stack.push("mjaooooo");
        stack.push("MJAAAOOO");
        System.out.println("\nPushed four elements to the stack");
        System.out.println(stack);

        System.out.println("\nWill attempt to pop the stack 5 times, "
                   + "anticipating an exception to be thrown");
        for (int i = 0; i <= 5; i++) {
            try {
                stack.pop();
            } catch (RuntimeException e) {
                System.out.printf("ERROR: %s%n", e.toString());
            }
        }

        System.out.println(stack);
    }
}
