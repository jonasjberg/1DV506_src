package js224eh_lab3;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 8
 */
public class DeckMain
{
    public static void main(String[] args)
    {
        Deck deck = new Deck();

        System.out.println("Created a new deck of cards.");
        System.out.println("Cards left in deck: " + deck.getNumberOfCards());

        Card card1 = deck.dealCard();
        Card card2 = deck.dealCard();
        Card card3 = deck.dealCard();

        System.out.println("Dealt cards: " + card1.toString() + ", " +
                           card2.toString() + ", " + card3.toString());
        System.out.println("Cards left in deck: " + deck.getNumberOfCards());
    }
}
