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


public class StackImplementation implements Stack
{
    final int DATA_STARTING_SIZE    = 32;
    final int DATA_RESIZE_INCREMENT = 8;

    private Object[] data;
    private int      topElementPointer;
    private int      currentSize;

    public StackImplementation()
    {
        data = new Object[DATA_STARTING_SIZE];
        currentSize = DATA_STARTING_SIZE;
        topElementPointer = 0;
    }

    /**
     * @return The current stack size.
     */
    @Override
    public int size()
    {
        return currentSize;
    }

    @Override
    public boolean isEmpty()
    {
        return topElementPointer < 0;
    }

    /**
     * Adds an element to the top of the stack.
     *
     * The stack size is increased by "DATA_RESIZE_INCREMENT" when the stack
     * is full. Available memory is plentiful so it is OK to allocate more
     * than what is currently needed right now.
     *
     * @param element The element to add.
     */
    @Override
    public void push(Object element)
    {
        /* Resize the "data" array in order to fit the new element. */
        if (topElementPointer == currentSize - 1) {
            Object[] temp = data.clone();
            data = new Object[currentSize + DATA_RESIZE_INCREMENT];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        } else {
            data[++topElementPointer] = element;
        }
    }

    /**
     * Returns and removes the top element.
     * An exception is thrown if the stack is empty.
     * @return The top-most element in the stack.
     */
    @Override
    public Object pop()
    {
        if (data.length == 0) {
            return null;
        }
        return null;
    }

    /**
     * Returns the top element without removing it.
     * An exception is thrown if the stack is empty.
     * @return The top-most element in the stack.
     */
    @Override
    public Object peek()
    {
        return null;
    }

    /**
     * Element iterator.
     * @return Iterable.
     */
    @Override
    public Iterator<Object> iterator()
    {
        return null;
    }
}
