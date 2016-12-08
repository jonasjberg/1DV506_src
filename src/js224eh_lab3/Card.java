package js224eh_lab3;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 8
 */
public class Card
{
    private Rank rank;
    private Suit suit;

    public enum Suit
    {
        CLUBS, DIAMONDS, HEARTS, SPADES;

//        /* Metoden 'values()' returnerar en array som innehåller enumens värden
//         * i den ordning de deklarerades. (STOPPED = 0, NORTH = 1, osv.. ) */
//        private static Suit[] allValues = values();
//
//        /* Metod för att kunna sätta en enum med en int.
//         * Förutsätter att ordningen för "enumens" värden inte ändras. */
//        public static Suit fromOrdinal(int n)
//        {
//            return allValues[n];
//        }
    }


    public enum Rank
    {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING,
        ACE;
    }

    public Card(Rank rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
    }
}
