package js224eh_lab3;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 */
public class DeckMain
{
    public static void main(String[] args)
    {
        Deck deck = new Deck();

        Card card1 = deck.dealCard();
        Card card2 = deck.dealCard();
    }
}
