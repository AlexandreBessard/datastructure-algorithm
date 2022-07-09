package crackingTheCodingInterview.chapter7ObjectOrientedDesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Deck of Cards: Design the data structures for a generic deck of cards. Explain how you would
subclass the data structures to implement blackjack.
 */
public class DeckOfCards {

    public enum Suit {
        Club (0), Diamond (1), Heart (2), Space (3);
        private int value;
        private Suit(int v) {
            value = v;
        }
        public int getValue() {
            return value;
        }
        public static Suit getSuitFromValue(int value) {
            return Arrays.stream(Suit.values())
                    .filter(e -> e.getValue() == value)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown value : " + value));
        }
    }

    //Implement BlackJackHand
    class BlackJackHand extends Hand<BlackJackCard> {

        public int score() {
            List<Integer> scores = possibleScores();
            for(int score: scores) {

            }
            return 0;
        }
        private List<Integer> possibleScores() {
            return new ArrayList<>();
        }
    }

    class BlackJackCard extends Card {
        public BlackJackCard(int c, Suit s) {
            super(c, s);
        }
        @Override
        public int value() {
            if (isAce())
                return 1;
            else if (faceValue >= 11 && faceValue <= 13)
                return 10;
            else
                return faceValue;
        }

        public boolean isAce() {
            return faceValue == 1;
        }
    }
    class Deck <T extends Card> {
        private List<T> cards;
        private int dealtIndex = 0;
        public void setDeckOfCards(List<T> deckOfCards) {
            cards = deckOfCards;
        }
        public void shuffle() {}
        public int remainingCards() {
            return cards.size() - dealtIndex;
        }
        public T[] dealtHand(int number) {
            return null;
        }
        public T dealCard() {
            return null;
        }
    }

    class Hand <T extends Card> {
        protected List<T> cards = new ArrayList<>();
        public int score() {
            int score = 0;
            for(T card : cards) {
                score += card.value();
            }
            return score;
        }
        public void addCard(T card) {
            cards.add(card);
        }
    }

    abstract class Card {
        private boolean available = true;
        protected int faceValue;
        protected Suit suit;
        public Card(int c, Suit s) {
            faceValue = c;
            suit = s;
        }
        public abstract int value();
        public Suit suit() {
            return suit;
        }
        //Check if card is available to be given out to someone
        public boolean isAvailable() {
            return available;
        }
        public void markUnavailable() {
            available = false;
        }
        public void markAvailable() {
            available = true;
        }
    }

}
