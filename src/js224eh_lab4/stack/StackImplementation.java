package js224eh_lab4.stack;


import java.util.Iterator;


public class StackImplementation implements Stack
{
    private Object[] data;
    private int elements;

    public StackImplementation()
    {
        elements = 0;
        data = new Object[0];
    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override public boolean isEmpty()
    {
        return false;
    }

    /**
     * Adds an element to the top of the stack.
     * @param element The element to add.
     */
    @Override
    public void push(Object element)
    {

    }

    /**
     * Returns and removes the top element.
     * An exception is thrown if the stack is empty.
     * @return The top-most element in the stack.
     */
    @Override
    public Object pop()
    {
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
