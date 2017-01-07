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
    final int STACK_DEFAULT_SIZE     = 32;
    final int STACK_RESIZE_INCREMENT = 8;

    private Object[] data;
    private int      topElementPointer;

    public StackImplementation()
    {
        data = new Object[STACK_DEFAULT_SIZE];
        topElementPointer = -1;
    }

    /**
     * @return The current stack size.
     */
    @Override
    public int size()
    {
        return topElementPointer + 1;
    }

    @Override
    public boolean isEmpty()
    {
        return topElementPointer == -1;
    }

    /**
     * Adds an element to the top of the stack.
     *
     * The stack size is increased by "STACK_RESIZE_INCREMENT" when the stack
     * is full. Available memory is plentiful so it is OK to allocate more
     * than what is currently needed right now.
     *
     * @param element The element to add.
     */
    @Override
    public void push(Object element)
    {
        /* Resize the "data" array in order to fit the new element. */
        if (size() == data.length) {
            System.out.println("Reallocating the stack ..");

            Object[] temp = data.clone();
            data = new Object[size() + STACK_RESIZE_INCREMENT];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }

        data[++topElementPointer] = element;
    }

    /**
     * Returns and removes the top element.
     * An exception is thrown if the stack is empty.
     * @return The top-most element in the stack.
     */
    @Override
    public Object pop()
    {
        if (isEmpty()) {
            throw new RuntimeException("\"StackUnderFlowException\"");
        }

        Object element = data[topElementPointer];
        data[topElementPointer] = null;
        topElementPointer--;
        return element;
    }

    /**
     * Returns the top element without removing it.
     * An exception is thrown if the stack is empty.
     * @return The top-most element in the stack.
     */
    @Override
    public Object peek()
    {
        if (isEmpty()) {
            throw new RuntimeException("\"StackUnderFlowException\"");
        }

        return data[topElementPointer];
    }

    /**
     * @return A "StackImplementationIterator" iterator.
     */
    @Override
    public Iterator<Object> iterator()
    {
        return new StackImplementationIterator(data, topElementPointer);
    }

}


/**
 * This class is lifted as-is from the 1DV506 lecture notes. Made non-public so
 * that it can share source file with the "StackImplementation" class without
 * generating a bunch of warnings.
 * Original JavaDoc:  IntArrayIterator.java
 *                    22 dec 2014
 *                    @author jlnmsi
 */
class StackImplementationIterator implements Iterator<Object>
{
    private int nextElement = 0;
    private final Object[] elements;
    private final int max;

    public StackImplementationIterator(Object[] values, int maxIndex)
    {
        elements = values;
        max = maxIndex;
    }

    @Override
    public boolean hasNext()
    {
        return nextElement < max;
    }

    @Override
    public Object next()
    {
        return elements[nextElement++];
    }
}
