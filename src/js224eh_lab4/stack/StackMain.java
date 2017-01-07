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

import java.util.Iterator;


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

        stack.pop();
        System.out.println("Popped the stack");
        System.out.println(stack);

        stack.push(new String("element3"));
        System.out.println("Pushed an element to the stack");
        System.out.println(stack);
    }
}
