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

        System.out.println("Created a new empty stack");
        System.out.println(stack);

        stack.push(new String("element1"));
        stack.push(new String("element2"));
        System.out.println("Pushed two elements to the stack");
        System.out.println(stack);

        System.out.printf("Peeking the stack: %s%n", stack.peek());

        stack.pop();
        System.out.println("Popped the stack");
        System.out.println(stack);

        System.out.printf("Peeking the stack: %s%n", stack.peek());

        stack.push(new String("element4"));
        stack.push(new String("prrrrrrr"));
        stack.push(new String("mjaooooo"));
        stack.push(new String("MJAAAOOO"));
        System.out.println("Pushed four elements to the stack");
        System.out.println(stack);

        System.out.println("Will attempt to pop the stack 5 times, "
                         + "anticipating an exception to be thrown");
        for (int i = 0; i <= 5; i++) {
            try {
                stack.pop();
            } catch (RuntimeException e) {
                System.out.printf("ERROR: %s%n", e.toString());
            }
        }
    }
}
