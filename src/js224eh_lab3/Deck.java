package js224eh_lab3;

import java.util.ArrayList;
import java.util.Random;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 8
 */
public class Deck {
    private ArrayList<Card> cards;

    /**
     * Creates a new deck instance.
     */
    public Deck() {
        cards = createDeck();
        shuffle();
    }

    /**
     * Creates a new deck of cards.
     *
     * @return A new deck of cards as an ArrayList of Card.
     */
    private ArrayList<Card> createDeck() {
        ArrayList<Card> newDeck = new ArrayList<>();

        for (int i = 0; i < Card.Suit.values().length; i++) {
            for (int j = 0; j < Card.Rank.values().length; j++) {
                newDeck.add(new Card(Card.Rank.values()[j],
                        Card.Suit.values()[i]));
            }
        }

        return newDeck;
    }

    /**
     * Shuffles the deck, I.E. randomizes the ordering of the cards.
     * Uses the "Fisher-Yates Shuffle" algorithm. The deck is modified
     * in place.
     *
     *     https://bost.ocks.org/mike/shuffle/
     *     https://blog.codinghorror.com/the-danger-of-naivete/
     */
    public void shuffle() {
        if (cards.size() != 52) {
            return;
        }

        /* The algorithm "Fisher-Yates Shuffle" was used during the course 1DV021.
         * Roughly "translated" from my JavaScript implementation.
         * https://github.com/1dv021/js224eh-examination-3/blob/master/src/carddeck.js
         */
        int m = cards.size();
        int i;
        Card t;
        Random random = new Random();

        while (m > 0) {
            i = (int) Math.floor(random.nextDouble() * m--);
            t = cards.get(m);
            cards.set(m, cards.get(i));
            cards.set(i, t);
        }
    }

    /**
     * Deals a card from this deck of cards.
     *
     * @return The first card in this deck of cards as a Card..
     */
    public Card dealCard() {
        /* Avoid returning null when deck is empty. */
        if (cards.isEmpty()) {
            cards = createDeck();
        }

        return cards.remove(0);
    }

    /**
     * @return The number of cards in this deck of cards.
     */
    public int getNumberOfCards() {
        return cards.size();
    }
}
