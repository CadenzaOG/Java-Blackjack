public class Card {

    private final CardValue cardValue;
    private final Suit suit;

    public Card(CardValue cardValue, Suit suit) {
        this.cardValue = cardValue;
        this.suit = suit;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public int getIntValue() {
        return cardValue.value;
    }

    public boolean isAce() {
        return this.cardValue.equals(CardValue.ACE);
    }

}
