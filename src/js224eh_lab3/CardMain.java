package js224eh_lab3;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-12-10.
 *
 * Laboration 3  --  Uppgift 8
 */
public class CardMain
{
    public static void main(String[] args)
    {
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);

        System.out.println("Card rank: " + card.getRank());
        System.out.println("Card suit: " + card.getSuit());
        System.out.println("Card.toString(): " + card);
    }
}
