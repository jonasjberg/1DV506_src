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

        printStackInfo(stack);
        stack.push(new String("element1"));
        stack.push(new String("element2"));
        printStackInfo(stack);
        stack.pop();
        stack.push(new String("element3"));
        printStackInfo(stack);
    }

    public static void printStackInfo(Stack stack)
    {
        String FORMAT = "%-20.20s : %s%n";
        System.out.printf("%n--------------------%n");
        System.out.printf(FORMAT, "stack.size()", stack.size());
        System.out.printf(FORMAT, "stack.isEmpty()", stack.isEmpty());

        System.out.printf("Stack contents:%n");

        Iterator<Object> iterator = stack.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.print(o + "  ");
        }
    }
}
