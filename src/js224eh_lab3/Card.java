package js224eh_lab3;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 8
 */
public class Card
{
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES;
    }

    public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING, ACE;
    }


    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank()
    {
        return rank;
    }

    public Suit getSuit()
    {
        return suit;
    }

    @Override
    public String toString()
    {
        return rank + " of " + suit;
    }
}
