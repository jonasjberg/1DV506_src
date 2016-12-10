package js224eh_lab3;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-12-08.
 *
 * Laboration 3  --  Uppgift 9
 */
public class Play123Main
{
    private static final int NUMBER_GAMES = 10000;

    public static void main(String[] args)
    {
        int numberWins = 0;

        for (int i = 0; i < NUMBER_GAMES; i++) {
            if (playGame()) {
                numberWins++;
            }
        }

        double probability = (double) numberWins / NUMBER_GAMES * 100;
        System.out.println("Won " + numberWins + " of " +
                           NUMBER_GAMES + " games.");
        System.out.printf("Probability: %.2f%%%n", probability);
    }

    /**
     * Starts a new game of "Patiens123" and runs it until completion.
     *
     * @return True if the game was won, otherwise false.
     */
    private static boolean playGame()
    {
        Deck deck = new Deck();

        int count = 1;
        do {
            Card card = deck.dealCard();

            switch (count) {
                case 1:
                    if (card.getRank() == Card.Rank.ACE) {
                        return false;
                    }
                    break;
                case 2:
                    if (card.getRank() == Card.Rank.TWO) {
                        return false;
                    }
                    break;
                case 3:
                    if (card.getRank() == Card.Rank.THREE) {
                        return false;
                    }
                    break;
            }

            count++;
            if (count > 3) {
                count = 1;
            }

        } while (deck.getNumberOfCards() > 0);

        return true;
    }
}
