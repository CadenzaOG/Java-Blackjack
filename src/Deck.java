import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;
    private Random rand;

    public Deck() {
        this.cards = new ArrayList<>();
        this.rand = new Random();
        initDeck();
        for (int i = 0; i <= 3; i++) {
            shuffle();
        }
    }

    public void printOrder() {
        for (Card c: cards) {
            System.out.println(c);
        }
    }

    // Fisher-Yates shuffle algorithm
   // https://www.geeksforgeeks.org/dsa/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
    private void shuffle() {
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            Card swap = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, swap);
        }
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

