package hexlet.code;

import java.util.Random;

public class Deck {
    private static final int MIN_CARD_RANK = 1;
    private static final int MAX_CARD_RANK = 9;
    private static final int NUMBER_OF_CARD_TYPES = 4;
    private int[] deck;
    private int currentCard;

    public Deck() {
        buildDeck();
    }

    private void buildDeck() {
        Random random = new Random();
        deck = new int[MAX_CARD_RANK * NUMBER_OF_CARD_TYPES];
        for (int i = MIN_CARD_RANK; i <= MAX_CARD_RANK; i++) {
            for (int j = 0; j < NUMBER_OF_CARD_TYPES; j++) {
                int currentElement = random.nextInt(deck.length);
                while (deck[currentElement] != 0) {
                    currentElement = random.nextInt(deck.length);
                }
                deck[currentElement] = i;
            }
        }
        currentCard = 0;
    }

    public int drawCard() {
        return deck[currentCard++];
    }
}