package js224eh_lab4.stack;


import java.util.Iterator;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-01-07.
 *
 * 1DV506 -- Problemlösning och Programmering, HT2016
 * Laboration 4: Exceptions, IO och interface
 * ---------------------------------------------------------------------------
 *
 * Uppgift 3
 * =========
 * Börja med att skapa ett under-paket med namnet stack i paketet
 * DittLnuAnvändarNamn_lab4. Spara sedan alla .java-filer relaterade till denna
 * uppgift i det paketet.
 * En stack är en LiFo (Last-in, first-out) datastruktur med tre operationer:
 * push, pop och peek. Push lägger in ett element överst på stacken, pop tar
 * bort och returnerar det översta elementet, och peek returnerar (utan att ta
 * bort) det översta elementet. Namnet "stack" kommer från engelskan och betyder
 * "hög" eller "stapel". Stacken kan liknas med en tallriksstapel som kan
 * påträffas i en skolbespisning eller lunchrestaurang. På stapeln kan man
 * endast lägga en tallrik eller ta bort den översta – det går inte att ta bort
 * en tallrik från mitten av stapeln.
 * Er uppgift är att implementera följande Stack interface:
 */

public interface Stack
{
    int size();                  // Current stack size
    boolean isEmpty();           // True if stack is empty
    void push(Object element);   // Add element at top of stack
    Object pop();                // Return and remove top element
                                 // exception if stack is empty.
    Object peek();               // Return (without removing) top element,
                                 // exception if stack is empty.
    Iterator<Object> iterator(); // Element iterator
}

/*
 * Iteratorn itererar över alla stackens element. Skriv också ett testprogram
 * StackMain.java som visar hur alla metoder fungerar.
 * Notera: Ni får inte använda några av de fördefinerade klasserna i Javas
 * klassbibliotek. Ni får dock använda arrayer.
 */
