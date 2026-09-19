import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initDeck();
    }

    // Fisher-Yates shuffle algorithm
    private void shuffle() {

    }

    private void initDeck() {
       for (Suit s: Suit.values()) {
            for (CardValue v: CardValue.values()) {
                cards.add(new Card(v, s));
            }
       }
    }

    public Card drawCard() {
        return cards.removeLast();
    }


}

