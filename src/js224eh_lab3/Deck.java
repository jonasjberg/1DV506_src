package js224eh_lab3;

import java.util.ArrayList;
import java.util.Random;

/*
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 8
 */
public class Deck
{
    private ArrayList<Card> cards = new ArrayList<>();
    
    public Deck()
    {
        for (int i = 0; i < Card.Suit.values().length; i++) {
            for (int j = 0; j < Card.Rank.values().length; j++) {
                cards.add(new Card(Card.Rank.values()[j],
                                   Card.Suit.values()[i]));
            }
        }
    }

    public void shuffle()
    {
        if (cards.size() != 52) {
            return;
        }

        /* Algoritmen "Fisher-Yates Shuffle" användes under kursen 1DV021. */
        int m = cards.size();
        Card t;
        int i;
        Random random = new Random();

        while (m > 0) {
            i = (int) Math.floor(random.nextInt() * m--);
            t = cards.get(m);
            cards.set(m, cards.get(i));
            cards.set(i, t);
        }
    }

    public Card dealCard()
    {
        if (cards.isEmpty()) {
            /* TODO: Throw exception? */
        }
        return cards.remove(0);
    }

    public int getNumberCardsInDeck()
    {
        return cards.size();
    }
}
