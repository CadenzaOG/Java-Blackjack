public class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getCardValue() {
        return rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public int getIntValue() {
        return rank.value;
    }

    public boolean isAce() {
        return this.rank.equals(Rank.ACE);
    }

    @Override
    public String toString() {
        return rank + "-" +suit;
    }
}
